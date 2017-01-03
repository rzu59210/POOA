package drawing;

/**
 * Created by kevin on 12/12/2016.
 */
public class Prototype {
    public Prototype(){

    }

    public Object Clone(){
        try{
            return this.clone();
        }catch (CloneNotSupportedException e){
            return new Exception(e);
        }
    }
}
