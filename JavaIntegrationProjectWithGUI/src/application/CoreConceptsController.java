package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 
 * @author Seth T. Graham
 *
 */

public class CoreConceptsController implements Initializable {

	// FXML variable links with Scene Builder
	@FXML
	private TreeView<String> treeView;
	@FXML
	private Label label;
	@FXML
	private Label exampleLabel;
	@FXML
	private Button mainMenuButton;

	public void initialize(URL url, ResourceBundle resources) {

		TreeItem<String> directory, primitiveDataType, mathMethods, variables, operators, loops, compareStrings, arrays,
				relationship, statements, exceptionHandling;

		// Root
		directory = new TreeItem<>("Directory");
		directory.setExpanded(true);

		// Primitive Data Types
		primitiveDataType = makeBranch("Primitive Data Types", directory);
		makeBranch("Byte", primitiveDataType);
		makeBranch("Short", primitiveDataType);
		makeBranch("Integer", primitiveDataType);
		makeBranch("Long", primitiveDataType);
		makeBranch("Float", primitiveDataType);
		makeBranch("Double", primitiveDataType);
		makeBranch("Boolean", primitiveDataType);
		makeBranch("Character", primitiveDataType);
		makeBranch("String", primitiveDataType);
		makeBranch("Casting", primitiveDataType);

		// Math Methods
		mathMethods = makeBranch("Math Methods", directory);
		makeBranch("Addition", mathMethods);
		makeBranch("Subtraction", mathMethods);
		makeBranch("Multiplication", mathMethods);
		makeBranch("Division", mathMethods);
		makeBranch("Remainder", mathMethods);
		makeBranch("Increment", mathMethods);
		makeBranch("Random Class", mathMethods);

		// Comparing Strings
		compareStrings = makeBranch("Comparing Strings", directory);
		makeBranch("compareTo() Method", compareStrings);

		// Variables
		variables = makeBranch("Variables", directory);
		makeBranch("What is a Variable?", variables);
		makeBranch("Scope of a Variable", variables);
		makeBranch("Final Keyword", variables);

		// Operators
		operators = makeBranch("Operators", directory);
		makeBranch("Prefix and Postfix", operators);
		makeBranch("Operator Precedence", operators);
		makeBranch("Ternary Operators", operators);

		// Switch Statements
		statements = makeBranch("Statements", directory);
		makeBranch("Switch Statement", statements);

		// Loops
		loops = makeBranch("Loops", directory);
		makeBranch("For Loops", loops);
		makeBranch("While Loops", loops);
		makeBranch("Do-While Loops", loops);
		makeBranch("Break Statements", loops);
		makeBranch("Continue Statements", loops);

		// Arrays
		arrays = makeBranch("Arrays", directory);
		makeBranch("Creating an Array", arrays);
		makeBranch("Searching a Array", arrays);
		makeBranch("Accumulator Example", arrays);
		makeBranch("Creating a Two Dimensional Array", arrays);
		makeBranch("Searching a Two Dimensional Array", arrays);

		// Class Relationships
		relationship = makeBranch("Classes and Relationships", directory);
		makeBranch("Inheritance", relationship);
		makeBranch("Polymorphism", relationship);
		makeBranch("Constructors", relationship);

		// Exception Handling
		exceptionHandling = makeBranch("Exception Handling", directory);
		makeBranch("Try and Catch", exceptionHandling);

		// Create Tree
		treeView.setRoot(directory);
		treeView.setShowRoot(true);
	}

	// Create Branch Method
	private TreeItem<String> makeBranch(String name, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(name);
		item.setExpanded(false);
		parent.getChildren().add(item);
		return item;
	}

	// Return to Main Menu Button
	public void mainMenuButtonPushed(ActionEvent event) throws IOException {
		Parent splashPageParent = FXMLLoader.load(getClass().getResource("/SplashPageFXML.fxml"));
		Scene splashPageScene = new Scene(splashPageParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(splashPageScene);
		window.show();
	}

	// Populate Labels on Mouse Click Method
	public void mouseClick(MouseEvent mouseEvent) {

		TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

		String description = "";
		String exampleCode = "";

		// Primitive Data Type Labels
		if (item.getValue() == "Byte") {
			description = "A byte can be any value from -128 to 127. Bytes are useful when you are working on \n"
					+ "a system with limited memory. \n";
			exampleCode = "public class Byte { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "byte byte1 = 100; \n\t\t" + "System.out.println(\"byte1 = \" + byte1); \n\t}\n}";
		} else if (item.getValue() == "Short") {
			description = "A short can be any Value from -32,768 to 32,767. Shorts can be used in large arrays \n"
					+ "where memory savings are needed. \n";
			exampleCode = "public class Short { \n\n\tpublic static void main(String[] args) {\n\n\t\t"
					+ "short short1 = 24000; \n\t\t" + "System.out.println(\"short1 = \" + short1); \n\t}\n}";
		} else if (item.getValue() == "Integer") {
			description = "A Int is a 32 bit Integer and can be used from -2^31 to 2^31 - 1. Int can also represent \n"
					+ "an unsigned 32 bit integer. \n";
			exampleCode = "public class Integer { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int int1 = 50000; \n\t\t" + "System.out.println(\"int1 = \" + int1); \n\t}\n}";
		} else if (item.getValue() == "Long") {
			description = "Long is a 64 bit signed integer and can be used from -2^63 to 2^63 -1. Only use this \n"
					+ "value when you need a range of values wider than those provided by int. \n";
			exampleCode = "public class Long { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "long long1 = 8000000000L; \n\t\t" + "System.out.println(\"long1 = \" + long1); \n\t}\n}";
		} else if (item.getValue() == "Float") {
			description = "Float is a single precision 32-bit IEEE floating point. This value should never be used "
					+ "for \nprecise values such as currency. \n";
			exampleCode = "public class Float { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "float float1 = 250.4445786f; \n\t\t" + "System.out.println(\"float1 = \" + float1); \n\t}\n}";
		} else if (item.getValue() == "Double") {
			description = "A double is a preciscion 64-bit IEEE 754 floating point. For decimal values, this data \n"
					+ "type is the default choice. \n";
			exampleCode = "public class Double { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "double double1 = Math.PI; \n\t\t" + "System.out.println(\"double1 = \" + double1); \n\t}\n}";
		} else if (item.getValue() == "Boolean") {
			description = "A boolean variable only has two variables: true and false. Use this data type for simple \n"
					+ "flags that track true or false conditions. \n";
			exampleCode = "public class Boolean { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "boolean boolean1; \n\t\t" + "boolean1 = (5 < 10); \n\t\t"
					+ "System.out.println(\"5 < 10? Answer is \" + boolean1); \n\t\t" + "boolean1 = (5 == 10); \n\t\t"
					+ "System.out.println(\" 5 == 10? Answer is \" + boolean1); \n\t}\n}";
		} else if (item.getValue() == "Character") {
			description = "Char is a data type that is a single 16-bit Unicode character. \n";
			exampleCode = "public class Character { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "char char1 = 'A'; \n\t\t" + "System.out.println(\"char1 = \" + char1); \n\t}\n}";
		} else if (item.getValue() == "String") {
			description = "Strings are immutable, which means that once created, their values cannot be changed. \n";
			exampleCode = "public class Strings { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "String string1 = \"Hello World!\"; \n\t\t" + "System.out.println(\"string1 = \" + string1);"
					+ "\n\t}\n}";
		} else if (item.getValue() == "Casting") {
			description = "Casting can happen two different ways. Typically IDEs, such as Eclipse, automatically \n"
					+ "\"widen\" or convert when you assign a variable to a bigger data type. If you need to \n"
					+ "\"narrow\" or assign a variable to a smaller data type you have to manually \"cast\" the \n"
					+ "variable to the desired data type to avoid Java errors. \n";
			exampleCode = "public class Casting { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int intSmall = 10; \n\t\t" + "System.out.println(\"intSmall = \" + intSmall); \n\t\t"
					+ "double autoDouble = intSmall; \n\t\t"
					+ "System.out.println(\"autoDouble = \" + autoDouble); \n\t\t"
					+ "double manualDouble = 600.2345; \n\t\t"
					+ "System.out.println(\"manualDouble = \" + manualDouble); \n\t\t"
					+ "int manualInt = (int) manualDouble; \n\t\t" + "System.out.println(\"manualInt = \" + manualInt);"
					+ "\n\t}\n}";

			// Math Method Labels
		} else if (item.getValue() == "Addition") {
			description = "The + operator adds the two values.";
			exampleCode = "public class Addition { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int e = 50; \n\t\t" + "int f = 2; \n\t\t" + "int result = 0; \n\n\t\t"
					+ "result += (e + f); \n\t\t" + "System.out.println(result); \n\t}\n}";
		} else if (item.getValue() == "Subtraction") {
			description = "The - operator subtracts the two values. \n";
			exampleCode = "public class Subtraction { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int e = 50; \n\t\t" + "int f = 2; \n\t\t" + "int result = 0; \n\n\t\t"
					+ "result += (e - f); \n\t\t" + "System.out.println(result); \n\t}\n}";
		} else if (item.getValue() == "Multiplication") {
			description = "The * operator multiplys the two values.";
			exampleCode = "public class Multiplication { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int e = 50; \n\t\t" + "int f = 2; \n\t\t" + "int result = 0; \n\n\t\t"
					+ "result += (e * f); \n\t\t" + "System.out.println(result); \n\t}\n}";
		} else if (item.getValue() == "Division") {
			description = "The / operator divides the two values.";
			exampleCode = "public class Division { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int e = 50; \n\t\t" + "int f = 2; \n\t\t" + "int result = 0; \n\n\t\t"
					+ "result += (e / f); \n\t\t" + "System.out.println(result); \n\t}\n}";
		} else if (item.getValue() == "Remainder") {
			description = "The % operator gets the remainder of the two divided values.";
			exampleCode = "public class Remainder { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int e = 50; \n\t\t" + "int f = 2; \n\t\t" + "int result = 0; \n\n\t\t"
					+ "result += (e % f); \n\t\t" + "System.out.println(result); \n\t}\n}";
		} else if (item.getValue() == "Increment") {
			description = "The ++ operator increments an integer value by 1.";
			exampleCode = "public class Increment { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int e = 50; \n\t\t" + "int result = 0; \n\n\t\t" + "result += (e++); \n\t\t"
					+ "System.out.println(result); \n\t}\n}";
		} else if (item.getValue() == "Random Class") {
			description = "This block of code is generating two random numbers from the Random class and \n"
					+ "taking the larger integer with the Math.max method taken from the Math class.";
			exampleCode = "public class RandomMethod { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "Random randomNumber = new Random(); \n\n\t\t" + "int a = randomNumber.nextInt(51); \n\t\t"
					+ "int b = randomNubmer.nextInt(51); \n\n\t\t" + "System.out.println(\"int a = \" + a); \n\t\t"
					+ "System.out.println(\"int b = \" + b); \n\t\t"
					+ "System.out.println(\"Math.max chose: \" + Math.max(a, b); \n\t}\n}";

			// Comparing Strings Labels
		} else if (item.getValue() == "compareTo() Method") {
			description = "Utilizing the == method of comparing Strings. The compiler will compare the "
					+ "memory \nlocation of the Strings. If the memory locations are EXACTLY the same it will return \n"
					+ "the boolean value TRUE. \n\nUtilizing the String classes compareTo() method will compare both "
					+ "Strings \r\nlexicographically.\n\r\nWhich means that it will return the difference between "
					+ "the Unicode values of \r\nboth Strings. \n";
			exampleCode = "public class CompareTo { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "String a = \"Hello World!\"; \n\t\tString b = \"Hello World!\"; \n\n\t\t"
					+ "System.out.println(a == b); \n\t\tSystem.out.println(a.compareTo(b)); \n\t}\n}";

			// Variable Labels
		} else if (item.getValue() == "What is a Variable?") {
			description = "A Variable is a storage location, located in a memory address, that is given an name \n"
					+ "and value. This value can be called in methods as an object or in math functions.";
			exampleCode = "public class Variables { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int a = 10; \n\n\t\tSystem.out.println(a); \n\t}\n}";
		} else if (item.getValue() == "Scope of a Variable") {
			description = "The Scope of a variable can be defined in two ways in a program, global or local. A \n"
					+ "global variable can be used by every method within a program. Using variables in this \n"
					+ "way is generally frowned upon because it can lead to issues with troubleshootng your \n"
					+ "program. \n" + "\n" + "A local variable can only be used by the method it is "
					+ "\"Housed\" in. This avoids any \n" + "conflicts of different methods overwriting your "
					+ "variables. " + "Bugs with local variables are \n" + "also easier to troubleshoot. \n";
			exampleCode = "public class VariableTest { \n\n" + "\t//Global Variable \n" + "\tint a = 10; \n\n"
					+ "\tprivate void privateVariable() { \n" + "\t\t//Local Variable \n" + "\t\tint b = 20; \n"
					+ "\t\tSystem.out.println(b); \n" + "\t} \n" + "}";
		} else if (item.getValue() == "Final Keyword") {
			description = "A \"Final\" is a non-access modifier applicable only to variables, methods, or classes. \n"
					+ "Essentially it makes the varible constant or unchangeable.";
			exampleCode = "public class Final { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "final int staticVariable = 22; \n\n\t\t"
					+ "System.out.println(\"staticVariable = \" + staticVariable); \n\t\t"
					+ "System.out.println(\"This variable can now no longer be changed.\"); \n\t}\n}";

			// Operator Labels
		} else if (item.getValue() == "Prefix and Postfix") {
			description = "The increment operator can be applied in either the Prefix or Postfix position. The \n"
					+ "position of the increment operator can drastically effect the results of your program.";
			exampleCode = "public class PreFixPostFix { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int prefix = 0;\n\t\t" + "int postfix = 0;\n\t\t" + "\r\n\t\t"
					+ "System.out.println(++prefix);\r\n\t\t" + "System.out.println(postfix++);\r\n\t\t"
					+ "\r\n\t\t/*\n\t\t"
					+ "* Notice the postfix result has not updated the value. The value will \n\t\t"
					+ "* update if we send postfix to the console again. \n\t\t*/\r\n\n\t\t"
					+ "System.out.println(postfix);" + "\n\t}\n}";
		} else if (item.getValue() == "Operator Precedence") {
			description = "Like a normal math equation Java operators have a set order in which are they are used. "
					+ "Here is a list showing the order in which Java prioritizes the operators. \n";
			exampleCode = "Priority 1: Assignment Operators \n"
					+ "=, +=, -=, *=, /=, %=, &=, ^=, |, <<=, >>=, >>>= \n\n" + "Priority 2: Ternary Operators \n"
					+ "?: \n\n" + "Priority 3: Logical OR \n" + "|| \n\n" + "Priority 4: Logical AND \n" + "&& \n\n"
					+ "Priority 5: Bitwise OR\n" + "| \n\n" + "Priority 6: Bitwise XOR \n" + "^ \n\n"
					+ "Priority 7: Bitwise AND\n" + "& \n\n" + "Priority 8: Equality Operators\n" + "==, != \n\n"
					+ "Priority 9: Relational Operators\n" + "<, <=, >, >=, instanceof \n\n"
					+ "Priority 10: Shift Operators\n" + "<<, >>, >>> \n\n"
					+ "Priority 11: Additive and String Concatenation Operators\n" + "+, - \n\n"
					+ "Priority 12: Multiplicative Operators\n" + "*, /, % \n\n"
					+ "Priority 13: Cast and Object Creation Operators\n" + "(), new \n\n"
					+ "Priority 14: Unary Pre-Increment, Unary Pre-Decrement, Unary Plus, "
					+ "Unary Minus, Unary Logical NOT,and the Unary Bitwise NOT\n" + "++int, --int, +, -, !, ~ \n\n"
					+ "Priority 15: Unary Post-Increment and Unary Post-Decrement\n" + "int++, int-- \n\n"
					+ "Prioirty 16: Access Array Element, Access Object Member, and Parentheses\n" + "[], ., () \n";
		} else if (item.getValue() == "Ternary Operators") {
			description = "This block of code is utilizing ternary operators. In this case the ternary operator acts \n"
					+ "like the Math.min() class. It will take the smaller of two integer values. \n";
			exampleCode = "public class Ternary Operator { \n\n\tpublic static void main(String[] args) {\n\n\t\t"
					+ "Random randomNumber = new Random(); \n\t\tint a = randomNumber.nextInt(51); \n\t\t"
					+ "int b = randomNumber.nextInt(51); \n\t\tint minimumValue = (c < d) ? c : d; \n\n\t\t"
					+ "System.out.println(\"int a = \" + a); \n\t\tSystem.out.println(\"int b = \" + b); \n\t\t"
					+ "System.out.println(\"minimumValue = \" + minimumValue); \n\t}\n}";

			// Statement Labels
		} else if (item.getValue() == "Switch Statement") {
			description = "The switch statement can have a number of possible execution paths. A switch works \n"
					+ "with the byte, short, char, and int primitive data types.";
			exampleCode = "import java.util.Scanner; \n\n"
					+ "public class Switch { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "Scanner scanner = new Scanner(System.in); \n\t\tint input = scanner.nextInt(); \n\t\t"
					+ "String menu; \n\n\t\t//Switch Statement. \n\t\tswitch (input) { \n\t\t\t"
					+ "case 1: menu = \"Main Menu\"; \n\t\t\t\tbreak; \n\t\t\tcase 2: menu = \"Menu1\"; \n\t\t\t\t"
					+ "break; \n\t\t\tcase 3: menu = \"Menu2\"; \n\t\t\t\tbreak; \n\t\t\t"
					+ "default: menu = \"Menu does not exist\"; \n\t\t\t\tbreak; \n\t\t} \n\t\t"
					+ "System.out.println(Menu); \n\t} \n}";

			// Loop Labels
		} else if (item.getValue() == "For Loops") {
			description = "For loops are also known as count-controlled loops. They are often used with arrays \n"
					+ "and lists.";
			exampleCode = "public class ForLoop {\n\n\tpublic static void main(String[] args) {\n\n\t\t"
					+ "int a = 0;\n\n\t\tfor (int i = 0; i < 6; i++) {\n\t\t\t++a;\n\t\t\tSystem.out.println(a);\n\t\t}"
					+ "\n\t}\n}";
		} else if (item.getValue() == "While Loops") {
			description = "While loops will continue to loop until the set condition is met.";
			exampleCode = "public class WhileLoop {\n\n\tpublic static void main(String[] args) {\n\n\t\t"
					+ "boolean stopLoop = false; \n\t\tint w = 0; \n\n\t\twhile (stopLoop != true) {\n\t\t\t"
					+ "System.out.println(\"I can't stop until \\\"stopLoop\\\" is true!\"); \n\t\t\tw++;\n\t\t\t"
					+ "} else if (w == 3) {\n\t\t\tSystem.out.println(\"Finally! \\\"stopLoop\\\" is true!\");\n\t\t\t"
					+ "stopLoop = true; \n\t\t}\n\t}\n}";
		} else if (item.getValue() == "Do-While Loops") {
			description = "Do-While loops are utilized when it is necessary to repeat the same code when a certain \n"
					+ "condition is met.";
			exampleCode = "public class DoWhileLoop { \n\n\tpublic static void main(String[] args) {\n\n\t\t"
					+ "int x = 0; \n\n\t\tdo {\n\t\t\tSystem.out.println(x); \n\t\t\tx++; \n\t\t} while (x < 4); \n\t}"
					+ "\n}";
		} else if (item.getValue() == "Break Statements") {
			description = "A \"break\" statement in a loop will terminate the loop and automatically resume at the \n"
					+ "next statement following the loop regardless if the condition is met.";
			exampleCode = "public class BreakStatements { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "boolean stopLoop = false; \n\t\tint w = 0; \n\t\twhile (stopLoop != true) { \n\t\t\t"
					+ "System.out.println(\"I can't stop until \\\"stopLoop\\\" is true!\"); \n\t\t\t"
					+ "w++; \n\t\t\tbreak; \n\t\t} else if (w == 3) { \n\t\t\t"
					+ "System.out.println(\"Finally! \\\"stopLoop\\\" is true!\"); \n\t\t\tstopLoop = true; \n\t\t}"
					+ "\n\t} \n}";
		} else if (item.getValue() == "Continue Statements") {
			description = "The \"continue\" statement causes a loop to jump to the next block of code Inside \n"
					+ "the loop.";
			exampleCode = "public class ContinueStatements { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "boolean stopLoop = false; \n\t\tint w = 0; \n\t\twhile (stopLoop != true { \n\t\t\t"
					+ "System.out.println(\"I can't stop until \\\"stopLoop\\\" is true!\"); \n\t\t\tw++; \n\t\t\t"
					+ "continue; \n\t\t} else if(w == 3) { \n\t\t\t"
					+ "System.out.println(\"Finally! \\\"stopLoop\\\" is true!\"); \n\t\t\tstopLoop = true; \n\t\t\t"
					+ "continue; \n\t\t} \n\t\tSystem.out.println(\"I want to be printed! Darn continue statement!\"); \n\t}"
					+ "\n}";

			// Array Labels
		} else if (item.getValue() == "Creating an Array") {
			description = "An array, is a dynamically-created object that serves as a container to hold a constant \n"
					+ "number of values of the same type.";
			exampleCode = "public class CreatingAnArray { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int[] intArray = new int[5] {5, 4, 6, 7, 8}; \n\t\tSystem.out.println(intArray[2]); \n\t}\n}";
		} else if (item.getValue() == "Searching a Array") {
			description = "This block of code searches for the smallest value of a array and returns the index of \n"
					+ "that number.";
			exampleCode = "import java.util.Random; \n\npublic class SearchingAnArray { \n\n\t"
					+ "private static Random random; \n\n\t"
					+ "public static void main(String[] args) { \n\n\t\tint[] array = new int[10]; \n\t\t"
					+ "int smallestNumber = 0; \n\n\t\tcreateArray(array); \n\t\tSystem.out.println(\"\\n\"); \n\t\t"
					+ "smallestNumber = findSmallestNumber(array); \n\t\t"
					+ "System.out.println(\"The smallest number in the array is: \" \n\t\t\t"
					+ "+ smallestNumber + \"\\n\"); \n\t\t"
					+ "smallestIndexPosition(array, smallestNumber); \n\t} \n\n\t// Create a Random Array \n\t"
					+ "private static void createArray(int[] arrayName) { \n\t\trandom = new Random() \n\t\t"
					+ "arrayName[i] = random.nextInt(100) + 1;"
					+ "\n\t\tSystem.out.printf(\"%5d\", arrayName[i]); \n\t\t} \n\t} \n\t"
					+ "// Find the Smallest Value of the Array \n\t"
					+ "private static int findSmallestNumber(int[] arrayName) { \n\t\tint minValue = arrayName[0]; \n\t\t"
					+ "for (int i = 0; i < arrayName.length; i++) { \n\t\t\tif (arrayName[i] < minValue) { \n\t\t\t\t"
					+ "minValue = arrayName[i]; \n\t\t\t} \n\t\t} \n\t\treturn minValue; \n\t} \n\n\t"
					+ "// Find the Index Position of the Smallest Number \n\t"
					+ "private static void smallestIndexPosition(int[] arrayName, int desiredNumber) { \n\t\t"
					+ "for (int i = 0; i < arrayName.length; i++) { \n\t\t\tif (arrayName[i] == desiredNumber) { \n\t\t\t\t"
					+ "System.out.println(\"The index position is: \" + i); \n\t\t\t} \n\t\t} \n\t} \n}";
		} else if (item.getValue() == "Accumulator Example") {
			description = "This block of code will output the sum of every number in the array.";
			exampleCode = "import java.util.Random; \n\npublic class Accumulator { \n\n\t"
					+ "private static Random random; \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int[] array = new int[10]; \n\n\t\tcreateArray(array); \n\t\tSystem.out.println(\"\\n\"); \n\t\t"
					+ "System.out.println(\"The sum of all numbers in the array is: \" \n\t\t\t"
					+ "+ accumulator(array)); \n\t} \n\n\t// Create a Random Array \n\t"
					+ "private static void createArray(int[] arrayName) { \n\t\trandom = new Random(); \n\t\t"
					+ "for (int i = 0; i < arrayName.length; i++) { \n\t\t\tarrayName[i] = random.nextInt(100) + 1; \n\t\t\t"
					+ "System.out.printf(\"%5d\", arrayName[i]); \n\t\t} \n\t} \n\n\t"
					+ "// Get the sum of all the numbers in the Array \n\t"
					+ "private static int accumulator(int[] arrayName) { \n\t\tint sum = 0; \n\t\t"
					+ "for (int i = 0; i < arrayName.length; i++) { \n\t\t\tsum += arrayName[i]; \n\t\t} \n\t\t"
					+ "return sum; \n\t} \n}";
		} else if (item.getValue() == "Creating a Two Dimensional Array") {
			description = "Arrays can be made in a \"multi-dimensional\" format. Below is an example of an two \n"
					+ "dimensional array.";
			exampleCode = "public class TwoDimensionalArray { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "int[][] grid = new int[2][2] {1, 2}, {3, 4}; \n\n\t\tSystem.out.println(grid[1][0]); \n\t}\n}";
		} else if (item.getValue() == "Searching a Two Dimensional Array") {
			description = "This block of code searches for the smallest value of a two dimensional array and \n"
					+ "returns the index of that number.";
			exampleCode = "import java.util.Random; \n\n"
					+ "public class SearchingA2DArray { \n\n\tprivate static Random random; \n\n\t"
					+ "public static void main(String[] args) { \n\n\t\tint[][] grid = new int[10][10]; \n\t\t"
					+ "int smallestNumber = 0; \n\n\t\tcreate2DArray(grid); \n\t\tSystem.out.println(\"\\n\"); \n\t\t"
					+ "smallestNumber = getMinValue(grid); \n\t\t"
					+ "System.out.println(\"The smallest value in the 2D array is: \" \n\t\t\t+ smallestNumber + \"\\n\"); "
					+ "\n\t\tfindPosition(grid, smallestNumber); \n\t}\n\n\t// Create 2 Dimensional Array \n\t"
					+ "private static void create2DArray(int[][] arrayName) { \n\t\trandom = new Random(); \n\t\t"
					+ "for (int i = 0; i < arrayName.length; i++) { \n\t\t\tfor (int j = 0; j < arrayName.length; j++) {"
					+ "\n\t\t\t\tarrayName[i][j] = random.nextInt(100) +1; \n\t\t\t\t"
					+ "System.out.printf(\"%5d\", arrayName[i][j]); \n\t\t\t} \n\t\t\tSystem.out.println(); \n\t\t}"
					+ "\n\t} \n\t// Find the Smallest Number \n\tprivate static int getMinValue(int[][] arrayName) { \n\t\t"
					+ "int minValue = arrayName[0][0]; \n\t\tfor (int i = 0; i < arrayName.length; i++) { \n\t\t\t"
					+ "for (int j = 0; j < arrayName.length; j++) { \n\t\t\t\tif (arrayName[i][j] < minValue) { \n\t\t\t\t\t"
					+ "minValue = arrayName[i][j]; \n\t\t\t\t} \n\t\t\t} \n\t\t} \n\t\treturn minValue; \n\t}"
					+ "\n\n\t// Find the Grid Position of the Smallest Number \n\tprivate static void findposition"
					+ "(int[][] arrayName, int desiredNumber) { \n\t\tfor (int i = 0; i < arrayName.length; i++) { \n\t\t\t"
					+ "for (int j = 0; j < arrayName.length; j++) { \n\t\t\t\tif (arrayName[i][j] == desiredNumber) {"
					+ "\n\t\t\t\t\tSystem.out.println(\"Row: \" + i + \" Column: \" + j); \n\t\t\t\t} \n\t\t\t}"
					+ "\n\t\t} \n\t} \n}";

			// Classes and Relationships Labels
		} else if (item.getValue() == "Inheritance") {
			description = "Inheritance is the mechanism in java by which one class is allowed to inherit the\n"
					+ "features of another class. Inheritance is very useful in code resuse.";
			exampleCode = "class Car { \n\n\tpublic int year; \n\tpublic String make; \n\tpublic String model; \n\n\t"
					+ "//Methods \n\tpublic Car(int year, String make, String model) { \n\t\t"
					+ "this.year = year; \n\t\tthis.make = make; \n\t\tthis.model = model; \n\t} \n\n\t"
					+ "public String createCarString() { \n\t\treturn(\"This car is a \" + year + make + model);"
					+ "\n\t} \n} \n\n"
					+ "class CarWithTransmissionType extends Car { \n\n\t //The subclass adds one more field \n\t"
					+ "public String transmissionType; \n\n\t // Constructor for the subclass \n\t"
					+ "public CarWithTransmissionType(int year, String make, String model, \n\t\t\t\t\t\t\t     String "
					+ "transmissionType) { \n\t\t"
					+ "super(year, make, model); \n\t\tthis.transmissionType = transmissionType; \n\t} \n\n\t"
					+ "//Overriding the createCarString() method of Car to print more info \n\t"
					+ "public String createCarString() { \n\t\treturn(super.createCarString() + \"\\nwith a \" \n\t\t\t"
					+ "+ transmissionType + \" transmission.\"); \n\t} \n} \n\n"
					+ "public class Main { \n\n\tpublic static void main(String[] args) { \n\n\t\t"
					+ "CarWithTransmissionType volkswagenGTI = \n\t\t\tnew CarWithTransmissionType(2015, Volkswagen, GTI, Manual);"
					+ "\n\t\tSystem.out.println(volkswagenGTI.createCarString()); \n\t} \n}";

		} else if (item.getValue() == "Polymorphism") {
			description = "Polymorphism is the capability of a method to do different things based on the object \nthat is "
					+ "acting upon";
			exampleCode = "class Animal { \n\n\tpublic void sound() { \n\t\tSystem.out.println(\"Animal is making a sound\");"
					+ "\n\t} \n} \n\n class Dog extends Animal { \n\n\tpublic void sound() { \n\t\t"
					+ "System.out.println(\"Woof!\"); \n\t} \n} \n\nclass Cat extends Animal { \n\n\t"
					+ "public void sound() { \n\t\tSystem.out.println(\"Meow!\"); \n\t} \n} \n\n"
					+ "public static void main(String[] args) { \n\t\tAnimal object = new Cat(); \n\t\tobject.sound(); \n\t}"
					+ "\n}";
		} else if (item.getValue() == "Constructors") {
			description = "Constructors are used to initialize the object's state. They assign values to the class\n"
					+ "variables at the time of object creation.";
			exampleCode = "class Car { \n\n\tpublic int year; \n\tpublic String make; \n\tpublic String model; \n\n\t"
					+ "//This is the Constructor with parameters. \n\t"
					+ "public Car(int year, String make, String model) { \n\t\tthis.year = year; \n\t\t"
					+ "this.make = make; \n\t\tthis.model = model; \n\t} \n\n\tpublic String carToString() { \n\t\t"
					+ "return(\"This car is a \" + year + make + model); \n\t} \n} \n\n"
					+ "public class Driver { \n\n\tpublic static void main(String[] args) { \n\t\t"
					+ "Car car = new Car(2015, Volkswagen, GTI); \n\t\tSystem.out.println(car.carToString);"
					+ "\n\t} \n}";

			// Exception Handling Labels
		} else if (item.getValue() == "Try and Catch") {
			description = "The try statement allows you to define a block of code to be tested for errors while \n"
					+ "it is being executed. \n\nThe catch statement allows you to define a block fo code to be "
					+ "executed, if an error \noccurs in the try block.";
			exampleCode = "import java.util.Scanner; \n\npublic class Main { \n\n\t"
					+ "public static void main(String[] args) throws Exception { \n\n\t\tint i = 1; \n\n\t\t"
					+ "System.out.println(\"Menu Directory: \\n\"); \n\t\tSystem.out.println(\"2: Menu2 \\n\");"
					+ "\n\t\tSystem.out.println(\"3: Menu3 \\n\"); \n\n\t\twhile (i == 1) { \n\t\t\ttry { \n\t\t\t\t"
					+ "Scanner scanner = new Scanner(System.in); \n\t\t\t\tint input = scanner.nextInt(); \n\t\t\t\t"
					+ "String menu; \n\n\t\t\t\tswitch (input) { \n\t\t\t\t\tcase1: menu = \"Main Menu\";"
					+ "\n\t\t\t\t\t\tbreak; \n\t\t\t\t\tcase 2: menu = \"Menu1\"; \n\t\t\t\t\t\tbreak;"
					+ "\n\t\t\t\t\tcase 3: menu = \"Menu2\"; \n\t\t\t\t\t\tbreak; \n\t\t\t\t\t"
					+ "default: menu = \"Menu does not exist!\"; \n\t\t\t\t\t\tbreak; \n\t\t\t\t} \n\t\t\t"
					+ "System.out.println(menu); \n\t\t\t} catch (Exception e) { \n\t\t\t\t"
					+ "System.out.println(\"Please enter a whole number!\"); \n\t\t\t} \n\t\t} \n\t} \n}";
		}

		label.setText(description);
		exampleLabel.setText(exampleCode);
	}
}