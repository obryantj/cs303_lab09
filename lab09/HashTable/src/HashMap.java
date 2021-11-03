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
        if(hash_map[index] == null && index >= 0 && index <= this.size){
            hash_map[index] = he;
            
        }
        else{ // collision! or out of bounds
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
        int probe = index*7 + 1;
        return probe;
    }

    public int quadraticProbe(int index, int key){
        return index;
    }

    public int hashFunction(long key){
        long index2 = key % hash_map.length;
        int index = (int) index2;

        // need a smaller number to fit in the 
        // desired size
        while(index >= this.size){
            index2 = key % 
            
        }

        return index;
    }


}