import java.awt.Color;



// Класс предназначенный для удобного взаимодействия с игровыми Хит-Боксами
public class HitBoxes {
    private Color safe = new Color(14, 241, 177, 100); // Цвет Безопасной зоны
    private Color heal = new Color(0, 255, 5,100); // Цвет зоны Восстанавливающей здоровье
    private Color pain = new Color(255, 38, 0,100); // Цвет зоны наносящей урон
    private Color wall = new Color(54, 76, 186,100); // Цвет зоны Стен
    private Color BoxColor; // Параметр хранящий в себе цвет Хит-Бокса
    private int StartX; // Параметр хранящий начальную точку длины Хит-Бокса
    private int StartY; // Параметр хранящий начальную точку высоты Хит-Бокса
    private int width;
    private int height;



    // Конструктор класса HitBoxes
    public HitBoxes(int startX, int startY, int size, String typeOfBox) {
        // Переназначение стартовых параметров
        StartX = startX;
        StartY = startY;
        width = size;
        height = size;

        // Назначение типа Хит-Бокса
        switch (typeOfBox.toUpperCase()) {
            case "WALL":
                BoxColor = wall;
                break;
            case "HEAL":
                BoxColor = heal;
                break;
            case "PAIN":
                BoxColor = pain;
                break;
            case "SAFE": default:
                BoxColor = safe;
                break;
        }
    }
    public HitBoxes(int startX, int startY, int width, int height, String typeOfBox) {
        // Переназначение стартовых параметров
        StartX = startX;
        StartY = startY;
        width = width;
        height = height;

        // Назначение типа Хит-Бокса
        switch (typeOfBox.toUpperCase()) {
            case "WALL":
                BoxColor = wall;
                break;
            case "HEAL":
                BoxColor = heal;
                break;
            case "PAIN":
                BoxColor = pain;
                break;
            case "SAFE": default:
                BoxColor = safe;
                break;
        }
    }

    public boolean inMod(int z, int z1, int z2){
        if(z1 <= z && z <= z2) {
            return true;
        }
        return false;
    }

    // Методы определяющие находится ли переданный объект на территории Данного Хит-Бокса
    public boolean inHitBox(int x, int y, int size) {
        if(inMod(x, StartX, StartX + width) && inMod(y, StartY, StartY + height)) {
            return true;
        }else if(inMod(x + size, StartX, StartX + width) && inMod(y, StartY, StartY + height)) {
            return true;
        }else if(inMod(x, StartX, StartX + width) && inMod(y + size, StartY, StartY + height)) {
            return true;
        }else if(inMod(x + size, StartX, StartX + width) && inMod(y + size, StartY, StartY + height)) {
            return true;
        }else if(inMod(StartX, x,x + size) && inMod(StartY, y, y + size)) {
            return true;
        }else if(inMod(StartX + width, x, x + size) && inMod(StartY, y, y + size)) {
            return true;
        }else if(inMod(StartX, x, x + size) && inMod(StartY + height, y, y + size)) {
            return true;
        }else if(inMod(StartX + width, x, x + size) && inMod(StartY + height, y, y + size)){
            return true;
        }
        return false;
    }
    public boolean inHitBox(int x, int y, int _heigh, int _weight) {
        if(inMod(x, StartX, StartX + this.width) && inMod(y, StartY, StartY + this.height)) {
            return true;
        }else if(inMod(x + _weight, StartX, StartX + this.width) && inMod(y, StartY, StartY + this.height)) {
            return true;
        }else if(inMod(x, StartX, StartX + this.width) && inMod(y + _heigh, StartY, StartY + this.height)) {
            return true;
        }else if(inMod(x + _weight, StartX, StartX + this.width) && inMod(y + _heigh, StartY, StartY + this.height)) {
            return true;
        }else if(inMod(StartX, x,x + _weight) && inMod(StartY, y, y + _heigh)) {
            return true;
        }else if(inMod(StartX + this.width, x, x + _weight) && inMod(StartY, y, y + _heigh)) {
            return true;
        }else if(inMod(StartX, x, x + _weight) && inMod(StartY + this.height, y, y + _heigh)) {
            return true;
        }else if(inMod(StartX + this.width, x, x + _weight) && inMod(StartY + this.height, y, y + _heigh)){
            return true;
        }
        return false;
    }

    public boolean inHitBox(HitBoxes secondHitBox) {
        int x = secondHitBox.StartX;
        int y = secondHitBox.StartY;
        int width = secondHitBox.width;
        int eight = secondHitBox.height;
        return inHitBox(x, y, width, eight);
    }

    // Методы для взаимодействия с Координатой X
    public void setNewX(int x){
        StartX = x;
    }
    public int getX(){
        return StartX;
    }

    // Методы для взаимодействия с Координатой Y
    public int getY(){
        return StartY;
    }
    public void setNewY(int y){
        StartY = y;
    }

    // Методы для взаимодействия с Размером Хит-Бокса
    public int getHeight(){
        return height;
    }

    // Методы для взаимодействия с Размером Хит-Бокса
    public int getWidth(){
        return width;
    }

    // Методы для взаимодействия с Цветом(Типом) Хит-Бокса
    public Color getBoxColor(){
        return BoxColor;
    }
}
