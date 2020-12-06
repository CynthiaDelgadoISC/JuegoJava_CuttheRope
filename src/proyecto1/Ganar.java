
package proyecto1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import proyecto1.Level1.tiempo;
import proyecto1.P_niveles;
import static proyecto1.P_niveles.l2;
import static proyecto1.P_niveles.l3;
import static proyecto1.P_niveles.l3;
import static proyecto1.P_niveles.l4;
import static proyecto1.P_niveles.l5;
import static proyecto1.P_niveles.l6;
import static proyecto1.P_niveles.l7;
import static proyecto1.P_niveles.l8;
import static proyecto1.P_niveles.l9;
import proyecto1.Proyecto1;
import proyecto1.Utils;
import static proyecto1.Proyecto1.frame;
import static proyecto1.Proyecto1.l1;
import static proyecto1.Proyecto1.timer;
import static proyecto1.Proyecto1.permiso;


public class Ganar extends JPanel{
    int cont;
    Image bg;
    int nivel;
    Timer clock;
    JButton b1, b2, b3;
    public P_niveles p;
   
    public Ganar( int _cont, int _nivel)
    {
        
        nivel=_nivel;
        if(nivel!=9)
        {
             Proyecto1.permiso.remove(nivel);
             Proyecto1.permiso.add(nivel, "true");
        }
        b1=new JButton(); b2=new JButton(); b3=new JButton();
        this.setLayout(new FlowLayout(FlowLayout.CENTER,100, 365));
        b1.setContentAreaFilled(false);
        b2.setContentAreaFilled(false);
        b3.setContentAreaFilled(false);
        b1.setPreferredSize(new Dimension(150,100));
        b2.setPreferredSize(new Dimension(100,150));
        b3.setPreferredSize(new Dimension(150,100));
       
        this.add(b1);
        this.add(b2);
        this.add(b3);
        
        cont=_cont;
        /*for(int i=0; i<Proyecto1.permiso.size(); i++)
            System.out.println(Proyecto1.permiso.get(i));*/
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               p_niveles();
            }});
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               regresar();
            }});
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               next();
            }});

    }
    
    public void p_niveles()
    {
       Proyecto1.frame.remove(this);
       p=new P_niveles();
       
        Proyecto1.frame.add(p);
    }
     public void regresar()
    {
        Proyecto1.frame.remove(this);
       switch(nivel)
       {
           case 1: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l1=new Level1();
                   l1.run();
                   break;
            case 2: 
                   
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l2=new Level2();
                   l2.run();
                   break;
             case 3: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l3=new Level3();
                   l3.run();
                   break;
              case 4: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l4=new Level4();
                   l4.run();
                   break;
            case 5: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l5=new Level5();
                   l5.run();
                   break;
            case 6: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l6=new Level6();
                   l6.run();
                   break;
            case 7: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l7=new Level7();
                   l7.run();
                   break;
            case 8: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l8=new Level8();
                   l8.run();
                   break;
            case 9: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l9=new Level9();
                   l9.run();
                   break;
             
           
       }        
       
    }
     public void next()
    {
       Proyecto1.frame.remove(this);
       switch(nivel+1)
       {
            case 2: 
                   
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l2=new Level2();
                   l2.run();
                   break;
             case 3: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l3=new Level3();
                   l3.run();
                   break;
             case 4: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l4=new Level4();
                   l4.run();
                   break;
             case 5: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l5=new Level5();
                   l5.run();
                   break;
            case 6: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l6=new Level6();
                   l6.run();
                   break;
            case 7: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l7=new Level7();
                   l7.run();
                   break;
            case 8: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l8=new Level8();
                   l8.run();
                   break;
             case 9: 
                   Proyecto1.timer.stop();
                   Proyecto1.timer=null;
                   l9=new Level9();
                   l9.run();
                   break;
             
       }           
    }
    
     public void paint(Graphics g)
     {
         
          Graphics2D g2d = (Graphics2D)g;
         g2d.clearRect(0,0,1000,700);
         ImageIcon icono2;
          icono2=new ImageIcon(getClass().getResource("f_ganar.jpg"));
            bg= new ImageIcon("Imagenes/f_ganar.jpg").getImage();
            g2d.drawImage(bg,0,0,getWidth(),getHeight(),this);
            
            //-----BARRA DE LOS HUEVOS OBTENIDOS------- 
           if(cont==0)
           {
               g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,225,100 ,180, 180, this);
                g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,385,80 ,180, 180, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,545,100 ,180, 180, this);
           }
           else if(cont==1)
           {
               g2d.drawImage(new ImageIcon("Imagenes/h11.png").getImage() ,225,100 ,180, 180, this);
                g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,385,80 ,180, 180, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage(),545,100 ,180, 180, this);
          
           }
           else if(cont ==2)
           {
               g2d.drawImage(new ImageIcon("Imagenes/h11.png").getImage() ,225,100 ,180, 180, this);
                g2d.drawImage(new ImageIcon("Imagenes/h11.png").getImage() ,385,80 ,180, 180, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,545,100 ,180, 180, this);
          
           }
           else{
               g2d.drawImage(new ImageIcon("Imagenes/h11.png").getImage() ,225,100 ,180, 180, this);
                g2d.drawImage(new ImageIcon("Imagenes/h11.png").getImage() ,385,80 ,180, 180, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h11.png").getImage() ,545,100 ,180, 180, this);
          
           }
           
            g2d.drawImage(new ImageIcon("Imagenes/flech1.png").getImage() ,150,380 ,300, 100, this);
             g2d.drawImage(new ImageIcon("Imagenes/rew.png").getImage(),370,350 ,300,150, this);
             if(nivel!=9)
              g2d.drawImage(new ImageIcon("Imagenes/flech2.png").getImage() ,550,390 ,300,100, this);
              g2d.drawImage(new ImageIcon("Imagenes/feliz.png").getImage() ,0,460 ,200, 200, this);
           
     } 
     
     
      public class Predecir implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {            
            Utils.world.step(1.0f/60.0f,8,3);
            repaint();           
        }
    }
    
      public void run() {
        
       Proyecto1.frame.add(this);
       Proyecto1.frame.setVisible(true);       
       Proyecto1.timer.start();   

       
    }
}

