import javax.swing.ImageIcon;

public class Cursor {
    private int Focus; // Номер слота, на котором сфокусирован курсор
    private ImageIcon Texture; // изображение курсора
    private Picture pic = new Picture(true, false, false, false);
    public Cursor(){
        Focus = 0;
        Texture = pic.group1.getImage("Cursor");
    }
    public ImageIcon getTexture(){
        return Texture;
    }
    public void setFocus(int focus){
        Focus = focus;
    }
    public int getFocus(){
        return Focus;
    }
}