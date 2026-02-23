package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum Season
{
	ALL,
	SUMMER,
	WINTER,
	RAINY;
}
public class CountriesAndCapitalsMethod {

	public static void main(String[] args) {
		HashMap<String, HashMap<Season, String>> map= new HashMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no.of countries you want to Enter :");
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter contries Name:");
			String country = sc.next();
			map.put(country, new HashMap<>());
			System.out.println("Enter no.of capitals");
			int number = sc.nextInt();
			if(number==1) 
				map.get(country).put(Season.ALL,sc.next());
			else if(number==2)
			{
				System.out.println("Enter Summer Capital:"); map.get(country).put(Season.SUMMER,sc.next());
				System.out.println("Enter Winter Capital:"); map.get(country).put(Season.WINTER,sc.next());
			}
			else
			{
				System.out.println("Enter Summer Capital:"); map.get(country).put(Season.ALL,sc.next());
				System.out.println("Enter Winter Capital:"); map.get(country).put(Season.WINTER,sc.next());
				System.out.println("Enter Rainy Capital:"); map.get(country).put(Season.RAINY,sc.next());
			}
		}
		
		// Print all countries, no.of capitals their names along with their capitals
		for(Map.Entry<String,HashMap<Season,String>> element:map.entrySet())
		{
			for(Map.Entry<Season,String> capital:element.getValue().entrySet())
			{
				System.out.print(capital.getKey()+" "+capital.getValue()+"   ");
			}
		}
		
		// Given particular Country
		System.out.println("Enter Required Country :");
		String requiredCountry=sc.next();
		HashMap<Season,String> capitals = map.get(requiredCountry);
		System.out.print(" No.of capitals:"+capitals.size());
		for(Map.Entry<Season,String> capital:map.get(requiredCountry).entrySet())
		{
			System.out.print(capital.getKey()+" "+capital.getValue()+"   ");
		}
		
		// Print countries with 2 capitals
		for(Map.Entry<String,HashMap<Season,String>> element:map.entrySet())
		{
			if(element.getValue().size()==2) System.out.println(element.getKey());
		}
		
		// Print countries with 3 capitals
		for(Map.Entry<String,HashMap<Season,String>> element:map.entrySet())
		{
			if(element.getValue().size()==3) System.out.println(element.getKey());
		}
		
		// Print countries that doesn't have summer capital
		for(Map.Entry<String,HashMap<Season,String>> element:map.entrySet())
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
		for(Map.Entry<String,HashMap<Season,String>> element:map.entrySet())
		{
			if(vowels.contains(element.getKey().charAt(0)))
			{
				for(Map.Entry<Season,String> capital:map.get(requiredCountry).entrySet())
				{
					System.out.print(capital.getKey()+" "+capital.getValue()+"   ");
				}
			}
		}
		
		//Find summer capitals of the countries which start with vowels.
		for(Map.Entry<String,HashMap<Season,String>> element:map.entrySet())
		{
			String summerCapital =element.getValue().getOrDefault(Season.SUMMER,null);
			if(summerCapital!=null)
			{
				if(vowels.contains(summerCapital.charAt(0)))
				{
					System.out.println(summerCapital);
				}
			}
		}
	}

}
