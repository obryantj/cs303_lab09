import java.util.ArrayList;

public class Collision extends HashEntry{private ArrayList<HashElement> collision_list; 
    private ArrayList<HashElement> collision_list; 

    public Collision(){
        this.collision_list = new ArrayList<HashElement>();
    }

    public void add(HashElement hele){
        this.collision_list.add(hele);
    }

    public ArrayList<HashElement> getHashElements(){
        return this.collision_list;
    }

    
}
