package memento;

public class Memento {

    private String text;

    void save(String text) {
        this.   text = text;
    }


    String get() {
        return text;
    }
}
