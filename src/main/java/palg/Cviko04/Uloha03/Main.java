package palg.Cviko04.Uloha03;

import palg.Cviko04.Uloha03.Generators.FixedForTestingGenerator;
import palg.Cviko04.Uloha03.Generators.FromTimestampGenerator;
import palg.Cviko04.Uloha03.Generators.Generator;
import palg.Cviko04.Uloha03.Generators.RandomDigitsGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // TODO: Tato metoda zajišťuje opakované generování 6-místných kódů zvoleným způsobem.
    //       Návrh na refaktorizaci:
    //       1) Založte složku Uloha03/Generators
    //       2) Ve složce Generators založte rozhraní nebo abstraktní třídu Generator
    //       3) Ve složce Generators založte vhodným způsobem čtyři potomky tohoto typu
    //       4) Metodu newCode přepracujte na metodu newGenerator s výstupním typem Generator
    //       5) Upravte metodu main tak, aby využívala metodu newGenerator
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        var strategy = props.getProperty("strategy");
        System.out.println("Systém je nastaven na způsob generování kódů: "+strategy);

        Scanner scanner = new Scanner(System.in);
        var g = newGenerator(strategy);
        while (true) {
            System.out.print("Pro vygenerování 6-místného kódu stiskněte ENTER:");
            scanner.nextLine();
            System.out.println(g.getCode());
        }
    }

    // tzv. "factory metoda"
    public static Generator newGenerator(String strategy){
        switch (strategy) {
            case "RANDOM_DIGITS":
                return new RandomDigitsGenerator();
            case "FROM_TIMESTAMP":
                return new FromTimestampGenerator();
            case "RANDOM_NUMBER_API":
                return new RandomDigitsGenerator();
            case "FIXED_FOR_TESTING":
                return new FixedForTestingGenerator();
            default:
                throw new RuntimeException("CHYBA NASTAVENÍ");
        }
    }
}
