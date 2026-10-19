package palg.Cviko04.Uloha03.Generators;

import java.time.Instant;

public class FromTimestampGenerator implements Generator {
    @Override
    public String getCode() {
        var s1 = Long.toString(Instant.now().toEpochMilli() % 1000000);
        while (s1.length() < 6)
            s1 = "0"+s1;
        return s1;
    }
}
