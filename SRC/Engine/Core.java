package Engine;

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by FlyOfFly on 18.02.2016 in 16:13.
 */

public class Core {
    private Game game;
    private boolean isRun;
    public Core(Game game){
        isRun = false;
        Window.CreateWindow(800,600,"Test");
        this.game = game;
    }
    public void start(){
        if(isRun) return;
        game.init();
        run();
    }
    public void run(){
        GL11.glViewport(0,0,800,600);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0,800,600, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        final double skip_ticks = 1000/60.0;
        double lastTime = Time.getTime();
        isRun = true;
        double contdTime = 0;
       double sleepTime = 0;
        double delta;
        double next_game_tick = Time.getTime()*1000;
        int fps = 0;
        glEnable(GL11.GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        while(!Window.IsCloseRequested()){
            double currentTime = Time.getTime();
            delta = currentTime-lastTime;
            lastTime = currentTime;
            Time.setDelta(delta);
            contdTime+= delta;
             if(contdTime>=1) {
                System.out.println("FPS:" + fps);
                contdTime = 0;
                fps = 0;
            }else fps++;

            glClear(GL_COLOR_BUFFER_BIT);
            game.update();
            Input.update();
            game.render();
            Window.render();

            next_game_tick+=skip_ticks;
            sleepTime=next_game_tick-(Time.getTime()*1000);
//            if(sleepTime>=0) {
//                try {
//                    Thread.sleep((long) (sleepTime));
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

}
