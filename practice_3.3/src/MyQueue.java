import java.util.Deque;
import java.util.Queue;

public class MyQueue<T> {
    MyLinkedList myLinkedList = new MyLinkedList();
    public MyQueue(){}
    void offer(Element item){
        myLinkedList.addLast(item);
    }
    Element peek (){
        return myLinkedList.getFirst();
    }
    Element poll (){
        Element element = myLinkedList.get(0);
        myLinkedList.removeFirst();
        return element;
    }
}
