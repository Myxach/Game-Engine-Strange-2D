package Game;

import Engine.Color;
import Engine.Rectangle;
import Engine.Sprite;
import Engine.Vector2f;

/**
 * Created by FlyOfFly on 18.02.2016 in Game-Engine-Strange-2D.
 */
public class Figure {
    Sprite sprite;
    Sprite spriteback;
    public static enum Figures{
        none,
        cross,
        sphere
    };
    private Figures fig;
    public Figure(Vector2f pos){
        spriteback = new Sprite(new Rectangle(pos.x,pos.y,64,64), Color.grey);
         sprite = new Sprite(new Rectangle(pos.x,pos.y,64,64), Color.white);
        fig = Figures.none;
    }
    public void draw(){
        spriteback.draw();
        if(this.fig!=Figures.none)
        sprite.draw();
    }
    public boolean TestFigure(Figures figure){
        return this.fig == figure;
    }


    public boolean ClickedUpdate(Figures figur){
        if(this.fig==Figures.none) {
            if (sprite.isClicked()) {
                if(figur == Figures.cross) {
                    sprite.setTexture("cross.png");
                }
                else {
                    sprite.setTexture("sphere.png");
                }
                fig = figur;
                return true;
            }
        }
        return false;
    }
}
