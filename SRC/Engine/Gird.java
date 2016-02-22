package Engine;
import static org.lwjgl.opengl.GL11.*;
/**
 * Created by FlyOfFly on 20.02.2016 in 10:18.
 */
public class Gird extends RenderObject {
    protected Gird(Color color, Vector2f pos, Vector2f size, RenderObject parent) {
        super(color, pos, size, parent);
    }

    public Gird(Color color, Rectangle rect, RenderObject parent) {
        super(color, rect, parent);
    }
    public void draw(){
        glBegin(GL_LINES);
        glColor3f(color.getR(),color.getG(),color.getB());
        final int sizeGird = 64;
        for(int i = 0;i<getSize().x ;i+=sizeGird){
            glVertex2f(getPos().x +(float) i, getPos().y+(float) 0);
            glVertex2f(getPos().x +(float) i, getPos().y +(float) getSize().y);
        }
        for(int i =0;i<getSize().y;i+=sizeGird){
            glVertex2f(getPos().x+(float)0,getPos().y+(float)i);
            glVertex2f(getPos().x+(float)getSize().x,getPos().y+(float)i);
        }
        glEnd();
    };
}
