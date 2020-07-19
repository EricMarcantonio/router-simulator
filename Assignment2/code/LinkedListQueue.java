public class LinkedListQueue<E> implements Queue<E>{
  private SinglyLinkedList<E> list = new SinglyLinkedList<E>();
  public LinkedListQueue(){}
  public int size(){
    return list.size();
  }
  public boolean isEmpty(){
    return list.isEmpty();
  }
  public E first(){
    return list.first();
  }
  public void enqueue(E node){
    list.addLast(node);
  }
  public E dequeue(){
    return list.removeFirst();
  }
}