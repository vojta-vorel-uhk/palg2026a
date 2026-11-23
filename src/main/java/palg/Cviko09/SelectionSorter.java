package palg.Cviko09;

import palg.Messages.Message;

public class SelectionSorter extends Sorter
{
    @Override
    public void sort(Message[] messages)
    {
        // TODO 3: doplnit kód
        for (int h=0; h < messages.length; h++){
            var min = findMinIndex(messages,h);
            swap(messages, h, min);
        }
    }

    private int findMinIndex(Message[] messages, int start)
    {
        int minIndex = start;
        for(int i=start; i <messages.length; i++){
            if(messages[i].compareTo(messages[minIndex]) < 0){
                minIndex = i;
            }
        }
        return minIndex;
    }
}
