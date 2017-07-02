package question3;

/**
 * Created by markz on 2/7/17.
 */
public class TimeConsumingTest {
    @MeasureTime
    public void execute() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Error happened in example service.");
        }
    }
}
