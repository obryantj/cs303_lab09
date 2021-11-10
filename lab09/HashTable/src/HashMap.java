import java.util.Arrays;
import java.util.ArrayList;

public class HashMap{

    private HashElement[] hash_map;
    private int size;

    public HashMap(int size){
        this.size = size;
        this.hash_map = new HashElement[size];
    }

    public int getSize(){
        return this.size;
    }
    
    public Boolean isMapFull(){
        for (int i = 0; i < this.size; i++){
            if (hash_map[i] == null){
                return false;
            }
        }
        return true;
    }

    public void put(HashElement hele){
        // call the hash function
        int index = hashFunction(hele);

        if(hash_map[index] == null){
            // there was no collision so just add it in
            hash_map[index] = hele;
        }
        else{ // collision!
            // since we aren't probing who cares
            // just add it in
            hash_map[index] = hele;
        }
    }

    public HashElement get(HashElement fake_hele){
        // have to get it using the hash function
        int index = hashFunction(fake_hele);
        return hash_map[index];
    }    

    public void linearPut(HashElement hele){
        // call the hash function
        int index = linearHashFunction(hele);
        hash_map[index] = hele;  
    }

    public HashElement linearGet(HashElement fake_hele){
        int index = linearHashFunction(fake_hele);
        return hash_map[index];
    }

    public void quadPut(HashElement hele){
        int index = quadHashFunction(hele);
        hash_map[index] = hele;  
    }

    public HashElement quadGet(HashElement fake_hele){
        int index = quadHashFunction(fake_hele);
        return hash_map[index];
    }



    public int linearProbe(int index){
        int probe = index;

        for(int i = 1; i < this.size; i++){
            probe = (index + i) % this.size; 
            if(probe >= this.size){
                // reset
                probe = 0;
            }
            if(hash_map[probe] == null){
                return probe;
            }
            if(isMapFull() == true){ // if the map is full just stop
                return probe;
            }
        }
        return probe;
    }

    public int quadraticProbe(int index){
        double probe = index;
        for(double i = 1; i < this.size; i++){
            probe = (index + Math.pow(index, i)) % this.size; 
            if(probe >= this.size){
                // reset
                probe = 0;
            }
            if(hash_map[(int)probe] == null){
                return (int)probe;
            }
            if(isMapFull() == true){ // if the map is full just stop
                return (int)probe;
            }
        }
        return (int) probe;
    }

    public int hashFunction(HashElement he){
        long key = he.getKey();
        long index2 = key % this.size;
        int index = (int) index2;
        return index;
    }

    public int linearHashFunction(HashElement he){
        long key = he.getKey();
        long index2 = key % hash_map.length;
        int index = (int) index2;

        // check if the space was free
        if(hash_map[index] == null){
            hash_map[index] = he;
        }
        else{ // collision! or out of bounds
            // call linear probing function
            // overwriting even if something else was there
            index = linearProbe(index);
        } 
        return index;
    }

    public int quadHashFunction(HashElement he){
        long key = he.getKey();
        long index2 = key % hash_map.length;
        int index = (int) index2;

        // check if the space was free
        if(hash_map[index] == null){
            hash_map[index] = he;
        }
        else{ // collision! or out of bounds
            // call linear probing function
            // overwriting even if something else was there
            index = quadraticProbe(index);
        } 
        return index;
    }

    public String toString(){  
        int i = 0;
        String[] elements = new String [this.size];
        for(HashElement hele:this.hash_map){
            elements[i] = "\nindex: " + i + hele.toString();
            i += 1;
        }
        String s = Arrays.toString(elements);
        return s;
    }


}