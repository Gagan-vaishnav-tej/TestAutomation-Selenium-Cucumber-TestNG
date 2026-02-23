package programs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student
{
	String name;
	float cgpa;
	int id;
	Student(String name,float cgpa,	int id)
	{
		this.name=name;
		this.cgpa=cgpa;
		this.id=id;
	}
	public String toString() {
		return name+"  "+cgpa+"  "+id;
	}
}
public class PriorityServing {

	public static void main(String[] args) {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o2.cgpa-o1.cgpa==0)
				{
					if(o1.name.compareTo(o2.name)==0)
					{
						return o2.id-o1.id;
					}else return o1.name.compareTo(o2.name);
				}else return o2.cgpa-o1.cgpa>0?1:-1;
			}
		});
		
		System.out.println("Enter number of input statement:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String command = sc.next().toLowerCase();
			if(command.equals("enter"))
			{
				String name = sc.next();
				float cgpa = sc.nextFloat();
				int id = sc.nextInt();
				queue.add(new Student(name,cgpa, id));
			}
			else
			{
				queue.poll();
			}
			System.out.println(queue.size());
			System.out.println(queue.peek().toString());
		}
		System.out.println("Remaining Entries:");
		while(!queue.isEmpty())
		{
			System.out.println(queue.peek().toString());
			queue.poll();
		}

	}

}
