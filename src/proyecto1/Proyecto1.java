package proyecto1;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Proyecto1 extends JPanel{
    public static Proyecto1 menu;
    static JFrame frame;
    static Timer timer;
    Image bg;
    JButton play;
    public static P_niveles p_niveles;
    public static Level1 l1;
    public static LinkedList<String> permiso;
  
    public Proyecto1()
    {
        Musica();
        timer=new Timer(6000,new Predecir()); 
        this.setLayout(new FlowLayout(FlowLayout.CENTER,50,300));
        play=new JButton(new ImageIcon("Imagenes/play.png"));
        play.setPreferredSize(new Dimension(140,40));
          
        this.add(play);
        
        frame = new JFrame("Cut the Rope");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,700);
        frame.add(this);
        frame.setVisible(true);
        
        permiso= new LinkedList<String>();
        Base();
        
        
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
               timer.stop();
               timer=null;
                frame.remove(menu);
                p_niveles=new P_niveles();
                p_niveles.run();
                
             
            }

        });

    } 
    
    public void Base ()
    {
        String cadena=null;  
        File file = new File("Permisos.txt");
        FileReader lector;
        BufferedReader br;
        try
        {
           lector = new FileReader(file);
           br = new BufferedReader(lector);
           while((cadena = br.readLine()) != null)
           { 
               permiso.add(cadena);
           }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Archivo No Encontrado");
        }
        catch(IOException ex)
        {}
        
        
    }
    
    public void Musica()
    {
        try {
         Clip sonido = AudioSystem.getClip();
         File a = new File("Imagenes/cancion.wav");
         sonido.open(AudioSystem.getAudioInputStream(a));
         sonido.start();
      } catch (Exception tipoError) {
         System.out.println("" + tipoError);
      }
    }
    
  
    public class Predecir implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {            
            Utils.world.step(1.0f/60.0f,8,3);
            repaint();           
        }
    }
    
   public void paint(Graphics g )
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.clearRect(0,0,1000,700);
        ImageIcon icono2;
     
            icono2=new ImageIcon(getClass().getResource("fondo.jpg"));
            bg= new ImageIcon("Imagenes/fondo.jpg").getImage();
            g2d.drawImage(bg,0,0,getWidth(),getHeight(),this);
            g2d.drawImage(new ImageIcon("Imagenes/title.png").getImage() ,300,50 ,400,200, this);
            g2d.drawImage(new ImageIcon("Imagenes/c1.png").getImage() ,550,450 ,400,200, this);
        
       
    }
    
    public static void main(String[] args) {
        menu= new Proyecto1();
    }
    
    
}
