import javax.swing.*;
import java.awt.event.ActionListener;

public class Object {

    private String name;
    private String  description;
    private final boolean Type; // Static object like wall = False || Dynamic object like bullet = True

    private Points cordX;
    private Points cordY;
    private int height;
    private int width;

    private JLabel label;
    private ImageIcon texture;
    private HitBoxes hitBox;

    private Picture pic = new Picture(false, false, false, true);
    private Timer timer;
    private boolean timerCreate;

    public Object(String _name, int _x, int _y, boolean _type, String _texture, JPanel _panel) {
        name = _name;
        description = "";
        Type = _type;
        cordX = new Points(_x);
        cordY = new Points(_y);
        texture = pic.group4.getImage(_texture);

        height = texture.getIconHeight();
        width = texture.getIconWidth();

        hitBox = new HitBoxes(cordX.get(), cordY.get(), height, "SAFE");

        label = new JLabel();
        label.setIcon(texture);
        label.setBounds(cordX.get(), cordY.get(), width, height);
        _panel.add(label);

        timerCreate = false;
        System.out.println("Object " +  name + " created");
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public boolean getType(){
        return Type;
    }

    public int getX(){
        return cordX.get();
    }

    public void updateX(int _newX){
        if(Type) {
            cordX.set(_newX);
        }else{
            System.out.println("Can Move only Dynamic object");
        }
    }

    public void subX(int _sub){
        if(Type) {
            cordX.sub(_sub);
        }else{
            System.out.println("Can Move only Dynamic object");
        }
    }

    public void addX(int _add){
        if(Type) {
            cordX.add(_add);
        }else{
            System.out.println("Can Move only Dynamic object");
        }
    }

    public int getY(){
        return cordY.get();
    }

    public void updateY(int _newY){
        if(Type) {
            cordY.set(_newY);
        }else{
            System.out.println("Can Move only Dynamic object");
        }
    }

    public void subY(int _sub){
        if(Type) {
            cordY.sub(_sub);
        }else{
            System.out.println("Can Move only Dynamic object");
        }
    }

    public void addY(int _add){
        if(Type) {
            cordY.add(_add);
        }else{
            System.out.println("Can Move only Dynamic object");
        }
    }

    public int getHeight(){
        return height;
    }

    private void setHeight(int _height){
        height = _height;
    }

    public int getWidth(){
        return width;
    }

    private void setWidth(int _width){
        width = _width;
    }

    public JLabel getLabel(){
        return label;
    }

    public ImageIcon getTexture(){
        return texture;
    }

    public HitBoxes getHitBox(){
        return hitBox;
    }

    public void setTexture(ImageIcon _image){
        texture = _image;
        setHeight(texture.getIconHeight());
        setWidth(texture.getIconWidth());
        hitBox = new HitBoxes(cordX.get(), cordY.get(), width, height, "SAFE");
    }

    public void createTimer(int _time, ActionListener _action){
        timer = new Timer(_time, _action);
        timerCreate = true;
    }

    public void startTimer(){
        if(timerCreate) {
            if(!timer.isRunning()) {
                timer.start();
                System.out.println("Timer started");
            }else{
                System.out.println("Timer is already running");
            }
        }else{
            System.out.println("Timer is not create before");
        }
    }

    public void stopTimer(){
        if(timerCreate) {
            if(timer.isRunning()) {
                timer.stop();
            }else{
                System.out.println("Timer is not running");
            }
        }else{
            System.out.println("Timer is not create before");
        }
    }

    public void changeTimerRun(){
        if(timerCreate) {
            if(timer.isRunning()) {
                timer.stop();
            }else {
                timer.start();
            }
        }else{
            System.out.println("Timer is not create before");
        }
    }
    public void repeatTimer(boolean alpha){
        if(timerCreate) {
            timer.setRepeats(alpha);
        }else{
            System.out.println("Timer is not create before");
        }
    }

    public void changeTimer(int _newTime, ActionListener _newAction){
        timer = new Timer(_newTime, _newAction);
    }

    public void pickUp(JPanel _panel){
        _panel.remove(label);
        _panel.updateUI();
        _panel.repaint();
        stopTimer();
        timerCreate = false;
    }
    public void Delete(JPanel _panel){
        _panel.remove(label);
        name = null;
        description = null;
        cordX = null;
        cordY = null;
        height = -2000;
        width = -2000;
        label = null;
        texture = null;
        hitBox = null;
        stopTimer();
        timer = null;
        timerCreate = false;
        pic = null;
    }
}
