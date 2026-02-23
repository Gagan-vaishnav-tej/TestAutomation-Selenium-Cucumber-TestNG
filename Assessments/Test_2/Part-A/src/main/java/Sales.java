import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sales {
    static Scanner sc = new Scanner(System.in);

    private static void findQuery(HashMap<String,HashMap<String,Integer>> details)
    {
        while(true)
        {
            System.out.println("Enter the following Options:");
            System.out.println("1. Find all products of a store\t\t\t\t\t2. Find highest price in a particular store");
            System.out.println("3. Find the all stores where particular product is available\t4. Quit Queries window");
            int option = sc.nextInt();
            switch (option) 
            {
                case 1:
                        System.out.println("Enter store name:");
                        findProductsByStore(details,sc.next());
                        break;
                    case 2:
                        System.out.println("Enter store name:");
                        findHighest(details,sc.next());
                        break;
                    case 3:
                        System.out.println("Enter products Name:");
                        findStores(details,sc.next());
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Enter Valid Option...");
            }
            System.out.println("\n");
        }

    }

    private static void fillData(HashMap<String,HashMap<String,Integer>> details)
    {
        // System.out.println("Number of stores data you want to enter :");
        // int N=sc.nextInt();
        // for(int i=0;i<N;i++)
        // {
        //     System.out.println("Enter Store Name :");
        //     String store = sc.next();
        //     details.put(store,new HashMap<>());
        //     System.out.println("Enter number of items in the store :");
        //     int n = sc.nextInt();
        //     for(int j=0;j<n;j++){
        //         System.out.println("Enter product or item name :");
        //         String item = sc.next();
        //         System.out.println("Enter price of the product or item:");
        //         int price = sc.nextInt();
        //         details.get(store).put(item,price);
        //     }
        // }
        details.put("store1",new HashMap<>());
        details.put("store2",new HashMap<>());
        details.get("store1").put("apple",100);
        details.get("store1").put("banana",50);
        details.get("store1").put("avacado",200);
        
        details.get("store2").put("orange",120);
        details.get("store2").put("mango",150);
        details.get("store2").put("avacado",250);
    }
    
    private static void findProductsByStore(HashMap<String,HashMap<String,Integer>> details, String str) {
        HashMap<String,Integer> res = details.getOrDefault(str, null);
        System.out.println(res!=null?"Available products in store "+str+"are:\n"+res:"Store Not found");
    }
    private static void findStores(HashMap<String,HashMap<String,Integer>> details, String str) {
        System.out.println("Entered");
        System.out.println("Following are the stores where item or product"+str+" is avaliable :");
        boolean flag = false;
        for(Map.Entry<String,HashMap<String,Integer>> curr:details.entrySet())
        {
            if(curr.getValue().containsKey(str)){
                flag=true;
                System.out.println(curr.getKey());
            }
        }
        if(!flag) System.out.println(str+" is not Present in available Store");
    }
    private static void findHighest(HashMap<String,HashMap<String,Integer>> details, String str) {
        HashMap<String,Integer> map = details.getOrDefault(str, null);
        if(map==null || map.size()==0) {
            System.out.println("No Products Found");
            return;
        }
        int max = -1;
        String highestItem = "";
        for(Map.Entry<String,Integer> set:map.entrySet())
        {
            if(set.getValue()>max){
                max=set.getValue();
                highestItem = set.getKey();
            }
        }
        System.out.println(highestItem);
    }

    public static void main(String[] args)
    {
        HashMap<String,HashMap<String,Integer>> details = new HashMap<>();
        while(true)
        {
            System.out.println("Enter One of the following Options: ");
            System.out.println("1. Enter details\n2. Queries");
            System.out.println("3. Quit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    fillData(details);
                    break;
                case 2:
                    findQuery(details);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid Option...");
            }
        }
    }
    
}
