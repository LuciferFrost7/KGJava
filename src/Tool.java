import javax.swing.ImageIcon;



// Класс предназначенный для хранения в себе предметов Типа "Инструмент"
public class Tool{
    private final String ToolName; // Параметр Инструмента - Название Инструмента
    private final String ToolID; // Параметр Инструмента - уникальный ID Инструмента
    private final String ToolRarity; // Параметр Инструмента - Редкость Инструмента
    private final ImageIcon ToolIcon; // Параметр Инструмента - Иконку Инструмент

    private final String ToolType; // Параметр отвечающий за Тип Инструмента
    private final int ToolPower; // Параметр отвечающий за уровень добываемых ресурсов



    // Конструктор класса Tool
    public Tool(String Tool_Name, String Tool_ID, String Tool_Rarity, String Tool_Type, int Tool_Power, ImageIcon Texture) {
        ToolName = Tool_Name;
        ToolID = Tool_ID;
        ToolRarity = Tool_Rarity;
        ToolIcon = Texture;
        ToolType = Tool_Type;
        ToolPower = Tool_Power;
    }

    // Метод возвращающий Тип Инструмента
    public String getToolType() {
        return ToolType;
    }

    // Метод возвращающий уровень добываемых ресурсов
    public int getToolPower() {
        return ToolPower;
    }

    // Метод возвращающий Имя Инструмента
    public String getToolName(){
        return ToolName;
    }

    // Методы возвращающий ID Инструмента
    public String getToolID(){
        return ToolID;
    }

    // Метод возвращающий Редкость Инструмента
    public String getToolRarity(){
        return ToolRarity;
    }

    // Методы возвращающий Иконку Инструмента
    public ImageIcon getToolIcon(){
        return ToolIcon;
    }

    // Методы возвращающий Тип Предмета
    public String getClassType(){
        return "TOOL";
    }

}
