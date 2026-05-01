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