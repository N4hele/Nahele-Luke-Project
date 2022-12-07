import java.awt.*;

public class Racer {

    // how far this dot has run    
    private int distance;
    private Color color;
    private String name;
    
    public Racer(String name, Color color) {
        this.name = name;
        this.color = color;
        this.distance = 0;
    }

    // Note: all of this classes instance variables are private.  The only way for 
    //  other classes to get their value is to use the 'accessor' -- the method that
    //  returns that instance variables value.  
    
    public int getDistance () {
        return (distance);
    }
    
    public void moved(int n) {
        distance = distance + n;
    }
    
    public Color getColor() {
        return(color);
    }
    
    public String getName() {
        return(name);
    }
}