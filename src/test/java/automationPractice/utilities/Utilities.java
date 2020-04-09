package automationPractice.utilities;

public class Utilities {

    public static void waitTime(int timeseconds){
        try {
            Thread.sleep(timeseconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
