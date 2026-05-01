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



import java.io.*;
public class Coffee{
	// Data members
	private double value;
	private String name;
	private static final int REGLEN = 20; // max reg length
	// Constructors
	public Coffee(){name = " "; value = 0.0;}
	public Coffee(String name, double value){
		this.name = name;
		this.value = value;
	}
	// Write the car data to an output stream
	public void put(DataOutputStream dout){
		StringBuffer st = new StringBuffer(name);
		st.setLength(REGLEN);
		String strName = st.toString();
		try{
			dout.writeChars(strName);
			dout.writeDouble(value);
		}
		catch(IOException e){e.printStackTrace();}
	}
	// Read car data from an input stream
	public void get(DataInputStream din){
		StringBuffer st = new StringBuffer(REGLEN);
		try{
			for(int i = 0; i < REGLEN; i++){
				char c = din.readChar();
				st.append(c);
			}
			name = st.toString().trim();
			value = din.readDouble();
		}
		catch(IOException e){e.printStackTrace();}
	}
	// Return the car data as a String
	public String toString(){
		return name + " " + value;
	}

}
import java.io.*;
import java.util.ArrayList;

public class CoffeeReader{
	public static void main(String[] args){
		try{
			FileInputStream fin = new FileInputStream("inventory.txt");
			DataInputStream din = new DataInputStream(fin);

			// Create a collection of Car objects
			ArrayList<Coffee> coffee = new ArrayList<Coffee>();

			while(din.available() > 0){
				Coffee c = new Coffee();
				c.get(din);
				coffee.add(c);
			}

			// Display the cars
			for(int i = 0; i < coffee.size(); i++){
				System.out.println(coffee.get(i).toString());
			}
			din.close();
		}
		catch(IOException e){e.printStackTrace();}
	}
}
import java.io.*;
import java.util.ArrayList;

public class CoffeeWriter{
	public static void main(String[] args){
		try{
			FileOutputStream fout = new FileOutputStream("inventory.txt");
			DataOutputStream dout = new DataOutputStream(fout);

			// Create a collection of Car objects
			ArrayList<Coffee> coffee = new ArrayList<Coffee>();
			coffee.add(new Coffee("Cappuccino", 2.50));
			coffee.add(new Coffee("Latte", 3.00));
			coffee.add(new Coffee("Espresso", 2.00));
			coffee.add(new Coffee("Americano", 2.50));

			// Write the cars to file
			for(int i = 0; i < coffee.size(); i++){
				coffee.get(i).put(dout);
			}
			dout.close();
		}
		catch(IOException e){e.printStackTrace();}
	}
}
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



import java.util.Scanner;

public class Menu2{

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
 		if (choice == options[0]){
			System.out.printf("%s coffe %.2f\n",menuItems[0] , prices[0]);

		}
		else if (choice == options[1]){
			System.out.printf("%s coffe %.2f\n",menuItems[1] , prices[1]);
		}

		else if (choice == options[2]){
			System.out.printf("%s coffe %.2f\n",menuItems[2] , prices[2]);
		}

		else if(choice == options[3]){
			System.out.printf("%s coffe %.2f\n",menuItems[3] , prices[3]);
		}
			//Display Menu
			displayMenu(options , menuItems ,prices);


			//Get Choice from user
			choice = in.nextInt();


		}
		System.out.println("Goodbye, call again!");


	}
}


