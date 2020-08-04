# clojure-exercise

A Clojure skill test

## Usage

### To set the input:
Replace the file **\resources\walls-input.txt** with the desired file with wall heights.

OR

Edit the **file-origin** value in **\src\clojure_exercise\file_io.clj**.

### To run:
Just do **lein run** in the project root folder. You will need the Leiningen installed.

OR

Execute **(-main)** inside the **repl** enviroment.

### Output:
Each state will be printed in the console and stored in **\resources\chocolate-output.txt**

## Logic behind the code:
### Program setup:
In file-io the program reads all the lines in the txt input and stores its values in memory as a vector, each line as one position. Then, it converts the values of the stored vector from string to int.

### Core execution:
It takes the vector with all wall heights inputs and generates a sub-vector adding only the values of the current instant.
Then, it calculates the amount of chocolate in the sub-vector and prints its instant and value in the console and in the output file.

The amount of chocolate is counted in the following way:
Recursively, for each position in the sub-vector, the program searches for the highest wall to the "right" and to the "left". It takes the value of the shorter wall between those two and returns the amount of chocolate on the wall of the current position, which is equal to the difference between the value of the shorter highest wall and the height of the wall in the current position.     