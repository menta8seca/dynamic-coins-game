import javafx.animation.AnimationTimer;

public class Motion extends AnimationTimer {
    private long previousTime = 0;
    @Override
    public void handle(long currentTime) {
        if (Driver.current >= Driver.solution.length||Driver.flag==0) {
            stop();
            return;
        }
        if (previousTime == 0) {
            previousTime = currentTime;
            return;
        }
        long elapsedTime = currentTime - previousTime;
        if (elapsedTime < 1500000000) {
            return;
        }
        previousTime = currentTime;
        Driver.nextB.fire();
    }
}
