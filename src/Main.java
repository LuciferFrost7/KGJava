import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



// Главный класс игры "KnightGame"
public class Main extends JFrame {
    public static final boolean IsHitBoxEnabled = false;

    public static final Color TRANSPARENT = new Color(0,0,0,0); // Создание прозрачного Цвета

    private final Random r = new Random(); // Создание параметра отвечающего за рандом

    private Song songy; // Создание объекта класса Song для воспроизведения музыки заднего фона

    private Cursor CursOn; // Класс хранящий в себе слот, на который указывает курсор

    private Picture pic = new Picture(true, true, true, true); // Создание объекта класса Picture для работы с изображениями

    private ItemList IL = new ItemList(); // Подключение списка игровых предметов

    private FastLine FastLine_; // Создание объекта класса FastLine для работы с Быстрой Линией

    private Player P1; // Создание объекта отвечающего за Игрока

    private Map<String, Color> RarityMap; // Словарь для хранения цветов редкостей
    private List RareList; // Список для хранения редкостей предметов

    private InventorySlotClass MainSlot1; // Главный слот инвенторя 1
    private InventorySlotClass MainSlot2; // Главный слот инвенторя 2
    private InventorySlotClass MainSlot3; // Главный слот инвенторя 3
    private InventorySlotClass MainSlot4; // Главный слот инвенторя 4
    private InventorySlotClass ExtraSlot8[]; // Массив Дополнительных слотов инвенторя 1-8

    private ArmoreSlotClass ArmorSlot1; // Слот для шлема
    private ArmoreSlotClass ArmorSlot2; // Слот для Нагрудника
    private ArmoreSlotClass ArmorSlot3; // Слот для Лат

    private String oldArm;

    private boolean HBbool[]; // Массив флагов отвечающих за отображение каждой из 7 полос жизни
    private boolean setting_open = false; // Параметр проверяющий настройки на открытость в данный момент
    private boolean KeyWPressed; // Отвечает за нажатую в данный момент клавишу W
    private boolean KeySPressed; // Отвечает за нажатую в данный момент клавишу S
    private boolean KeyAPressed; // Отвечает за нажатую в данный момент клавишу A
    private boolean KeyDPressed; // Отвечает за нажатую в данный момент клавишу D
    private boolean KeyEPressed; // Отвечает за нажатую в данный момент клавишу E
    private boolean KeyCPressed;
    private boolean Key12345Pressed; // Отвечает за нажатые клавиши 1, 2, 3, 4, 5
    private boolean invopen; // Флаг отвечающий за то открыт ли сейчас инвентарь
    private boolean CursorMoving; // Флаг для отключения возможности переключения Курсора
    private boolean ifArmoreOpen; // Флаг отвечающий за отображение слотов брони в инвентаре
    private boolean experimentalRules; // Флаг отвечающий за вкл/выкл эксперементальных настроеек
    private boolean voidSlot;
    boolean KeyEshPressed;

    private JTextField Setting_Commander; // Поле для ввода текста (Коммандер)

    private JPanel Jframe; // Создание главного экрана
    private JPanel frame; // Создание основного игрового поля
    private JPanel Settings; // Создание Панели настроек
    private JPanel panel; // Панель для отображения Здоровья
    private JPanel InventoryDesignPanel; // Создание изображения для инвенторя
    private JPanel SettingsPanel; // Создание Панели настроек
    private JPanel ExtraPanel; // Панель для отображения Дополнительной информации о предметах
    private JPanel InventoryPanel; // Панель для отображения Инвенторя

    private JLabel Setting_main_label; // Создание надписи Settings
    private JLabel Setting_Volume_label; // Кликабельная надпись отвечающая за настройку вкл-выкл Музыки заднего фона
    private JLabel player_name; // Поле отвечающее за отображение имени игрока в панели здоровья
    private JLabel player_health; // Поле отображающее количество здоровья игрока
    private JLabel HB; // Изображение стандартное линии жизни
    private JLabel HBHeart; // Изображения сердца жизни обозначающего, что персонаж жив
    private JLabel HBPoints[]; // Массив Изображений хранящий в себе 7 полос жизни
    private JLabel settinglabel; // Изображения кнопки настроек
    private JLabel Setting_commander_label; // Строка отображающая строку указывающаю на коммандер
    private JLabel InventorySlots[]; // Массив изображений слотов быстрой линии
    private JLabel ItemSlots[]; // Создание изображений для отображения предметов в быстрой линии
    private JLabel cursor; // Изображение для отображения Курсора
    private JPanel PLAYER; // Изображение игрока для перемещения по карте
    private JLabel ExtraPanelBackground; // Изображение Дизайна для Панели дополнительной информации
    private JLabel ItemType; // Строка отвечающая за отображение Типа Предмета (Предмет, Оружие, Броня, Инструмент)
    private JLabel ItemName; // Строка отображающая Название предмета
    private JLabel ItemRarity1; // Постоянная Строка отображающая "Редкость"
    private JLabel ItemRarity2; // Строка отображающая редкость предмета
    private JLabel ItemIconSlot; // Постоянная Строка отображающая текстуру слота в Панеле дополнительной информации
    private JLabel ItemIconInv; // Строка отображающая текстуру предмета
    private JLabel Parametr1; // Строка отображающая данные о предмете 1
    private JLabel Parametr2; // Строка отображающая данные о предмете 1
    private JLabel Parametr3; // Строка отображающая данные о предмете 1
    private JLabel DefinitionLine; // Постоянная Строка отображающая декоративную линию
    private JLabel Description; // Строка отображающая описание предмета
    private JLabel CloseButton; // Постоянная Кнопка отвечающая за закрытие панели дополнительной информации
    private JLabel playerLevelIcon; // Постоянная Иконка для обозначения места, где будет отображаться уровень игрока
    private JLabel playerLevelLabel; // Строка для отображения уровня игрока
    private JLabel playerCoinCounterIcon; // Постоянная Иконка для обозначения места, где будет отображаться монеты
    private JLabel playerCoinCounterLabel; // Строка для отображения количества монет игрока
    private JLabel playerNickNameBackground; // Постоянное изображения для обозначения места, где будет имя игрока
    private JLabel playerNickNameLabel; // Строка отображающая имя игрока
    private JLabel playerMaxHealthIcon; // Постоянная иконка для обозначения места, где будет отображаться Максимальное количество здоровья игрока
    private JLabel playerMaxHealthLabel; // Строка отображающая максимальное еоличество игрока
    private JLabel playerDefencePointsIcon; // Постоянная иконка отображающая щит
    private JLabel playerDefencePointsLabel; // Строка отображающая количество очков защиты игрока
    private JLabel playerDamageIcon; // Постоянная иконка отображающая меч
    private JLabel playerDamageLabel; // Строка отображающая количество урона игрока
    private JLabel playerFractionIcon; // Иконка отображающая фракцию игрока
    private JLabel playerFractionLabel; // Строка отображающая фракцию игрока
    private JLabel FirstInventoryButton; // Первая кнопка инвенторя для отображения меню навыков опыта
    private JLabel SecondInventoryButton; // Вторая кнопка инвенторя для отображения меню дерева фракционных талантов
    private JLabel playerIDLabel; // Строка отображающая ID игрока
    private JPanel slice;

    private Timer bol1;
    private Timer HealthChecker;

    private KeyAdapter MoveListener;
    public static List wallsList[];
    private static int wallsCount;

    private List listMode;
    private int GameMode;

    public Main(){
        this.setTitle("Knight Game Java Project");
        //setIconImage(pic.group1.getImage("KG_LogoType1"));

        // Создание основного окна приложения
        Jframe = new JPanel();
        Jframe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Jframe.setBorder(new EmptyBorder(5, 5, 5, 5));
        Jframe.setBackground(Color.ORANGE);
        Jframe.setLayout(null);
        setContentPane(Jframe);

        createFrame();

        // Проигрывание музыки при загрузке приложения
        songy = new Song("Evilpixel");

        CreateHelloPage();

        // Показатели отвечающие за открытие и настройки окна
        setPreferredSize(new Dimension(1230, 860));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void createFrame(){
        // Создание основного экрана отображающего игру
        frame = new JPanel();
        Jframe.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setLayout(null);
        frame.setBounds(15,15,1180,780);
        getContentPane().add(frame);
    }
    public void createRarityList(){
        // Подключение списка игровых предметов
        RareList = new List();
        RareList.add("casual");
        RareList.add("common");
        RareList.add("rare");
        RareList.add("very_rare");
        RareList.add("epic");
        RareList.add("legendary");
        RareList.add("hero");
    }
    public void createRarityMap(){
        // Создание Словаря хранящего цвета по названию редкостей
        RarityMap = new HashMap<String, Color>();
        RarityMap.put("_casual_",new Color(39, 245, 230));
        RarityMap.put("_common_",new Color(81, 232, 187));
        RarityMap.put("_rare_",new Color(31, 122, 207));
        RarityMap.put("_very_rare_",new Color(17, 42, 153));
        RarityMap.put("_epic_",new Color(81, 18, 255));
        RarityMap.put("_legendary_",new Color(255, 183, 0));
        RarityMap.put("_hero_",new Color(209, 44, 124));
    }

    private void CreateHelloPage(){
        JPanel HelloPage = new JPanel();
        HelloPage.setLayout(null);
        HelloPage.setBackground(Color.BLACK);
        HelloPage.setBounds(15,15,1180,780);

        JPanel logoColor = new JPanel();
        logoColor.setLayout(null);
        logoColor.setBackground(Color.BLACK);
        logoColor.setBounds(250,290,700,310);
        HelloPage.add(logoColor);

        JLabel logoOverView = new JLabel();
        logoOverView.setIcon(pic.group1.getImage("KnightGameOverView"));
        logoOverView.setBounds(250,300,600,300);
        HelloPage.add(logoOverView);

        JLabel LogoType = new JLabel();
        LogoType.setIcon(pic.group1.getImage("KG_LogoType"));
        LogoType.setBounds(750,375,128,128);
        HelloPage.add(LogoType);

        Jframe.add(HelloPage);
        ActionListener Action = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HelloPage.setVisible(false);
                createMainMenu(frame);
                songy.PlaySong();
            }
        };
        Timer HelloPager = new Timer(6000, Action);
        HelloPager.setRepeats(false);
        HelloPager.start();

        for(int i = 100; i < 5000; i+=100){
            int finalI = i;
            ActionListener Action1 = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    logoColor.setBackground(new Color(0,0,0,250 - (finalI / 20)));
                    HelloPage.updateUI();
                }
            };
            Timer HelloPager1 = new Timer(finalI, Action1);
            HelloPager1.setRepeats(false);
            HelloPager1.start();
        }
    }
    private void createMainMenu(JPanel _panel){

        listMode = new List();
        GameMode = 0;
        listMode.add("BETA");// 1
        listMode.add("Dungeon");// 2
        listMode.add("Waves");// 3

        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(null);
        mainMenu.setBackground(Color.ORANGE);
        mainMenu.setBounds(0, 0, 1180, 780);

        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(null);
        centralPanel.setBackground(Color.GRAY);
        centralPanel.setBounds(350, 20, 480, 740);
        mainMenu.add(centralPanel);

        JPanel centralBlockFirst = new JPanel();
        centralBlockFirst.setLayout(null);
        centralBlockFirst.setBackground(Color.DARK_GRAY);
        centralBlockFirst.setBounds(30, 20, 420, 68);
        centralPanel.add(centralBlockFirst);

        JLabel gameName = new JLabel("♦ Knight Game ♦");
        gameName.setFont(new Font("Tahoma", Font.PLAIN, 40));
        gameName.setBounds(65, 8, 300, 48);
        centralBlockFirst.add(gameName);

        JPanel centralBlockSecond = new JPanel();
        centralBlockSecond.setLayout(null);
        centralBlockSecond.setBackground(Color.DARK_GRAY);
        centralBlockSecond.setBounds(30, 108, 420, 462);
        centralPanel.add(centralBlockSecond);

        JLabel playButton = new JLabel();
        playButton.setIcon(pic.group1.getImage("MainMenu/playButton"));
        playButton.setBounds(106, 20,192,48);
        playButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                PlayGame();
                _panel.remove(mainMenu);
                _panel.updateUI();
                _panel.repaint();
            }
            public void mouseEntered(MouseEvent evt) {
                playButton.setIcon(pic.group1.getImage("MainMenu/playButtonTouched"));
            }
            public void mouseExited(MouseEvent evt) {
                playButton.setIcon(pic.group1.getImage("MainMenu/playButton"));
            }
        });
        centralBlockSecond.add(playButton);

        JLabel modeButton = new JLabel();

        JLabel modeLeftButton = new JLabel();
        modeLeftButton.setIcon(pic.group1.getImage("MainMenu/modeLeftButton"));
        modeLeftButton.setBounds(48, 88,48,48);
        modeLeftButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                GameMode = GameMode - 1 == 0 ? 3 : GameMode - 1;
                switch(GameMode) {
                    case 0:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeButton"));
                        break;
                    case 1:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeBetaButton"));
                        break;
                    case 2:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeDungeonButton"));
                        break;
                    case 3:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeWavesButton"));
                        break;
                }
            }
            public void mouseEntered(MouseEvent evt) {
                modeLeftButton.setIcon(pic.group1.getImage("MainMenu/modeLeftButtonTouched"));
            }
            public void mouseExited(MouseEvent evt) {
                modeLeftButton.setIcon(pic.group1.getImage("MainMenu/modeLeftButton"));
            }
        });
        modeLeftButton.setVisible(false);
        centralBlockSecond.add(modeLeftButton);

        JLabel modeRightButton = new JLabel();
        modeRightButton.setIcon(pic.group1.getImage("MainMenu/modeRightButton"));
        modeRightButton.setBounds(304, 88,48,48);
        modeRightButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                GameMode = (GameMode + 1) < 4 ? GameMode + 1 :  1;
                switch(GameMode) {
                    case 0:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeButton"));
                        break;
                    case 1:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeBetaButton"));
                        break;
                    case 2:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeDungeonButton"));
                        break;
                    case 3:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeWavesButton"));
                        break;
                }
            }
            public void mouseEntered(MouseEvent evt) {
                modeRightButton.setIcon(pic.group1.getImage("MainMenu/modeRightButtonTouched"));
            }
            public void mouseExited(MouseEvent evt) {
                modeRightButton.setIcon(pic.group1.getImage("MainMenu/modeRightButton"));
            }
        });
        modeRightButton.setVisible(false);
        centralBlockSecond.add(modeRightButton);


        modeButton.setIcon(pic.group1.getImage("MainMenu/modeButton"));
        modeButton.setBounds(106, 88,192,48);
        MouseAdapter adapt = new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if(GameMode == 0){
                    GameMode = 1;
                    modeButton.setIcon(pic.group1.getImage("MainMenu/modeBetaButtonTouched"));
                    modeLeftButton.setVisible(true);
                    modeRightButton.setVisible(true);
                }
                else{
                    GameMode = 0;
                    modeButton.setIcon(pic.group1.getImage("MainMenu/modeButtonTouched"));
                    modeLeftButton.setVisible(false);
                    modeRightButton.setVisible(false);
                }
            }
            public void mouseEntered(MouseEvent evt) {
                switch(GameMode) {
                    case 0:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeButtonTouched"));
                        break;
                    case 1:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeBetaButtonTouched"));
                        break;
                    case 2:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeDungeonButtonTouched"));
                        break;
                    case 3:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeWavesButtonTouched"));
                        break;
                }
            }
            public void mouseExited(MouseEvent evt) {
                switch(GameMode) {
                    case 0:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeButton"));
                        break;
                    case 1:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeBetaButton"));
                        break;
                    case 2:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeDungeonButton"));
                        break;
                    case 3:
                        modeButton.setIcon(pic.group1.getImage("MainMenu/modeWavesButton"));
                        break;
                }
            }
        };
        modeButton.addMouseListener(adapt);
        modeButton.addMouseMotionListener(adapt);
        centralBlockSecond.add(modeButton);

        JPanel centralBlockThird = new JPanel();
        centralBlockThird.setLayout(null);
        centralBlockThird.setBackground(Color.DARK_GRAY);
        centralBlockThird.setBounds(30, 590, 420, 130);
        centralPanel.add(centralBlockThird);

        JLabel exitButton = new JLabel();
        exitButton.setIcon(pic.group1.getImage("MainMenu/exitButton"));
        exitButton.setBounds(106,46, 192, 48);
        exitButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                GameExit();
                frame.setVisible(false);
                System.exit(0);
            }
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(pic.group1.getImage("MainMenu/exitButtonTouched"));
            }

            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(pic.group1.getImage("MainMenu/exitButton"));
            }
        });
        centralBlockThird.add(exitButton);

        _panel.add(mainMenu);
    }
    private void PlayGame(){
        switch(GameMode){
            case 0: case 1:{
                // Создание Основного игрока
                P1 = new Player("#0000000", "Test Player", 10, 500, 500, frame);

                createRarityList();
                createRarityMap();
                wallsList = new List[256];
                wallsCount = 0;

                CreateHealthPanel(); // Создание Панели Здоровья

                CreateSettingButton(); // Создание "Кнопки" Настроек

                CreateFastLine(); // Создание Быстрой Линии

                SettingsCreate(400,120); // Создание панели настроек

                // Создание Инвенторя
                CreateInventory();
                CreateExtraPanel(112,212);
                voidSlotCheck();

                //Добавление изображения игрока
                PLAYER = P1.panel;
                frame.add(PLAYER);
                HealthChecker = new Timer(100, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        HealthUpdate();
                    }
                });
                HealthChecker.start();

                //
                CursorMoving = true;




                ActionListener PA1 = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if(PLAYER.getX() > 1120){
                            PLAYER.setBounds(0, PLAYER.getY(),64,64);
                        }
                        if(PLAYER.getX() < 0){
                            PLAYER.setBounds(1119, PLAYER.getY(),64,64);
                        }
                        if(PLAYER.getY() > 720){
                            PLAYER.setBounds(PLAYER.getX(), 0,64,64);
                        }
                        if(PLAYER.getY() < 0){
                            PLAYER.setBounds(PLAYER.getX(), 720,64,64);
                        }
                    }
                };
                bol1  = new Timer(10 ,PA1);
                bol1.start();

                JPanel Terrain = new JPanel();
                Terrain.setBackground(TRANSPARENT);
                Terrain.setBounds(15,15,1180,780);
                Jframe.add(Terrain);
                takeDamage(P1);

                System.out.println("Game Started");
                summonKnight(900,300);
                createObject("coin", 200, 150);
                createObject("expirience", 300, 150);
                createObject("wall",100,100);
                createObject("iron_helmet",400, 150);
                createObject("iron_chestplate",440, 150);
                createObject("iron_legs",480, 150);
                createObject("knight_sword",520, 150);
            }break;
            case 2:{

            }break;
            case 3:{
                wallsList = new List[256];
                wallsCount = 0;

                CreateSettingButton();
                SettingsCreate(400,120);

                P1 = new Player("#0000000", "Test Player", 10, 500, 500, frame);
                PLAYER = P1.panel;
                frame.add(PLAYER);

                for(int i = 0; i < 20; i++){
                    createObject("wall", 100 + i * 48, 100);
                    createObject("wall", 100 + i * 48, 532);
                }
                for(int i = 0; i < 8; i++){
                    createObject("wall", 100, 148 + i * 48);
                    createObject("wall", 1012, 148 + i * 48);
                }

                CreateHealthPanel();
                HealthChecker = new Timer(100, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        HealthUpdate();
                    }
                });
                HealthChecker.start();
            }break;
            default:{
                System.out.println("<Game System Error> : don't have this mode!");
            }break;
        }
        KeyWPressed = false;
        KeySPressed = false;
        KeyAPressed = false;
        KeyDPressed = false;
        KeyCPressed = false;
        KeyEPressed = false;
        KeyEshPressed = false;
        Key12345Pressed = false;
        MoveListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_C:{
                        if(P1.getAlive()) {
                            takeDamage(P1);
                            KeyCPressed = true;
                        }
                    }
                    break;
                    case KeyEvent.VK_A: {
                        KeyAPressed = true;
                    }
                    break;
                    case KeyEvent.VK_D: {
                        KeyDPressed = true;
                    }
                    break;
                    case KeyEvent.VK_W: {
                        KeyWPressed = true;
                    }
                    break;
                    case KeyEvent.VK_S: {
                        KeySPressed = true;
                    }
                    break;
                    case KeyEvent.VK_E: {
                        invOpen();
                        KeyEPressed = true;
                    }break;
                    case KeyEvent.VK_ESCAPE: {
                        SettingsOpen();
                        KeyEshPressed = true;
                    }break;
                    case KeyEvent.VK_1: {
                        CursorMove(0);
                        Key12345Pressed = true;
                    }
                    break;
                    case KeyEvent.VK_2: {
                        CursorMove(1);
                        Key12345Pressed = true;
                    }
                    break;
                    case KeyEvent.VK_3: {
                        CursorMove(2);
                        Key12345Pressed = true;
                    }
                    break;
                    case KeyEvent.VK_4: {
                        CursorMove(3);
                        Key12345Pressed = true;
                    }
                    break;
                    case KeyEvent.VK_5: {
                        CursorMove(4);
                        Key12345Pressed = true;
                    }
                    break;
                    default:{
                        System.out.println("ErrorCode");
                    }break;
                }
                if (!Key12345Pressed || !KeyEPressed) {
                    PlayerMoveCheck();
                }
                frame.updateUI();
            }
            @Override
            public void keyReleased(KeyEvent e){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_C:{
                        KeyCPressed = false;
                    }break;
                    case KeyEvent.VK_A:{
                        KeyAPressed = false;
                    }break;
                    case KeyEvent.VK_D: {
                        KeyDPressed = false;
                    }break;
                    case KeyEvent.VK_W: {
                        KeyWPressed = false;
                    }break;
                    case KeyEvent.VK_S: {
                        KeySPressed = false;
                    }break;
                    case KeyEvent.VK_1:
                    case KeyEvent.VK_2:
                    case KeyEvent.VK_3:
                    case KeyEvent.VK_4:
                    case KeyEvent.VK_5:{ Key12345Pressed = false; }break;
                    case KeyEvent.VK_E:{
                        KeyEPressed = false;
                    }break;
                    case KeyEvent.VK_ESCAPE:{
                        KeyEshPressed = false;
                    }break;
                    default:{
                        System.out.println("ErrorCode");
                    }break;
                }
            }
        };
        addKeyListener (MoveListener);

    }
    private void MainMenuOpen(){
        removeKeyListener(MoveListener);
        MoveListener = null;
        switch(GameMode){
            case 0: case 1:{
                bol1.stop();
                HealthChecker.stop();

                RareList = null;
                RarityMap = null;
                P1.Delete();
                P1 = null;
                FastLine_ = null;
                MainSlot1 = null;
                MainSlot2 = null;
                MainSlot3 = null;
                MainSlot4 = null;
                ExtraSlot8 = null;
                CursOn = null;
                ArmorSlot1 = null;
                ArmorSlot2 = null;
                ArmorSlot3 = null;

                setting_open = false;
                invopen = false;
                ifArmoreOpen = false;

                frame.remove(panel);
                panel = null;
                frame.remove(SettingsPanel);
                SettingsPanel = null;
                frame.remove(InventoryDesignPanel);
                InventoryDesignPanel = null;
                frame.remove(Settings);
                Settings = null;
                frame.remove(ExtraPanel);
                ExtraPanel = null;

                Jframe.remove(frame);
                frame.updateUI();
                frame.repaint();
                createFrame();
                createMainMenu(frame);
            }break;
            case 2:{

            }break;
            case 3:{
                P1.Delete();
                P1 = null;
                frame.remove(PLAYER);

                HealthChecker.stop();

                frame.remove(panel);
                panel = null;

                frame.remove(SettingsPanel);
                SettingsPanel = null;

                frame.updateUI();
                frame.repaint();
                Jframe.remove(frame);


                createFrame();
                createMainMenu(frame);
            }break;
            default:{

            }break;
        }




    }

    private void PLAYERMOVE(int i, int j){
        if (canMove(PLAYER.getX() + i, PLAYER.getY() + j)) {
            PLAYER.setBounds(PLAYER.getX() + i, PLAYER.getY() + j, PLAYER.getWidth(), PLAYER.getHeight());
            P1.setX(PLAYER.getX() + i);
            P1.setY(PLAYER.getY() + j);
        }
    }
    public static boolean canMove(int cordX, int cordY){
        for(int i = 0; i < wallsCount; i++){
            HitBoxes hbn = new HitBoxes(Integer.parseInt(wallsList[i].getItem(0)) - 1, Integer.parseInt(wallsList[i].getItem(1)) - 1, 50, "wall");
            if(hbn.inHitBox(cordX, cordY, 64, 64)) {
                return false;
            }
        }
        return true;
    }
    private void PlayerMoveCheck(){
        if(P1.getAlive()) {
            while (true) {
                if (KeyWPressed && KeyAPressed) {
                    PLAYERMOVE(-P1.getSpeed(), -P1.getSpeed());
                    break;
                } // Движение по Диагонали Вверх и Влево
                if (KeyWPressed && KeyDPressed) {
                    PLAYERMOVE(P1.getSpeed(), -P1.getSpeed());
                    break;
                } // Движение по Диагонали Вверх и Вправо

                if (KeySPressed && KeyAPressed) {
                    PLAYERMOVE(-P1.getSpeed(), P1.getSpeed());
                    break;
                } // Движение по диагонали Вниз и Влево
                if (KeySPressed && KeyDPressed) {
                    PLAYERMOVE(P1.getSpeed(), P1.getSpeed());
                    break;
                } // Движение по диагонали Вниз и Влево

                if (KeyWPressed) {
                    PLAYERMOVE(0, -P1.getSpeed() * 2);
                    break;
                } // Движение вверх
                if (KeySPressed) {
                    PLAYERMOVE(0, P1.getSpeed() * 2);
                    break;
                } // Движение вниз

                if (KeyAPressed) {
                    PLAYERMOVE(-P1.getSpeed() * 2, 0);
                    break;
                } // Движение влево
                if (KeyDPressed) {
                    PLAYERMOVE(P1.getSpeed() * 2, 0);
                    break;
                } // Движение вправо
                else {
                    break;
                }
            }
        }
    }
    private void CreateHealthPanel(){
        // Панель Здоровья
        panel = new JPanel();
        panel.setBounds(0, 600, 300, 65);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        frame.add(panel);

        // Отображение имени игрока
        player_name = new JLabel(P1.getName());
        player_name.setForeground(Color.WHITE);
        player_name.setBounds(10,0,300,20);
        panel.add(player_name);

        // Отображение количество здоровья игрока
        player_health = new JLabel("Health : " + P1.getHP() + " / " + P1.getMaxHP());
        player_health.setForeground(Color.WHITE);
        player_health.setBounds(10,42,300,20);
        panel.add(player_health);

        //
        HBHeart = new JLabel();
        HBHeart.setIcon(pic.group1.getImage("HealthHeart"));
        HBHeart.setBounds(10, 26, 16,16);
        panel.add(HBHeart);

        //
        HBPoints = new JLabel[7];
        for(int i = 0;i < 7;i++){
            HBPoints[i] = new JLabel();
            HBPoints[i].setIcon(pic.group1.getImage("HealthPoint"));
            HBPoints[i].setBounds(24 + i * 32, 26, 32,16);
            panel.add(HBPoints[i]);
        }

        //
        HBbool = new boolean[7];
        for(int i = 0; i < 7;i++){ HBbool[i] = true; }
        HealthUpdate();

        // Отображение изображения полосы здоровья
        HB = new JLabel();
        HB.setIcon(pic.group1.getImage("HealthBar"));
        HB.setBounds(0, 20, 256, 32);
        panel.add(HB);
    }
    private void HealthUpdate(){
        player_health.setText("Health : " + P1.getHP() + " / " + P1.getMaxHP());
        if(P1.getAlive()){
            double bhp = P1.getHP();
            double bhm = P1.getMaxHP();
            HealthLinesUpdate(bhp, bhm, 6);
            for(int i = 1; i < 7; i++) {
                HealthLinesUpdate(bhp, bhm / 7 * (7 - i), 6 - i);
            }
        }
    }

    private void CreateSettingButton(){
        // Панель расположения настроек
        SettingsPanel = new JPanel();
        SettingsPanel.setBounds(5, 5, 64, 64);
        SettingsPanel.setLayout(null);
        SettingsPanel.setBackground(TRANSPARENT);
        frame.add(SettingsPanel);

        // Добавление Изображения Иконки настроек
        settinglabel = new JLabel();
        settinglabel.setIcon(pic.group1.getImage("MenuButton"));
        settinglabel.setBounds(0,0,settinglabel.getIcon().getIconWidth(),settinglabel.getIcon().getIconHeight());
        SettingsPanel.add(settinglabel);

        // Добавление кликабельности изображения иконки настроек
        settinglabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                SettingsOpen();
            }
        });
    }
    private void SettingsOpen(){
        // Открытие-Закрытие настроек
        if(! setting_open) {
            settinglabel.setIcon(pic.group1.getImage("MenuButtonTouched"));
            Settings.setVisible(true);
            frame.updateUI();
            setting_open = true;
        }
        else if(setting_open){
            settinglabel.setIcon(pic.group1.getImage("MenuButton"));
            Settings.setVisible(false);
            frame.updateUI();
            setting_open = false;
            setFocusable(true); // ??????????????????????????????????????????????????????????????????????
        }
    }

    private void CreateFastLine(){
        // Подключение класса для Быстрой Линии
        FastLine_ = new FastLine();

        // Панель Быстрой полосы
        InventoryDesignPanel = new JPanel();
        InventoryDesignPanel.setBackground(new Color(0,0,0,0));
        InventoryDesignPanel.setLayout(null);
        InventoryDesignPanel.setBounds(1180- 64 * 5, 536,64 * 5,128);
        frame.add(InventoryDesignPanel);

        CursOn = new Cursor();
        cursor = new JLabel(CursOn.getTexture());
        cursor.setBounds(CursOn.getFocus() * 64, 0, 64,64);
        InventoryDesignPanel.add(cursor);

        // Наполнение слотов пустыми предметами
        ItemSlots = new JLabel[5];
        for(int i = 0; i < 5; i++){
            ItemSlots[i] = new JLabel();
        }
        for(int i = 0;i < 5; i++){
            ItemSlots[i].setIcon(pic.group2.getImage(0));
            ItemSlots[i].setBounds((i * 48) + 8 + (16*i),73,48,48);
            ItemSlots[i].setForeground(TRANSPARENT);
            InventoryDesignPanel.add(ItemSlots[i]);
        }

        // Заполнение Визуальных слотов инвентаря с 0 по 4
        InventorySlots = new JLabel[5];
        for(int i = 0; i < 5; i++){
            InventorySlots[i] = new JLabel();
        }
        InventorySlots[0].setIcon(pic.group1.getImage("Inventory_Slots_Opener"));
        for(int i = 1;i < 5; i++){
            InventorySlots[i].setIcon(pic.group1.getImage("Inventory_Slots_State"));
        }
        for(int i = 0;i < 5; i++){
            InventorySlots[i].setBounds(i*64,64,64,64);
            InventorySlots[i].setForeground(Color.WHITE);
            InventoryDesignPanel.add(InventorySlots[i]);
        }
    }

    private void CreateInventory() {
        invopen = false;
        InventoryPanel = new JPanel();
        InventoryPanel.setBackground(TRANSPARENT);
        InventoryPanel.setLayout(null);
        InventoryPanel.setBounds(327, 197, 506, 356);
        InventoryPanel.setVisible(false);
        frame.add(InventoryPanel);
        JLabel InventoryPanelIcon = new JLabel();
        InventoryPanelIcon.setIcon(pic.group1.getImage("Inventory"));
        InventoryPanelIcon.setBounds(0,0,506,356);



        MainSlot1 = new InventorySlotClass(0, 23, 23, IL.getItemInfo("#0000").getItemIcon(), InventoryPanel);
        addDragItem(MainSlot1._Image, MainSlot1);
        MainSlot1._Button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right Click");
                    ArmorUpdate(MainSlot1);
                }else if(e.getButton() == MouseEvent.BUTTON1){
                    System.out.println("Left Click");
                    SlotsInformation(MainSlot1);
                }else{
                    System.out.println("UnCorrect Click");
                }
            }
        });

        MainSlot2 = new InventorySlotClass(1, 95, 23, IL.getItemInfo("#0000").getItemIcon(), InventoryPanel);
        addDragItem(MainSlot2._Image, MainSlot2);
        MainSlot2.update("#0000", IL.getItemInfo("#0000").getItemIcon());
        MainSlot2._Button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right Click");
                    ArmorUpdate(MainSlot2);
                }else if(e.getButton() == MouseEvent.BUTTON1){
                    System.out.println("Left Click");
                    SlotsInformation(MainSlot2);
                }else{
                    System.out.println("UnCorrect Click");
                }
            }
        });

        MainSlot3 = new InventorySlotClass(2, 23, 95, IL.getItemInfo("#0000").getItemIcon(), InventoryPanel);
        addDragItem(MainSlot3._Image, MainSlot3);
        MainSlot3._Button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right Click");
                    ArmorUpdate(MainSlot3);
                }else if(e.getButton() == MouseEvent.BUTTON1){
                    System.out.println("Left Click");
                    SlotsInformation(MainSlot3);
                }else{
                    System.out.println("UnCorrect Click");
                }
            }
        });
        MainSlot4 = new InventorySlotClass(3, 95, 95, IL.getItemInfo("#0000").getItemIcon(), InventoryPanel);
        addDragItem(MainSlot4._Image, MainSlot4);
        MainSlot4._Button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                System.out.println("Right Click");
                ArmorUpdate(MainSlot4);
            }else if(e.getButton() == MouseEvent.BUTTON1){
                System.out.println("Left Click");
                SlotsInformation(MainSlot4);
            }else{
                System.out.println("UnCorrect Click");
            }
            }
        });

        // Создание Дополнительных слоёв
        ExtraSlot8 = new InventorySlotClass[8];
        int xcoordinates[] = {347, 419};
        int ycoordinates[] = {23, 95, 169, 243};
        for(int i = 0; i < ExtraSlot8.length; i++){
            ExtraSlot8[i] = new InventorySlotClass(i+4, xcoordinates[i%2],ycoordinates[i/2] , IL.getItemInfo("#0000").getItemIcon(), InventoryPanel);
            addDragItem(ExtraSlot8[i]._Image, ExtraSlot8[i]);
            int finalI = i;
            ExtraSlot8[i]._Button.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        System.out.println("Right Click");
                        ArmorUpdate(ExtraSlot8[finalI]);
                    }else if(e.getButton() == MouseEvent.BUTTON1){
                        System.out.println("Left Click");
                        SlotsInformation(ExtraSlot8[finalI]);
                    }else{
                        System.out.println("UnCorrect Click");
                    }
                }
            });
        }
        CreateCharacterPanel();
        CreateInventoryInformationLabels();

        FirstInventoryButton = new JLabel();
        FirstInventoryButton.setIcon(pic.group1.getImage("InventoryLongButton"));
        FirstInventoryButton.setBounds(23,239,148,38);
        FirstInventoryButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                System.out.println("FirstInventoryButton Clicked");
            }
        });
        InventoryPanel.add(FirstInventoryButton);

        SecondInventoryButton = new JLabel();
        SecondInventoryButton.setIcon(pic.group1.getImage("InventoryLongButton"));
        SecondInventoryButton.setBounds(23,285,148,38);
        SecondInventoryButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                System.out.println("SecondInventoryButton Clicked");
            }
        });
        InventoryPanel.add(SecondInventoryButton);
        InventoryPanel.add(InventoryPanelIcon);
    }

    private void addDragItem(JLabel label, InventorySlotClass ISC){
        MouseAdapter dragItem = new MouseAdapter() {
            private JLabel selectedLabel = null;
            private Point selectedLabelLocation = null;
            private Point panelClickPoint = null;

            @Override
            public void mousePressed(final MouseEvent e) {
                final Component pressedComp = label.findComponentAt(e.getX(), e.getY());
                if (ISC.getItemID() != "#0000" && pressedComp != null && pressedComp instanceof JLabel) {
                    selectedLabel = (JLabel) pressedComp;
                    selectedLabelLocation = selectedLabel.getLocation();
                    panelClickPoint = e.getPoint();
                    //label.setComponentZOrder(selectedLabel, 0);
                    selectedLabel.repaint();
                }
                else {
                    selectedLabel = null;
                    selectedLabelLocation = null;
                    panelClickPoint = null;
                }
            }

            @Override
            public void mouseDragged(final MouseEvent e) {
                if (selectedLabel != null && selectedLabelLocation != null && panelClickPoint != null) {
                    final Point newPanelClickPoint = e.getPoint();
                    selectedLabel.setLocation(selectedLabelLocation.x + (newPanelClickPoint.x - panelClickPoint.x), selectedLabelLocation.y + (newPanelClickPoint.y - panelClickPoint.y));
                }
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                if(ISC.getItemID() != "#0000") {
                    selectedLabel.setLocation(ISC.x + 8, ISC.y + 8);
                }
            }
        };
        label.addMouseListener(dragItem);
        label.addMouseMotionListener(dragItem);
        // Создать список с хитбоксами всех ячееек ДЛЯ ИНВЕНТОРЯ
        // устроить проверку на то что слот свободный
        // Если свободный -> заполнить свободный и стереть прошлый
        // Если занят -> записать прошлый заполнить прошлый и заполнить новый старым
    }

    private void CreateInventoryInformationLabels() {
        // Создание поля для отображения уровня опыта игрока
        playerLevelIcon = new JLabel();
        playerLevelIcon.setIcon(pic.group1.getImage("KG_ExpirienceLVL"));
        playerLevelIcon.setBounds(22,182,18,18);
        InventoryPanel.add(playerLevelIcon);
        playerLevelLabel = new JLabel("Player Level: 1");
        playerLevelLabel.setBounds(47,182,100,15);
        InventoryPanel.add(playerLevelLabel);

        // Создание поля для отображения количества монет игрока
        playerCoinCounterIcon = new JLabel();
        playerCoinCounterIcon.setIcon(pic.group1.getImage("KG_Coins"));
        playerCoinCounterIcon.setBounds(22,205,18,18);
        InventoryPanel.add(playerCoinCounterIcon);
        playerCoinCounterLabel = new JLabel("Coins: 0");
        playerCoinCounterLabel.setBounds(47,205,120,16);
        InventoryPanel.add(playerCoinCounterLabel);

        // Создание поля для отображения Имени игрока
        playerNickNameLabel = new JLabel(P1.getName());
        playerNickNameLabel.setBounds(201,241,118,15);
        InventoryPanel.add(playerNickNameLabel);
        playerNickNameBackground = new JLabel();
        playerNickNameBackground.setIcon(pic.group1.getImage("playerBackground"));
        playerNickNameBackground.setBounds(197,239,122,20);
        InventoryPanel.add(playerNickNameBackground);

        // Создание поля для отображения максимального количества здоровья игрока
        playerMaxHealthIcon = new JLabel();
        playerMaxHealthIcon.setIcon(pic.group1.getImage("KG_MaxHealth"));
        playerMaxHealthIcon.setBounds(182,262,18,18);
        InventoryPanel.add(playerMaxHealthIcon);
        playerMaxHealthLabel = new JLabel("Max Health: " + String.valueOf(P1.getMaxHP()));
        playerMaxHealthLabel.setBounds(206,263,120,16);
        InventoryPanel.add(playerMaxHealthLabel);

        // Создание поля для отображения количества защиты игрока
        playerDefencePointsIcon = new JLabel();
        playerDefencePointsIcon.setIcon(pic.group1.getImage("KG_Defence"));
        playerDefencePointsIcon.setBounds(182,284,18,18);
        InventoryPanel.add(playerDefencePointsIcon);
        playerDefencePointsLabel = new JLabel("Defence: " + String.valueOf(P1.getDP()));
        playerDefencePointsLabel.setBounds(206,285,120,16);
        InventoryPanel.add(playerDefencePointsLabel);

        // Создание поля для отображения количества урона игрока
        playerDamageIcon = new JLabel();
        playerDamageIcon.setIcon(pic.group1.getImage("KG_Damage"));
        playerDamageIcon.setBounds(182,305,18,18);
        InventoryPanel.add(playerDamageIcon);
        playerDamageLabel = new JLabel("Damage: " + P1.getDamage());
        playerDamageLabel.setBounds(206,306,120,16);
        InventoryPanel.add(playerDamageLabel);

        // Создание поля для отображения фракции игрока(Бета 1.3)
        playerFractionIcon = new JLabel();
        playerFractionIcon.setIcon(pic.group1.getImage("KG_NoneField"));
        playerFractionIcon.setBounds(182,326,18,18);
        InventoryPanel.add(playerFractionIcon);
        playerFractionLabel = new JLabel("None Text Field");
        playerFractionLabel.setBounds(206,327,120,16);
        InventoryPanel.add(playerFractionLabel);

        // Создание поля отображающее ID игрока
        playerIDLabel = new JLabel("Player ID Number: " + String.valueOf(P1.getPlayerID()));
        playerIDLabel.setBounds(10,329,166,16);
        playerIDLabel.setForeground(new Color(173,173,173));
        InventoryPanel.add(playerIDLabel);
    }

    private void ArmorUpdate(InventorySlotClass Sl){
        if(IL.KGArmors.containsKey(Sl.getItemID())) {
            Armor arm = IL.KGArmors.get(Sl.getItemID());
            switch (arm.getArmorType()) {
                case "Helmet":
                    if (ArmorSlot1.getItemID().equals("#0000")) {
                        ArmorSlot1.update(arm.getArmorID(), arm.getArmorIcon());
                        Sl.update(IL.KGItems.get("#0000").getItemID(), IL.KGItems.get("#0000").getItemIcon());
                        FastLine_.setNewItemID(Sl.getSlotID(), "#0000");
                        ItemSlots[Sl.getSlotID()].setIcon(IL.KGItems.get("#0000").getItemIcon());

                        P1.setMaxHP(P1.getMaxHP() + arm.getExtraHealthPoints());
                        P1.setDP(P1.getDP() + arm.getDefendPoints());
                    }else{
                        Armor OldArmor = IL.KGArmors.get(ArmorSlot1.getItemID());
                        ArmorSlot1.update(arm.getArmorID(), arm.getArmorIcon());

                        Sl.update(OldArmor.getArmorID(), OldArmor.getArmorIcon());
                        FastLine_.setNewItemID(Sl.getSlotID(), OldArmor.getArmorID());
                        ItemSlots[Sl.getSlotID()].setIcon(OldArmor.getArmorIcon());
                        P1.setMaxHP(P1.getMaxHP() + (OldArmor.getExtraHealthPoints() - arm.getExtraHealthPoints()));
                        P1.setDP(P1.getDP() + (OldArmor.getDefendPoints()- arm.getDefendPoints()));
                    }
                    break;
                case "Chestplate":
                    if (ArmorSlot2.getItemID().equals("#0000")) {
                        ArmorSlot2.update(arm.getArmorID(), arm.getArmorIcon());
                        Sl.update(IL.KGItems.get("#0000").getItemID(), IL.KGItems.get("#0000").getItemIcon());
                        FastLine_.setNewItemID(Sl.getSlotID(), "#0000");
                        ItemSlots[Sl.getSlotID()].setIcon(IL.KGItems.get("#0000").getItemIcon());

                        P1.setMaxHP(P1.getMaxHP() + arm.getExtraHealthPoints());
                        P1.setDP(P1.getDP() + arm.getDefendPoints());
                    }else{
                        Armor OldArmor = IL.KGArmors.get(ArmorSlot1.getItemID());
                        ArmorSlot2.update(arm.getArmorID(), arm.getArmorIcon());

                        Sl.update(OldArmor.getArmorID(), OldArmor.getArmorIcon());
                        FastLine_.setNewItemID(Sl.getSlotID(), OldArmor.getArmorID());
                        ItemSlots[Sl.getSlotID()].setIcon(OldArmor.getArmorIcon());
                        P1.setMaxHP(P1.getMaxHP() + (OldArmor.getExtraHealthPoints() - arm.getExtraHealthPoints()));
                        P1.setDP(P1.getDP() + (OldArmor.getDefendPoints()- arm.getDefendPoints()));
                    }
                    break;
                case "Legs":
                    if (ArmorSlot3.getItemID().equals("#0000")) {
                        ArmorSlot3.update(arm.getArmorID(), arm.getArmorIcon());
                        Sl.update(IL.KGItems.get("#0000").getItemID(), IL.KGItems.get("#0000").getItemIcon());
                        FastLine_.setNewItemID(Sl.getSlotID(), "#0000");
                        ItemSlots[Sl.getSlotID()].setIcon(IL.KGItems.get("#0000").getItemIcon());

                        P1.setMaxHP(P1.getMaxHP() + arm.getExtraHealthPoints());
                        P1.setDP(P1.getDP() + arm.getDefendPoints());
                    }else{
                        Armor OldArmor = IL.KGArmors.get(ArmorSlot1.getItemID());
                        ArmorSlot3.update(arm.getArmorID(), arm.getArmorIcon());

                        Sl.update(OldArmor.getArmorID(), OldArmor.getArmorIcon());
                        FastLine_.setNewItemID(Sl.getSlotID(), OldArmor.getArmorID());
                        ItemSlots[Sl.getSlotID()].setIcon(OldArmor.getArmorIcon());
                        P1.setMaxHP(P1.getMaxHP() + (OldArmor.getExtraHealthPoints() - arm.getExtraHealthPoints()));
                        P1.setDP(P1.getDP() + (OldArmor.getDefendPoints()- arm.getDefendPoints()));
                    }
                    break;
                default:
                    System.out.println("None this type of armor");
                    break;
            }
            HealthUpdate();
            playerDefencePointsLabel.setText("Defence: " + String.valueOf(P1.getDP()));
            playerMaxHealthLabel.setText("Max Health: " + String.valueOf(P1.getMaxHP()));
        }
    }

    private void CreateCharacterPanel(){
        JPanel InventoryCharacterPanel = new JPanel();
        InventoryCharacterPanel.setBackground(TRANSPARENT);
        InventoryCharacterPanel.setLayout(null);
        InventoryCharacterPanel.setBounds(189,23,140,208);
        InventoryPanel.add(InventoryCharacterPanel);

        ifArmoreOpen = false;
        ArmorSlot1 = new ArmoreSlotClass(0, 44, 17, IL.getItemInfo("#0000").getItemIcon(), InventoryCharacterPanel);
            ArmorSlot1._Image.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON3){
                        if(!ArmorSlot1.getItemID().equals("#0000")){
                            voidSlotCheck();
                            if(voidSlot){
                                setOffArmor(0);
                            }
                        }
                    }
                }
            });
        ArmorSlot2 = new ArmoreSlotClass(1, 44, 75, IL.getItemInfo("#0000").getItemIcon(), InventoryCharacterPanel);
            ArmorSlot2._Image.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON3){
                        if(!ArmorSlot2.getItemID().equals("#0000")){
                            voidSlotCheck();
                            if(voidSlot){
                                setOffArmor(1);
                            }
                        }
                    }
                }
            });
        ArmorSlot3 = new ArmoreSlotClass(2, 44, 133, IL.getItemInfo("#0000").getItemIcon(), InventoryCharacterPanel);
            ArmorSlot3._Image.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON3){
                        if(!ArmorSlot3.getItemID().equals("#0000")){
                            voidSlotCheck();
                            if(voidSlot){
                                setOffArmor(2);
                            }
                        }
                    }
                }
            });

        JLabel ExtraOpenButton = new JLabel();
        ExtraOpenButton.setIcon(pic.group1.getImage("ExtrasButton"));
        ExtraOpenButton.setBounds(122, 190, 10, 10);
        ExtraOpenButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if(!ifArmoreOpen) {
                    ArmorSlot1.setVisible(true);
                    ArmorSlot2.setVisible(true);
                    ArmorSlot3.setVisible(true);
                            ifArmoreOpen = true;
                }else{
                    ArmorSlot1.setVisible(false);
                    ArmorSlot2.setVisible(false);
                    ArmorSlot3.setVisible(false);
                    ifArmoreOpen = false;
                }
            }
        });
        InventoryCharacterPanel.add(ExtraOpenButton);

        JLabel invPic = new JLabel();
        invPic.setIcon(pic.group1.getImage("CharacterPanel"));
        invPic.setBounds(0,0,140,208);
        InventoryCharacterPanel.add(invPic);
    }

    private int voidSlotCheck(){
        if(MainSlot1.getItemID().equals("#0000")){
            voidSlot = true;
            return 0;
        }
        if(MainSlot2.getItemID().equals("#0000")){
            voidSlot = true;
            return 1;
        }
        if(MainSlot3.getItemID().equals("#0000")){
            voidSlot = true;
            return 2;
        }
        if(MainSlot4.getItemID().equals("#0000")){
            voidSlot = true;
            return 3;
        }
        else{
            for(int i = 0; i < 8;i++){
                if(ExtraSlot8[i].getItemID().equals("#0000")) {
                    voidSlot = true;
                    return i+4;
                }
            }
        }
        voidSlot = false;
        return -1;
    }

    private void setOffArmor(int i){
        P1.setMaxHP(P1.getMaxHP() - IL.KGArmors.get(i==0 ? ArmorSlot1.getItemID() : i==1 ? ArmorSlot2.getItemID() : ArmorSlot3.getItemID()).getExtraHealthPoints());
        HealthUpdate();
        P1.setDP(P1.getDP() - IL.KGArmors.get(i==0 ? ArmorSlot1.getItemID() : i==1 ? ArmorSlot2.getItemID() : ArmorSlot3.getItemID()).getDefendPoints());
        playerDefencePointsLabel.setText("Defence: " + String.valueOf(P1.getDP()));
        playerMaxHealthLabel.setText("Max Health: " + String.valueOf(P1.getMaxHP()));
        switch(voidSlotCheck()){
            case 0:
                oldArm = i==0 ? ArmorSlot1.getItemID() : i==1 ? ArmorSlot2.getItemID() : ArmorSlot3.getItemID();
                MainSlot1.update(oldArm, IL.KGArmors.get(oldArm).getArmorIcon());
                ItemSlots[0].setIcon(IL.KGArmors.get(oldArm).getArmorIcon());
                FastLine_.setNewItemID(0, oldArm);
                break;
            case 1:
                oldArm = i==0 ? ArmorSlot1.getItemID() : i==1 ? ArmorSlot2.getItemID() : ArmorSlot3.getItemID();
                MainSlot2.update(oldArm, IL.KGArmors.get(oldArm).getArmorIcon());
                ItemSlots[1].setIcon(IL.KGArmors.get(oldArm).getArmorIcon());
                FastLine_.setNewItemID(1, oldArm);
                break;
            case 2:
                oldArm = i==0 ? ArmorSlot1.getItemID() : i==1 ? ArmorSlot2.getItemID() : ArmorSlot3.getItemID();
                MainSlot3.update(oldArm, IL.KGArmors.get(oldArm).getArmorIcon());
                ItemSlots[2].setIcon(IL.KGArmors.get(oldArm).getArmorIcon());
                FastLine_.setNewItemID(2, oldArm);
                break;
            case 3:
                oldArm = i==0 ? ArmorSlot1.getItemID() : i==1 ? ArmorSlot2.getItemID() : ArmorSlot3.getItemID();
                MainSlot4.update(oldArm, IL.KGArmors.get(oldArm).getArmorIcon());
                ItemSlots[3].setIcon(IL.KGArmors.get(oldArm).getArmorIcon());
                FastLine_.setNewItemID(3, oldArm);
                break;
            case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:
                oldArm = i==0 ? ArmorSlot1.getItemID() : i==1 ? ArmorSlot2.getItemID() : ArmorSlot3.getItemID();
                ExtraSlot8[voidSlotCheck()-4].update(oldArm, IL.KGArmors.get(oldArm).getArmorIcon());
                break;
        }
        switch(i){
            case 0:
                ArmorSlot1.update("#0000", IL.KGItems.get("#0000").getItemIcon());
                break;
            case 1:
                ArmorSlot2.update("#0000", IL.KGItems.get("#0000").getItemIcon());
                break;
            case 2:
                ArmorSlot3.update("#0000", IL.KGItems.get("#0000").getItemIcon());
                break;
            default:
                System.out.println("Не верный слот для брони");
                break;
        }
    }

    private void CreateExtraPanel(int exoid, int eyoid){
        ExtraPanel = new JPanel();
        ExtraPanel.setLayout(null);
        ExtraPanel.setBounds(exoid, eyoid,208,314);
        ExtraPanel.setBorder(BorderFactory.createLineBorder(TRANSPARENT));
        ExtraPanel.setBackground(TRANSPARENT);
        ExtraPanel.setVisible(false);
        frame.add(ExtraPanel);

        // Создание надписи олицетворяющей тип предмета
        ItemType = new JLabel("None");
        ItemType.setBounds(12, 9, 100,15);
        ItemType.setForeground(new Color(182,182,182));
        ExtraPanel.add(ItemType);

        // Создание надписи отображающей "Именование предмета"
        ItemName = new JLabel("Item Name");
        ItemName.setBounds(72, 33, 100,15);
        ExtraPanel.add(ItemName);

        // Создание надписи отображающей "Редкость:"
        ItemRarity1 = new JLabel("Rarity :");
        ItemRarity1.setBounds(12, 130, 100,15);
        ExtraPanel.add(ItemRarity1);

        // Создание надписи отображающей Редкость предмета
        ItemRarity2 = new JLabel("Casual");
        ItemRarity2.setBounds(61, 130, 100,15);
        ItemRarity2.setForeground(RarityMap.get("_casual_"));
        ExtraPanel.add(ItemRarity2);

        // Создание надписи отображающей предмет
        ItemIconInv = new JLabel();
        ItemIconInv.setBounds(79, 64, 48,48);
        ItemIconInv.setIcon(pic.group2.getImage("KG_VoidItem"));
        ExtraPanel.add(ItemIconInv);

        // Создание надписи отображающей слот
        ItemIconSlot = new JLabel();
        ItemIconSlot.setBounds(71, 56, 64,64);
        ItemIconSlot.setIcon(pic.group1.getImage("InventorySlot"));
        ExtraPanel.add(ItemIconSlot);

        // Создание надписи отображающей параметр 1 у предмета
        Parametr1 = new JLabel("Param 1 :");
        Parametr1.setBounds(12, 149, 100,15);
        ExtraPanel.add(Parametr1);

        // Создание Надписи отображающей параметр 2 у предмета
        Parametr2 = new JLabel("Param 2 :");
        Parametr2.setBounds(12, 168, 100,15);
        ExtraPanel.add(Parametr2);

        // Создание Надписи отображающей параметр 3 у предмета
        Parametr3 = new JLabel("Param 3 :");
        Parametr3.setBounds(12, 187, 100,15);
        ExtraPanel.add(Parametr3);

        // Создание Декоративной полоски
        DefinitionLine = new JLabel();
        DefinitionLine.setBounds(16,234,182,4);
        DefinitionLine.setIcon(pic.group1.getImage("ExtraPanelLine"));
        ExtraPanel.add(DefinitionLine);

        // Создание Надписи описывающей предмет
        Description = new JLabel("<html>Description of Item</html>");
        Description.setBounds(12, 234, 185,41);
        Description.setForeground(new Color(60,14,136));
        ExtraPanel.add(Description);

        // Создание Кликабельного изображения закрывающего дополнительную панель
        CloseButton= new JLabel();
        CloseButton.setBounds(175,13,20,20);
        CloseButton.setIcon(pic.group1.getImage("ExtraCloseButton"));
        // Добавление функционала изображению закрывающем Дополнительную панель
        CloseButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                ExtraPanel.setVisible(false);
            }
        });
        ExtraPanel.add(CloseButton);

        //
        ExtraPanelBackground = new JLabel();
        ExtraPanelBackground.setIcon(pic.group1.getImage("ExtraPanelDesign"));
        ExtraPanelBackground.setBounds(0,0,208,314);
        ExtraPanel.add(ExtraPanelBackground);
    };
    private void ExtraPanelUpdate(Item item) {
        if(ExtraPanel.isVisible() && !ItemName.getText().equals(item.getItemName()) || !ExtraPanel.isVisible() && !ItemName.getText().equals(item.getItemName()) ) {
            if (IL.KGItems.containsKey(item.getItemID())) {
                ExtraPanel.setVisible(true);
                ItemType.setText(item.getClassType());
                ItemName.setText(item.getItemName());
                ItemRarity2.setText(item.getItemRarity());
                ItemRarity2.setForeground(RarityMap.get("_" + item.getItemRarity() + "_"));
                ItemIconInv.setIcon(item.getItemIcon());
                Parametr1.setText("");
                Parametr2.setText("");
                Parametr3.setText("");
                Description.setText("Item Description will be able in Beta1.2");
            } else {
                System.out.println("Weapon Error");
            }
        }else if(ExtraPanel.isVisible() && ItemName.getText().equals(item.getItemName())){
            ExtraPanel.setVisible(false);
        }else{
            ExtraPanel.setVisible(true);
        }
        }
    private void ExtraPanelUpdate(Weapon item){
        if(ExtraPanel.isVisible() && !ItemName.getText().equals(item.getWeaponName()) || !ExtraPanel.isVisible() && !ItemName.getText().equals(item.getWeaponName())) {
            if(IL.KGWeapons.containsKey(item.getWeaponID())) {
                ExtraPanel.setVisible(true);
                ItemType.setText(item.getClassType());
                ItemName.setText(item.getWeaponName());
                ItemRarity2.setText(item.getWeaponRarity());
                ItemRarity2.setForeground(RarityMap.get("_" + item.getWeaponRarity() + "_"));
                ItemIconInv.setIcon(IL.KGWeapons.get(item.getWeaponID()).getWeaponIcon());
                Parametr1.setText(String.valueOf(item.getWeaponDamage()));
                Parametr2.setText(String.valueOf(item.getWeaponSpeed()));
                Parametr3.setText(String.valueOf(item.getWeaponRange()));
                Description.setText("Weapon Description will be able in Beta1.2");
            }else{
                System.out.println("Weapon Error");
            }
        }else if(ExtraPanel.isVisible() && ItemName.getText().equals(item.getWeaponName())){
            ExtraPanel.setVisible(false);
        }else{
            ExtraPanel.setVisible(true);
        }
    }
    // ? Armore
    // ? Tool

    private void SettingsCreate(int left, int down){
            // Создание Панели Настроек
            Settings = new JPanel();
            Settings.setBounds(left, down, 360, 500);
            Settings.setBorder(BorderFactory.createLineBorder(Color.black));
            Settings.setLayout(null);
            Settings.setBackground(Color.GRAY);
            Settings.setVisible(false);
            frame.add(Settings);

            // Создание Надписи Настройки
            Setting_main_label = new JLabel("Settings");
            Setting_main_label.setForeground(Color.BLACK);
            Setting_main_label.setBounds(110,10,300,50);
            Setting_main_label.setFont(new Font("Tahoma", Font.PLAIN, 40));
            Settings.add(Setting_main_label);

            // Создание надписи Коммандной строки
            Setting_commander_label = new JLabel("Commander :");
            Setting_commander_label.setForeground(Color.BLACK);
            Setting_commander_label.setBounds(20,412,300,50);
            Setting_commander_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
            Settings.add(Setting_commander_label);

            // Создание Настройки "Вкл / Выкл Звука"
            Setting_Volume_label = new JLabel("Volume : True");
            Setting_Volume_label.setForeground(Color.BLACK);
            Setting_Volume_label.setBounds(20,80,200,30);
            Setting_Volume_label.setFont(new Font("Tahoma", Font.PLAIN, 24));

            // Создание Кликабельности надписи для изменения состояния настройки
            Setting_Volume_label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                    songy.Pause("NONE");
                    if(Setting_Volume_label.getText().equals("Volume : True")) {
                        Setting_Volume_label.setText("Volume : False");
                    }else{
                        Setting_Volume_label.setText("Volume : True");
                    }
                }
            });
            Settings.add(Setting_Volume_label);

            // Создание Строки Управления Игрой
            Setting_Commander = new JTextField(15);
            Setting_Commander.setBounds(20,450,260,30);
            Setting_Commander.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        COMMANDER_Action(Setting_Commander.getText());
                        Setting_Commander.setText("");
                    }
                }

            });
            Settings.add(Setting_Commander);

            experimentalRules = false;
            JLabel expRule = new JLabel("Experiment Rules");
            expRule.setFont(new Font("Tahoma", Font.PLAIN, 24));
            expRule.setBounds(20,120,300,30);
            expRule.setForeground(Color.BLACK);
            expRule.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                    if(experimentalRules){
                        experimentalRules = false;
                        expRule.setForeground(Color.BLACK);
                    }else{
                        experimentalRules = true;
                        expRule.setForeground(Color.GREEN);
                    }
                }
            });
            Settings.add(expRule);

            JLabel SettingMainMenu = new JLabel("Exit in main Menu");
            SettingMainMenu.setForeground(Color.BLACK);
            SettingMainMenu.setBounds(20,160,200,30);
            SettingMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 24));
            SettingMainMenu.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                    // createMainMenu(frame);
                    MainMenuOpen();
                }
            });
            Settings.add(SettingMainMenu);

    }

    private void ActiveItemsChange(Item item){
            P1.setDamage(P1.ST_Damage);
            P1.setDamageSpeed(P1.ST_DamageSpeed);
            P1.setDamageRange(P1.ST_DamageRange);
            playerDamageLabel.setText("Damage: " + String.valueOf(P1.getDamage()));
    }
    private void ActiveItemsChange(Armor item){
        P1.setDamage(P1.ST_Damage);
        P1.setDamageSpeed(P1.ST_DamageSpeed);
        P1.setDamageRange(P1.ST_DamageRange);
        playerDamageLabel.setText("Damage: " + String.valueOf(P1.getDamage()));
    }
    private void ActiveItemsChange(Weapon item){
            P1.setDamage(item.getWeaponDamage());
            P1.setDamageSpeed(item.getWeaponSpeed());
            P1.setDamageRange(item.getWeaponRange());
            playerDamageLabel.setText("Damage: " + String.valueOf(P1.getDamage()));
    }
    private void ActiveItemsChange(Tool item){
        P1.setDamage(P1.ST_Damage);
        P1.setDamageSpeed(P1.ST_DamageSpeed);
        P1.setDamageRange(P1.ST_DamageRange);
        playerDamageLabel.setText("Damage: " + String.valueOf(P1.getDamage()));
    }
    private void ColorChange(Color color){
        Jframe.setBackground(color);
        Jframe.updateUI();
    }

    public void HealthLinesUpdate(double bhp, double bhm, int i){
        if(i == 6) {
            HBbool[6] = bhp == bhm;
        }else if(i < 6 && bhp > 0){
            HBbool[i] = bhp >= bhm;
        }else{
            HBbool[i] = false;
            P1.Born();
            HBHeart.setVisible(false);
            PlayerDeadAnimation();
        }
        HBPoints[i].setVisible(HBbool[i]);
    }
    private void COMMANDER_Action(String command){
        System.out.println(command);
        try {
            if (command.charAt(0) == '&') {
                command = command.substring(1);
                String[] comm = command.split(" ");
                switch (comm[0]) {
                    case "SetColor": {
                        if (comm.length != 2 || !P1.getPermission()) {
                            break;
                        }
                        switch (comm[1]) {
                            case "RED": {
                                ColorChange(Color.RED);
                            }
                            break;
                            case "ORANGE": {
                                ColorChange(Color.ORANGE);
                            }
                            break;
                            case "YELLOW": {
                                ColorChange(Color.YELLOW);
                            }
                            break;
                            case "GREEN": {
                                ColorChange(Color.GREEN);
                            }
                            break;

                            case "CYAN": {
                                ColorChange(Color.CYAN);
                            }
                            break;
                            case "BLUE": {
                                ColorChange(Color.BLUE);
                            }
                            break;
                            case "PINK": {
                                ColorChange(Color.PINK);
                            }
                            break;
                            case "MAGENTA": {
                                ColorChange(Color.MAGENTA);
                            }
                            break;

                            case "WHITE": {
                                ColorChange(Color.WHITE);
                            }
                            break;
                            case "BLACK": {
                                ColorChange(Color.BLACK);
                            }
                            break;
                            case "GRAY": {
                                ColorChange(Color.GRAY);
                            }
                            break;
                            case "DARK_GRAY": {
                                ColorChange(Color.DARK_GRAY);
                            }
                            break;

                            default: {
                                ColorChange(Color.orange);
                            }
                        }
                    }break;
                    case "Volume": {
                        if (comm.length != 2 || !P1.getPermission()) {
                            break;
                        }
                        switch (comm[1]) {
                            case "TRUE": {
                                Setting_Volume_label.setText("Volume : True");
                                songy.Pause("TRUE");
                            }
                            break;
                            case "FALSE": {
                                Setting_Volume_label.setText("Volume : False");
                                songy.Pause("FALSE");
                            }
                            break;
                            default: {
                            }
                            break;
                        }
                    }break;
                    case "Player": {
                        if (comm.length < 2 || !P1.getPermission()) {
                            break;
                        }
                        switch (comm[1]) {
                            case "Name": {
                                if (comm.length > 3) {
                                    break;
                                }
                                P1.setName(comm[2]);
                                player_name.setText(P1.getName());
                                playerNickNameLabel.setText(P1.getName());
                            }
                            break;
                            case "MaxHealth": {
                                if (comm.length > 3) {
                                    break;
                                }
                                try {
                                    P1.setMaxHP(Integer.parseInt(comm[2]));
                                    HealthUpdate();
                                } catch (Exception e) {
                                    System.out.println("ExceptionError");
                                }
                            }
                            break;
                            case "FullHeal": {
                                if (comm.length != 2) {
                                    break;
                                }
                                P1.setHP(P1.getMaxHP());
                                HealthUpdate();
                            }
                            break;
                            case "Heal": {
                                if (comm.length != 3) {
                                    break;
                                }
                                try {
                                    int healcount = Integer.parseInt(comm[2]);
                                    if (P1.getHP() + healcount < P1.getMaxHP()) {
                                        P1.setHP(P1.getHP() + healcount);
                                    } else {
                                        P1.setHP(P1.getMaxHP());
                                    }
                                    HealthUpdate();
                                } catch (Exception e) {
                                    System.out.println("ExceptionError");
                                }
                            }
                            break;
                            case "DEAD": {
                                if (comm.length != 2) {
                                    break;
                                }
                                P1.Die();
                                P1.setHP(0);
                                HealthUpdate();
                                PlayerDeadAnimation();
                            }
                            break;
                            default: {
                            }
                            break;
                        }
                    }break;
                    case "SetPermission": {
                        if (comm.length != 2) {
                            break;
                        }
                        switch (comm[1]) {
                            case "ADMIN": {
                                P1.setAdmin();
                                player_name.setForeground(Color.RED);
                            }
                            break;
                            case "USER": {
                                P1.setUser();
                                player_name.setForeground(Color.WHITE);
                            }
                            break;
                        }
                    }break;
                    case "SetSlot": {
                        if (comm.length != 3 || !P1.getPermission()) {
                            break;
                        }
                        try {
                            switch(comm[1]){
                                case "0":
                                    if(IL.KGWeapons.containsKey(comm[2])) {
                                        MainSlot1.update(comm[2], IL.getWeaponInfo(comm[2]).getWeaponIcon());
                                    }else if(IL.KGItems.containsKey(comm[2])){
                                        MainSlot1.update(comm[2], IL.getItemInfo(comm[2]).getItemIcon());
                                    }else if(IL.KGArmors.containsKey(comm[2])){
                                        MainSlot1.update(comm[2], IL.getArmorInfo(comm[2]).getArmorIcon());
                                    }else if(IL.KGTools.containsKey(comm[2])){
                                        MainSlot1.update(comm[2], IL.getToolInfo(comm[2]).getToolIcon());
                                    }
                                    break;
                                case "1":
                                    if(IL.KGWeapons.containsKey(comm[2])) {
                                        MainSlot2.update(comm[2], IL.getWeaponInfo(comm[2]).getWeaponIcon());
                                    }else if(IL.KGItems.containsKey(comm[2])){
                                        MainSlot2.update(comm[2], IL.getItemInfo(comm[2]).getItemIcon());
                                    }else if(IL.KGArmors.containsKey(comm[2])){
                                        MainSlot2.update(comm[2], IL.getArmorInfo(comm[2]).getArmorIcon());
                                    }else if(IL.KGTools.containsKey(comm[2])){
                                        MainSlot2.update(comm[2], IL.getToolInfo(comm[2]).getToolIcon());
                                    }
                                    break;
                                case "2":
                                    if(IL.KGWeapons.containsKey(comm[2])) {
                                        MainSlot3.update(comm[2], IL.getWeaponInfo(comm[2]).getWeaponIcon());
                                    }else if(IL.KGItems.containsKey(comm[2])){
                                        MainSlot3.update(comm[2], IL.getItemInfo(comm[2]).getItemIcon());
                                    }else if(IL.KGArmors.containsKey(comm[2])){
                                        MainSlot3.update(comm[2], IL.getArmorInfo(comm[2]).getArmorIcon());
                                    }else if(IL.KGTools.containsKey(comm[2])){
                                        MainSlot3.update(comm[2], IL.getToolInfo(comm[2]).getToolIcon());
                                    }
                                    break;
                                case "3":
                                    if(IL.KGWeapons.containsKey(comm[2])) {
                                        MainSlot4.update(comm[2], IL.getWeaponInfo(comm[2]).getWeaponIcon());
                                    }else if(IL.KGItems.containsKey(comm[2])){
                                        MainSlot4.update(comm[2], IL.getItemInfo(comm[2]).getItemIcon());
                                    }else if(IL.KGArmors.containsKey(comm[2])){
                                        MainSlot4.update(comm[2], IL.getArmorInfo(comm[2]).getArmorIcon());
                                    }else if(IL.KGTools.containsKey(comm[2])){
                                        MainSlot4.update(comm[2], IL.getToolInfo(comm[2]).getToolIcon());
                                    }
                                    break;
                                default:
                                    System.out.println("Not true command(1)");
                                    break;
                            }
                            ItemSlots[Integer.parseInt(comm[1])].setIcon(pic.getImageOnID(comm[2]));
                            FastLine_.setNewItemID(Integer.parseInt(comm[1]), comm[2]);
                            if(CursOn.getFocus() == Integer.parseInt(comm[1])){
                                CursorMove(Integer.parseInt(comm[1]));
                            }else{
                                System.out.println("123");
                            }
                        }
                        catch(Exception e){
                            System.out.println("ExceptionError");
                        }
                    }break;
                    case "Summon": {
                        if (comm.length != 4 || !P1.getPermission()) {
                            break;
                        }
                        try {
                            switch (comm[1]) {
                                case "GORUML": {
                                    summonGoruml(Integer.parseInt(comm[2]), Integer.parseInt(comm[3]));
                                }break;
                                case "ENT": {
                                    summonEnt(Integer.parseInt(comm[2]), Integer.parseInt(comm[3]));
                                }break;
                                case "KNIGHT": {
                                    summonKnight(Integer.parseInt(comm[2]), Integer.parseInt(comm[3]));
                                }
                            }
                        }catch (Exception e){
                            System.out.println("Command isn't true!");
                        }
                    }break;
                    case "CreateObject":{
                        if (comm.length != 4 || !P1.getPermission()) {
                            break;
                        }
                        try {
                            createObject(comm[1].toLowerCase(), Integer.parseInt(comm[2]), Integer.parseInt(comm[3]));
                        }catch (Exception e){
                            System.out.println("Object creating Error!");
                        }
                    }break;
                    default: {
                        System.out.println("Uncorrect Command!");
                    }
                    break;
                }
            }
        }catch(Exception e)
        {
            System.out.println("ExceptionError");
        }
    }
    private void CursorMove(int i){
        if(!setting_open && CursorMoving) {
            CursOn.setFocus(i);
            cursor.setBounds(CursOn.getFocus() * 64, 0, 64, 64);
            if(IL.KGItems.containsKey(FastLine_.getItemID(i))){
                System.out.println("Item");
                ActiveItemsChange(IL.KGItems.get(FastLine_.getItemID(i)));
            }else if(IL.KGWeapons.containsKey(FastLine_.getItemID(i))){
                System.out.println("Weap");
                ActiveItemsChange(IL.KGWeapons.get(FastLine_.getItemID(i)));
            }else if(IL.KGArmors.containsKey(FastLine_.getItemID(i))){
                System.out.println("Armor");
                ActiveItemsChange(IL.KGArmors.get(FastLine_.getItemID(i)));
            }else if(IL.KGTools.containsKey(FastLine_.getItemID(i))){
                System.out.println("Tool");
                ActiveItemsChange(IL.KGTools.get(FastLine_.getItemID(i)));
            }else{
                System.out.println("321");
            }
            playerDamageLabel.setText("Damage: " + P1.getDamage());
            Jframe.updateUI();
        }
    }
    public void invOpen() {
        //if(CursOn.getFocus() == 4 && FastLine_.getSlot(4).getItemID() == "#0003") {
        if (invopen) {
            InventoryPanel.setVisible(false);
            ExtraPanel.setVisible(false);
            invopen = false;
            CursorMoving = true;
        } else {
            InventoryPanel.setVisible(true);
            invopen = true;
            CursorMoving = false;
        }
        frame.updateUI();
        // }
    }
    public void SlotsInformation(InventorySlotClass slot) {
        if (IL.getClassType(slot.getItemID()).equals("ITEM")) {
            ExtraPanelUpdate(IL.getItemInfo(slot.getItemID()));
        } else if (IL.getClassType(slot.getItemID()).equals("WEAPON")) {
            ExtraPanelUpdate(IL.getWeaponInfo(slot.getItemID()));
        }
    }


    private void summonGoruml(int x, int y){
        HitBoxes gorumlHitBox = new HitBoxes(x, y,64,"pain");
        List EntTex = new List();
        EntTex.add("Mobs/GORUML/up");
        EntTex.add("Mobs/GORUML/right");
        EntTex.add("Mobs/GORUML/down");
        EntTex.add("Mobs/GORUML/left");
        EntTex.add("Mobs/GORUML/dead");
        Entity goruml = new Entity("GORUML", x, y, "AGRO", 5, 0, 1, 3, EntTex, P1, gorumlHitBox, frame);
        goruml.lootableCreate(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(goruml.dropHere) {
                    createObject("coin", goruml.getX() + 16, goruml.getY() + 16);
                    goruml.dropHere = false;
                }
            }
        });
    }
    private void summonEnt(int x, int y){
        HitBoxes EntHitBox = new HitBoxes(x, y,64,"pain");
        List EntTex = new List();
        EntTex.add("Mobs/ENT/down");
        EntTex.add("Mobs/ENT/up");
        EntTex.add("Mobs/ENT/left");
        EntTex.add("Mobs/ENT/right");
        EntTex.add("Mobs/ENT/dead");
        Entity ent = new Entity("ENT", x, y, "AGRO", 10, 0, 2, 2, EntTex, P1, EntHitBox, frame);
        ent.lootableCreate(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ent.dropHere) {
                    createObject("coin", ent.getX() + 16, ent.getY() + 16);
                    ent.dropHere = false;
                }
            }
        });
    }
    private void summonKnight(int x, int y){
        HitBoxes KnightHitBox = new HitBoxes(x, y,64,"pain");
        List EntTex = new List();
        EntTex.add("Mobs/KNIGHT/up");
        EntTex.add("Mobs/KNIGHT/right");
        EntTex.add("Mobs/KNIGHT/down");
        EntTex.add("Mobs/KNIGHT/left");
        EntTex.add("Mobs/KNIGHT/dead");
        Entity knight = new Entity("KNIGHT", x, y, "AGRO", 15, 0, 3, 3, EntTex, P1, KnightHitBox, frame);
        knight.lootableCreate(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(knight.dropHere) {
                    createObject("coin", knight.getX() + 8, knight.getY() + 16);
                    createObject("expirience", knight.getX() + 32, knight.getY() + 16);
                    knight.dropHere = false;
                }
            }
        });
    }
    public void createObject(String name, int X, int Y){
        switch(name){
            case "coin":{
                Object object = new Object("Coin", X, Y, true, "KG_Coins", frame);
                object.createTimer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            // pickUp object
                            if (object.getHitBox().inHitBox(new HitBoxes(P1.getX(), P1.getY(), 64, "safe"))) {
                                P1.setCoins(P1.getCoins() + 1);
                                playerCoinCounterLabel.setText("Coins : " + P1.getCoins());
                                object.pickUp(frame);
                            }
                        } catch (Exception ex) {
                            object.Delete(frame);
                        }
                    }
                });
                object.repeatTimer(true);
                object.startTimer();
            }break;
            case "expirience":{
                Object object = new Object("Expirience", X, Y, true, "KG_Expirience", frame);
                object.createTimer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                        // pickUp object
                        if(object.getHitBox().inHitBox(new HitBoxes(P1.getX(), P1.getY(), 64, "safe"))){
                            expirienceUpdate(P1, 1);
                            object.pickUp(frame);
                        }
                        } catch (Exception ex) {
                            object.Delete(frame);
                        }
                    }
                });
                object.repeatTimer(true);
                object.startTimer();
            }break;
            case "wall":{
                Object object = new Object("Wall", X, Y, false, "wall", frame);
                wallsList[wallsCount] = new List();
                wallsList[wallsCount].add(String.valueOf(X));
                wallsList[wallsCount].add(String.valueOf(Y));
                wallsCount++;
                object.createTimer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                        // pickUp object
                        if(object.getHitBox().inHitBox(new HitBoxes(P1.getX(), P1.getY(), 64, "safe"))){

                        }
                        } catch (Exception ex) {
                            object.Delete(frame);
                        }
                    }
                });
                object.repeatTimer(true);
                object.startTimer();
            }break;
            case "iron_helmet":{
                Object object = new Object("iron_helmet", X, Y, true, "Armor/Iron/head", frame);
                object.createTimer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(object.getHitBox().inHitBox(new HitBoxes(P1.getX(), P1.getY(), 64, "safe"))){
                                if(voidSlotCheck() != -1){
                                    if(voidSlotCheck() > 3){
                                        ExtraSlot8[voidSlotCheck() - 4].update("#0007", pic.group2.getImage("Armor/Iron/head"));
                                    }else {
                                        switch (voidSlotCheck()) {
                                            case 0:
                                                MainSlot1.update("#0007", pic.group2.getImage("Armor/Iron/head"));
                                                break;
                                            case 1:
                                                MainSlot2.update("#0007", pic.group2.getImage("Armor/Iron/head"));
                                                break;
                                            case 2:
                                                MainSlot3.update("#0007", pic.group2.getImage("Armor/Iron/head"));
                                                break;
                                            case 3:
                                                MainSlot4.update("#0007", pic.group2.getImage("Armor/Iron/head"));
                                                break;
                                        }
                                        ItemSlots[voidSlotCheck() - 1].setIcon(pic.getImageOnID("#0007"));
                                        FastLine_.setNewItemID(voidSlotCheck() - 1, "#0007");
                                    }
                                    object.pickUp(frame);

                                }
                            }
                        } catch (Exception ex) {
                            object.Delete(frame);
                        }
                    }
                });
                object.repeatTimer(true);
                object.startTimer();
            }break;
            case "iron_chestplate":{
                Object object = new Object("iron_chestplate", X, Y, true, "Armor/Iron/body", frame);
                object.createTimer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(object.getHitBox().inHitBox(new HitBoxes(P1.getX(), P1.getY(), 64, "safe"))){
                                if(voidSlotCheck() != -1){
                                    if(voidSlotCheck() > 3){
                                        ExtraSlot8[voidSlotCheck() - 4].update("#0008", pic.group2.getImage("Armor/Iron/body"));
                                    }else {
                                        switch (voidSlotCheck()) {
                                            case 0:
                                                MainSlot1.update("#0008", pic.group2.getImage("Armor/Iron/body"));
                                                break;
                                            case 1:
                                                MainSlot2.update("#0008", pic.group2.getImage("Armor/Iron/body"));
                                                break;
                                            case 2:
                                                MainSlot3.update("#0008", pic.group2.getImage("Armor/Iron/body"));
                                                break;
                                            case 3:
                                                MainSlot4.update("#0008", pic.group2.getImage("Armor/Iron/body"));
                                                break;
                                        }
                                        ItemSlots[voidSlotCheck() - 1].setIcon(pic.getImageOnID("#0008"));
                                        FastLine_.setNewItemID(voidSlotCheck() - 1, "#0008");
                                    }
                                    object.pickUp(frame);

                                }
                            }
                        } catch (Exception ex) {
                            object.Delete(frame);
                        }
                    }
                });
                object.repeatTimer(true);
                object.startTimer();
            }break;
            case "iron_legs":{
                Object object = new Object("iron_legs", X, Y, true, "Armor/Iron/legs", frame);
                object.createTimer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(object.getHitBox().inHitBox(new HitBoxes(P1.getX(), P1.getY(), 64, "safe"))){
                                if(voidSlotCheck() != -1){
                                    if(voidSlotCheck() > 3){
                                        ExtraSlot8[voidSlotCheck() - 4].update("#0009", pic.group2.getImage("Armor/Iron/legs"));
                                    }else {
                                        switch (voidSlotCheck()) {
                                            case 0:
                                                MainSlot1.update("#0009", pic.group2.getImage("Armor/Iron/legs"));
                                                break;
                                            case 1:
                                                MainSlot2.update("#0009", pic.group2.getImage("Armor/Iron/legs"));
                                                break;
                                            case 2:
                                                MainSlot3.update("#0009", pic.group2.getImage("Armor/Iron/legs"));
                                                break;
                                            case 3:
                                                MainSlot4.update("#0009", pic.group2.getImage("Armor/Iron/legs"));
                                                break;
                                        }
                                        ItemSlots[voidSlotCheck() - 1].setIcon(pic.getImageOnID("#0009"));
                                        FastLine_.setNewItemID(voidSlotCheck() - 1, "#0009");
                                    }
                                    object.pickUp(frame);

                                }
                            }
                        } catch (Exception ex) {
                            object.Delete(frame);
                        }
                    }
                });
                object.repeatTimer(true);
                object.startTimer();
            }break;
            case "knight_sword":{
                Object object = new Object("knight_sword", X, Y, true, "Weapon/Knight/sword", frame);
                object.createTimer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(object.getHitBox().inHitBox(new HitBoxes(P1.getX(), P1.getY(), 64, "safe"))){
                                if(voidSlotCheck() != -1){
                                    if(voidSlotCheck() > 3){
                                        ExtraSlot8[voidSlotCheck() - 4].update("#0002", pic.group2.getImage("Weapon/Knight/sword"));
                                    }else {
                                        switch (voidSlotCheck()) {
                                            case 0:
                                                MainSlot1.update("#0002", pic.group2.getImage("Weapon/Knight/sword"));
                                                break;
                                            case 1:
                                                MainSlot2.update("#0002", pic.group2.getImage("Weapon/Knight/sword"));
                                                break;
                                            case 2:
                                                MainSlot3.update("#0002", pic.group2.getImage("Weapon/Knight/sword"));
                                                break;
                                            case 3:
                                                MainSlot4.update("#0002", pic.group2.getImage("Weapon/Knight/sword"));
                                                break;
                                        }
                                        ItemSlots[voidSlotCheck() - 1].setIcon(pic.getImageOnID("#0002"));
                                        FastLine_.setNewItemID(voidSlotCheck() - 1, "#0002");
                                    }
                                    object.pickUp(frame);

                                }
                            }
                        } catch (Exception ex) {
                            object.Delete(frame);
                        }
                    }
                });
                object.repeatTimer(true);
                object.startTimer();
            }break;
            default:{
                System.out.println("Object '" + name + "' not found!");
            }break;
        }
        frame.updateUI();
    }

    public void takeDamage(Player player){
        if(!player.DMGCooldown.isRunning()) {
            slice = player.slice.panel;
            frame.add(player.slice.panel);
            player.slice.Active();
            Timer slice_removing = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player.slice.Deactive();
                    frame.remove(player.slice.panel);
                    frame.revalidate();
                    frame.repaint();
                }
            });
            slice_removing.setRepeats(false);
            slice_removing.start();
            player.DMGCooldown.start();
        }
    }

    public void expirienceUpdate(Player player, int points){
        player.setExpPoints(player.getExpPoints() + points);
        playerLevelLabel.setText("Player Level: " + player.getLVL());
    }

    private void GameExit(){
        System.out.println("<class Main> : Game successfully Finished");
    }

    private void PlayerDeadAnimation(){
        P1.Die();
        ActionListener PlayerAfterDeadActions = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HB.setIcon(pic.group1.getImage("HealthBar"));
            }
        };
        Timer timer = new Timer(4000 ,PlayerAfterDeadActions);
        timer.setRepeats(false);
        timer.start();

        HB.setIcon(pic.group4.getImage("HealthBar"));
        P1.Die();
        frame.updateUI();
    }
    // Метод main
    public static void main(String[] args) { new Main(); }
}