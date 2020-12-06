
package proyecto1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.Timer;
import proyecto1.Proyecto1;
import static proyecto1.Proyecto1.frame;
import static proyecto1.Proyecto1.menu;
import static proyecto1.Proyecto1.p_niveles;
import proyecto1.Utils;


public class P_niveles extends JPanel {
    Image bg;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    JPanel p1,p2,p3,p4;
    public static P_niveles menu;
    public static Level1 l1;
    public static Level2 l2;
    public static Level3 l3;
    public static Level4 l4;
    public static Level5 l5;
    public static Level6 l6;
    public static Level7 l7;
    public static Level8 l8;
    public static Level9 l9;

    P_niveles()
    {
        super(new GridLayout(4,1));
        Proyecto1.timer=new Timer(1, new Predecir());
       // this.setLayout(new FlowLayout(FlowLayout.CENTER,50,300));
        p1=new JPanel(); p2=new JPanel();p3=new JPanel();p4=new JPanel();
        b1=new JButton(); b2=new JButton();b3=new JButton();b4=new JButton();
        b5=new JButton(); b6=new JButton(); b7=new JButton();
        b8=new JButton();b9=new JButton();
        b10=new JButton();
  
       b1.setPreferredSize(new Dimension(100,150));b1.setOpaque(false);
       b2.setPreferredSize(new Dimension(100,150));b2.setOpaque(false);
       b3.setPreferredSize(new Dimension(100,150));b3.setOpaque(false);
       b4.setPreferredSize(new Dimension(100,150));b4.setOpaque(false);
       b5.setPreferredSize(new Dimension(100,150));b5.setOpaque(false);
       b6.setPreferredSize(new Dimension(100,150));b6.setOpaque(false);
       b7.setPreferredSize(new Dimension(100,150));b7.setOpaque(false);
       b8.setPreferredSize(new Dimension(100,150));b8.setOpaque(false);
       b9.setPreferredSize(new Dimension(100,150));b9.setOpaque(false);
       b10.setPreferredSize(new Dimension(60,150));b10.setOpaque(false);
     
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(b10);
                
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,80,10));        
        p1.setOpaque(false);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
     
        p2.setLayout(new FlowLayout(FlowLayout.CENTER,80,10));
        p2.setOpaque(false);
        p2.add(b5);   
        p2.add(b6);
        p2.add(b7);
        
        p3.setLayout(new FlowLayout(FlowLayout.CENTER,80,10));
        p3.setOpaque(false);
        p3.add(b8);
        p3.add(b9);
        
        p4.setLayout(new FlowLayout(FlowLayout.TRAILING));
        p4.setOpaque(false);
        p4.add(b10);
    
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        p4.setVisible(true);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
      
       Proyecto1.frame.add(this);
            frame.setVisible(true);
            
            
            ////Actions of button
    b10.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
              goo();  
            } 
      });
    b1.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {  if(Proyecto1.permiso.get(0).equals("true"))
            gon1() ;} });
    
    b2.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {  if(Proyecto1.permiso.get(1).equals("true"))
            gon2(); } });
    
     b3.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {   if(Proyecto1.permiso.get(2).equals("true"))
            gon3();}  });
     
    b4.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {    if(Proyecto1.permiso.get(3).equals("true"))
            gon4();}  });
    
     b5.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {    if(Proyecto1.permiso.get(4).equals("true"))
            gon5();} });
     
    b6.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {    if(Proyecto1.permiso.get(5).equals("true"))
            gon6();} }); 
 
     b7.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {    if(Proyecto1.permiso.get(6).equals("true"))
            gon7();} }); 
     b8.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {    if(Proyecto1.permiso.get(7).equals("true"))
            gon8();} }); 
    b9.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {    if(Proyecto1.permiso.get(8).equals("true"))
            gon9();} }); 
    }

    public void gon1()
    {
                frame.remove(this);
                l1=new Level1();
                l1.run();
    }
    public void gon2()
    {
                frame.remove(this);
                l2=new Level2();
                l2.run();
    }
    
     public void gon3()
    {
                frame.remove(this);
                l3=new Level3();
                l3.run();
    }
    public void gon4()
    {
                frame.remove(this);
                l4=new Level4();
                l4.run();
    } 
    public void gon5()
    {
               frame.remove(this);
                l5=new Level5();
                l5.run();
    }
    public void gon6()
    {
                frame.remove(this);
                l6=new Level6();
                l6.run();
    }
    public void gon7()
    {
       frame.remove(this);
        l7=new Level7();
        l7.run();
    }
    public void gon8()
    {
        frame.remove(this);
        l8=new Level8();
        l8.run();
    }
    public void gon9()
    {
        frame.remove(this);
        l9=new Level9();
        l9.run();
    }
 
     public void goo()
      {
                Proyecto1.frame.remove(this);
               Proyecto1.menu=new Proyecto1();
                Proyecto1.frame.add(Proyecto1.menu);
               
      }
    
    
    private Dimension Dimension(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public class Predecir implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {            
            Utils.world.step(1.0f/60.0f,8,3);
            repaint();           
        }
    }
    
      public void run() {
        Proyecto1.timer.stop();      
       Proyecto1.frame.add(this);
       Proyecto1.frame.setVisible(true);
      
    }
     

    public void paint(Graphics g)
     {
       
         Graphics2D g2d = (Graphics2D)g;
         g2d.clearRect(0,0,1000,700);
         ImageIcon icono2;
          icono2=new ImageIcon(getClass().getResource("f10.jpg"));
            bg= new ImageIcon("Imagenes/f11.jpg").getImage();
           
            g2d.drawImage(bg,0,0,getWidth(),getHeight(),this);
            g2d.drawImage(new ImageIcon("Imagenes/n1.png").getImage() ,150,-10 ,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n2.png").getImage() ,330,-12 ,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n3.png").getImage() ,510,-10 ,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n4.png").getImage() ,690,-10 ,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n5.png").getImage() ,240, 150,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n6.png").getImage() ,420, 157,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n7.png").getImage() ,600,157 ,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n8.png").getImage() ,330,310 ,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/n9.png").getImage() ,510,310 ,150,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/felcha.png").getImage() ,895,500 ,100,150, this);         
            g2d.drawImage(new ImageIcon("Imagenes/drag2.png").getImage() ,5,330 ,310,400, this);
        
        
        
     }
}
