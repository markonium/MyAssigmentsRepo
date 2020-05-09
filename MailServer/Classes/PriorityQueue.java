package eg.edu.alexu.csd.datastructure.mailServer;
/**
 * DList Node for PQueue
 * @author Marwan Selim, Fares M. Fouad
 *
 */
class node{
    // so we create the node of the linked list we will use to build the PQueue and we chose a node of a double linked list to ease the access
    Object data;
    node next;
    node pre;
    // this is the key of the node
    int k;
}
/**
 * Priority queue class
 * @author Marwan Selim, Fares M. Fouad
 *
 */
public class PriorityQueue implements IPriorityQueue {
  private node head ;
  private node tail;
  private int size =0;

public void insert(Object item, int key){
        node m = new node();
        m.data=item;
        m.k=key;
        if (size==0){
            head=m;
            tail=m;
        }
        else {
            if (m.k>tail.k){
                m.pre=tail;
                tail.next=m;
                tail=m;
            }else if(m.k<=head.k){
                head.pre=m;
                m.next=head;
                head=m;
            }else {
                node x=head;
                node y;
                for (int i=0;i<size-1;i++){
                    x=x.next;
                    if(x.k>=m.k){
                        y= x.pre;
                        x.pre=m;
                        m.next =x;
                        m.pre=y;
                        y.next=m;
                        break;
                    }
                }
            }
        }
        size++;
    }
    public void add(Object item){
        insert(item,tail.k);
    }
    public Object removeMin(){
    	if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        node m =head;
        node n =head.next;
        m.next=null;
        if(n!=null) {
        	n.pre=null;
            head=n;
        }
        size--;
        return m.data;
    }
    public Object min(){
        if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        return head.data;
    }
    public boolean isEmpty(){
        if (size()==0){
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }

    public void show(){
    	if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        node m =head;
        System.out.println(m.data);
        for (int i=0;i<(size-1);i++){
            m=m.next;
            System.out.println(m.data);
        }
    }

}
