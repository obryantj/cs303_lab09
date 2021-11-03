public class HashMap{
    private Integer key;
    private Integer[] hash_map = new Integer[100];
    private int index;
    private String value;
    
    public void put(Integer key, String value){
        if(hash_map[index] == null){
            hash_map[index] = key;
        }
        if(hash_map != null){
            // call linear probing function
        }
    }
    public int getKey(int index){
        return hash_map[index];
    }

    public void linearProbe(int index, Integer key){

    }

    public int hashFunction(Integer key){
        int index = 
        return index;
    }


}