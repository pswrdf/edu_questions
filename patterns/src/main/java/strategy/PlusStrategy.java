package strategy;

public class PlusStrategy implements Strategy{

    @Override
    public int action(int first, int second) {
        return first + second;
    }
}
