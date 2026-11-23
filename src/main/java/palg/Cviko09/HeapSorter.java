package palg.Cviko09;

import palg.Messages.Message;

public class HeapSorter extends Sorter
{
    public void sort(Message[] messages)
    {
        palg.Cviko08.Heap heap = new palg.Cviko08.Heap(messages.length);
        for(int i=0; i <messages.length; i++){
            heap.add(messages[i]);
        }
        for(int i=0; i <messages.length; i++){
            messages[i] = heap.extractMin();
        }

        // TODO 2: doplnit kód
    }
}
