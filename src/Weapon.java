import javax.swing.ImageIcon;



// Класс для создания оружия
public class Weapon{
    private final String WeaponName; // Параметр Оружия - Название Оружия
    private final String WeaponID; // Параметр Оружия - уникальный ID Оружия
    private final String WeaponRarity; // Параметр Оружия - Редкость Оружия
    private final ImageIcon WeaponIcon; // Параметр Оружия - Иконка Оружия

    private final String WeaponType; // Параметр оружия - Тип Оружия
    private final Points WeaponDamage; // Параметр Оружия - Урон оружия
    private final double WeaponRange; // Параметр Оружия - Расстояние для нанесения урона
    private final double WeaponSpeed; // Параметр Оружия - Скорость атаки оружия



    // Конструктор Класса Weapon
    public Weapon(String Weapon_Name,
                  String Weapon_ID,
                  String Weapon_Rarity,
                  String Weapon_Type,
                  int Weapon_Damage,
                  double Weapon_Range,
                  double Weapon_Speed,
                  ImageIcon Texture){
        WeaponName = Weapon_Name;
        WeaponID = Weapon_ID;
        WeaponRarity = Weapon_Rarity;
        WeaponType = Weapon_Type;
        WeaponDamage = new Points(Weapon_Damage);
        WeaponRange = Weapon_Range;
        WeaponSpeed = Weapon_Speed;
        WeaponIcon = Texture;
    }

    // Метод для получения Типа Оружия
    public String getWeaponType(){
        return WeaponType;
    }

    // Метод для получения количества урона Оружия
    public int getWeaponDamage(){
        return WeaponDamage.get();
    }

    // Метод для получения Расстояния нанесения урона
    public double getWeaponRange(){
        return WeaponRange;
    }

    // Метод для получения Скорости нанесения удара
    public double getWeaponSpeed(){
        return WeaponSpeed;
    }

    // Метод для получения Имени предмета
    public String getWeaponName(){
        return WeaponName;
    }

    // Метод для получения ID предмета
    public String getWeaponID(){
        return WeaponID;
    }

    // Метод для получения Редкости предмета
    public String getWeaponRarity(){ return WeaponRarity; }

    // Метод для получения Иконки предмета
    public ImageIcon getWeaponIcon(){
        return WeaponIcon;
    }

    // Метод для получения Типа предмета
    public String getClassType(){
        return "WEAPON";
    }
}