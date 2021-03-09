package proxy;

public class ProxyImage implements Image {
    Image image;

    @Override
    public void print() {
        System.out.println("printing image");
        image.print();
    }
}
