package example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static example.Movie.MovieType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void testStatementSingleRegularRental() {
        Movie regularMovie = new Movie("Regular Movie", REGULAR);
        Rental rental = new Rental(regularMovie, 1);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expectedStatement = """
                Rental Record for John Doe
                \tRegular Movie\t2.0
                Amount owed is 2.0
                You earned 1 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    void testStatementMultipleRentals() {
        Customer customer = getCustomer();

        String expectedStatement = """
                Rental Record for Jane Doe
                \tRegular Movie\t3.5
                \tNew Release Movie\t3.0
                \tChildren's Movie\t3.0
                Amount owed is 9.5
                You earned 3 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }

    private static Customer getCustomer() {
        Movie regularMovie = new Movie("Regular Movie", REGULAR);
        Movie newReleaseMovie = new Movie("New Release Movie", NEW_RELEASE);
        Movie childrensMovie = new Movie("Children's Movie", CHILDRENS);

        List<Rental> rentals = List.of(
                new Rental(regularMovie, 3),  // 2 + (1.5 * 1) = 3.5
                new Rental(newReleaseMovie, 1), // 3 * 1 = 3
                new Rental(childrensMovie, 4)   // 1.5 + (1.5 * 1) = 3
        );

        return new Customer("Jane Doe", rentals);
    }

    @Test
    void testStatementNewReleaseBonus() {
        Movie newReleaseMovie = new Movie("New Release Movie", NEW_RELEASE);
        Rental rental = new Rental(newReleaseMovie, 2); // 3 * 2 = 6
        Customer customer = new Customer("John Doe", List.of(rental));

        String expectedStatement = """
                Rental Record for John Doe
                \tNew Release Movie\t6.0
                Amount owed is 6.0
                You earned 2 frequent renter points"""; // Bonus point for 2-day rental

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    void testStatementChildrensMovie() {
        Movie childrensMovie = new Movie("Children's Movie", CHILDRENS);
        Rental rental = new Rental(childrensMovie, 4); // 1.5 + (1.5 * 1) = 3.0
        Customer customer = new Customer("John Doe", List.of(rental));

        String expectedStatement = """
                Rental Record for John Doe
                \tChildren's Movie\t3.0
                Amount owed is 3.0
                You earned 1 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    void testStatementWithDifferentRentalDays() {
        Movie regularMovie = new Movie("Regular Movie", REGULAR);
        Rental rental = new Rental(regularMovie, 5); // 2 + (3 * 1.5) = 6.5
        Customer customer = new Customer("Alice", List.of(rental));

        String expectedStatement = """
                Rental Record for Alice
                \tRegular Movie\t6.5
                Amount owed is 6.5
                You earned 1 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }
}
