public class LinkedList {

    static Node head1, head2;
    
    static class Node {

        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

/*Function to get the intersection of two linked lists*/
    int getNode()
    {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if(c1 > c2){
            d = c1 - c2;
            return _getIntersectionNode(d,head1,head2);
        }
        else{
            d = c2 - c1;
            return _getIntersectionNode(d,head2,head1);
        }
    }

    int _getIntersectionNode(int d, Node node1, Node node2){
        int i;
        Node current1 = node1;
        Node current2 = node2;
        for(i=0; i<d; i++){
            if(current1 == null){
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if(current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return -1;
    }

    //Takes head pointer of the linked list and returns the count of nodes in the list
    int getCount(Node node){
        Node current = node;
        int count = 0;

        while (current != null){
            count++;
            current=current.next;
        }

        return count;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();

        //First linked list
        linkedList.head1 = new Node(3);
        linkedList.head1.next = new Node(6);
        linkedList.head1.next.next = new Node(15);
        linkedList.head1.next.next.next = new Node(15);
        linkedList.head1.next.next.next.next = new Node(30);

        //Second linked list
        linkedList.head2 = new Node(10);
        linkedList.head2.next = new Node(15);
        linkedList.head2.next.next = new Node(30);

        System.out.println("The node intersection is: " + linkedList.getNode());
    }

}