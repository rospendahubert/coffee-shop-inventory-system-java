import java.util.Scanner;

public class Menu{
	public static void main(String[] args){

		//User choice
		int choice;

		//Display Menu
		System.out.println("M E N U");
		System.out.println("=================");
		System.out.println("1. Americano");
		System.out.println("2. Latte");
		System.out.println("3. Espresso");
		System.out.println("4. Exit");
		System.out.println("=================");
		System.out.print("Enter choice");

		//Setup the Scanner
		Scanner in = new Scanner(System.in);

		//Get Choice from user
		choice = in.nextInt();

	//Menu loop
	while(choice!=4){
		//Check choice value
 		if (choice == 1){
			System.out.println("Americano Coffe!");

		}
		else if (choice ==2){
			System.out.println("Latte Coffe!");
		}

		else if (choice ==3){
			System.out.println("Espresso Coffe!");
		}
			//Display Menu
			System.out.println("M E N U");
			System.out.println("=================");
			System.out.println("1. Americano");
			System.out.println("2. Latte");
			System.out.println("3. Espresso");
			System.out.println("4. Exit");
			System.out.println("=================");
			System.out.print("Enter choice");

			//Get Choice from user
			choice = in.nextInt();


		}
		System.out.println("Goodbye, call again!");


	}
}


