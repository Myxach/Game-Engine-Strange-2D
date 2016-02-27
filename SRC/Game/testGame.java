package Game;

import Engine.*;
import org.lwjgl.input.Keyboard;

/**
 * Created by FlyOfFly on 18.02.2016 in Game-Engine-Strange-2D.
 */

public class testGame extends Game {
    public boolean win = false;

    Figure[] fig = new Figure[3 * 3];
    Figure.Figures currentFig = Figure.Figures.cross;
    Sprite figure;
    Sprite Win;
    Vector2f pos = new Vector2f(0,0);

    @Override
    public void init() {
        RenderObject obj = new RenderObject(new Rectangle(0,0,70*3,70*3));
        obj.setAnchor(Vector2f.Zero);
        for (int i = 0; i < 3 * 3; i++) {
            int posy = ((i / 3) % 3)-1;
            int posX = (i % 3)-1;
            fig[i] = new Figure(new Vector2f(posX * 70, posy * 70),obj);
        }
        Win = new Sprite(new Rectangle(390,400,64,64),"win.png");
        figure = new Sprite(new Rectangle(300,400,64,64));
        //gird = new Gird(Color.green,new Rectangle(-10,-10,1024,768),null);
    }

    @Override
    public void render() {
       // gird.draw();
        for (int i = 0; i < 3 * 3; i++) {
            fig[i].draw();
        }
        if(win) {
            Win.draw();
            figure.draw();
        }
    }

    public boolean HorCheck(Figure.Figures figure){
        for(int i =0;i<9;i+=3){
            if (!fig[i].TestFigure(figure)) continue;
            if (!fig[i+1].TestFigure(figure)) continue;
            if (!fig[i+2].TestFigure(figure)) continue;
            return true;
        }
        return false;
    }

    public boolean VertCheck(Figure.Figures figur){
        for(int i =0;i<3;i++){
            if(fig[i].TestFigure(figur)) {
                if (fig[i+3].TestFigure(figur)) {
                    if (fig[i+6].TestFigure(figur)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean VertHorCheck(Figure.Figures figur){
        if(fig[4].TestFigure(figur)) {
            if (fig[0].TestFigure(figur) ) {
                if (fig[8].TestFigure(figur))
                    return true;
            } else if (fig[2].TestFigure(figur)) {
                if (fig[6].TestFigure(figur))
                    return true;
            }
        }
        return false;
    }

    public boolean check(Figure.Figures figur) {
        if (HorCheck(figur)) return true;
        if (VertCheck(figur)) return true;
        if (VertHorCheck(figur)) return true;
        return false;
    }

    @Override
    public void update() {

        if(!win){
            for (int i = 0; i < 3 * 3; i++) {
                if (fig[i].ClickedUpdate(currentFig)){
                    if(check(currentFig)) win = true;
                    if(currentFig == Figure.Figures.cross){
                        if(win) figure.setTexture("cross.png");
                        currentFig = Figure.Figures.sphere;
                    }
                    else {
                        if(win) figure.setTexture("sphere.png");
                        currentFig = Figure.Figures.cross;
                    }
                    break;
                }
            }
        }

        if(Input.getKeyDown(Keyboard.KEY_UP))
            pos.y-=1;

        if(Input.getKeyDown(Keyboard.KEY_DOWN))
            pos.y+=1;

        if(Input.getKeyDown(Keyboard.KEY_LEFT))
            pos.x-=1;

        if(Input.getKeyDown(Keyboard.KEY_RIGHT))
            pos.x+=1;

        System.out.println("X:"+pos.x+" Y:" +pos.y);
//        gird.setPos(pos);
    }
}
