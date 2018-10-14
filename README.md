# ComcastInterviewQuestion
Number Adder

## Requirements
- Java 8
- Maven 3

## Command To Build

```mvn clean compile assembly:single```

## Command To Run

``` java -jar target/NumberAdder.jar -x -f ```

## Command To Run Unit Tests

``` mvn test ```

## Things To Note

- Does not handle negative numbers
- Only handles digits 0-9 (Single digit numbers)
- For file and user input, assumed that content was one big string. Stripped all whitespace.
