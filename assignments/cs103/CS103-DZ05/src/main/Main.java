package main;

public class Main {
     public static void main(String[] args){
         Node head = new Node(11, new Node(3, new Node(52, new Node(10, null))));
         Node headOfReversed = reverse(head);
         printLinkedList(headOfReversed);
     }

     public static void printLinkedList(Node head){
         Node p = head;
         while (p != null){
             System.out.print(p.value + ", ");
             p = p.next;
         }
         System.out.println("");
     }

     public static Node reverse(Node head){
         if(head.next == null){
             return head;
         }
         Node headNext = head.next;
         Node headReverseOfRest = reverse(head.next);
         headNext.next = head;
         head.next = null;
         return headReverseOfRest;

     }
}
