package palg.Cviko05.Uloha02;

import java.util.ArrayList;

public class Stack implements Waiting {
    private ArrayList<Object> data = new ArrayList<>();
    public void add(Object object) {
        data.add(object);
    }

    public Object remove() {
        if(data.size() == 0)
            return null;
        return data.removeLast();
    }

    public int count() {
        return data.size();
    }
}
