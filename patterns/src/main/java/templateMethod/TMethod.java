package templateMethod;

public abstract class TMethod {

    public void tmethod() {
        one();
        two();
    }

    abstract void one();
    abstract void two();
}
