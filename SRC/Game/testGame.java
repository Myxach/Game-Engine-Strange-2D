package Game;

import Engine.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by FlyOfFly on 18.02.2016 in Game-Engine-Strange-2D.
 */
public class testGame implements Game {
    Figure[] fig = new Figure[3 * 3];
    Figure.Figures currentFig = Figure.Figures.cross;
    Sprite figure;
    Sprite Win;
    public boolean win = false;
    @Override
    public void init() {
        for (int i = 0; i < 3 * 3; i++) {
            int posy = ((i / 3) % 3);
            int posx = (i % 3);
            fig[i] = new Figure(new Vector2f(posx * 70, posy * 70));
        }
        figure = new Sprite(new Rectangle(300,300,64,64));
         Win = new Sprite(new Rectangle(390,300,64,64),"win.png");
        currentFig = Figure.Figures.cross;
    }

    @Override
    public void render() {
        for (int i = 0; i < 3 * 3; i++) {
            fig[i].draw();
        }
        if(win) {
            Win.draw();
            figure.draw();
        }
    }

    float temp = 0;
    public boolean HorCheck(Figure.Figures figur){
        for(int i =0;i<9;i+=3){
            if(fig[i+0].TestFigure(figur)) {
                if (fig[i+1].TestFigure(figur)) {
                    if (fig[i+2].TestFigure(figur)) {
                        return true;
                    }
                }
            }
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
            if (fig[0].TestFigure(figur)) {
                if (fig[8].TestFigure(figur))
                    return true;
            } else if (fig[2].TestFigure(figur)) {
                if (fig[6].TestFigure(figur))
                    return true;
            }
        }
        return false;
    }
    public boolean check(Figure.Figures figur){
       if(HorCheck(figur)) return true;
        if(VertCheck(figur)) return true;
        if(VertHorCheck(figur)) return true;
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
    }
}
