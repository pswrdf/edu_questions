package state;

public class FirstState implements State{
    @Override
    public void doAction(Context context) {
        context.state = this;
    }
}
