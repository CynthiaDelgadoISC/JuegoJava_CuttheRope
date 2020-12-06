
package proyecto1;

import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.joints.*;


public class Rope extends Thread{
    public Body cadena [];
    public int NO_OF_LINK;
    public DistanceJointDef jdef=new DistanceJointDef();
    public DistanceJoint dj;
    public  Body candy; 
    int posx, posy;
    public boolean flag=true;
    
    Rope(int _posx, int _posy, int tam, Body _candy)
    {       
        cadena= new Body[tam];
        NO_OF_LINK=tam;
        posx=_posx;
        posy=_posy;
        candy=_candy;
        crea_cadena();
    }
    
    private void crea_cadena()
    {
        for(int i=0; i<NO_OF_LINK; i++)
        {
            if(i==0 )
                cadena[i] = new Rectangulo(posx+(i*5),posy+(i*5),5,5,BodyType.STATIC).crea_rectangulo();
            else if(i==NO_OF_LINK-1)
                cadena[i]=candy;
            else
                cadena[i] = new Rectangulo(posx+(i*5),posy+(i*5),5,5,BodyType.DYNAMIC).crea_rectangulo();
        
        }
        
        for(int i=0;i<NO_OF_LINK-1;i++)
        {
            jdef = new DistanceJointDef();
            jdef.bodyA=cadena[i];
            jdef.bodyB=cadena[i+1];
            jdef.length=2;
           
            jdef.collideConnected=true;
            jdef.localAnchorA.set((float)0,(float) 0);
            jdef.localAnchorB.set(0,0);
            dj=(DistanceJoint) Utils.world.createJoint(jdef);  
        }
        
    }
    
    public void Destroy_rope()
    {
        for(int i=0; i<NO_OF_LINK-1; i++) //que no destruya la bola
             Utils.world.destroyBody(cadena[i]);
        
        Utils.world.destroyJoint(dj);              
        flag=false;
       
    }
    
    @Override
    public void run()
    {        
        while(flag);            
    }
    
}

