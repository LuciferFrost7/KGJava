import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.*;



// Класс отвечающий за визуальное отображение слота инвенторя и хранит в себе ID игрового предмета
public class InventorySlotClass{
    public final JLabel _Button; // Параметр отвечающий за функциональную кнопку
    public final JLabel _Image; // Параметр отвечающий за отображение изображения
    private final JLabel _Slot; // Параметр отвечающий за отображение Текстуры слота
    private int SlotID;
    private String ItemID; // Параметр хранящий айди предмета внутри
    public int x;
    public int y;



    // Конструктор класса InventorySlotClass
    public InventorySlotClass(int Slot_ID, int x, int y, ImageIcon img, JPanel pan){
        ItemList IL = new ItemList();
        Picture pic = new Picture(true, true, false, false);
        SlotID = Slot_ID;
        ItemID = "#0000";
        this.x = x;
        this.y = y;

        _Button = new JLabel();
        _Button.setBounds(x + 48, y + 48, 10, 10);
        _Button.setIcon(pic.group1.getImage("ExtrasButton"));

        _Image = new JLabel();
        _Image.setBounds(x + 8, y + 8, 48, 48);
        _Image.setIcon(img);

        _Slot = new JLabel();
        _Slot.setBounds(x, y, 64, 64);
        _Slot.setIcon(pic.group1.getImage("InventorySlot"));

        pan.add(_Button);
        pan.add(_Image);
        pan.add(_Slot);
    }

    // Метод обновляющий ячейку слота
    public void update(String Item_ID, ImageIcon Texture){
        ItemID = Item_ID;
        _Image.setIcon(Texture);
    }

    // Метод возвращающий ID игрового предмета хранящегося в слоте инвенторя
    public String getItemID(){
        return ItemID;
    }
    public int getSlotID(){
        return SlotID;
    }
}
