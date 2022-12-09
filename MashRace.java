import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

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
    int windowWidth = 600;
    int windowHeight= 1000;

 
    int racerY = 900;






    // This ArrayList holds the Dot objects in the race
    ArrayList<Racer> racers = new ArrayList<Racer>();
    // constructor
    public MashRace() {
        KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
        initRacers();
        myFrame = new JFrame("Mash Racers");
        myFrame.add(this);
        myFrame.setSize(windowWidth, windowHeight);
        myFrame.setVisible(true);
        runRace();
    }

    public void initRacers(){
        racers.add(new Racer("Racer 1", 130));
        racers.add(new Racer("Racer 2", 400));
    }

    public void runRace(){
        while(endgame == false){
            
        }
    }

    public void paintComponent(Graphics g){
        super.repaint();
        g.drawLine(-100, 101, 700 , 101);
        g.drawLine(-100, 102, 700 , 102);
        g.drawLine(-100, 103, 700 , 103);
        g.drawLine(-100, 104, 700 , 104);

        for(Racer r:racers){
            drawRacer(r, g);
        }
        
    }

    public class MyKeyListener implements KeyListener{
        @Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("A") && endgame == false){
                racers.get(0).moved(-10);
            }
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("L") && endgame == false){
                racers.get(1).moved(-10);
		    }
        }
    }

    private boolean endgame;
    public void drawRacer(Racer racer, Graphics g) {
        int topX = racer.getStartX();
        int topY = racerY + racer.getDistance();
        int drawDiam = 50;
        if(topY<100){
            g.setFont(new Font("Ariel", Font.BOLD, 72));
            g.drawString(racer.getName() + " WINS", 65, 97);
            System.out.println(racer.getName() + " WINS");
            endgame = true;
        }

        g.setColor(Color.green);
        g.fillOval(topX, topY, drawDiam, drawDiam);
        g.setColor(Color.black);
        g.drawOval(topX, topY, drawDiam, drawDiam);

       
        g.setColor(Color.white);
        g.fillOval(topX, topY, drawDiam-30, drawDiam-30);
        g.fillOval(topX+30, topY, drawDiam-30, drawDiam-30);
    
        g.setColor(Color.black);
        g.drawOval(topX+30, topY, drawDiam-30, drawDiam-30);
        g.drawOval(topX, topY, drawDiam-30, drawDiam-30);

        g.fillOval(topX+5, topY, drawDiam-40, drawDiam-40);
        g.fillOval(topX+35, topY, drawDiam-40, drawDiam-40);

        

    }


    
}
