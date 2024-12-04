import javax.swing.*;


// Класс предназначенный для хранения информации об Ударе игрока
public class Slice {

    private int x; // Месторасположение по X
    private int y; // Месторасположение по Y
    private boolean sliceCreate; // Флаг отображающий активен ли сейчас Удар
    private JLabel slice; // Изображение хранящиеся для расположения ударя на поле боя
    private Picture pic = new Picture(false, false, true, false);


    // Конструктор класса Slice
    public Slice(int _x, int _y) {
        x = _x;
        y = _y;
        sliceCreate = false;

        slice = new JLabel();
        slice.setIcon(pic.group3.getImage("Slice"));
        slice.setBounds(this.x, this.y, 64, 64);
    }

    public JLabel getSlice() {
        return slice;
    }

    public void sliceUpdate(){
        sliceCreate = !sliceCreate;
    }

    public boolean getActive(){
        return sliceCreate;
    }

    public void setX(int _x){
        x = _x;
        slice.setBounds(x, y, 64, 64);
    }

    public int getX(){
        return x;
    }

    public void setY(int _y){
        y = _y;
        slice.setBounds(x, y, 64, 64);
    }

    public int getY(){
        return y;
    }

    public void newTexture(String _newTexture, JPanel panel){
        slice.setText(_newTexture);
        panel.updateUI();
    }
}
