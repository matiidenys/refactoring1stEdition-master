У pom було додано
```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.8.1</version>
    <scope>test</scope>
</dependency>
```
Було створено 3 файли для тестів, CustomerTest, RentalTest і MovieTest. <br/>
RentalTest: Перевіряє, чи правильно працюють геттери класу Rental.<br/>
MovieTest: Перевіряє, чи правильно працюють геттери класу Movie.<br/>
CustomerTest перевіряє:<br/>
Одиничну оренду регулярного фільму;<br/>
Множинні оренди різних типів фільмів;<br/>
Бонусні бали для нових релізів;<br/>
Оренду дитячого фільму;<br/>
Різні дні оренди для регулярного фільму.
