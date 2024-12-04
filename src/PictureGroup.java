import javax.swing.ImageIcon;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.awt.List;

public class PictureGroup {
    private final Map<String, ImageIcon> dict; // Словарь Ключ = ID Предмета / Значение = Изображение предмета
    private final List namelist;


    // Конструктор класса PictureGroup
    public PictureGroup(Map<String,ImageIcon> map, List list){
        dict = map;
        namelist = list;
    }
    public PictureGroup(String path, List list, String format){
        // Запись поступающего листа
        namelist = list;
        // Объявление dict-а необходимым словарём
        dict = new HashMap<>(namelist.getItemCount());
        URL u[] = new URL[namelist.getItemCount()];
        ImageIcon im[] = new ImageIcon[namelist.getItemCount()];

        for(int i = 0; i < namelist.getItemCount();i++){
            u[i] = getClass().getResource(path + namelist.getItem(i) + format);
            im[i] = new ImageIcon(u[i]);
            dict.put(namelist.getItem(i), im[i]);
        }
    }
    public int Length(){
        return namelist.getItemCount();
    }
    public ImageIcon getImage(String str){
        return dict.get(str);
    }
    public ImageIcon getImage(int ind){
        return dict.get(namelist.getItem(ind));
    }
    public List getList(){
        return namelist;
    }
    public Map getMap(){
        return dict;
    }
}