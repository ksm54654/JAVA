package chapter05;

//import 
import java.util.List;
import java.io.*;   	// * -> all(모든)을 의미함?

public class Armor {
	/*
	 * public void setHeight(int value) { height = value; }
	 */
		private String name;
		private int height;
		private int weight;
		private String color;
		private boolean isFly;
		
		public void setName() {
			String value = "mark6";
			name = value;
		}
		
		public String getName() {
			
			if (name == null)
				return "No Name";
			
			return name;
		}
	
}
