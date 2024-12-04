// Класс для работы со слотами в быстрой Линии
public class FastLine {
    private int Cursor; // Параметр отвечающий за номер слота, на котором в текущий момент расположен Курсор
    private final Slot FirstSlot; // Первый слот Быстрой линии
    private final Slot SecondSlot; // Второй слот Быстрой линии
    private final Slot ThirdSlot; // Третий слот Быстрой линии
    private final Slot ForthdSlot; // Четвёртый слот Быстрой линии
    private final Slot FifthSlot; // Пятый слот Быстрой линии
    private final Slot[] Slots; // Параметр хранящий Список Слотов
    private ItemList IL;


    // Конструктор Класса FastLine
    public FastLine(){
        IL = new ItemList();
        // Создание Слотов Быстрой Линии
        Cursor = 1;
        FirstSlot = new Slot(true, 0, "#0000");
        SecondSlot = new Slot(false, 1, "#0000");
        ThirdSlot = new Slot(false, 2, "#0000");
        ForthdSlot = new Slot(false, 3, "#0000");
        FifthSlot = new Slot(false, 4,"#0000");

        // Заполнение Массива Слотов Быстрой Линии
        Slots = new Slot[5];
        Slots[0] = FirstSlot;
        Slots[1] = SecondSlot;
        Slots[2] = ThirdSlot;
        Slots[3] = ForthdSlot;
        Slots[4] = FifthSlot;
    }

    // Методы для взаимодействия со слотами
    public void setSlotOnCursor(int Number_of_Slot){
        Slots[Number_of_Slot].setOnCursor(true);
        Slots[Cursor].setOnCursor(false);
        Cursor = Number_of_Slot;
    }
    public int getCorsor(){
        return Cursor;
    }
    public void setNewItemID(int Number_of_Slot, String ItemId){
        if(IL.KGWeapons.containsKey(ItemId)){
            Slots[Number_of_Slot].setWeapon(IL.getWeaponInfo(ItemId));
        }else if(IL.KGItems.containsKey(ItemId)) {
            Slots[Number_of_Slot].setItem(IL.getItemInfo(ItemId));
        }else if(IL.KGArmors.containsKey(ItemId)) {
            Slots[Number_of_Slot].setArmor(IL.getArmorInfo(ItemId));
        }else if(IL.KGTools.containsKey(ItemId)) {
            Slots[Number_of_Slot].setTool(IL.getToolInfo(ItemId));
        }else{
            System.out.println("Error Type Item");
        }
    }
    public String getItemID(int Number_of_Slot){
        return Slots[Number_of_Slot].getItemID();
    }
    public Slot getSlot(int Number_of_Slot){
        return Slots[Number_of_Slot];
    }

}