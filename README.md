# Sum Digits of String
Write a program that will iterate over the input, adding the digits, and returning the result.

Input:
 - SHALL accept STDIN as the default
 - SHALL accept a file when flag [-f] is specified
 - SHALL handle hex values when flag [-x] is specified

Output:
 - SHALL output result as single Long to STDOUT
 - SHALL always output result in base 10


Be sure to include:
 - README on how to build/test/execute your application
 - Automated Unit Tests


Examples:
```
$ echo "abc123" | ./myProg
6

$ echo "abc123" | ./myProg -x
39

$ echo "qq" | ./myProg
0

$ echo "abc123" > file.tmp
$ ./myProg -f file.tmp
6
```

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
