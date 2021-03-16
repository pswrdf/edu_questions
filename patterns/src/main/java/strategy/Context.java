package strategy;

/**
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time. This type of design pattern comes under behavior pattern.
 */
public class Context {


    Strategy strategy;

    int a1;
    int a2;

    int result;

    void execute() {
        result = strategy.action(a1, a2);
    }
}
