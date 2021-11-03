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
    
    public void put(HashElement he){

        // get the key
        long key = he.getKey();
        
        // call the hash function
        int index = hashFunction(key);
        
        // check if the space was free
        if(hash_map[index] == null){
            hash_map[index] = he;
            
        }
        else{ // collision!
            // call linear probing function
            // overwriting even if something else was there
            index = linearProbe(index, key);
            hash_map[index] = he;
        }
    }

    public HashElement get(int index){
        return hash_map[index];
    }

    public int linearProbe(int index, long key){
        return index*7 + 1;
    }

    public int quadraticProbe(int index, int key){
        return index;
    }

    public int hashFunction(long key){
        int index = (int) key % hash_map.length;
        return index;
    }


}