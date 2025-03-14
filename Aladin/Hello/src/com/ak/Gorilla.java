package com.ak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gorilla {

	public static void main(String[] args) {
		 
		Map<Integer,String > result = new HashMap<Integer,String > ();
		
		result.put(1, "Akash");
		result.put(2, "Mithra");
		result.put(3, "Dhiva");
		result.put(4, "Gokul");
		
		System.out.println(result);
		
		List<String> king = new ArrayList<String> ();
		
		
		for(String r : result.values()) {
			king.add(r);
		}
		List<hi> lList = new ArrayList<>();
		for(int i=0; i<king.size();i+=4) {
			 hi l = new hi();
		        l.setName1(king.get(i));
		        l.setName2(king.get(i + 1));
		        l.setName3(king.get(i + 2));
		        l.setName4(king.get(i + 3));
		        lList.add(l);
		}
		
		for (hi l : lList) {
	        System.out.println(l.StringValue());
	    }

	}
	
	static class hi{
		private String name1, name2,name3,name4;

		public String getName1() {
			return name1;
		}

		public void setName1(String name1) {
			this.name1 = name1;
		}

		public String getName2() {
			return name2;
		}

		public void setName2(String name2) {
			this.name2 = name2;
		}

		public String getName3() {
			return name3;
		}

		public void setName3(String name3) {
			this.name3 = name3;
		}

		public String getName4() {
			return name4;
		}

		public void setName4(String name4) {
			this.name4 = name4;
		}
		
		public String StringValue() {
			 return "name1='" + name1 + '\'' +
	                    ", name2='" + name2 + '\'' +
	                    ", name3='" + name3 + '\'' +
	                    ", name4='" + name4 + '\'';
		}
	}

}
