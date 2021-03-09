package proxy;

public class RealImage implements Image {
    @Override
    public void print() {
        System.out.println(
                "image"
        );
    }
}
