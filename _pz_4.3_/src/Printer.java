public class Printer implements Printable{
    public Printer(){}
    @Override
    public void print(String msg){
        System.out.println(msg);
    }
}
