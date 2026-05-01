import java.util.Scanner;

public class Menu3{

	public static void displayMenu(int opts[], String items[], double pr[]){
		//Display Menu
				System.out.println("M E N U");
				System.out.println("=================");
				//Loop through options and items
				for(int i = 0; i < opts.length-1; i++){
					System.out.printf("%d. %s \t %.2f\n", opts[i], items[i], pr[i]);
				}
				//Print the exit options
				System.out.printf("%d. %s\n", opts[opts.length-1], items[items.length-1]);
				System.out.println("=================");
				System.out.print("Enter choice");
	}

	public static void main(String[] args){

		//User choice
		int choice;
		int choice2;
		double cash;
		double change;
		//Menu data
		int options[] = {1,2,3,4,5};
		String menuItems[] = {"Cappuccino", "Latte", "Espresso", "Americano", "Exit"};
		double prices[] = {2.50, 3.00, 2.00, 2.50};
		//Exit option
		int EXIT = options[options.length-1];



		//Display Menu
		displayMenu(options , menuItems, prices );


		//Setup the Scanner
		Scanner in = new Scanner(System.in);

		//Get Choice from user
		choice = in.nextInt();

	//Menu loop
	while(choice!= EXIT){
		//Check choice value
 		if (choice==options[0]){
			System.out.println("----");
			System.out.println("1.Cash");
			System.out.println("2.Card");
			System.out.println("----");
			choice2=in.nextInt();
			if (choice2 > 0 && choice2 < 3){
				if(choice2 == 1){
					System.out.print("Enter Cash");
					cash=in.nextDouble();
					if(cash >= 2.50){
						change=cash-2.50;
						System.out.println("Here is your coffee. Change" + change);
					}
					else
						System.out.print("Not enough");

							System.out.println();
				}
				if (choice2==2){
					System.out.println("Here is your coffe and your card");

				}

			}




		}
		//Transactions
		else if (choice == options[1]){
			System.out.println("----");
			System.out.println("1.Cash");
			System.out.println("2.Card");
			System.out.println("----");
			choice2=in.nextInt();
			if (choice2 > 0 && choice2 < 3){
				if(choice2 == 1){
					System.out.print("Enter Cash");
					cash=in.nextDouble();
					if(cash >= 3.00){
						change=cash-3.00;
						System.out.println("Here is your coffee. Change" + change);
					}
					else
						System.out.print("Not enough!");
						System.out.println();
				}
				if (choice2==2){
					System.out.println("Here is your coffe and your card");

				}

			}
		}

		else if (choice == options[2]){
			System.out.println("----");

			System.out.println("1.Cash");

			System.out.println("2.Card");

			choice2=in.nextInt();
			if (choice2 > 0 && choice2 < 3){
				if(choice2 == 1){
						System.out.print("Enter Cash");
					cash=in.nextDouble();
					if(cash >= 2.00){
						change = cash-2.00;
						System.out.println("Here is your coffee. Change" + change);
					}
					else
						System.out.print("Not enough!");
						System.out.println();
				}
				if (choice2==2){
					System.out.println("Here is your coffee and your card");

				}

			}

		}

		else if(choice == options[3]){
			System.out.println("----");

			System.out.println("1.Cash");

			System.out.println("2.Card");

			System.out.println("----");

			choice2=in.nextInt();
			if (choice2 > 0 && choice2 < 3){
				if(choice2 == 1){
					System.out.print("Enter Cash");
					cash=in.nextDouble();
					if(cash >= 2.50){
						change=cash-2.50;
						System.out.println("Here is your coffee.Change" + change);
					}
					else
						System.out.print("Not enough!");

				}
				if (choice2==2){
					System.out.println("Here is your coffe andcar d");

				}

			}



		}
			//Display Menu
			displayMenu(options , menuItems ,prices);


			//Get Choice from user
			choice = in.nextInt();


		}
		//Goodbye Message
		System.out.println("Goodbye, call again!");


	}
}


