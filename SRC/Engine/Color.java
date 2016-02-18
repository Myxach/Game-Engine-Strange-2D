package Engine;

public class Color {
	float r,g,b;
	public static final Color red = new Color(1.0f,0,0);
	public static final Color green = new Color(0,1.0f,0);
	public static final Color blue = new Color(0,0,1.0f);
	public static final Color white = new Color(1.0f,1,1);
	public static final Color black = new Color(0,0,0);
	public static final Color yellow = new Color(1.0f,235/255.0f,4/255);
	public static final Color cyan = new Color(0,1.0f,1.0f);
	public static final Color magenta = new Color(1.0f,0,1.0f);
	public static final Color gray = new Color(0.5f,0.5f,0.5f);
	public static final  Color grey = gray;
	public Color(int r, int g, int b){
		this.r = r;
		this.g= g;
		this.b = b;
	}
	public Color(float r, float g, float b){
		this.r = r*255;
		this.g= g*255;
		this.b = b*255;
	}
	public float getR(){
		return r/255;
	}

	public float getG(){
		return g/255;
	}

	public float getB(){
		return b/255;
	}
}
