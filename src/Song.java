import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.net.URL;


// Класс хранящий в себе Саундтреки игрового процесса
public class Song {

    private Clip clip; // Параметр отвечающий за воспроизведение звука
    private URL soundURL[]; // Массив ссылок на изображения

    // Конструктор Класса Song
    public Song(String songName){
        try {
            soundURL = new URL[1];
            soundURL[0] = getClass().getResource("song/" + songName + ".wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[0]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            System.out.println("<class Song>: Clip successfully created");
        }catch(Exception e){
            System.out.println("ERROR <class Song>: Clip not successful created!");
        }
    }

    // Метод для Проигрывания Трека
    public void PlaySong(){
        try {
            LoopSong();
            clip.start();
        } catch (Exception e) {
            System.out.println("ERROR <class Song>: Clip not successful start playing!");
        }
    }

    // Метод для Зацикливания Трека
    public void LoopSong(){
        try {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e){
            System.out.println("ERROR <class Song>: Clip not successful loop!");
        }
    }

    // Метод для остановки Трека
    public void StopSong(){
        try {
            clip.stop();
        }catch(Exception e){
            System.out.println("ERROR <class Song>: Clip not successful stop playing!");
        }
    }

    // Метод для Остановки Трека на Паузу
    public void Pause(String stopWord){
        try {
            if (clip.isActive() && stopWord.equals("NONE") || stopWord.equals("FALSE")) {
                StopSong();
            } else {
                PlaySong();
            }
        } catch (Exception e) {
            System.out.println("ERROR <class Song>: Clip not successful pause!");
        }
    }

    // Метод для обнуления объекта класса Song
    public void Delete(){
        StopSong();
        clip = null;
        soundURL = null;
        System.out.println("<class Song>: Song successfully deleted!");
    }
}