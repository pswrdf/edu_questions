package chainOfResponsibility;

public class FileLogger extends AbstractLogger {

    protected FileLogger(int level) {
        super(level);
    }

    @Override
    void log(String msg) {
        System.out.println("write file: " + msg);
    }
}
