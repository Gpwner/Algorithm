import java.util.LinkedList;

//
//[1]
//        [2, 1]
//        [3, 2, 1]
//        [4, 3, 2, 1]
//        [5, 4, 3, 2, 1]
//        [1,5,4,3,2]
//        本次被踢掉的元素是:2
//        [6,1,5,4,3]
//        [4,6,1,5,3]
//        本次被踢掉的元素是:3
//        [7,4,6,1,5]
/**
 * @author
 * @version 2017/6/25.15:24
 */
public class LinkedListCache<Object> {
    //默认的缓存大小
    private static int CAPACITY = 0;

    //引用一个双向链接表
    private LinkedList<Object> list;

    //构造函数
    public LinkedListCache(int capacity) {
        this.CAPACITY = capacity;
        list = new LinkedList<Object>();
    }

    //添加一个元素
    public synchronized void put(Object object) {

        if (list != null && list.contains(object)) {
            list.remove(object);
        }
        removeLeastVisitElement();
        list.addFirst(object);
    }

    //移除最近访问次数最少的元素
    private synchronized void removeLeastVisitElement() {

        int size = size();

        //注意，这儿必须得是CAPACITY - 1否则所获的size比原来大1
        if (size > (CAPACITY - 1)) {
            Object object = list.removeLast();
            System.out.println("本次被踢掉的元素是:" + object.toString());
        }
    }

    //获取第N个索引下面的元素
    public synchronized Object get(int index) {
        return list.get(index);
    }

    //清空缓存
    public synchronized void clear() {
        list.clear();
    }

    //获取链接表的大小
    public int size() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    //toString方法
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedListCache linkedListCache = new LinkedListCache<String>(5);

        linkedListCache.put("1");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("2");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("3");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("4");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("5");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("1");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("6");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("4");
        System.out.println(linkedListCache.toString());
        Thread.sleep(1000);
        linkedListCache.put("7");
        System.out.println(linkedListCache.toString());
    }
}
