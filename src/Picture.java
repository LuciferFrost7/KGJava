import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// Класс хранящий в себе Изображения
public class Picture {
    // Параметры Класса
    //private int Length; // Параметр отвечающий за количество изображений
    //private ImageIcon Images[]; // Массив изображений
    //private URL URLmass[]; // Массив ссылок на изображения
    //private List Listok; // Список со строками путей изображений
    private Map<String, ImageIcon> mapka;
    private List IDList;

    PictureGroup group1;
    PictureGroup group2;
    PictureGroup group3;
    PictureGroup group4;
    PictureGroup group5;
    // Конструктор класса Picture
    public Picture(boolean g1, boolean g2, boolean g3, boolean g4){
        if(g1){
        CreateGroup1();}
        if(g2){
        CreateGroup2();}
        if(g3){
        CreateGroup3();}
        if(g4){
        CreateGroup4();
        CreateGroup5();}
    }

    // Создание группы изображений связанных с интерфейсом
    private void CreateGroup1()
    {
        List l1 = new List();
        l1.add("HealthBar");// 0
        l1.add("MenuButton");// 1
        l1.add("MenuButtonTouched");// 2
        l1.add("Inventory_Slots_Opener");// 3
        l1.add("Inventory_Slots_State");// 4
        l1.add("Cursor");// 5
        l1.add("InventorySlot");// 6
        l1.add("CharacterPanel");// 7
        l1.add("ArmoreSlot");// 8
        l1.add("ExtrasButton");// 9
        l1.add("HealthHeart");// 10
        l1.add("HealthPoint");// 11
        l1.add("ExtraPanelLine");// 12
        l1.add("ExtraCloseButton");// 13
        l1.add("ExtraPanelDesign");// 14

        l1.add("KG_Coins");// 15
        l1.add("KG_ExpirienceLVL");// 16
        l1.add("playerBackground");// 17
        l1.add("KG_MaxHealth");// 18
        l1.add("KG_Defence");// 19
        l1.add("KG_Damage");// 20
        l1.add("KG_NoneField");// 21
        l1.add("InventoryLongButton");// 22
        l1.add("Inventory");// 23
        l1.add("KnightGameOverView");// 24
        l1.add("KG_LogoType");// 25
        l1.add("KG_LogoType1");// 26

        l1.add("MainMenu/exitButton");// 27
        l1.add("MainMenu/exitButtonTouched");// 28
        l1.add("MainMenu/playButton");// 29
        l1.add("MainMenu/playButtonTouched");// 30
        l1.add("MainMenu/modeButton");// 31
        l1.add("MainMenu/modeButtonTouched");// 32
        l1.add("MainMenu/modeLeftButton");// 33
        l1.add("MainMenu/modeLeftButtonTouched");// 34
        l1.add("MainMenu/modeRightButton");// 35
        l1.add("MainMenu/modeRightButtonTouched");// 36
        l1.add("MainMenu/modeBetaButton");// 37
        l1.add("MainMenu/modeBetaButtonTouched");// 38
        l1.add("MainMenu/modeDungeonButton");// 39
        l1.add("MainMenu/modeDungeonButtonTouched");// 40
        l1.add("MainMenu/modeWavesButton");// 41
        l1.add("MainMenu/modeWavesButtonTouched");// 42

        group1 = new PictureGroup("Images/Group1/", l1,".png");
        System.out.println("PictureGroup1_LoadedSuccessful");
    }

    // Создание группы изображений связанных с Предметами
    private void CreateGroup2()
    {
        List l2 = new List();
        l2.add("KG_VoidItem");// 0
        l2.add("KG_Coins");// 1
        l2.add("Weapon/Knight/sword");// 7
        l2.add("KGbackpack");// 3
        l2.add("StartHelmet");// 4
        l2.add("StartChestplate");// 5
        l2.add("StartLegs");// 6
        l2.add("Armor/Iron/head");// 7
        l2.add("Armor/Iron/body");// 8
        l2.add("Armor/Iron/legs");// 9
        Map<String, ImageIcon> m2 = new HashMap<>(l2.getItemCount());
        URL u2[] = new URL[l2.getItemCount()];
        ImageIcon i2[] = new ImageIcon[l2.getItemCount()];
        for (int i = 0; i < l2.getItemCount(); i++) {
            u2[i] = getClass().getResource("Images/Group2/" + l2.getItem(i) + ".png");
            i2[i] = new ImageIcon(u2[i]);
            m2.put(l2.getItem(i), i2[i]);
        }
        IDList = new List();
        mapka = new HashMap<>(l2.getItemCount());
        IDList.add("#0000");
        IDList.add("#0001");
        IDList.add("#0002");
        IDList.add("#0003");
        IDList.add("#0004");
        IDList.add("#0005");
        IDList.add("#0006");
        IDList.add("#0007");
        IDList.add("#0008");
        IDList.add("#0009");
        group2 = new PictureGroup(m2, l2);
        for(int i =0; i < IDList.getItemCount();i++){
            mapka.put(IDList.getItem(i), group2.getImage(Integer.parseInt(IDList.getItem(i).substring(1,IDList.getItem(i).length()))));
        }
        System.out.println("PictureGroup2_LoadedSuccessful");

    }

    // Создание группы изображений связанных с Существами
    private void CreateGroup3()
    {
        List l3 = new List();
        l3.add("Player/BOBAPlayer");// 0
        l3.add("Player/TestPlayerDead");// 1
        l3.add("Slice");// 2
        l3.add("Mobs/GORUML/up");// 3
        l3.add("Mobs/GORUML/right");// 4
        l3.add("Mobs/GORUML/down");// 5
        l3.add("Mobs/GORUML/left");// 6
        l3.add("Mobs/GORUML/dead");// 7
        l3.add("Mobs/HealthBar/MobHealBar");// 8
        l3.add("Mobs/HealthBar/MHBStartLine");// 9
        l3.add("Mobs/HealthBar/MHBLine");// 10
        l3.add("Mobs/HealthBar/MHBEndLine");// 11
        l3.add("Mobs/ENT/up");// 12
        l3.add("Mobs/ENT/right");// 13
        l3.add("Mobs/ENT/down");// 14
        l3.add("Mobs/ENT/left");// 15
        l3.add("Mobs/ENT/dead");// 16

        l3.add("Mobs/KNIGHT/up");// 12
        l3.add("Mobs/KNIGHT/right");// 13
        l3.add("Mobs/KNIGHT/down");// 14
        l3.add("Mobs/KNIGHT/left");// 15
        l3.add("Mobs/KNIGHT/dead");// 16
        l3.add("Player/Player"); // 17
        l3.add("Player/PlayerDead"); // 18

        group3 = new PictureGroup("Images/Group3/", l3,".png");
        System.out.println("PictureGroup3_LoadedSuccessful");
    }

    // Создание группы изображение связанных с Эффектами
    private void CreateGroup4()
    {
        List l4 = new List();
        l4.add("HealthBar");// 0
        l4.add("KG_Coins");// 1
        l4.add("KG_Expirience");// 2
        l4.add("wall");// 3
        l4.add("Armor/Iron/head");// 4
        l4.add("Armor/Iron/body");// 5
        l4.add("Armor/Iron/legs");// 6

        l4.add("Weapon/Knight/sword");// 7
        group4 = new PictureGroup("Images/Group4/", l4, ".gif");
        System.out.println("PictureGroup4_LoadedSuccessful");
    }
    ImageIcon getImageOnID(String ImageID){
        return mapka.get(ImageID);
    }
    private void CreateGroup5()
    {
        List l5 = new List();
        l5.add("FieldGround");// 0
        l5.add("SandGround");// 1


        group5 = new PictureGroup("Images/Group5/", l5, ".png");
        System.out.println("PictureGroup5_LoadedSuccessful");
    }
}