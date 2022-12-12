import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MashRace extends JPanel {

    private JFrame myFrame;
    private Random randGen = new Random();

    int windowWidth = 600;
    int windowHeight= 1000;
    boolean endgame;
    int racerY = 900;
    Color randColor = Color.green;
    

    ArrayList<Racer> racers = new ArrayList<Racer>();

    ArrayList<Color> colors = new ArrayList<Color>() {
        {

            add(Color.blue);
            add(Color.cyan);
            add(Color.green);
            add(Color.magenta);
            add(Color.yellow);
            add(Color.orange);
            add(Color.pink);
        }
    };

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
                racers.get(0).setColor(nextColor());
            }
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("L") && endgame == false){
                racers.get(1).moved(-10);
                racers.get(1).setColor(nextColor());
		    }
        }
    }

    
    public void drawRacer(Racer racer, Graphics g) {
        int topX = racer.getStartX();
        int topY = racerY + racer.getDistance();
        int drawDiam = 50;
        if(topY<100){
            g.setFont(new Font("Ariel", Font.BOLD, 72));
            g.drawString(racer.getName() + " WINS", 60, 97);
            System.out.println(racer.getName() + " WINS");
            endgame = true;
        }


        g.setColor(racer.getColor());
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




    



    int counter = 0;
    public Color nextColor() {
        counter++;
        if(counter < 4)
            return Color.cyan;
        if(counter < 7)
            return Color.yellow;

        if(counter > 8)
            counter = 0;
        return Color.magenta;
    }

}
