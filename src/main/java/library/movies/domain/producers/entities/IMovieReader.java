package library.movies.domain.producers.entities;

import java.util.List;

public interface IMovieReader {
    List<Movie> loadMovies();
}
