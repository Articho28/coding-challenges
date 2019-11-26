

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int res = cache.get(1);
        System.out.println(res);
        cache.put(3,3);
        res = cache.get(2);
        System.out.println(res);
        cache.put(4,4);
        res = cache.get(1);
        System.out.println(res);
        res = cache.get(3);
        System.out.println(res);
        res = cache.get(4);
        System.out.println(res);
    }
}