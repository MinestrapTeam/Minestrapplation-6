package minestrapp.utils;

public class GeneralUtils {

    public static int getProgressScaled(int max, int pixels, int progress){
        return (pixels * progress) / max;
    }

}
