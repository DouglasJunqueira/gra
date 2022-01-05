package library.movies.infrastructure.files;

import library.movies.domain.producers.entities.IMovieRpt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieStarter implements ApplicationRunner {

    private final IMovieRpt iMovieRpt;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var resource = new ClassPathResource("static/movielist.csv");
        var reader = new CsvAdapter(resource.getInputStream());

        var movies = reader.loadMovies();
        iMovieRpt.saveAll(movies);
    }
}
