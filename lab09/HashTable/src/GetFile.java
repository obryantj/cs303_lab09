import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

public class GetFile {

    public static int[] getIntFile(File f){
        // make an array list and copy it to an array
        try{
            ArrayList<Integer> al = new ArrayList<Integer>();
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                al.add(sc.nextInt());
            }
            sc.close();

            int s = al.size();
            int[] A = new int[s];
            for (int i = 0; i < s; i++){ // copy array list to array
                A[i] = al.get(i);
            }
            return A;
        }
        catch(FileNotFoundException fnf){
            System.out.println("file not found");
            // I have to return something or java get mad
            int[] B = new int[0];
            return B;
        }
    }
    public static String[] getStringFile(File f){
        try{
            ArrayList<String> al = new ArrayList<String>();
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                al.add(sc.nextLine());
            }
            sc.close();

            // remove the empty lines
            int s = al.size();
            for (int j = 0; j < s; j++){
                if(al.get(j).isEmpty()){
                    al.remove(j);
                    s = s - 1; // have to decrement s or loop breaks
                }
            }
            // copy array list to array
            int s2 = al.size();
            String[] A = new String[s2];
            for (int i = 0; i < s2; i++){ 
                A[i] = al.get(i); 
            }
            return A;
        }
        catch(FileNotFoundException fnf){
            System.out.println("file not found");
            // I have to return something or java get mad
            String[] B = new String[0];
            return B;
        }
    }
}
