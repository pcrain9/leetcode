import java.util.Random;
import java.util.HashMap;

/* Definition for singly-linked list.
Inspiration for creating linked list goes to: https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/*/
public class ListNode {
    ListNode head;    
    int key;  
    int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;}
  
    public static ListNode brutegetIntersectionNode(ListNode headA, ListNode headB) {
        //brute force: traverse list b and check against all values of a: will result in quadratic run time
        for(ListNode tmp = headA; tmp != null; tmp = tmp.next){
            for(ListNode tmp1 = headB; tmp1 != null; tmp1 = tmp1.next){
                if(tmp1.val == tmp.val) return tmp1;
            }
        }
        return null;
    }

    public static ListNode hashgetIntersectionNode(ListNode headA, ListNode headB) {
        //hash all values of both lists, check for overlap
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(ListNode tmp = headA; tmp != null; tmp = tmp.next){
            hm.put(count++, tmp.val);            
        }
        for(ListNode tmp1 = headB; tmp1 != null; tmp1 = tmp1.next){
            if(hm.containsValue(tmp1.val)) return tmp1;
        }
        return null;
    }

    public void insert(ListNode node, int x){
        
        ListNode new_node = new ListNode(x);
        //check if list is empty
        if(node.next == null){
            node.next = new_node;            
        }
        else{
            ListNode tracker = node;
            while(tracker.next != null){
                tracker = tracker.next;
            }
            tracker.next = new_node;
        }
    }
    public static void main(String[] args){
        Random random = new Random();
        ListNode A = new ListNode(random.nextInt(20 - 1) + 1);
        ListNode B = new ListNode(random.nextInt(20 - 1) + 1);
        
        //populate the lists by inserting random ints between 1 and 20
        for(int i = 0; i < 5; i++){
            A.insert(A, random.nextInt(20 - 1) + 1);
        }
        for(int i = 0; i < 3; i++){
            B.insert(B, random.nextInt(20 - 1) + 1);
        }

        //print the lists
        ListNode tmp = A;
        while(tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;}
        tmp = B;
        System.out.println("");
         while(tmp != null){
            System.out.print(" " + tmp.val);
            tmp = tmp.next;}
        
        //find the intersection
        ListNode answer = hashgetIntersectionNode(A, B);
        if(answer == null) System.out.println("\n No intersection");
        else System.out.println("\n Intersection is at value: " + answer.val);

    }
}