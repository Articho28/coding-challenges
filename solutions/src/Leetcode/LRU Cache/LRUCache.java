import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;


class LRUCache {

    int capacity;
    int total;
    HashMap<Integer, Integer> content;
    Queue<Integer> evictionQueue;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;    
        this.content = new HashMap<Integer, Integer>();
        this.total = 0;  
        this.evictionQueue = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        if (content.get(key) != null) {
            // if element is already present, put it at the back of eviction queue.
            evictionQueue.remove(key);
            evictionQueue.add(key);
            return content.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (content.get(key) != null) {
            //Update the value we currently have for that key.
            content.put(key, value);
            
            //Element is now most recently used so put at the back of the queue.
            evictionQueue.remove(key);
            evictionQueue.add(key);

        } else {
            if (total < capacity) {
                //Increment total number of elements present
                // Add new element to the back of eviciton queue.
                content.put(key, value);
                evictionQueue.add(key);
                this.total++;
            } else {

                //If capacity is full, evict first element in eviciton queue
                int badKey = evictionQueue.remove();
                content.remove(badKey);
                content.put(key, value);
                evictionQueue.add(key);
            }

        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */