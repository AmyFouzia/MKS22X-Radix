public class Node{
    private E data;
    private Node next;
    private Node prev;
 
    //constructors
    public Node(E value){
      data = value;
    }

    public Node(E value, Node nextNode, Node prevNode){
      data = value;
      next = nextNode;
      prev = prevNode;
    }

    public Node next(){
      return next;
    }

    public Node prev(){
      return prev;
    }

    public void setNext(Node other){
      next = other;
    }

    public void setPrev(Node other){
      prev = other;
    }

    public E getData(){
      return data;
    }

    public E setData(E set){
      data = set;
      return data;
    }

    public String toString(){
      return data + "";
    }

  }


}
