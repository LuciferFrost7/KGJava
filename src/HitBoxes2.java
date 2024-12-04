import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HitBoxes2 {
    private int x;
    private int y;
    private int width;
    private int height;

    private String type;

    private final String[] HB_TYPES = { "PAIN", "SAFE", "BaNaNa", "WALL", "HEAL" };
    public static final HashMap<String, Color> HB_COLORS = new HashMap<>(){{
        put("PAIN", new Color(255, 0, 0,50));
        put("SAFE", new Color(0, 255, 187,50));
        put("BaNaNa", new Color(255, 200, 0,50));
        put("WALL", new Color(0, 0, 255,50));
        put("HEAL", new Color(0, 255, 0,50));
    }};

    public HitBoxes2(int X, int Y, int Width, int Height, String Type){
        setX(X);
        setY(Y);
        setWidth(Width);
        setHeight(Height);
        setType(Type);
    }

    public HitBoxes2(int X, int Y, int WidthHeight, String Type){
        setX(X);
        setY(Y);
        setWidth(WidthHeight);
        setHeight(WidthHeight);
        setType(Type);
    }

    public void setX(int newX){
        if(newX >= 0){
            x = newX;
        }else{
            System.out.println("<class HitBoxes> : HitBox can't have start 'X' position lower than 0 or equal to 0");
        }
    }
    public int getX(){
        return x;
    }

    public void setY(int newY){
        if(newY >= 0){
            y = newY;
        }else{
            System.out.println("<class HitBoxes> : HitBox can't have start 'Y' position lower than 0 or equal to 0");
        }
    }
    public int getY(){
        return y;
    }

    public void setWidth(int newWidth){
        if(newWidth > 0){
            width = newWidth;
        }else{
            System.out.println("<class HitBoxes> : HitBox can't have width lower than 0 or equal to 0");
        }
    }
    public int getWidth(){
        return width;
    }

    public void setHeight(int newHeight){
        if(newHeight > 0){
            height = newHeight;
        }else{
            System.out.println("<class HitBoxes> : HitBox can't have height lower than 0 or equal to 0");
        }
    }
    public int getHeight(){
        return height;
    }

    public void setType(String newType){
        if(Arrays.asList(HB_TYPES).contains(newType.toUpperCase())){
            type = newType;
        }else{
            System.out.println("<class HitBoxes> : HitBox haven't type like '" + newType + "'");
        }
    }
    public String getType(){
        return type;
    }

    private boolean IsMod(int x, int xs, int xe){
        return xs <= x && x <= xe;
    }
    public boolean Intersection(int x, int y, int width, int height){
        return Intersection(new HitBoxes2(x, y, width, height, "safe"));
    }
    public boolean Intersection(int x, int y, int widthHeight){
        return Intersection(new HitBoxes2(x, y, widthHeight, widthHeight, "safe"));
    }
    public boolean Intersection(HitBoxes2 other){
        if(IsMod(other.getX(), x, x + width) && IsMod(other.getY(), y, y + height)){
            return true;
        } else if (IsMod(x, other.getX(), other.getWidth()) && IsMod(y, other.getY(), other.getHeight())) {
            return true;
        }
        return false;
    }
}
