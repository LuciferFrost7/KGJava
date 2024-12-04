
// Абстрактный класс хранящий стандартные показатели класса игрок
public class Player_Standart {
    protected final short ST_RegenerationHealth = 50; // Стандартное значение для Регенирируемого здоровья
    protected final String ST_Permission = "USER"; // Стандартное значение для полномочий игрока
    protected final String ST_Alive = "ALIVE"; // Стандартное значение для статуса Жив-Мёртв
    protected final int ST_Level = 1; // Стандартное значение для уровня игрока
    protected final int ST_Expirience = 0;
    protected final int ST_Damage = 1; // Стандартное значение для наносимого урона
    protected final double ST_DamageSpeed = 2.0; // Стандартное значение для скорости нанесения урона
    protected final int ST_DamageRange = 10; // Стандартное значение для требуемого для нанесения урона расстояния
    protected final int ST_DefencePoints = 0; // Стандартное значение для количества очков защиты
    protected final int ST_ObsoluteDefencePoints = 0; // Стандартное значение для количества невосприимчивого урона
    protected final int ST_Coins = 0; // Стандартное значение для количества монет игрока0
}