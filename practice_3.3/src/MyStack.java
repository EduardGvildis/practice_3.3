import java.util.Stack;

public class MyStack <T> {
    MyLinkedList myLinkedList = new MyLinkedList();
    MyStack(){}
    public void push(T element){
        myLinkedList.addFirst(element);
    }
    public Element pop(){
        return myLinkedList.getFirst();
    }
}
