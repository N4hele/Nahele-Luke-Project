    import java.awt.*;
    import javax.swing.*;
    import java.util.Random;
    import java.util.ArrayList;

    public class MashRace extends JPanel {

    private JFrame myFrame;
    private Random randGen = new Random();

    // the length in pixels of the track
    int trackLength = 300;
    int startLine = 50;
    // number of milliseconds (one thousanth of a second) to pause between each cycle
    int pauseTime = 15;
    Racer winnaWinnaWinn; // who has won (or null if nobody)
    int winnaEffectDiameter; // for the special effects at end
    int defaultDiameter = 70; // default diameter for the dot

    int topBorder = 10; // allow for the menu bar at the top of the frame
    int border = 10; // the border around the dots
    int sideBorder = startLine; // space after the finishLine
    int windowWidth = 500;
    int windowHeight= 500;

    int racer1X = 200;
    int racer1Y = 400;
    int racer2X = 300;
    int racer2Y = 400;


    // This ArrayList holds the Dot objects in the race
    ArrayList<Racer> racers = new ArrayList<Racer>();

    // constructor
    public MashRace() {
        initRacers();
        myFrame = new JFrame("Mash Racers");
        myFrame.add(this);
        myFrame.setSize(windowWidth, windowHeight);
        myFrame.setVisible(true);
        runRace();
    }

    public void initRacers(){
        racers.add(new Racer("Racer1", 200));
        racers.add(new Racer("Racer2", 300));
    }

    public void runRace(){
        while(true){
            
        }
    }

    public void paintComponent(Graphics g){
        super.repaint();
        for(Racer r:racers){
            drawRacer(r, g);
        }
        
    }

    

    public void drawRacer(Racer racer, Graphics g) {
        int topX = racer.getStartX();
        int topY = racer1Y + racer.getDistance();
        int drawDiam = 50;
        g.fillOval(topX, topY, drawDiam, drawDiam);
        g.setColor(Color.black);
        g.drawOval(topX, topY, drawDiam, drawDiam);
    }


}