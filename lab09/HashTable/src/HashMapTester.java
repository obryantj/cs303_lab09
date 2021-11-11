import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class HashMapTester {
    
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        // make a new hashmap object
        HashMap hm = new HashMap(100);
        driver(sc, hm);
        sc.close();

    }


    public static void driver4(Scanner sc, HashMap hm, File f){ // file search
        System.out.println("\n\n**************************");
        System.out.println("      PROBING CHOICE");
        System.out.println("**************************");
        System.out.println("Enter 1 to not using probing");
        System.out.println("Enter 2 to use linear probing");
        System.out.println("Enter 3 to use quadratic probing");
        int choice = sc.nextInt();
        // sc.next(); // this makes it work somehow lol
        String[] input = GetFile.getStringFile(f);
        ArrayList<ArrayList<String>> list_ception3 = parseThing(input);        
        switch(choice){
            case 1: // search without probe
                long start = System.nanoTime();
                for(ArrayList<String> a:list_ception3){
                    long search_key = Long.parseLong(a.get(0));
                    String expected_value  = a.get(2);
                    HashElement fake_he2 = new HashElement(search_key, "");
                    HashElement returned_he = hm.get(fake_he2);
                    String returned_value = "";
                    try{
                        returned_value = returned_he.getValue();
                    }
                    catch(NullPointerException npe){
                        returned_value = "value was null";
                    }
                    System.out.println("\nFor key: " + search_key + "\nexpected value was: " + expected_value + "\nreturned value was: " + returned_value);
                } 
                long end = System.nanoTime();
                System.out.println("time to execute was: " + (end - start));
                break;
            case 2: // search with linear probe
                long start2 = System.nanoTime();
                for(ArrayList<String> a:list_ception3){
                    long search_key = Long.parseLong(a.get(0));
                    String expected_value  = a.get(2);
                    HashElement fake_he2 = new HashElement(search_key, "");
                    HashElement returned_he = hm.linearGet(fake_he2);
                    String returned_value = "";
                    try{
                        returned_value = returned_he.getValue();
                    }
                    catch(NullPointerException npe){
                        returned_value = "value was null";
                    }
                    System.out.println("\nFor key: " + search_key + "\nexpected value was: " + expected_value + "\nreturned value was: " + returned_value);
                } 
                long end2 = System.nanoTime();
                System.out.println("time to execute was: " + (end2 - start2));
                break;
            case 3: // search with quad probe
                long start3 = System.nanoTime();
                for(ArrayList<String> a:list_ception3){
                    long search_key = Long.parseLong(a.get(0));
                    String expected_value  = a.get(2);
                    HashElement fake_he2 = new HashElement(search_key, "");
                    HashElement returned_he = hm.quadGet(fake_he2);
                    String returned_value = "";
                    try{
                        returned_value = returned_he.getValue();
                    }
                    catch(NullPointerException npe){
                        returned_value = "value was null";
                    }
                    System.out.println("\nFor key: " + search_key + "\nexpected value was: " + expected_value + "\nreturned value was: " + returned_value);
                } 
                long end3 = System.nanoTime();
                System.out.println("time to execute was: " + (end3 - start3));
                break;
            default:
                System.out.println("Please enter a valid command");
                break;
        }
    }

    public static void driver3(Scanner sc, HashMap hm){ //manual search
        System.out.println("\n\n**************************");
        System.out.println("      PROBING CHOICE");
        System.out.println("**************************");
        System.out.println("Enter 1 to not use probing");
        System.out.println("Enter 2 to use linear probing");
        System.out.println("Enter 3 to use quadratic probing");
        int choice = sc.nextInt();
        switch(choice){
            case 1: // search without probe
                System.out.println("Enter search key");
                long key = sc.nextLong();
                HashElement fake_he = new HashElement(key, "");
                long start = System.nanoTime();
                HashElement he = hm.get(fake_he);
                long end = System.nanoTime();
                System.out.println("\nHash info: " + he);
                System.out.println("time to execute was: " + (end-start));
                break;
            case 2: // search with linear probe
                System.out.println("Enter search key");
                long key2 = sc.nextLong();
                HashElement fake_he2 = new HashElement(key2, "");
                long start2 = System.nanoTime();
                HashElement he2 = hm.linearGet(fake_he2);
                long end2 = System.nanoTime();
                System.out.println("\nHash info: " + he2);
                System.out.println("time to execute was: " + (end2-start2));
                break;
            case 3: // search with quad probe
                System.out.println("Enter search key");
                long key3 = sc.nextLong();
                HashElement fake_he3 = new HashElement(key3, "");
                long start3 = System.nanoTime();
                HashElement he3 = hm.quadGet(fake_he3);
                long end3 = System.nanoTime();
                System.out.println("\nHash info: " + he3);
                System.out.println("time to execute was: " + (end3-start3));
                break;
            default:
                System.out.println("Please enter a valid command");
                break;
        }
    }

    public static void driver2(Scanner sc, HashMap hm, File f){ // hash table build methods
        System.out.println("\n\n**************************");
        System.out.println("      PROBING CHOICE");
        System.out.println("**************************");
        System.out.println("Enter 1 to not use probing");
        System.out.println("Enter 2 to use linear probing");
        System.out.println("Enter 3 to use quadratic probing");
        int choice = sc.nextInt();
        String[] input = GetFile.getStringFile(f);
        ArrayList<ArrayList<String>> list_ception = parseThing(input);
        switch(choice){
            case 1: // no probing
                // add the elements to the hashmap
                long start = System.nanoTime();
                for(ArrayList<String> a:list_ception){
                    long key = Long.parseLong(a.get(0));
                    String value  = a.get(1);
                    HashElement he = new HashElement(key, value);
                    hm.put(he);
                } 
                long end = System.nanoTime();
                System.out.println("\ntime to build was: " + (end - start));               
                break;
            case 2: // linear probing
                long start2 = System.nanoTime();
                for(ArrayList<String> a:list_ception){
                    long key = Long.parseLong(a.get(0));
                    String value  = a.get(1);
                    HashElement he = new HashElement(key, value);
                    hm.linearPut(he);
                }     
                long end2 = System.nanoTime();
                System.out.println("\ntime to build was: " + (end2 - start2));  
                break;
            case 3: // quad probing
                long start3 = System.nanoTime();
                for(ArrayList<String> a:list_ception){
                    long key = Long.parseLong(a.get(0));
                    String value  = a.get(1);
                    HashElement he = new HashElement(key, value);
                    hm.quadPut(he);
                }  
                long end3 = System.nanoTime();
                System.out.println("\ntime to build was: " + (end3 - start3));    
                break;
            default:
                System.out.println("Please enter a valid command");
                break;
        }
        driver(sc,hm);
    }

    public static void driver(Scanner sc, HashMap hm){
        System.out.println("\n\n**************************");
        System.out.println("       TESTING MENU");
        System.out.println("**************************");
        System.out.println("\nEnter 1 to make hashmap using the random order input file");
        System.out.println("Enter 2 to make hashmap using the sorted order input fie");
        System.out.println("Enter 3 to display the current hashmap");
        System.out.println("Enter 4 to maunually search hashmap");
        System.out.println("Enter 5 to search hashmap using the test file");
        System.out.println("Enter 6 to clear the hashmap");
        System.out.println("Enter 7 to exit");

        int choice = sc.nextInt();

        switch(choice){
            case 1: // make hashmap on random input file
                // CHANGE THIIS FILE PATH WHEN YOU TURN IT IN
                File f1 = new File("/home/josh/UAB/CS303/lab/lab09/cs303_lab09/lab09/HashTable/src/newUPC-random.csv");
                driver2(sc,hm,f1);
                break; 
            case 2: // make hashmap on sorted input file
                // CHANGE THIIS FILE PATH WHEN YOU TURN IT IN
                File f2 = new File("/home/josh/UAB/CS303/lab/lab09/cs303_lab09/lab09/HashTable/src/newUPC.csv");
                driver2(sc,hm,f2);
                break; 
            case 3: // display the current hashmap
                try{
                    System.out.println(hm.toString());
                }
                catch(NullPointerException npe){
                    System.out.println("There is no hash map");
                }
                
                break;
            case 4: // do manual search
                driver3(sc, hm);
                break;
            case 5: // do search using the test file
                // CHANGE THIIS FILE PATH WHEN YOU TURN IT IN
                File f3 = new File("/home/josh/UAB/CS303/lab/lab09/cs303_lab09/lab09/HashTable/src/input.dat");
                driver4(sc, hm, f3);
                break;
            case 6: //clear hashmap
                hm = new HashMap(100);
                break;
            case 7: // exit
                System.exit(0);
                break;
            default:
                System.out.println("\nEnter a valid command"); 
                break; 
        }

        driver(sc, hm);
    }


    public static ArrayList<ArrayList<String>> parseThing(String[] input){
        int l = input.length;
        ArrayList<ArrayList<String>> s_ception = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < l; i++){
            String[] split_line = input[i].split(",");
            int l_split_line = split_line.length;
            ArrayList<String> inner_list = new ArrayList<String>();
            for(int j = 0; j < l_split_line; j++){
                inner_list.add(split_line[j]);
            }
            s_ception.add(inner_list);
        } 
        return s_ception;
    }



}
