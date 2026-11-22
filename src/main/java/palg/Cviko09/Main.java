package palg.Cviko09;

import palg.Messages.Message;

import java.time.Instant;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        long seed = System.currentTimeMillis();
        new NoSorter().sortWithReport(randomMessages(seed), "NoSorter.html");
        new JavaSorter().sortWithReport(randomMessages(seed), "JavaSorter.html");
        new HeapSorter().sortWithReport(randomMessages(seed), "HeapSorter.html");
        new SelectionSorter().sortWithReport(randomMessages(seed), "SelectionSorter.html");
        new InsertionSorter().sortWithReport(randomMessages(seed),"InsertionSorter.html");
    }

    private static Message[] randomMessages(long seed)
    {
        Random random = new Random(seed);
        Message[] messages = new Message[300];
        for(int i=0; i< messages.length; i++)
        {
            var epochSeconds=random.nextInt(0, 10000);
            messages[i] = new Message( Instant.ofEpochSecond(epochSeconds),"Uběhlo "+epochSeconds+" sekund");
        }
        return messages;
    }
}
