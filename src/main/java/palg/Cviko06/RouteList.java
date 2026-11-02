package palg.Cviko06;

public class RouteList implements SimplifiedList<Location>
{
    RouteListNode head; // null, pokud je seznam prázdný
    int count;

    @Override
    public void addFirst(Location item) {
        head = new RouteListNode(item, head );
        count++;
    }

    @Override
    public void addLast(Location item) {
        if(head == null){
            head = new RouteListNode(item,null);
            count = 1;
            return;
        }
        var last = head;
        while (last.getNext() != null)
            last = last.getNext();
        last.setNext(new RouteListNode(item,null));
        count++;
    }

    // tato metoda vyhodí IndexOutOfBounds
    // pokud je index mimo rozsah
    @Override
    public Location get(int i) {
        if(i < 0 || i >= count)
            throw new IndexOutOfBoundsException();

        var prst = head;
        for (int k=0; k<i; k++){
            prst = prst.getNext();
        }
        return prst.getPayload();
    }

    @Override
    public int size() {
        return count;
    }
    // TODO 3:
    //  Implementuj rozhraní SimplifiedList, tak aby fungovalo jako spojový seznam. Využij třídu RouteListNode.

    // TODO 4 (na doma):
    //  Přidej možnost procházet RouteList pomocí for-each cyklu
    //  a zprovozni tento cyklus v Utils.geoDistance
    //  - je potřeba aby RouteList implementoval Iterable<Location>
    //  - k tomu je potřeba založit speciální třídu jako "iterátor",
    //    např. RouteListIterator

}
