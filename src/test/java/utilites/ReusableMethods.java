package utilites;

public class ReusableMethods {
    public static void bekle(int saniye){

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
