# Java BODMAS Calculator

* A traditional calculator application in Java that evaluates mathematical expressions using the BODMAS rule (operator precedence).
* This project demonstrates stack-based expression evaluation.
* handling multi-digit numbers, decimal numbers, and parentheses without using any external libraries or scripting engines.

# Features

* Supports basic arithmetic operations: +, -, *, /

* Handles multi-digit numbers and decimal numbers

* Evaluates expressions with parentheses ()

* Implements operator precedence according to BODMAS

* Pure Java implementation using two stacks: one for numbers and one for operators

* Console-based, easily extendable to a GUI version

# How It Works

* Input Expression: Provide a mathematical expression as a string.

* Tokenization: The program reads digits, decimals, operators, and parentheses.

* Stacks:

1)Numbers Stack: Stores operands

2)Operators Stack: Stores operators and parentheses

* BODMAS Evaluation:

1)Parentheses are evaluated first

2)Multiplication and division are prioritized over addition and subtraction

3)Operators of same precedence are evaluated left to right

* Final Result: Remaining operations are applied, leaving a single value as the output.

# Technologies Used

* Java (JDK 8 or higher)

* Stack Data Structure (java.util.Stack)
