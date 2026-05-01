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