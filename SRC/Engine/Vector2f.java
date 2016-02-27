package Engine;

/**
 * Created by FlyOfFly on 18.02.2016 in Game-Engine-Strange-2D.
 */
public class Vector2f {
    public static final Vector2f Zero = new Vector2f(0, 0);
    public static final Vector2f One = new Vector2f(1,1);
    public static final Vector2f Left = new Vector2f(0,1);
    public static final Vector2f Right = new Vector2f(1,0);
    public static final Vector2f LeftCenter = new Vector2f(0.5f,1);
    public static final Vector2f RightCenter = new Vector2f(1,0.5f);
    public static final Vector2f Center = new Vector2f(0.5f,0.5f);
    public float x, y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f add(Vector2f r) {
        return new Vector2f(r.x + x, r.y + y);
    }

    public Vector2f mul(Vector2f r) {
        return new Vector2f(r.x * x, r.y * y);
    }

    public double length() {
        return Math.sqrt(dot(this));
    }

    public Vector2f normalize() {
        double len = length();
        if(len == 0) return this;

        x/=len;
        y/=len;

        return this;
    }

    public Vector2f negative(){
        return new Vector2f(-x,-y);
    }

    public double dot(Vector2f other){
        return x*other.x + y*other.y;
    }

    public Vector2f sub(Vector2f vec) {
        return new Vector2f(x-vec.x,y-vec.y);
    }
}
