import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;


public class Pong extends JPanel implements ActionListener, KeyListener
{
    private final int Rec1_width=20;
    private final int Rec1_height=80;
    private final int Rec2_width=20;
    private final int Rec2_height=80;
    private final int ball_width=20;
    private final int ball_height=20;
    private final int LocX_rec1=8;
    private final int LocX_rec2=1250;
    int k=6;
    int LocY_rec1=10,LocY_rec2=10,LocX_B=630,LocY_B=350;
    int velY1,velY2,velX_b,velY_b,flag=0,q,points1=0,points2=0,miss1=0,miss2=0;
    float top,bot,cen,tot;double slope;
    Timer tm=new Timer(1,this);
    boolean collision=false;
    public Pong()
    {
        tm.start();
        addKeyListener(this);
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
	    }
	public void paintComponent(Graphics g)
	 {
	     super.paintComponent(g);
	     g.setColor(Color.GREEN);
	     g.fillRect(0,0,1280,800);
	     g.setColor(Color.BLUE);
	     g.fillRect(LocX_rec1,LocY_rec1,Rec1_width,Rec1_height);
	     g.setColor(Color.BLUE);
	     g.fillRect(LocX_rec2,LocY_rec2,Rec2_width,Rec2_height);
	     g.setColor(Color.BLACK);
	     g.fillRect(640,0,2,2000);
	     g.setColor(Color.RED);
	     g.fillOval(LocX_B,LocY_B,ball_width,ball_height);
         g.setColor(Color.black);
         g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
         g.drawString("HITS= "+points1, 40, 50);
         g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
         g.setColor(Color.black);
         g.drawString("HITS= "+points2, 1100, 50);
         g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
         g.setColor(Color.white);
         g.drawString("MISS= "+miss1, 40, 700);
         g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
         g.setColor(Color.white);
         g.drawString("MISS= "+miss2, 1100, 700);
          g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
         g.setColor(Color.BLACK);
         g.drawString("WARNING: WALLS ARE BOUNCY !!! ENJOY ", 300, 700);
         
         if(collision==true){
          
           g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
           g.setColor(Color.black);
           g.drawString("LOL",400,100);}
           
	    
     }
	public void actionPerformed(ActionEvent e)
	{Random r=new Random();
	    if(LocY_rec1<10)
	    {
	        LocY_rec1=11;
	       }
	    if(LocY_rec1>650)
	    {
	        LocY_rec1=650;
	    }
	    if(LocY_rec2<10)
	    {
	        LocY_rec2=11;
	       }
	    if(LocY_rec2>650)
	    {
	        LocY_rec2=650;
	    }
	    if(LocX_B<5)
	    {
	       //LocX_B=5;
	       
	    if((LocY_B>LocY_rec1)&&(LocY_B<LocY_rec1+80))
	        {velX_b=3;
	         points1++;
	         repaint();}
	        else
	         {velX_b=3;
	         collision=true;
	         miss1++;
	         repaint();}
	         
	       }
	    if(LocX_B>1240)
	    {
	        //LocX_B=860;
	        velX_b=3;
	        if((LocY_B>LocY_rec2)&&(LocY_B<LocY_rec2+80))
	        {velX_b=-3;
	         points2++;
	         repaint();}
	         else
	         {velX_b=-3;
	         collision=true;
	         miss2++;
	         repaint();}
	    }
	    if(LocY_B<5)
	    {
	        LocY_B=5;
	        if(velX_b<0)
	        velX_b=(-1)*(r.nextInt((6 - 2) + 1) + 2);

	        if(velX_b>0)
	        velX_b=(r.nextInt((6 - 2) + 1) + 2);
	        velY_b=(r.nextInt((6 - 2) + 1) + 2);
	    }
	    if(LocY_B>700)
	    {
	        LocY_B=700;
	        
	        if(velX_b<0)
	        velX_b=(-1)*(r.nextInt((6 - 2) + 1) + 2);
	        if(velX_b>0)
	        velX_b=(r.nextInt((6 - 2) + 1) + 2);
	        velY_b=-1*(r.nextInt((6 - 2) + 1) + 2);
	    }
	    LocY_rec1=LocY_rec1+velY1;
	    LocY_rec2=LocY_rec2+velY2;
        LocX_B=LocX_B+velX_b;
	    LocY_B=LocY_B+velY_b;
	    collision=false;
	    
	    repaint();
	   }
	   public void keyPressed(KeyEvent e){
	    char code=e.getKeyChar();
	    if(code=='o')
	    {velY2=-12;}
	    if(code=='l'){
	    velY2=12;}
	    if(code=='s'){
	    velY1=12;}
	    if(code=='w'){
	    velY1=-12;}
	    if(code=='b'){
	    velX_b=3;velY_b=3;
	   }
	  }
	public void keyReleased(KeyEvent e)
	 { 
	   velY1=0; 
	   velY2=0;
	   
	 }
	
    public void keyTyped(KeyEvent e){}
	public static void main(String arge[])
      {
        JFrame f=new JFrame("PING PONG");
        f.setSize(1200,700);
        Pong s = new Pong();
        f.add(s);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setSize(900,700);
	    f.setVisible(true);
	   }
}