// Класс для взаимодействия с игровыми Очками
public class Points {
    private int Count; // Параметр для хранения количества очков
    private int CountLimit; // Параметр хранящий Предел хранения очков


    // Конструктор Класса Points если передаётся один параметр
    public Points(int count){
        Count = count;
        CountLimit = 9999999;
    }

    // Конструктор Класса Points если передаётся два параметра
    public Points(int count, int countlimit){
        Count = count;
        CountLimit = countlimit;
    }

    public double getd(){
        return (double)Count;
    }
    //  Метод для получения значения Очков
    public int get(){
        return Count;
    }

    // Метод для установления значения Очков
    public void set(int count){
        if(count <= CountLimit) {
            Count = count;
        }
    }

    // Метод для Добавления очков к основному значению
    public void add(int count){
        if(Count + count <= CountLimit) {
            Count += count;
        }
        else
        {
            Count = CountLimit;
        }
    }

    // Метод для Снятия очков от основного значения
    public void sub(int count){
        if(Count >= count) {
            Count -= count;
        }
        else
        {
            Count = 0;
        }
    }
    public void sub(double count){
        if(Count >= count) {
            Count -= count;
        }
        else
        {
            Count = 0;
        }
    }
}