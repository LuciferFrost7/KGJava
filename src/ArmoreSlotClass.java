import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;



// Класс для отображения ячеек брони и хранения ID находящегося в ячейке предмета
public class ArmoreSlotClass {
    public JLabel _Image; // Параметр отображающий Текстуру предмета
    private JLabel _Slot; // Параметр отображющий слот для брони
    private String ItemID; // Параметр отвечающий за хранение ID игрового предмета
    private int SlotID;
    private Picture pic = new Picture(true, false, false, false); // Подключение 1 группы изображений



    // Конструктор класса ArmoreSlotClass
    public ArmoreSlotClass(int Slot_ID, int x, int y,ImageIcon img, JPanel panel) {
        ItemID = "#0000";
        SlotID = Slot_ID;

        _Slot = new JLabel();
        _Slot.setBounds(x + 3 ,y + 3, 54, 54);
        _Slot.setIcon(pic.group1.getImage("ArmoreSlot"));

        _Image = new JLabel();
        _Image.setBounds(x + 6 , y + 6, 48, 48);
        _Image.setIcon(img);

        setVisible(false);
        panel.add(_Image);
        panel.add(_Slot);

    }

    // Метод Обновляющей содержимое ячейки слота на новый предмет
    public void update(String Item_ID, ImageIcon Texture){
        ItemID = Item_ID;
        _Image.setIcon(Texture);
    }

    // Метод определяющий видимость слота и его содержимого
    public void setVisible(boolean visible){
        _Slot.setVisible(visible);
        _Image.setVisible(visible);
    }

    // Метод возвращающий ID находящегося в ячейке предмета
    public String getItemID() {
        return ItemID;
    }

    public int getSlotID(){
        return SlotID;
    }

}
