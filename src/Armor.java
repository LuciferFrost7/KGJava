import javax.swing.ImageIcon;



// Класс предназначенный для хранения в себе экземпляров брони
public class Armor{

    private final String ArmorName; // Параметр предмета - Название предмета
    private final String ArmorID; // Параметр предмета - уникальный ID предмета
    private final String ArmorRarity; // Параметр предмета - Редкость предмета
    private final ImageIcon ArmorIcon; // Параметр предмета - Иконка предмета

    private final Points DefendPoints; // Параметр Брони - очки защиты игрока
    private final Points ExtraHealthPoints; // Параметр Брони - очки здоровья игрока
    private final String ArmorType; // Параметр Брони - Тип Брони



    // Конструктор класса Armor
    public Armor(String Armor_Name,
                 String Armor_ID,
                 String Armor_Rarity,
                 int Defend_Points,
                 int Extra_Health_Points,
                 String Armor_Type,
                 ImageIcon Texture) {
        ArmorName = Armor_Name;
        ArmorID = Armor_ID;
        ArmorRarity = Armor_Rarity;
        ArmorIcon = Texture;
        DefendPoints = new Points(Defend_Points);
        ExtraHealthPoints = new Points(Extra_Health_Points);
        ArmorType = Armor_Type;
    }

    //  Методы для получения параметров брони
    public int getDefendPoints(){
        return DefendPoints.get();
    }
    public int getExtraHealthPoints(){
        return ExtraHealthPoints.get();
    }

    // Метод для получения Типа Брони(Шлем / Кираса / Латы)
    public String getArmorType(){
        return ArmorType;
    }

    // Методы для получения имени брони
    public String getArmorName(){
        return ArmorName;
    }

    // Методы для получения ID брони
    public String getArmorID(){
        return ArmorID;
    }

    // Метод для получения Редкости брони
    public String getArmorRarity(){ return ArmorRarity; }

    // Методы для получения Иконкой брони
    public ImageIcon getArmorIcon(){
        return ArmorIcon;
    }

    // Методы для получения Типа Предмета
    public String getClassType(){
        return "ARMOR";
    }
}