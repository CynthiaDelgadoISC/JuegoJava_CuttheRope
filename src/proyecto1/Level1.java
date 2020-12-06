
package proyecto1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

 class Level1 extends JPanel {
    Image bg;
    int nivel=1;
    Rope cuerda;
    Body candy;
    Timer clock;
    int seg=60, min=1;
   // JFrame frame;
    int cont=0;
    int xpet=460, ypet=500;
    int xh1= 487, yh1=250;
    int xh2= 487, yh2=350;
    int xh3= 487, yh3=450;
    public int ANCHO =1000;
    public int  ALTURA =700;
    boolean f1=true, f2=true, f3=true, time_flag=true;
    public static cortar c;
    
    
    Ganar menu_ganar;
    Perder menu_perder;
    
    Level1()
    {
        Utils.world=null;
        Utils.world = new World(new Vec2(0,-9.8f));
        clock = new Timer(1000,new tiempo());
        c = new cortar();
        cont=0;
        this.addMouseMotionListener(c);
        candy= new Candy(500,100, BodyType.DYNAMIC).crea_esfera();
        cuerda=new Rope(500,100,5, candy);
        Utils.addGround(1000,2);
        Utils.addRoof(1000,-10);
        Proyecto1.timer=new Timer(1, new Predecir());
        clock.start();
         if(Proyecto1.timer.isRunning())
         Proyecto1.timer.stop();
        Proyecto1.timer=null;
        Proyecto1.timer=new Timer(1, new Level1.Predecir());
        
    }
  
      class tiempo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            seg--;
             if(seg==0)
            {
                min--;
                seg=60;
            }
            if(min<0)
            {
               time_flag=false;
                min=1;
            }
               
            
        }
    }
    
     public class Predecir implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {            
            Utils.world.step(1.0f/60.0f,8,3);
            repaint();           
        }
    }
    
     public class cortar implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent me) {
              for(int i=0; i<cuerda.NO_OF_LINK; i++)
              {         
                  
                 if( me.getX()>(int)Utils.toPixelPosX(cuerda.cadena[i].getPosition().x)-5 && 
                     me.getX()<(int)Utils.toPixelPosX(cuerda.cadena[i].getPosition().x)+8 &&
                     me.getY()>(int)Utils.toPixelPosY(cuerda.cadena[i].getPosition().y)-5 && 
                     me.getY()<(int)Utils.toPixelPosY(cuerda.cadena[i].getPosition().y)+8  )
                            cuerda.Destroy_rope();
              }
        }

         @Override
        public void mouseMoved(MouseEvent me) {}
     }
     
     public void paint(Graphics g)
     {
         
         System.out.println("hola");
         Graphics2D g2d = (Graphics2D)g;
        g2d.clearRect(0,0,1000,700);
        ImageIcon icono2;
      
         icono2=new ImageIcon(getClass().getResource("f1.jpg"));
         bg= new ImageIcon("Imagenes/f1.jpg").getImage();
         g2d.drawImage(bg,0,0,getWidth(),getHeight(),this);
         
        
         g2d.setColor(Color.WHITE);
         g2d.setFont( new Font( "Calibri", Font.ITALIC, 50 ) );
          String imprime="";
          imprime+=Integer.toString(min);
          imprime+=" : ";
          imprime+=Integer.toString(seg);
        g2d.drawString(imprime,800,50);
        
        
       if(Over() && !Win() && time_flag)
       {
         
         for(int i=0;i<cuerda.NO_OF_LINK;i++)
        {
             if(cuerda.flag){ //entrara y dibujara la cuerda
           g2d.setColor(Color.WHITE);
              
            g2d.setStroke(new BasicStroke(5.0f)); //grosor linea
            if(i+1<cuerda.NO_OF_LINK) //Dibuja la cuerda
               g2d.drawLine((int)Utils.toPixelPosX(cuerda.cadena[i].getPosition().x),(int)Utils.toPixelPosY(cuerda.cadena[i].getPosition().y),     (int)Utils.toPixelPosX(cuerda.cadena[i+1].getPosition().x),(int)Utils.toPixelPosY(cuerda.cadena[i+1].getPosition().y)); //dibujalinea
            g2d.setColor(Color.BLUE);
            if(i+1==cuerda.NO_OF_LINK)//se dibjua la bola al final
                g2d.drawImage(new ImageIcon("Imagenes/candy.png").getImage() ,(int)Utils.toPixelPosX(cuerda.cadena[i].getPosition().x)-13,(int)Utils.toPixelPosY(cuerda.cadena[i].getPosition().y)-3,40, 40, this);
         
            else if (i==0) //dibuja el pin
               g2d.drawImage(new ImageIcon("Imagenes/pin.png").getImage() ,(int)Utils.toPixelPosX(cuerda.cadena[i].getPosition().x)-14,(int)Utils.toPixelPosY(cuerda.cadena[i].getPosition().y)-15,30, 30, this);
    
           }
           else //deja de dibujar la cuerda
            {
                g2d.setColor(Color.WHITE);
              
                 
                g2d.drawImage(new ImageIcon("Imagenes/pin.png").getImage() ,(int)Utils.toPixelPosX(cuerda.cadena[0].getPosition().x)-10,(int)Utils.toPixelPosY(cuerda.cadena[0].getPosition().y)-10,30, 30, this);
                if(i+1==cuerda.NO_OF_LINK)//se dibjua la bola al final
                 g2d.drawImage(new ImageIcon("Imagenes/candy.png").getImage() ,(int)Utils.toPixelPosX(cuerda.cadena[i].getPosition().x)-14,(int)Utils.toPixelPosY(cuerda.cadena[i].getPosition().y)-15,40, 40, this);
         
            }
 
        }  
        g2d.setColor(Color.WHITE);
            // DIBUJA EL DRAGON
            
            g2d.drawImage(new ImageIcon("Imagenes/pet.gif").getImage() ,xpet-80, ypet-20,150,190 , this);
           
         
            //HUEVO 1
            if( f1)
                g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,xh1, yh1,35, 35, this); //dibuja el huevo 
            if(((int)Utils.toPixelPosY(candy.getPosition().y)>yh1 &&(int)Utils.toPixelPosY(candy.getPosition().y)<yh1+35 ) && ((int)Utils.toPixelPosX(candy.getPosition().x)>xh1-20 && (int)Utils.toPixelPosX(candy.getPosition().x)<xh1+35+5))
            {
                if(f1) //para que solo cunete la primera vez que pase por esa posicion
                cont++;
                f1=false; //para dejar de dibujar el huevo
            }
            //HUEVO 2
            if(f2)
              g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,xh2, yh2,35, 35, this);
            if(((int)Utils.toPixelPosY(candy.getPosition().y)>yh2 &&(int)Utils.toPixelPosY(candy.getPosition().y)<yh2+35 ) && ((int)Utils.toPixelPosX(candy.getPosition().x)>xh2-20 &&(int)Utils.toPixelPosX(candy.getPosition().x)<xh2+35+5))
            {
                if(f2) 
                cont++;
                f2=false;
            }
            //HUEVO 3
            if(f3)
               g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,xh3, yh3,35, 35, this);
            if(((int)Utils.toPixelPosY(candy.getPosition().y)>yh3 &&(int)Utils.toPixelPosY(candy.getPosition().y)<yh3+35 ) && ((int)Utils.toPixelPosX(candy.getPosition().x)>xh3-20 &&(int)Utils.toPixelPosX(candy.getPosition().x)<xh3+35+5))
            {
                if(f3)
                cont++;
                f3=false;
            }
            
           //-----BARRA DE LOS HUEVOS OBTENIDOS------- 
           if(cont==0)
           {
               g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,50,20 ,45, 45, this);
                g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,100,20 ,45, 45, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,150,20 ,45, 45, this);
           }
           else if(cont==1)
           {
               g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,50,20 ,45, 45, this);
                g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,100,20 ,45, 45, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,150,20 ,45, 45, this);
          
           }
           else if(cont ==2)
           {
               g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,50,20 ,45, 45, this);
                g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,100,20 ,45, 45, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h7.png").getImage() ,150,20 ,45, 45, this);
          
           }
           else{
               g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,50,20 ,45, 45, this);
                g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,100,20 ,45, 45, this);
                 g2d.drawImage(new ImageIcon("Imagenes/h1.png").getImage() ,150,20 ,45, 45, this);
          
           }
             
           
         
       }
     
      else //Si pierde o gana
       {
           //this.removeAll();
           Utils.world.destroyBody(candy);
             clock.stop();
             Proyecto1.timer.stop();
             Proyecto1.frame.remove(this);
            System.out.println(!Over());
           if(!Over() || !time_flag)
           {
               menu_perder=new Perder(nivel);
               menu_perder.run();
               Proyecto1.frame.add(menu_perder);
              /*
                Proyecto1.menu=new Proyecto1();
               Proyecto1.frame.add(Proyecto1.menu);*/
               System.out.println("PERDISTE");
             
               //System.exit(ABORT);
               
           }
               
           if(Win())
           {
               System.out.println("GANASTE");
               Proyecto1.timer.stop();
               menu_ganar=new Ganar(cont, nivel);
               menu_ganar.run();
               Proyecto1.frame.add(menu_ganar);
              // Proyecto1.flag=0;
               ///Proyecto1.timer.stop();
           }
           
        }                     
     }
 
      
  
     
     
    public void run() {
        Proyecto1.timer.stop();
        
        
       Proyecto1.frame.add(this);
       Proyecto1.frame.setVisible(true);
       Proyecto1.timer.start();   

       
    }
    
    
      public boolean Over()
    {
        if( (int)Utils.toPixelPosY(candy.getPosition().y)>670 ||(int)Utils.toPixelPosY(candy.getPosition().y)<0)
            return false;
        else
            return true;
    }
    
     public boolean Win()
    {
        if(((int)Utils.toPixelPosY(candy.getPosition().y)>=ypet)&&((int)Utils.toPixelPosX(candy.getPosition().x)>xpet && (int)Utils.toPixelPosX(candy.getPosition().x)<xpet +130 )  )
            return true;
        else
            return false;
    }
    
}
        

