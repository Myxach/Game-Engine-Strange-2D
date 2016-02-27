package Engine;

/**
 * Created by FlyOfFly on 19.02.2016 in 04:39.
 */
public class RenderObject {

    private Vector2f pos;
    private Vector2f size;
    private Vector2f scale;
    private Vector2f anchor = new Vector2f(0f,0f);
    protected Color color;
    private RenderObject parent;
    public void setScale(Vector2f scale){
        this.scale =scale;
    }


    public RenderObject(Rectangle rectangle){
        this(Color.black,new Vector2f(rectangle.x,rectangle.y),new Vector2f(rectangle.width,rectangle.height),null);
    }

    protected RenderObject(Color color,Vector2f pos,Vector2f size,RenderObject parent){
        this(color,pos,size,Vector2f.Zero,parent);
    }

    protected RenderObject(Color color, Rectangle rect,RenderObject parent){
        this(color,new Vector2f(rect.x,rect.y),new Vector2f(rect.width,rect.height),parent);
    }

    protected RenderObject (Color color,Vector2f pos,Vector2f size,Vector2f anchor,RenderObject parent){
        this.color = color;
        this.pos = pos;
        this.size = size;
        this.scale = Vector2f.One;
        this.parent = parent;
        this.anchor = anchor;
    }

    public void setParent(RenderObject parent){
        this.parent = parent;
    }

    public Vector2f getPos(){
        Vector2f currentPos = pos.add(getSize().mul(anchor.negative()));
        if(parent == null)
            return currentPos;
        else
            return parent.getPos().add(currentPos);
    }
    public Vector2f getSize(){
        return new Vector2f(size.x*scale.x,size.y*scale.y);
    }

    public void draw() {

    }
    //
    public void setPos(Vector2f pos) {
        this.pos = pos;
    }

    public void setAnchor(Vector2f anchor) {
        this.anchor = anchor;
    }
}
