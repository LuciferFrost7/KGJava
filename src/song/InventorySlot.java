import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.*;
/*
// Класс для хранения предмета и дополнительной информации о нём олицетворяющий слот инвенторя Персонажа
public class InventorySlot {

    public JLabel slot; // Параметр отвечающий за хранение текстуры Слота
    public JLabel CloseButton; // Параметр отвечающей за кнопку открывающею Дополнительную Панель

    public JLabel label; // Параметр хранящий в строку, которая отображает предмет
    private String ItemID; // Параметр отвечающий за ID предмета находящегося в слоте
    private String ItemType; // Параметр отвечающий за Тип предмета находящегося в слоте
    private String ItemDesription; // Параметр отвечающий за описание предмета находящегося в слоте
    private ImageIcon Texture; // Параметр отвечающий за хранение Текстуры предмета находящегося в слоте

    private Item item; // Параметр отвечающий за хранение Предмета
    private Weapon weapon; // Параметр отвечающий за хранение Оружия
    private Armore armor; // Параметр отвечающий за хранение Брони
    private Tool tool; // Параметр отвечающий за хранение Инструмента

    private Picture pic = new Picture(true, false, false, false);
    private boolean infoopen = false;
    private ItemList IL = new ItemList();


    // Конструктор Класса InventorySlot для Оружия

    // Конструктор Класса InventorySlot для Предмета
    public InventorySlot(Item it, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP, char d) {
        ConstructItem(it, x, y, placepanel, ExPanel, EP);
    }
    public InventorySlot(Weapon it, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP, String c) {
        ConstructWeapon(it, x, y, placepanel, ExPanel, EP);
    }
    public InventorySlot(Armore it, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP, boolean b) {
        ConstructArmor(it, x, y, placepanel, ExPanel, EP);
    }
    public InventorySlot(Tool it, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP, int a) {
        ConstructTool(it, x, y, placepanel, ExPanel, EP);
    }

    // Конструктор Класса InventorySlot Для Оружия
    public void ConstructWeapon(Weapon weap, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP){
        weapon = weap;
        ItemID = weapon.getItemID();
        ItemType = weapon.getClassType();
        Texture = IL.getItemInfo(ItemID, 'b').getItemIcon();
        CloseButton = new JLabel();
        CloseButton.setBounds(x+48, y+48, 10, 10);
        CloseButton.setIcon(pic.group1.getImage("ExtrasButton"));
        CloseButton.addMouseListener( new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(infoopen){
                    ExPanel.setVisible(false);
                    infoopen = false;
                }else {
                    EP.Update(ItemType, weap.getItemName(), weap.getItemRarity(), weap.getItemIcon(), String.valueOf(weap.getWeaponDamage()), weap.getWeaponType(), String.valueOf(weap.getWeaponSpeed()), "Weapon");
                    ExPanel.setVisible(true);
                    infoopen = true;
                }
            }
        });

        placepanel.add(CloseButton);
        label = new JLabel();
        label.setBounds(x + 8, y + 8, 48,   48);
        EP.setNewImage(Texture);
        placepanel.add(label);

        CreateSlot(x, y, placepanel);
    }

    // Конструктор Класса InventorySlot для Брони
    public void ConstructArmor(Armore arm, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP){
        CloseButton = new JLabel();
        CloseButton.setBounds(x+48, y+48, 10, 10);
        CloseButton.setIcon(pic.group1.getImage("ExtrasButton"));
        CloseButton.addMouseListener( new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(infoopen){
                    ExPanel.setVisible(false);
                    infoopen = false;
                }else {
                    EP.Update(ItemType, item.getItemName(), item.getItemRarity(), item.getItemIcon(), "0", "", "", "Armor");
                    ExPanel.setVisible(true);
                    infoopen = true;
                }
            }
        });
        placepanel.add(CloseButton);

        //concept
        armor = arm;
        ItemID = arm.getItemID();
        ItemType = arm.getClassType();
        Texture = IL.getItemInfo(ItemID).getItemIcon();

        label = new JLabel();
        label.setBounds(x, y, 48,48);
        label.setIcon(Texture);
        placepanel.add(label);

        CreateSlot(x, y, placepanel);
    }

    // Конструктор Класса InventorySlot для Инструмента
    public void ConstructTool(Tool to, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP){
        CloseButton = new JLabel();
        CloseButton.setBounds(x+48, y+48, 10, 10);
        CloseButton.setIcon(pic.group1.getImage("ExtrasButton"));
        CloseButton.addMouseListener( new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(infoopen){
                    ExPanel.setVisible(false);
                    infoopen = false;
                }else {
                    EP.Update(ItemType, item.getItemName(), item.getItemRarity(), item.getItemIcon(), String.valueOf(tool.getToolPower()), "", "", "Tool");
                    ExPanel.setVisible(true);
                    infoopen = true;
                }
            }
        });
        placepanel.add(CloseButton);

        //Concept
        tool = to;
        ItemID = to.getItemID();
        ItemType = to.getClassType();
        Texture = IL.getItemInfo(ItemID).getItemIcon();

        label = new JLabel();
        label.setBounds(x, y, 64, 64);
        label.setIcon(Texture);
        placepanel.add(label);

        CreateSlot(x, y, placepanel);
    }

    // Конструктор Класса InventorySlot Для Предмета
    public void ConstructItem(Item it, int x, int y, JPanel placepanel, JPanel ExPanel, ExtraPanelClass EP) {
        CloseButton = new JLabel();
        CloseButton.setBounds(x+48, y+48, 10, 10);
        CloseButton.setIcon(pic.group1.getImage("ExtrasButton"));
        CloseButton.addMouseListener( new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (infoopen) {
                    ExPanel.setVisible(false);
                    infoopen = false;
                } else {
                    EP.Update(ItemType, item.getItemName(), item.getItemRarity(), item.getItemIcon(), "Количество", "", "", "Item");
                    ExPanel.setVisible(true);
                    infoopen = true;
                }
            }
        });
        placepanel.add(CloseButton);

        item = it;
        ItemID = item.getItemID();
        ItemType = item.getClassType();
        Texture = IL.getItemInfo(ItemID).getItemIcon();
        label = new JLabel();
        label.setBounds(x + 8, y + 8, 48, 48);
        label.setIcon(Texture);
        placepanel.add(label);

        CreateSlot(x, y, placepanel);
    }


    // Методы для смены предмета на новый
    public void setNewItem(Item it){
        item = it;
        ItemID = item.getItemID();
        ItemType = item.getClassType();
        Texture = IL.getItemInfo(ItemID).getItemIcon();
        label.setIcon(Texture);
    }

    public void setNewWeapon(Weapon wea){
        weapon = wea;
        ItemID = weapon.getItemID();
        ItemType = weapon.getClassType();
        Texture = IL.getItemInfo(ItemID).getItemIcon();
        label.setIcon(Texture);
    }

    public void setNewArmor(Armore arm){
        armor = arm;
        ItemID = arm.getItemID();
        ItemType = arm.getClassType();
        Texture = IL.getItemInfo(ItemID).getItemIcon();
        label.setIcon(Texture);
    }

    public void setNewTool(Tool to){
        //Concept
        tool = to;
        ItemID = to.getItemID();
        ItemType = to.getClassType();
        Texture = IL.getItemInfo(ItemID).getItemIcon();
        label.setIcon(Texture);
    }



    public void musorka() {
        // Методы для возвращения стандартных параметров
        public String getItemID () {
            return ItemID;
        }

        public String getItemType () {
            return ItemType;
        }

        public String getItemDesription () {
            return ItemDesription;
        }
            // Методы для возвращения Предметов по их типам
    public Item getItem(){
        return item;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public Armore getArmor(){
        return armor;
    }

    public Tool getTool(){
        return tool;
    }
    }
    public void CreateSlot(int x, int y, JPanel placepanel) {
        slot = new JLabel();
        slot.setBounds(x, y, 64, 64);
        slot.setIcon(pic.group1.getImage("InventorySlot"));
        placepanel.add(slot);
    }
}*/