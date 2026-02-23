import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Employee 
{
        String name;
        String job;
        int salary;
        String dateOfJoining;

        Employee( String name,String job,int salary,String dateOfJoining)
        {
            this.name=name;
            this.job=job;
            this.salary=salary;
            this.dateOfJoining=dateOfJoining;
        }

        public String toString(){
            return name+" "+job+" "+salary+" "+dateOfJoining;
        }
}

public class EmployeDataManagement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Employee> details = new ArrayList<>();
        while(true)
        {
            System.out.println("Enter One of the following Options: ");
            System.out.println("1. Enter details\n2. Sort by Queries");
            System.out.println("3. Quit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    fillData(details);
                    break;
                case 2:
                    SortByQuery(details);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid Option...");
            }
        }
    }
    private static void SortByQuery(ArrayList<Employee> details) {
        while(true)
        {
            System.out.println("Enter the following options to sort accordingly:");
            System.out.println("1. Salary ascending Order\t\t\t2. Salary descending order");
            System.out.println("3. Date of joining ascending \t4. Date of joining descending\t5. Quit Queries window");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    Collections.sort(details,(a,b)->a.salary-b.salary);
                    System.out.println(details);
                    break;
                case 2:
                    Collections.sort(details,(a,b)->b.salary-a.salary);
                    System.out.println(details);
                    break;
                case 3:
                    sortByDOJASD(details);
                    break;
                case 4:
                    sortByDOJDEC(details);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Option...");
                    break;
            }
        }
    }

    private static void sortByDOJASD(ArrayList<Employee> details) {
        Collections.sort(details,new Comparator<Employee>(){
            public int compare(Employee a,Employee b)
            {
                String[] dojA = a.dateOfJoining.split("-");
                String[] dojB = a.dateOfJoining.split("-");
                if(Integer.parseInt(dojA[2])-Integer.parseInt(dojB[2])==0){
                    if(Integer.parseInt(dojA[1])-Integer.parseInt(dojB[1])==0){
                        return Integer.parseInt(dojA[0])-Integer.parseInt(dojB[2]);
                    }
                    else
                        return Integer.parseInt(dojA[1])-Integer.parseInt(dojB[1]);
                }
                else
                    return Integer.parseInt(dojA[2])-Integer.parseInt(dojB[2]);
            }
        });
        System.out.println(details);
    }

    private static void sortByDOJDEC(ArrayList<Employee> details) {
        Collections.sort(details,new Comparator<Employee>(){
            public int compare(Employee a,Employee b)
            {
                String[] dojA = a.dateOfJoining.split("-");
                String[] dojB = a.dateOfJoining.split("-");
                if(Integer.parseInt(dojB[2])-Integer.parseInt(dojA[2])==0){
                    if(Integer.parseInt(dojB[1])-Integer.parseInt(dojA[1])==0){
                        return Integer.parseInt(dojB[0])-Integer.parseInt(dojA[2]);
                    }
                    else
                        return Integer.parseInt(dojB[1])-Integer.parseInt(dojA[1]);
                }
                else
                    return Integer.parseInt(dojB[2])-Integer.parseInt(dojA[2]);
            }
        });
        System.out.println(details);
    }
    private static void fillData(ArrayList<Employee> details) {
        // System.out.println("Number of stores data you want to enter :");
        // int N=sc.nextInt();
        // for(int i=0;i<N;i++)
        // {
        //     String name,job,dateOfJoining;
        //     int salary;
        //     System.out.println("Enter Employee Name"); name=sc.next();
        //     System.out.println("Enter employee job role"); job=sc.next();
        //     System.out.println("Enter employee salary :"); salary=sc.nextInt();
        //     System.out.println("Enter date of joining"); dateOfJoining=sc.next();
        //     details.add(new Employee(name, job, salary, dateOfJoining));
        // }
        details.add(new Employee("Gagan", "SDE", 1000000, "10-10-2000"));
        details.add(new Employee("Gagan", "SDE-2", 2000000, "10-10-2010"));
    }
}
