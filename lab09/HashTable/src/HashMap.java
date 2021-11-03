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

        // call the hash function
        int index = hashFunction(he);
        hash_map[index] = he;
    }

    public HashElement get(HashElement fake_he){
        // have to get it using the hash function
        int index = hashFunction(fake_he);
        HashElement he = hash_map[index];
        return he;
    }

    public int linearProbe(int index, long key){
        int probe = (index*7 + 1) % this.size;
        // need to go back around if probe is greater than size

        while(probe > this.size){
            probe = 0;
            probe = (index*7 + 1) % this.size;

        }
        return probe;
    }

    public int quadraticProbe(int index, int key){
        return index;
    }

    public int hashFunction(HashElement he){
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
            index = linearProbe(index, key);
        } 

        return index;
    }


}