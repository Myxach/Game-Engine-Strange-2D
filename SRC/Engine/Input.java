package Engine;

/**
 * Created by FlyOfFly on 18.02.2016 in Game-Engine-Strange-2D.
 */
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {
    private static final int NUM_KEYCODES = 256;
    private static final int NUM_MOUSEBUTTON = 3;

    private static boolean[] LastKeys = new boolean[NUM_KEYCODES];
    private static boolean[] LastMouse = new boolean[NUM_MOUSEBUTTON];


    public static void update(){
        for(int i =0;i<NUM_KEYCODES;i++)
            LastKeys[i] = getKey(i);
        for(int i =0;i<NUM_MOUSEBUTTON;i++)
            LastMouse[i] = getMouse(i);
    }

    public static boolean getKey(int keyCode){
        return Keyboard.isKeyDown(keyCode);
    }

    public static boolean getKeyDown(int keyCode){
        return getKey(keyCode) && !LastKeys[keyCode];
    }

    public static boolean getKeyUp(int keyCode){
        return !getKey(keyCode) && LastKeys[keyCode];
    }

    public static boolean getMouse(int mouseButton){
        return Mouse.isButtonDown(mouseButton);
    }

    public static boolean getMouseDown(int mouseButton){
        return getMouse(mouseButton) && !LastMouse[mouseButton];
    }

    public static boolean getMouseUp(int mouseButton){
        return !getMouse(mouseButton) && LastKeys[mouseButton];
    }
    public static Vector2f getMousePos(){
        return new Vector2f(Mouse.getX(), 600-Mouse.getY());
    }
    public static void setMousePos(Vector2f pos){
        Mouse.setCursorPosition((int)pos.x, (int)pos.y);
    }
    public static void setCursor(boolean enabled){
        Mouse.setGrabbed(!enabled);
    }
}
