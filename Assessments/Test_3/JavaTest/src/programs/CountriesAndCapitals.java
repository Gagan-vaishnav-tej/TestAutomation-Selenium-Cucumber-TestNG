package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountriesAndCapitals {

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> map= new HashMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no.of countries you want to Enter :");
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter contries Name:");
			String country = sc.next();
			map.put(country, new ArrayList<String>());
			System.out.println("Enter no.of capitals");
			int number = sc.nextInt();
			if(number==1) 
				map.get(country).add(sc.next());
			else if(number==2)
			{
				System.out.println("Enter Summer Capital:"); map.get(country).add(sc.next());
				System.out.println("Enter Winter Capital:"); map.get(country).add(sc.next());
			}
			else
			{
				System.out.println("Enter Summer Capital:"); map.get(country).add(sc.next());
				System.out.println("Enter Winter Capital:"); map.get(country).add(sc.next());
				System.out.println("Enter Rainy Capital:"); map.get(country).add(sc.next());
			}
		}
		
		// Print all countries, no.of capitals their names along with their capitals
		for(Map.Entry<String,ArrayList<String>> element:map.entrySet())
		{
			ArrayList<String> capitals = element.getValue();
			System.out.print(element.getKey()+"   "+" No.of capitals:"+capitals.size());
			for(int i=0;i<capitals.size();i++)
			{
				if(i==0)
				{
					System.out.println("Summer capitals: "+capitals.get(i));
				}
				else if(i==1)
				{
					System.out.println("Winter capitals: "+capitals.get(i));
				}
				else
				{
					System.out.println("Rainy capitals: "+capitals.get(i));
				}
			}
		}
		
		
		// Given particular Country
		System.out.println("Enter Required Country :");
		String requiredCountry=sc.next();
		ArrayList<String> capitals = map.get(requiredCountry);
		System.out.print(" No.of capitals:"+capitals.size());
		for(int i=0;i<capitals.size();i++)
		{
			if(i==0)
			{
				System.out.println("Summer capitals: "+capitals.get(i));
			}
			else if(i==1)
			{
				System.out.println("Winter capitals: "+capitals.get(i));
			}
			else
			{
				System.out.println("Rainy capitals: "+capitals.get(i));
			}
		}
		
		// Print countries with 2 capitals
		for(Map.Entry<String,ArrayList<String>> element:map.entrySet())
		{
			if(element.getValue().size()==2) System.out.println(element.getKey());
		}
		
		// Print countries with 3 capitals
		for(Map.Entry<String,ArrayList<String>> element:map.entrySet())
		{
			if(element.getValue().size()==3) System.out.println(element.getKey());
		}
		
		// Print countries that doesn't have summer capital
		for(Map.Entry<String,ArrayList<String>> element:map.entrySet())
		{
			if(element.getValue().size()==1) System.out.println(element.getKey());
		}
		
		//Find and return the capitals of the countries which start with vowels.
		ArrayList<Character> vowels = new ArrayList<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		for(Map.Entry<String,ArrayList<String>> element:map.entrySet())
		{
			if(vowels.contains(element.getKey().charAt(0)))
			{
				System.out.println(element.getKey()+"  capital(s):"+element.getValue());
			}
		}
		
		//Find and return the capitals of the countries which start with vowels.
		for(Map.Entry<String,ArrayList<String>> element:map.entrySet())
		{
			if(element.getValue().size()>1 && vowels.contains(element.getValue().get(0).charAt(0)))
			{
				System.out.println(element.getKey()+"  capital(s):"+element.getValue().get(0));
			}
		}
	}

}
