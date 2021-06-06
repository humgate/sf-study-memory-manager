//Main App
public class Main {
    public static void main(String[] args) {
        MemoryManager manager = new MemoryManager(100);
        manager.malloc(5);
        manager.malloc(2);


        System.out.println(
                manager.dlist.getByIndex(0).index + " " + manager.dlist.getByIndex(0).length + " " +
                        manager.dlist.getByIndex(0).allocated);
        System.out.println(
                manager.dlist.getByIndex(1).index + " " + manager.dlist.getByIndex(1).length +  " " +
                        manager.dlist.getByIndex(1).allocated);
        System.out.println(
                manager.dlist.getByIndex(2).index + " " + manager.dlist.getByIndex(2).length +  " " +
                        manager.dlist.getByIndex(2).allocated);
    }



}
