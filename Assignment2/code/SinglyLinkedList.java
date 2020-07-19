public class SinglyLinkedList<E>{

  private static class Node<E>{
    E element;
    private Node<E> next=null;
    public Node(E e, Node<E> n){
      element=e;
      next=n;
    }
    public E getElement(){
      return element;
    }
    public Node<E> getNext(){
      return next;
    }
    public void setNext(Node<E> n){
      next=n;
    }
  }
  
  private Node<E> head;
  private Node<E> tail;
  private int size;
  
  public SinglyLinkedList(){
    head=null;
    tail=null;
    size=0;
  }
  
  public int size(){
    return size;
  }
  
  public boolean isEmpty(){
    if(size==0)
      return true;
    else
      return false;
  }
  
  public E first(){
    if(head!=null)
      return head.getElement();
    else
      return null;
  }
  
  public E last(){
    if(tail!=null)
      return tail.getElement();
    else
      return null;
  }
  
  public void addFirst(E element){
    head = new Node<E>(element, head);
    if(isEmpty())
      tail=head;
    size++;
  }
  
  public void addLast(E element){
    Node<E> node = new Node<E>(element, null);
    if(isEmpty()){
      tail=node;
      head=node;
    }
    else{
      tail.setNext(node);
      tail=node;
    }
    size++;
  }
  
  public E removeFirst(){
    if(isEmpty())
      return null;
    E element=head.getElement();
    head=head.getNext();
    size--;
    if(size==0)
      tail=null;
    return element;
  }

}