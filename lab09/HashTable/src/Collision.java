import java.util.ArrayList;

public class Collision {
    private ArrayList<HashElement> collision_list; 

    public Collision(){
        this.collision_list = new ArrayList<HashElement>();
    }

    public ArrayList<HashElement> getCollision(){
        return this.collision_list;
    }
}
