package chainOfResponsibility;

public abstract class AbstractLogger {

    protected final int level;

    protected AbstractLogger logger = null;

    protected AbstractLogger(int level) {
        this.level = level;
    }

    abstract void log(String msg);

    public void log(int level, String msg) {
        if (level == this.level) {
            log(msg);
        }
        if (logger != null) {
            logger.log(level, msg);
        }
    }
}
