package Engine;

public class Color {
	private final float alpha;
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
	public static final Color transparent = new Color(0,0,0,0);
	public static final double Gamma = 2f;
	public Color(int r, int g, int b){
		this(r,g,b,255);
	}

	public Color(float r, float g, float b){
		this(r,g,b,1);
	}

	public Color(int r, int g, int b,int alpha){
		this.r = r/255;
		this.g= g/255;
		this.b = b/255;
		this.alpha = alpha/255;
	}

	public Color(float r, float g, float b,float alpha){
		this.r = r;
		this.g= g;
		this.b = b;
		this.alpha = alpha;
	}
	public static enum BlendType{
		Alpha,
		Additive,
		Multiplicative,
		MultiplicativeX,
	}
	public Color Blend(BlendType blend, Color dest){
		Color srcAlpha = SourceAlpha();
		Color InvsrcAlpha = InvSourceAlpha();
		switch (blend){

			case Alpha:
				return this.mul(srcAlpha).add(dest.mul(InvsrcAlpha));
			case Additive:
				return this.mul(Color.white).add(dest.mul(Color.white));
			case Multiplicative:
				return this.mul(Color.transparent).add(dest.mul(this));
			case MultiplicativeX:
				return this.mul(dest).add(dest.mul(this));
		}
		return null;
	}

	public Color SourceAlpha(){
		return new Color(alpha,alpha,alpha,alpha);
	}

	public Color InvSourceAlpha(){
		return new Color(1-alpha,1-alpha,1-alpha,1-alpha);
	}

	public Color add(Color other){
		return new Color(r+other.r, g+other.g, b+other.b);
	}


	public Color mul(Color other) {
		return new Color(r*other.r, g*other.g, b*other.b);
	}

	public float getR(){
		return (float)Math.pow(r,(float)Gamma);
	}

	public float getG(){
		return (float)Math.pow(g,(float)Gamma);
	}

	public float getB(){
		return (float)Math.pow(b,(float)Gamma);
	}
}
