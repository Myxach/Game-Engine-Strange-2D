package Engine;

import org.lwjgl.opengl.GL11;

import javax.vecmath.Vector3f;

import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL13.glActiveTexture;

/**
 * Created by FlyOfFly on 18.02.2016 in Game-Engine-Strange-2D.
 */
public class Sprite extends RenderObject{
    Texture texture;
    public Sprite(Rectangle sprRect,String path, Color color){
        super(color,sprRect,null);
         if(!path.isEmpty())  texture = new Texture(path);
        else texture = null;
    }
    public Sprite(Rectangle sprRect,String path){
        this(sprRect,path,Color.white);
    }
    public Sprite(Rectangle sprRect,Color color){
        this(sprRect,"",color);
    }

    public Sprite(Rectangle sprRect){
        this(sprRect,"", Color.white);
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setTexture(Texture texture){
        this.texture = texture;
    }
    public void setTexture(String path){
        texture = new Texture(path);
    }

    @Override
    public void draw(){
        if(texture!=null) {

            GL11.glEnable(GL11.GL_TEXTURE_2D);
            glActiveTexture(GL_TEXTURE0);
            texture.bind();
        }
        glBegin(GL_QUADS);

        glColor3f(color.getR(),color.getG(),color.getB());
        glTexCoord2f(0,0);
        glVertex2f(getPos().x,getPos().y);
        glTexCoord2f(1,0);
        glVertex2f(getPos().x+getSize().x,getPos().y);
        glTexCoord2f(1,1);
        glVertex2f(getPos().x+getSize().x,getPos().y+ getSize().y);
        glTexCoord2f(0,1);
        glVertex2f(getPos().x,getPos().y+ getSize().y);
        glEnd();
        if(texture!=null){
            GL11.glDisable(GL11.GL_TEXTURE_2D);
        }
    }
}
