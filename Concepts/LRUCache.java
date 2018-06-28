import java.util.*;
import java.io.*;

public class LRUCache {


    public static class Node{
        int key;
        int val;
        Node next, prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }

    Node head, tail;

    private int capacity;
    int N;

    HashMap<Integer, Node> map;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.N = 0;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
      if(N == 0) return -1;
      
      if(map.containsKey(key)){
        Node node = map.get(key);
        Node temp;

        if(head.key == node.key)
        {
            return head.val;
        }
        if(tail.key == node.key){
            tail = tail.prev;
        }

        temp = node.prev;
        temp.next = node.next;
        temp = node.next;
        if(temp != null){
            temp.prev = node.prev;
        }

        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;

        return node.val;

      }

      return -1;
    }
    
    public void set(int key, int value) {
       if(map.containsKey(key)){
        Node node = map.get(key);
        Node temp; 

        //check if head's key is equal to the given key
        if(node.key == head.key){
            head.val = value;
            return;
        }
        //check if tail's key == given key
        if(node.key == tail.key){
            tail = tail.prev; //remove tail from list and add it to front 
        }

        //link nodes next elment to nodes previous element
        temp = node.prev;
        temp.next = node.next;
        temp = node.next;
        if(temp != null){
            temp.prev = node.prev;
        }

        //adding node to the front of the list and undating head
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;

        node.val = value;

        return;

       }

       if(N == capacity){
        if(tail != null){
            map.remove(tail.key);
            tail = tail.prev;

            if(tail != null){
                tail.next.prev = null;
                tail.next = null;
            }
            N--;
        }
    }
        Node node = new Node(key, value);
        node.next = head;
        if(head != null){
            head.prev = node;
        }
        head = node;
        N++;

        if(N == 1){
            tail = head;
        }
        map.put(key, node);
       
     
    }


    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.set(2, 3);
        l.set(3, 4);
        l.set(5, 6);
        System.out.println(l.get(2));
        
    }
}
