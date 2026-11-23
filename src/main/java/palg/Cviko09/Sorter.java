package palg.Cviko09;


import palg.Messages.Message;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public abstract class Sorter
{
    private final String dir = System.getProperty("user.dir");

    protected static void swap(Message[] m, int a, int b){
        var temp = m[a];
        m[a] = m[b];
        m[b] = temp;
    }

    public abstract void sort(Message[] messages);

    public void sortWithReport(Message[] messages, String fileName)
    {
        sort(messages);
        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<head>");
        html.append("<style>");
        html.append("div .box {font-family: Consolas; padding: 5px; margin: 5px; color: #000B; border-radius: 5px; width:120px; text-align: center; font-size:10px}");
        html.append("</style>");
        html.append("</head>");
        html.append("<body>");
        html.append("<div style='width:100%;display: flex; flex-direction: row; flex-wrap: wrap'>");
        for(Message c : messages)
        {
            String color=c.getColor();
            html.append("<div class='box' style='white-space: nowrap; display: flex;align-items: center;background-color: "+color+"'>");
            html.append("<span style=''>✉&nbsp;</span> "+c);
            html.append("</div>");
        }
        html.append("</body>");
        html.append("</html>");
        try
        {

            var dirPath = Paths.get(dir,"reports");
            Files.createDirectories(dirPath);
            var filePath = Paths.get(dirPath.toString(),fileName);
            var file = new File(Paths.get(dirPath.toString(),fileName).toString());
            Files.write(filePath, html.toString().getBytes());
            TimeUnit.MILLISECONDS.sleep(1000);
            Desktop.getDesktop().open(file);
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }
}
