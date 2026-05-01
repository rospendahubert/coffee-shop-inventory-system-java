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