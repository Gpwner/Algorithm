import java.util.LinkedHashMap;
import java.util.Map;


//
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4


/**
 * @author 东北大学软件工程 许正创
 * @version 2017/6/25.15:41
 */




public class LRUCache {
    private final LinkedHashMap<Integer, Integer> linkedHashMap;
    private int CAPACITY = -1;

    public LRUCache(int capacity) {
        if (capacity < 0)
            System.exit(1);
        CAPACITY = capacity;
        linkedHashMap = new LinkedHashMap() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };

    }

    public int get(int key) {
        int value = linkedHashMap.getOrDefault(key, -1);
        if (value == -1)
            return -1;
        else {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        if (linkedHashMap.keySet().contains(key))
            linkedHashMap.remove(key);
        linkedHashMap.put(key, value);
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        System.out.println(cache.linkedHashMap);
        cache.put(1, 1);
        System.out.println(cache.linkedHashMap);
        cache.put(2, 3);    // evicts key 2
        System.out.println(cache.linkedHashMap);
        cache.put(4, 1);
        System.out.println(cache.linkedHashMap);
        System.out.println(cache.get(1));
        System.out.println(cache.linkedHashMap);
        System.out.println(cache.get(2));
        System.out.println(cache.linkedHashMap);

    }
}