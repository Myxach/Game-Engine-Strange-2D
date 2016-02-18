package Engine; /**
 * Created by FlyOfFly on 18.02.2016 in 16:13.
 */

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Window {

    public static void CreateWindow(int width,int height,String Title){
        Display.setTitle(Title);
        try{
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Keyboard.create();
            Mouse.create();
        }
        catch(LWJGLException e){
            e.printStackTrace();
        }
    }
    public static void render(){

        Display.update();
      //  Display.sync(60);
    }
    public static boolean IsCloseRequested(){
        return Display.isCloseRequested();
    }
    public static void Dispose(){
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
    }
    public static int getWidth(){
        return Display.getDisplayMode().getWidth();
    }
    public static int getHeight(){
        return Display.getDisplayMode().getHeight();
    }

    public static String getTitle(){
        return Display.getTitle();
    }
}
