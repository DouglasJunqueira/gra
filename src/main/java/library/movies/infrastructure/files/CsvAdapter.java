package library.movies.infrastructure.files;

import library.movies.domain.producers.entities.IMovieReader;
import library.movies.domain.producers.entities.Movie;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CsvAdapter implements IMovieReader {

    private static final String COMMA_DELIMITER = ";";

    private final InputStream csv;

    @Override
    public List<Movie> loadMovies() {
        var entries = readFile();
        List<Movie> movies = new ArrayList<>();

        entries.forEach(entry -> {
            var producers = entry[3].split("(and|,)");
            //var studios = entry[2].split("(and|,)");
            for (var producer:producers) {
                //for (var studio:studios) {
                    var movie = new Movie();
                    movie.setYear(Integer.parseInt(entry[0]));
                    movie.setTitle(entry[1]);
                    movie.setStudio(entry[2]);
                    movie.setProducer(producer.trim());
                    movie.setWinner(entry.length > 4 && entry[4] != null && entry[4].equalsIgnoreCase("yes"));
                    movies.add(movie);
                //}
            }
        });
        return movies;
    }

    @SneakyThrows
    private List<String[]> readFile() {
        var entries = new ArrayList<String[]>();
        try (var csvReader = new BufferedReader(new InputStreamReader(csv))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                var values = line.split(COMMA_DELIMITER);
                if (values.length >= 4 && !values[0].equalsIgnoreCase("year")) {
                    entries.add(values);
                }
            }
        }
        return entries;
    }
}
