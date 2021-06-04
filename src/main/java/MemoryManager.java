import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MemoryManager {
    DoublelinkedList<Integer> list = new DoublelinkedList<>();

    private int size = 0;

    MemoryManager() {
    this(1024);
    }

    MemoryManager(int size){
        this.size = size;
    }

    public int malloc (int i) {
        return i;
    }

    public int free (int i) {
        return (i);
    }
}
