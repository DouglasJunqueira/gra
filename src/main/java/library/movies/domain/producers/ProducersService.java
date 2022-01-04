package library.movies.domain.producers;

import library.movies.domain.producers.entities.IMovieRpt;
import library.movies.domain.producers.entities.Movie;
import library.movies.domain.producers.models.ProducerRangeModel;
import library.movies.domain.producers.models.WinnerIntervalModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducersService {

    private final IMovieRpt movieRpt;

    public WinnerIntervalModel calculateIntervals() {
        WinnerIntervalModel intervals = new WinnerIntervalModel();
        List<Movie> winners = movieRpt.findByWinner(true);

        if (winners.isEmpty())
            return intervals;

        Map<String, List<Movie>> moviesGroupedByProducer =  winners.stream().collect(Collectors.groupingBy(Movie::getProducer));

        moviesGroupedByProducer = moviesGroupedByProducer.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (!moviesGroupedByProducer.isEmpty())
            checkIntervals(moviesGroupedByProducer, intervals);

        return intervals;
    }

    private void checkIntervals(Map<String, List<Movie>> moviesGroupedByProducer, WinnerIntervalModel intervals) {
        moviesGroupedByProducer.forEach((producer, movies) -> {
            movies.sort(Comparator.comparing(Movie::getProducer));
            CheckMinRange(movies, intervals.getMin().isEmpty() ? 99999 : intervals.getMin().get(0).getInterval(), intervals);
            CheckMaxRange(movies, intervals.getMax().isEmpty() ? -1 : intervals.getMax().get(0).getInterval(), intervals);
        });
    }

    private void CheckMinRange(List<Movie> movies, int diffYears, WinnerIntervalModel intervals) {
        for (int i =0; i < movies.size() -1; i++) {
            if (movies.get(i+1).getYear() - movies.get(i).getYear() < diffYears) {
                diffYears = movies.get(i+1).getYear() - movies.get(i).getYear();
                intervals.AddAndResetMin(NewRange(movies.get(i), diffYears, movies.get(i+1).getYear()));
            }
            else if (movies.get(i+1).getYear() - movies.get(i).getYear() == diffYears) {
                intervals.AddMin(NewRange(movies.get(i), diffYears, movies.get(i+1).getYear()));
            }
        }
    }

    private void CheckMaxRange(List<Movie> movies, int diffYears, WinnerIntervalModel intervals) {
        for (int i =0; i < movies.size() -1; i++) {
            if (movies.get(i+1).getYear() - movies.get(i).getYear() > diffYears) {
                diffYears = movies.get(i+1).getYear() - movies.get(i).getYear();
                intervals.AddAndResetMax(NewRange(movies.get(i), diffYears, movies.get(i+1).getYear()));
            }
            else if (movies.get(i+1).getYear() - movies.get(i).getYear() == diffYears) {
                intervals.AddMax(NewRange(movies.get(i), diffYears, movies.get(i+1).getYear()));
            }
        }
    }

    private ProducerRangeModel NewRange(Movie movie, int years, int lastYear) {
        return new ProducerRangeModel(movie.getProducer(), years, movie.getYear(), lastYear);
    }


}
