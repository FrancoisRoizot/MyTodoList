package francois.roizot.mytodolist;

import java.util.ArrayList;

/**
 * Created by froizot on 01/03/2017.
 */
public final class ArrayListSingleton {

    private static volatile ArrayListSingleton instance = null;

    private ArrayList<String> text = new ArrayList<String>();

    private ArrayListSingleton() {
        super();
    }

    public static ArrayListSingleton getInstance() {
        if (ArrayListSingleton.instance == null) {
            synchronized(ArrayListSingleton.class) {
                if (ArrayListSingleton.instance == null) {
                    ArrayListSingleton.instance = new ArrayListSingleton();
                }
            }
        }
        return ArrayListSingleton.instance;
    }

    public void addItem(String text) {
        this.text.add(0, text);
    }

    public ArrayList<String> getItems() {
        return this.text;
    }

    public void empty() { this.text.clear(); }
}
