package example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalTest {

    @Test
    void testRentalGetters() {
        Movie movie = new Movie("Test Movie", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 5);

        assertEquals(movie, rental.getMovie());
        assertEquals(5, rental.getDaysRented());
    }
}
