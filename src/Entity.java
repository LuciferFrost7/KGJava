import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Entity {
    private int x;
    private int y;
    private String type;
    private int damage;
    private int speed;
    private Points MaxHealth;
    private Points Health;
    private Points Defence; // Testing before Beta1.2

    private JLabel Mob;
    private JLabel HealthBar;
    private HitBoxes HitBox;

    private JLabel Lines[];

    private JPanel mobPanel;
    private PictureGroup gallery;
    private PictureGroup HBgallery;
    private Timer timer;
    private Timer damageTimer;



    boolean bdvig = false;
    private boolean Alive;
    private List HBTex;

    private Timer Lootable;
    public boolean dropHere = true;

    public Entity(String mobName, int x, int y, String type, int MaxHP, int Defence, int damage, int speed, List TextureListName, Player PLAYER, HitBoxes hitbox, JPanel PANEL) {
        Alive = true;
        this.x = x;
        this.y = y;
        this.type = type; // Agressive / Passive / Neitral
        this.damage = damage;
        this.speed = speed;
        this.MaxHealth = new Points(MaxHP);
        this.Health = new Points(MaxHP);
        this.Defence = new Points(Defence);

        HitBox = hitbox;
        HBTex = new List();
        HBTex.add("Mobs/HealthBar/MobHealBar");
        HBTex.add("Mobs/HealthBar/MHBStartLine");
        HBTex.add("Mobs/HealthBar/MHBLine");
        HBTex.add("Mobs/HealthBar/MHBEndLine");

        gallery = new PictureGroup("Images/Group3/", TextureListName, ".png");
        HBgallery = new PictureGroup("Images/Group3/", HBTex, ".png");

        ImageIcon img = gallery.getImage(TextureListName.getItem(0));
        ImageIcon img2 = gallery.getImage(TextureListName.getItem(0));
        ImageIcon HBimg = HBgallery.getImage(0);

        mobPanel = new JPanel();
        mobPanel.setLayout(null);
        mobPanel.setBackground(Main.IsHitBoxEnabled ? new Color(100, 0, 0, 50) : Main.TRANSPARENT);
        mobPanel.setBounds(x, y, img.getIconWidth(), img.getIconHeight());

        Mob = new JLabel();
        Mob.setIcon(img);
        Mob.setBounds(0, 4, img.getIconWidth(), img.getIconHeight());

        Lines = new JLabel[9];
        for (int i = 0; i < 9; i++) {
            Lines[i] = new JLabel();
            if (i == 0 || i == 8) {
                Lines[i].setIcon(HBgallery.getImage(i == 0 ? 1 : 3));
                Lines[i].setBounds(i == 0 ? 16 : 40, 3, 4, 6);
                continue;
            }
            Lines[i].setIcon(HBgallery.getImage(2));
            Lines[i].setBounds(16 + ((i) * 3), 3, 4, 6);
        }


        HealthBar = new JLabel();
        HealthBar.setIcon(HBimg);
        HealthBar.setBounds(14, 0, HBimg.getIconWidth(), HBimg.getIconHeight());

        for (int i = 0; i < 9; i++) mobPanel.add(Lines[i]);
        mobPanel.add(HealthBar);
        mobPanel.add(Mob);
        PANEL.add(mobPanel);

        Timer deadTimer = new Timer(2500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PANEL.remove(mobPanel);
                PANEL.revalidate();
                PANEL.repaint();
                Lootable.start();
            }
        });
        int XXX = x;
        int YYY = y;
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Alive) {
                    try {
                        if (PLAYER.getAlive() && PLAYER.slice.getActive() & HitBox.inHitBox(PLAYER.slice.getX(), PLAYER.slice.getY(), 64)) {
                            Health.sub(PLAYER.getDamage());
                            Lines[8].setVisible(Health.get() == MaxHealth.get());
                            Lines[7].setVisible(Health.get() >= (MaxHealth.getd() / 8) * 7);
                            Lines[6].setVisible(Health.get() >= (MaxHealth.getd() / 8) * 6);
                            Lines[5].setVisible(Health.get() >= (MaxHealth.getd() / 8) * 5);
                            Lines[4].setVisible(Health.get() >= MaxHealth.getd() / 4);
                            Lines[3].setVisible(Health.get() >= (MaxHealth.getd() / 8) * 3);
                            Lines[2].setVisible(Health.get() >= (MaxHealth.getd() / 8) * 2);
                            Lines[1].setVisible(Health.get() >= MaxHealth.getd() / 8);
                            Lines[0].setVisible(Health.get() > 0);
                            if (Health.get() <= 0) {
                                Mob.setIcon(gallery.getImage(4));
                                Alive = false;
                                deadTimer.setRepeats(false);
                                deadTimer.start();
                            }
                        }
                        switch (mobName) {
                            case "GORUML": {
                                if (bdvig) {
                                    changeX(speed, img.getIconHeight());
                                    if (mobPanel.getX() >= XXX + 200) {
                                        bdvig = false;
                                    }
                                } else if (!bdvig) {
                                    changeX(-speed, img.getIconHeight());
                                    if (mobPanel.getX() <= XXX - 200) {
                                        bdvig = true;
                                    }
                                }
                            }
                            break;
                            case "ENT": {
                                if (bdvig) {
                                    changeY(speed, img.getIconHeight());
                                    if (mobPanel.getY() >= YYY + 200) {
                                        bdvig = false;
                                    }
                                } else if (!bdvig) {
                                    changeY(-speed, img.getIconHeight());
                                    if (mobPanel.getY() <= YYY - 200) {
                                        bdvig = true;
                                    }
                                }
                            }
                            break;
                            case "KNIGHT": {
                                if (new HitBoxes(getX() - 150, getY() - 150, 364, "pain").inHitBox(PLAYER.getX(), PLAYER.getY(), 64)) {
                                    if (PLAYER.getX() != getX()) {
                                        if (PLAYER.getX() < getX()) {
                                            changeX(-speed, img.getIconHeight());
                                        } else if (PLAYER.getX() > x) {
                                            changeX(speed, img.getIconHeight());
                                        }
                                    }
                                    if (PLAYER.getY() != getY()) {
                                        if (PLAYER.getY() < getY()) {
                                            changeY(-speed, img.getIconHeight());
                                        } else if (PLAYER.getY() > y) {
                                            changeY(speed, img.getIconHeight());
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    } catch (Exception ex) {
                        timer = null;
                        damageTimer = null;
                        Lootable = null;
                        MaxHealth = null;
                        Points Health = null;
                        Points Defence = null; // Testing before Beta1.2
                        Mob = null;
                        HealthBar = null;
                        HitBox = null;
                        Lines = null;
                        mobPanel = null;
                        gallery = null;
                        HBgallery = null;
                        bdvig = false;
                        Alive = false;
                        HBTex = null;
                        dropHere = false;
                    }
                }

            }
        });
        timer.start();

        switch (mobName) {

            case "GORUML": {
                damageTimer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (PLAYER.getAlive() & Alive & new HitBoxes(PLAYER.getX(), PLAYER.getY(), 64, "pain").inHitBox(HitBox)) {
                                PLAYER.setHP(PLAYER.getHP() - damage);
                            }

                        } catch (Exception ex) {
                            timer = null;
                            damageTimer = null;
                            Lootable = null;
                            MaxHealth = null;
                            Points Health = null;
                            Points Defence = null; // Testing before Beta1.2
                            Mob = null;
                            HealthBar = null;
                            HitBox = null;
                            Lines = null;
                            mobPanel = null;
                            gallery = null;
                            HBgallery = null;
                            bdvig = false;
                            Alive = false;
                            HBTex = null;
                            dropHere = false;
                        }
                    }
                });
            }
            break;
            case "ENT": {
                damageTimer = new Timer(1000, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        try{
                        if (PLAYER.getAlive() & Alive & new HitBoxes(PLAYER.getX(), PLAYER.getY(), 64, "pain").inHitBox(HitBox)) {
                            PLAYER.setHP(PLAYER.getHP() - damage);
                        }
                        } catch (Exception ex) {
                            timer = null;
                            damageTimer = null;
                            Lootable = null;
                            MaxHealth = null;
                            Points Health = null;
                            Points Defence = null; // Testing before Beta1.2
                            Mob = null;
                            HealthBar = null;
                            HitBox = null;
                            Lines = null;
                            mobPanel = null;
                            gallery = null;
                            HBgallery = null;
                            bdvig = false;
                            Alive = false;
                            HBTex = null;
                            dropHere = false;
                        }
                    }
                });
                System.out.println(1);
            }
            break;
            case "KNIGHT": {
                damageTimer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try{
                        if (PLAYER.getAlive() & Alive & new HitBoxes(PLAYER.getX(), PLAYER.getY(), 64, "pain").inHitBox(HitBox)) {
                            PLAYER.setHP(PLAYER.getHP() - damage);
                        }
                        } catch (Exception ex) {
                            timer = null;
                            damageTimer = null;
                            Lootable = null;
                            MaxHealth = null;
                            Points Health = null;
                            Points Defence = null; // Testing before Beta1.2
                            Mob = null;
                            HealthBar = null;
                            HitBox = null;
                            Lines = null;
                            mobPanel = null;
                            gallery = null;
                            HBgallery = null;
                            bdvig = false;
                            Alive = false;
                            HBTex = null;
                            dropHere = false;
                        }
                    }
                });
                System.out.println(2);
            }
            break;
        }
        damageTimer.start();
    }
    public void changeX(int speed, int size) {
        x = x + speed;
        HitBox.setNewX(x);
        mobPanel.setBounds(x, y, size, size);
    }

    public void changeY(int speed, int size) {
        if(Main.canMove(getX(), getY() + speed)) {
            y += speed;
            HitBox.setNewY(y);
            mobPanel.setBounds(x, y, size, size);
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public PictureGroup getGallery() {
        return gallery;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxHealth() {
        return MaxHealth.get();
    }

    public int getHealth() {
        return Health.get();
    }

    public int getDefence() {
        return Defence.get();
    }

    public void lootableCreate(int _time, ActionListener _action){
        Lootable = new Timer(_time, _action);
        Lootable.setRepeats(false);
    }
}
