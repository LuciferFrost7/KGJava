import javax.swing.ImageIcon;



// Класс для создания предметов
public class Item {
    private final String ItemName; // Параметр предмета - Название предмета
    private final String ItemID; // Параметр предмета - уникальный ID предмета
    private final String ItemRarity; // Параметр предмета - Редкость предмета
    private final ImageIcon ItemIcon; // Параметр предмета - Иконка предмета



    // Конструктор Класса Item
    public Item(String Item_Name, String Item_ID, String Item_Rarity,ImageIcon Item_Icon){
        ItemName = Item_Name;
        ItemID = Item_ID;
        ItemRarity = Item_Rarity;
        ItemIcon = Item_Icon;
    }

    // Методы для получения Имени предмета
    public String getItemName(){
        return ItemName;
    }

    // Методы для получения ID предмета
    public String getItemID(){
        return ItemID;
    }

    // Метод для получения Редкости предмета
    public String getItemRarity(){ return ItemRarity; }

    // Методы для получения Изображения предмета
    public ImageIcon getItemIcon(){
        return ItemIcon;
    }

    // Методы для получения Типа предмета
    public String getClassType(){
        return "ITEM";
    }
}