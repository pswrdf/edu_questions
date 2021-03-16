package chainOfResponsibility;

public class ConsoleLogger extends AbstractLogger {
    protected ConsoleLogger(int level) {
        super(level);
    }

    @Override
    void log(String msg) {
        System.out.println("console: " + msg);
    }

    public static void main(String[] args) {
        FileLogger fileLogger = new FileLogger(1);
        fileLogger.logger = new ConsoleLogger(2);
        fileLogger.log(1 , "qwe");
    }
}
