package utilites;

public class ReusableMethods {
    public static void bekle(int saniye){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
