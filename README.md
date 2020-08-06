# clojure-exercise

A Clojure skill test.

## Usage

### To set the input:
Put the files with the wall heights in **/resources**.

### To run:
Just do **lein run FILE_PATH** in the project root folder. You will need the Leiningen installed.

Example:

lein run resources/large.txt

OR

Execute **(-main FILE_PATH)** inside the **repl** environment.
There are presets for small, medium and large .txt files inside the resources folder. So, it's possible to do:

(-main small)

(-main medium)

(-main large)

### Output:
The total amount of chocolate will be printed in the console.

## How it works:
### Program setup:
**walls-instant** reads all the lines in the txt input and stores its values in memory as an int vector, each line as one position.

### Core execution:
**chocolate-count** is the main expression of the program.
It controls the finish state, counts the chocolate and does algorithm optimization by memorizing the biggest left value and the position of the biggest right value.
The program counts the amount of chocolate in each wall with **chocolate-calculator**.

#### position-max-right
It is a multi arity expression.

If only the vector is used as a paramenter, it returns the index of the first item with the biggest value in the vector.

When a previous state is already known and given as a parameter, if the position of the biggest value is higher than the position of the actual wall, it just returns the biggest value position.
If the position of the biggest value is lower or equal to the wall, it finds the new position recursively, passing only the subvector composed of all the values starting from the current wall to the end, and calculate the position in the main vector based on those two positions.

#### chocolate-calculator
It's a simple expression which returns the amount of chocolate based on the wall passed and the difference between its height and the height of the lowest of the biggest walls to the left and to the right.

#### chocolate-count
It controls each iteration and calls all other expressions in the program.

First, it initializes the values only requiring the vector of all walls heights. Then, until the end of the vector, for each iteration, it stores the actual wall being used to calculate the amount of chocolate, the left biggest wall, the position of the right biggest wall and stores the chocolate sum.

## Tests
The program uses **midje** for tests.

To run then, just do **lein midje** on root folder

or, inside REPL:

(use 'midje.repl)

(autorest)