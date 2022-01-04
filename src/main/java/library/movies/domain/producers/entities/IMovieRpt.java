package library.movies.domain.producers.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRpt extends JpaRepository<Movie, Integer> {

    List<Movie> findByWinner(Boolean winner);
}
