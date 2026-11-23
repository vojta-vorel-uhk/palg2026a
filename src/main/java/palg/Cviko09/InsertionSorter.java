package palg.Cviko09;


import palg.Messages.Message;

public class InsertionSorter extends Sorter
{
    @Override
    public void sort(Message[] messages)
    {
        // TODO 4: doplnit kód
        for (int h=1; h<messages.length; h++){
            int i = h-1;
            while (i>=0 && messages[i+1].compareTo(messages[i]) < 0){
                swap(messages, i,i+1);
                i--;
            }
        }
    }
}
