import java.util.HashMap;
import java.util.Map;

// Класс хранящий в себе все игровые предметы
public class ItemList {
    public Map<String, Item> KGItems; // Словарь Хранящий игровые предметы по их айди
    public Map<String, Weapon> KGWeapons; // Словарь Хранящий игровые оружия по их айди
    public Map<String, Armor> KGArmors;
    public Map<String, Tool> KGTools;
    private Picture pic; // Параметр для передачи изображения
    private Item KGVoidItem; // Игровой Предмет
    private Item KGCoin; // Игровой Предмет
    private Weapon KGSword; // Игровое Оружие
    private Item KGBackpack;
    private Armor KGStartHelmet;
    private Armor KGStartChestplate;
    private Armor KGStartLegs;
    private Armor KGIronHead;
    private Armor KGIronBody;
    private Armor KGIronLegs;



    // Конструктор Класса ItemList
    public ItemList(){
        KGItems = new HashMap<>(3);
        KGWeapons = new HashMap<>(1);
        KGArmors = new HashMap<>(3);
        KGTools = new HashMap<>(1);
        pic = new Picture(false, true, false, false);
        // Item
        // 0000
        KGVoidItem = new Item("KG VoidItem", "#0000", "casual", pic.group2.getImage(0));
        KGItems.put(KGVoidItem.getItemID(), KGVoidItem);
        // Item
        // 0001
        KGCoin = new Item("KG Coin","#0001", "common", pic.group2.getImage(1));
        KGItems.put(KGCoin.getItemID(), KGCoin);
        // Weapon
        // 0002
        KGSword = new Weapon("KG Sword", "#0002", "legendary", "Sword", 10, 2, 2, pic.group2.getImage(2));
        KGWeapons.put(KGSword.getWeaponID(), KGSword);
        //
        //
        KGBackpack = new Item("KG BackPack","#0003","common", pic.group2.getImage(3));
        KGItems.put(KGBackpack.getItemID(), KGBackpack);
        //
        //
        KGStartHelmet = new Armor("KG Start Helmet","#0004","rare",3,10,"Helmet", pic.group2.getImage(4));
        KGArmors.put(KGStartHelmet.getArmorID(), KGStartHelmet);
        //
        //
        KGStartChestplate = new Armor("KG Start Chestplate","#0005","rare",4,12,"Chestplate", pic.group2.getImage(5));
        KGArmors.put(KGStartChestplate.getArmorID(), KGStartChestplate);
        //
        //
        KGStartLegs = new Armor("KG Start Legs","#0006","rare",4,8,"Legs", pic.group2.getImage(6));
        KGArmors.put(KGStartLegs.getArmorID(), KGStartLegs);
        //
        //
        KGIronHead = new Armor("KG Iron Head","#0007","rare",3,10,"Helmet", pic.group2.getImage(7));
        KGArmors.put(KGIronHead.getArmorID(), KGIronHead);
        //
        //
        KGIronBody = new Armor("KG Iron Body","#0008","rare",4,12,"Chestplate", pic.group2.getImage(8));
        KGArmors.put(KGIronBody.getArmorID(), KGIronBody);
        //
        //
        KGIronLegs = new Armor("KG Iron Legs","#0009","rare",4,8,"Legs", pic.group2.getImage(9));
        KGArmors.put(KGIronLegs.getArmorID(), KGIronLegs);
    }

    // Метод для получения информации о Предмете
    public Item getItemInfo(String ItemID){
        return KGItems.get(ItemID);
    }
    public Weapon getWeaponInfo(String ItemID){
        return KGWeapons.get(ItemID);
    }
    public Armor getArmorInfo(String ItemID){
        return KGArmors.get(ItemID);
    }
    public Tool getToolInfo(String ItemID){
        return KGTools.get(ItemID);
    }
    public String getClassType(String ItemId){
        if(KGItems.containsKey(ItemId)){
            return KGItems.get(ItemId).getClassType();
        }else if(KGWeapons.containsKey(ItemId)){
            return KGWeapons.get(ItemId).getClassType();
        }else if(KGArmors.containsKey(ItemId)) {
            return KGArmors.get(ItemId).getClassType();
        }else if(KGTools.containsKey(ItemId)) {
            return KGTools.get(ItemId).getClassType();
        }else{
            return "";
        }
    }
}