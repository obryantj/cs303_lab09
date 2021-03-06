

public class HashElement{
    private long key;
    private String value;
    

    public HashElement(long key, String value){
        this.key = key;
        this.value = value;
 
    }

    public void setKey(int key){
        this.key = key;
    }
    public long getKey(){
        return this.key;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }

    public String toString(){ 
        try{
        String s = " key: " + getKey() + " value: " + getValue();
        return s;
        }
        catch(NullPointerException npe){
            return "hash element was null";
        }
    }

}
