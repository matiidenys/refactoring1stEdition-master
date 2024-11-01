package example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    @Test
    void testMovieGetters() {
        Movie movie = new Movie("Test Movie", Movie.MovieType.NEW_RELEASE);

        assertEquals("Test Movie", movie.getTitle());
        assertEquals(Movie.MovieType.NEW_RELEASE, movie.getPriceCode());
    }
}
