public class HashEntry{
    private HashElement hele;
    private Collision c;
    private Boolean collision_flag = false;
    private int index;



    public int getIndex(){
        return this.index;
    }

    public void setHashElement(HashElement hele){
        this.hele = hele;
    }

    public HashElement getHashElement(){
        return this.hele;
    }

    public void setCollision(Collision c){
        this.c = c;
    }

    public Collision getCollision(){
        return this.c;
    }

    public Boolean getCollisionFlag(){
        return this.collision_flag;
    }
    public void setCollisionFlag(Boolean b){
        this.collision_flag = b;
    }


    // public String toString(){
    //     String s = getHashElement();
    //     return s;
    // }


}