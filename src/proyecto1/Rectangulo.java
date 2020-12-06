
package proyecto1;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class Rectangulo {
    int x, y, ancho, alto;
    int xbox, ybox;
    BodyType type;
    BodyDef rect;
    PolygonShape ps;
    FixtureDef fd;
    Body rectangulo;  
    
    public Rectangulo(int _x, int _y, int _ancho, int _alto, BodyType _type)
    {
        x=_x; y=_y;
        ancho=_ancho; alto=_alto;
        xbox=(int) Utils.toPosX(_x);
        ybox=(int) Utils.toPosY(_y);
        type=_type;
    }
    
    public Body crea_rectangulo()
    {
        rect = new BodyDef();
        rect.type=type;
        rect.position.set(xbox,ybox);
        ps= new PolygonShape();
        ps.setAsBox(ancho*0.1f,alto*0.1f);
        fd = new FixtureDef();
        fd.shape=ps;
        fd.density = .1f; //Definimos su densidad                              
        fd.friction = 0.3f; //Definimos su friccion
        fd.restitution = 0.8f;
        rectangulo = Utils.world.createBody(rect);
        rectangulo.createFixture(fd);         
        return rectangulo;
    }
}
