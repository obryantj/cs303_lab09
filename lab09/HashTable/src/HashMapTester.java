import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class HashMapTester {
    
    public static void main(String[] args) throws Exception {


        // CHANGE THIIS FILE PATH WHEN YOU TURN IT IN
        File f = new File("C:\\Users\\Josh O'Bryant\\Documents\\_School\\UAB\\CS303\\lab\\cs303_lab09\\lab09\\HashTable\\src\\newUPC-random.csv");
        String[] input = GetFile.getStringFile(f);
        ArrayList<ArrayList<String>> list_ception = parseThing(input);
        Scanner sc = new Scanner(System.in);
        sc.close();

        // make a new hashmap object
        HashMap hm = new HashMap(100);

        // add the elements to the hashmap
        for(ArrayList<String> a:list_ception){
            long key = Long.parseLong(a.get(0));
            System.out.println(key);
            String value  = a.get(1);
            HashElement he = new HashElement(key, value);
            hm.put(he);
        }



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
