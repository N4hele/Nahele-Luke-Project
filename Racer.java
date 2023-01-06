import java.awt.*;
import java.lang.Thread.State;

public class Racer {

    // how far this dot has run    
    private int distance;
    private Color color;
    private String name;
    private int startX;
    
    public Racer(String name, int startX) {
        this.name = name;
        this.distance = 0;
        this.startX = startX;
        this.color = Color.green;
    }

    // Note: all of this classes instance variables are private.  The only way for 
    //  other classes to get their value is to use the 'accessor' -- the method that
    //  returns that instance variables value.  
    
    public int getDistance () {
        return (distance);
    }

    public int getStartX (){
        return startX;
    }
    
    public void moved(int n) {
        distance = distance + n;
    }
    
    public Color getColor() {
        return(color);
    }

    public void setColor(Color c){
        color = c;
    }
    
    public String getName() {
        return(name);
    }
}//final commit