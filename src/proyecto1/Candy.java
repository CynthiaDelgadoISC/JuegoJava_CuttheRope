
package proyecto1;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


public class Candy {
     int x, y;
    int xbox,ybox;
    BodyType tipo;
    BodyDef ball;
    CircleShape cs ;   
    FixtureDef fd;
    Body esf;  
   
    Candy(int _x, int _y, BodyType _tipo )
    {
        x=_x;
        y=_y;
         xbox=(int) Utils.toPosX(x);
         ybox=(int) Utils.toPosY(y);
        tipo=_tipo;
    }
    
    public Body crea_esfera()
    {
      
       ball = new BodyDef(); //Creamos la definicion del cuerpo logico de JBox2D para la esfera
       
        ball.type=tipo; 
        ball.position.set(xbox, ybox);
            
       cs = new CircleShape(); //Definimos la forma de el cuerpo (En este caso esfera)  
       cs.setRadius(10*0.1f);   //Definimos el radio logico de Jbox2D
       fd = new FixtureDef(); //Objeto para definir las propiedades fisicas de la esfera
       fd.shape = cs; //Tiene forma de esfera
       fd.density = 0f; //Definimos su densidad
       fd.friction = 0.3f; //Definimos su friccion
       fd.restitution = 8f;
       esf = Utils.world.createBody(ball); //Creamos el cuerpo en JBox2d
       esf.createFixture(fd);  //Asociamos sus propiedades 
       return esf;
    }
}
