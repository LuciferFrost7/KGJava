import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Player_Standart{
    public JPanel panel;
    public JLabel label;
    public HitBoxes2 HitBox;

    public Slice2 slice;
    public Timer DMGCooldown;

    private String NickName;
    private String PlayerID;

    private double HP;
    private double MaxHP;

    private double DMG;
    private double DMGSpeed;

    private int xPosition;
    private int yPosition;
    private int Speed;

    private int ExpPoints;
    private int LVL;
    private int Coins;

    private boolean Permission;
    private boolean Alive;

    private Picture pic = new Picture(true, true, true, true);

    public Player(String playerid, String nickname, int maxhealth, int x, int y, JPanel FRAME) {
        final int PLAYER_HEIGHT = 48;
        final int PLAYER_WIDTH = 48;
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(590, 390, PLAYER_HEIGHT, PLAYER_WIDTH);
        panel.setBackground(Main.IsHitBoxEnabled ? new Color(255, 143, 0, 50) : Main.TRANSPARENT);
        panel.setBounds(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);

        label = new JLabel();
        label.setIcon(pic.group3.getImage("Player/Player"));
        label.setBounds(0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
        panel.add(label);
        HitBox = new HitBoxes2(x, y, PLAYER_WIDTH, PLAYER_HEIGHT, "safe");

        slice = new Slice2(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);

        setName(nickname);
        setPlayerID(playerid);
        setMaxHP(maxhealth);
        setHP(maxhealth);
        setSpeed(3);

        setX(x);
        setY(y);

        setExpPoints(0);
        setCoins(0);
        setLVL(1);
        setUser();
        setAlive(true);
        setDamage(2);
        setDamageSpeed(900);
        Cooldown();

        System.out.println("<class Player> : Player '" + nickname + "' created successfully");
    }

    public void setName(String newName) {
        if(!newName.isEmpty() && newName.length() < 27){
            NickName = newName;
        }else{
            if(newName.isEmpty()){
                System.out.println("<class Player> : Player Nickname isn't to be empty");
            }else{
                System.out.println("<class Player> : Player Nickname is too long");
            }
        }
    }
    public String getName() {
        return NickName;
    }

    public void setPlayerID(String newPlayerID) {
        if(! newPlayerID.isEmpty() && newPlayerID.length() < 9){
            PlayerID = newPlayerID;
        }else{
            if(newPlayerID.isEmpty()){
                System.out.println("<class Player> : Player ID isn't be empty");
            }else{
                System.out.println("<class Player> : Player ID is too long");
            }
        }
    }
    public String getPlayerID() {
        return PlayerID;
    }

    public void setMaxHP(double newMHP) {
        if(0 < newMHP) {
            MaxHP = newMHP;
        }else{
            System.out.println("<class Player> : HP is less than 0");
        }
    }
    public double getMaxHP() {
        return MaxHP;
    }

    public void setHP(double newHP) {
        if(0 <= newHP && newHP <= MaxHP){
            HP = newHP;
        }else{
            if(newHP > MaxHP){
                System.out.println("<class Player> : HP is greater than MaxHP");
            }
            else{
                HP = 0;
                Die();
            }
        }
    }
    public double getHP() {
        return HP;
    }

    public void setY(int newY){
        if(newY > 0){
            yPosition = newY;
            slice.setY(newY);
        }else{
            System.out.println("<class Player> : Y need to be greater than 0");
        }
    }
    public int getY() {
        return yPosition;
    }

    public void setX(int newX){
        if(newX > 0){
            xPosition = newX;
            slice.setX(newX + panel.getWidth());
        }else{
            System.out.println("<class Player> : X need to be greater than 0");
        }
    }
    public int getX() {
        return xPosition;
    }

    public void setExpPoints(int newExpPoints) {
        if(newExpPoints >= 0){
            ExpPoints = newExpPoints;
            if(ExpPoints >= 2){
                LVL += ExpPoints / 2;
                ExpPoints %= 2;
            }
        }else{
            System.out.println("<class Player> : Expirience Points need to be greater than 0 or equals 0");
        }
    }
    public int getExpPoints() {
        return ExpPoints;
    }

    public void setLVL(int newLVL) {
        if(newLVL > 0){
            LVL = newLVL;
        }else{
            System.out.println("<class Player> : LVL need to be greater than 0");
        }
    }
    public int getLVL() {
        return LVL;
    }

    public void setCoins(int newCoins) {
        if(newCoins >= 0){
            Coins = newCoins;
        }else{
            System.out.println("<class Player> : Coins need to be greater than 0 or equals 0");
        }
    }
    public int getCoins() {
        return Coins;
    }

    public void setSpeed(int newSpeed){
        if(newSpeed >= 0){
            Speed = newSpeed;
        }else{
            System.out.println("<class Player> : Speed need to be greater than 0 or equals 0");
        }
    }
    public int getSpeed() {
        return Speed;
    }

    public void setAlive(boolean flag){
        Alive = flag;
    }
    public void Born(){
        Alive = true;
        label.setIcon(pic.group3.getImage("Player/Player"));
        System.out.println("<class Player> : Player " + NickName + " Born");
    }
    public void Die(){
        Alive = false;
        label.setIcon(pic.group3.getImage("Player/PlayerDead"));
        System.out.println("<class Player> : Player " + NickName + " Die");
    }
    public boolean IsAlive(){
        return Alive;
    }
    public boolean getAlive(){
        return Alive;
    }

    public boolean IsAdmin(){
        return Permission;
    }
    public boolean IsUser(){
        return !Permission;
    }
    public void setAdmin(){
        Permission = true;
    }
    public void setUser(){
        Permission = false;
    }
    public boolean getPermission(){
        return Permission;
    }
    public void setPermission(boolean flag){
        Permission = flag;
    }

    public void setDamage(double newDamage){
        if(newDamage >= 0){
            DMG = newDamage;
        }else{
            System.out.println("<class Player> : Damage need to be greater than 0 or equals 0");
        }
    }
    public double getDamage(){
        return DMG;
    }

    public void setDamageSpeed(double newDamageSpeed){
        if(newDamageSpeed >= 0){
            DMGSpeed = newDamageSpeed;
        }else{
            System.out.println("<class Player> : Damage speed need to be greater than 0 or equals 0");
        }
    }
    public double getDamageSpeed(){
        return DMGSpeed;
    }
    public void NoneStopDamageSpeed(){
        DMGSpeed = 0;
    }
    public void Cooldown(){
        DMGCooldown = new Timer((int)DMGSpeed, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DMGCooldown.stop();
            }
        });
        DMGCooldown.setRepeats(false);
    }

    public void Delete(){

    };
    public double getDP(){
        return 0;
    }
    public void setDP(double newDP){

    }
    public void setDamageRange(double newDR){

    }
}