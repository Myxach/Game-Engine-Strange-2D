package Engine;

/**
 * Created by FlyOfFly on 19.02.2016 in 04:46.
 */
public class Button  extends Sprite {

    public Button(Rectangle sprRect, String path, Color color) {
        super(sprRect, path, color);
    }

    public Button(Rectangle sprRect, String path) {
        super(sprRect, path);
    }

    public Button(Rectangle sprRect, Color color) {
        super(sprRect, color);
    }

    public Button(Rectangle sprRect) {
        super(sprRect);
    }
    public boolean isClicked(){

            if(Input.getMouseDown(0)){
                Vector2f mousepos = Input.getMousePos();
                    if(mousepos.x <=getPos().x+getSize().x && mousepos.x >=getPos().x &&
                    mousepos.y <=getPos().y+getSize().y && mousepos.y >=getPos().y ){
                        System.out.println("Clicked");
                    return true;
                 }
            }
            return false;
    }
}
