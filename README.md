У pom було додано
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.8.1</version>
    <scope>test</scope>
</dependency>

Було створено 3 файли для тестів, CustomerTest, RentalTest і MovieTest.
RentalTest: Перевіряє, чи правильно працюють геттери класу Rental.
MovieTest: Перевіряє, чи правильно працюють геттери класу Movie.
CustomerTest перевіряє:
Одиничну оренду регулярного фільму;
Множинні оренди різних типів фільмів;
Бонусні бали для нових релізів;
Оренду дитячого фільму;
Різні дні оренди для регулярного фільму.
