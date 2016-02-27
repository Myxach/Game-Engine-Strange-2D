package Game;

import Engine.*;

/**
 * Created by FlyOfFly on 18.02.2016 in Game-Engine-Strange-2D.
 */
public class Figure {
    Sprite sprite;
    Button spriteback;
    public static enum Figures{
        none,
        cross,
        sphere
    };
    private Figures fig;
    public Figure(Vector2f pos,RenderObject obj){
        spriteback = new Button(new Rectangle(Window.getWidth()/2-pos.x,Window.getHeight()/2-pos.y,64,64), Color.grey);
         sprite = new Sprite(new Rectangle(0,0,64,64), Color.white);
        sprite.setParent(spriteback);
        //sprite.setScale(new Vector2f(2,1));
        fig = Figures.none;
        spriteback.setParent(obj);
        spriteback.setAnchor(new Vector2f(0.5f,0.5f));
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
            if (spriteback.isClicked()) {
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
