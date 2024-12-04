import javax.swing.*;
import java.awt.*;

public class Slice2 {
    private int x;
    private int y;
    private final int SLICE_HEIGHT;
    private final int SLICE_WIDTH;

    public HitBoxes2 HitBox;

    private boolean active;

    public JLabel label;
    public JPanel panel;

    private final Picture pic = new Picture(false, false, true, false);

    public Slice2(int X, int Y, int sliceHeight, int sliceWidth){
        SLICE_HEIGHT = sliceHeight;
        SLICE_WIDTH = sliceWidth;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x + sliceWidth, y, SLICE_WIDTH, SLICE_HEIGHT);
        panel.setBackground(Main.IsHitBoxEnabled ? new Color(0, 0, 255, 50) : Main.TRANSPARENT);

        label = new JLabel();
        label.setIcon(pic.group3.getImage("Slice"));
        label.setBounds(0, 0, SLICE_WIDTH, SLICE_HEIGHT);
        panel.add(label);

        setX(X);
        setY(Y);
        HitBox = new HitBoxes2(x, y, SLICE_WIDTH, SLICE_HEIGHT, "pain");
        active = false;
    }

    public void setX(int newX){
        if(newX > 0){
            x = newX;
            panel.setBounds(x, y, SLICE_WIDTH, SLICE_HEIGHT);
        }else{
            System.out.println("<class Slice> : Slice 'X' position can't be lower than 0");
        }
    }
    public int getX(){
        return x;
    }

    public void setY(int newY){
        if(newY > 0){
            y = newY;
            panel.setBounds(x, y, SLICE_WIDTH, SLICE_HEIGHT);
        }else{
            System.out.println("<class Slice> : Slice 'Y' position can't be lower than 0");
        }
    }
    public int getY(){
        return y;
    }

    public int getSliceHeight(){
        return SLICE_HEIGHT;
    }
    public int getSliceWidth(){
        return SLICE_WIDTH;
    }

    public void Active(){
        active = true;
    }
    public void Deactive(){
        active = false;
    }
    public void setActive(boolean newActive){
        active = newActive;
    }
    public boolean getActive(){
        return active;
    }
    public boolean IsActive(){
        return active;
    }

    public void ChangePlayerPosition(int newX, int newY){
        if(newX > 0){
            if(newY > 0){
                x = newX;
                y = newY;
            }else{
                System.out.println("<class Slice> : Slice 'Y' position can't be lower than 0");
            }
        }else{
            System.out.println("<class Slice> : Slice 'X' position can't be lower than 0");
        }
    }
}
