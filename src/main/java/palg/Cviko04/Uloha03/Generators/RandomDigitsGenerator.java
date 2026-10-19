package palg.Cviko04.Uloha03.Generators;

import java.util.Random;

public class RandomDigitsGenerator implements Generator {
    @Override
    public String getCode() {
        var r = new Random();
        var s = "";
        for (int i = 1; i < 6; i++)
            s += Integer.toString(r.nextInt(10));
        return s;
    }
}
