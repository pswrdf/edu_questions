package memento;

/**
 * Шаблон хранитель фиксирует и хранит текущее состояние объекта, чтобы оно легко восстанавливалось.
 */
public class Editor {
    private String cur;
    private Memento memento;
    void save() {
        memento = new Memento();
        memento.save(cur);
    }

    void restore() {
        cur = memento.get();
    }
}
