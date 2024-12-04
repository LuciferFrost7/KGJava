import javax.swing.ImageIcon;


// Класс предназначен для работы со слотами Быстрой линии
public class Slot {

    private int slotID; // Параметр хранящий ID слота
    private String itemID; // Параметр отвечающий за ID отображаемого игрового предмета
    private boolean onCursor; // Параметр отвечающий за отображения курсора на определённой ячейке


    private ImageIcon slotImage; // Параметр отвечающий за изображение элемента
    private Picture pic = new Picture(false, true, false, false); // Создание элемента класса Picture для взаимодействия с изображениями


    // Конструктор класса Slot
    public Slot(boolean _onCursor, int _slotId, String _itemId){
        slotID = _slotId;
        itemID = _itemId;
        setOnCursor(_onCursor);
        setSlotImage(pic.group2.getImage(0));
    }

    // Методы для взаимодействия с "Состоянием Курсора"
    public boolean isOnCursor() {
        return onCursor;
    }

    public void setOnCursor(boolean _onCursor){
        onCursor = _onCursor;
    }

    // Методы для взаимодействия с ID игровых предметов отображаемых в инвенторе
    public void setItem(Item _item){
        itemID = _item.getItemID();
        setSlotImage(_item.getItemIcon());
    }

    public void setWeapon(Weapon item){
        itemID = item.getWeaponID();
        setSlotImage(item.getWeaponIcon());
    }

    public void setArmor(Armor item){
        itemID = item.getArmorID();
        setSlotImage(item.getArmorIcon());
    }

    public void setTool(Tool item){
        itemID = item.getToolID();
        setSlotImage(item.getToolIcon());
    }

    public String getItemID(){
        return itemID;
    }

    // Методы для взаимодействия с Изображением слота Слотами
    public void setSlotImage(ImageIcon _newSlotImage){
        slotImage = _newSlotImage;
    }

    public ImageIcon getSlotImage(){
        return slotImage;
    }


    // Методы для взаимодействия с ID слотов
    public void setSlotID(int _slotId){
        slotID = _slotId;
    }

    public int getSlotID(){
        return slotID;
    }

    // Метод для обнуления объекта класса Slot
    public void Delete(){
        slotID = -1;
        itemID = null;
        onCursor = false;
        slotImage = null;
        pic = null;
    }
}