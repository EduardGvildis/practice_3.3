import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository employee = new EmployeeRepository();
        employee.getNameAndSurnameOfTop3BySalary();
        System.out.println("I'm wait your massage");
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.next();
        Menu(txt);
    }
    public static void Menu(String txt){
        System.out.println("Enter a number to choose how we will store yours massage \n1.To the console \n2.to the error output stream\n3.to the file");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){
            int scanChuslo = scanner.nextInt();
            if(scanChuslo > 3){
                throw new ArithmeticException();
            }
            else{
                if(scanChuslo == 1){
                    Printer printer = new Printer();
                    printer.print(txt);
                }else if(scanChuslo == 2){
                    printErrMessage(txt);
                }else if(scanChuslo == 3){
                    FilePrinter filePrinter = new FilePrinter();
                    filePrinter.print(txt);
                }
            }
        }else {
            throw new IllegalArgumentException();
        }
    }
    public static void printMessage(String msg, Printable p){
        p.print(msg);
    }
    public static void printErrMessage(String msg){
        printMessage( msg, message -> System.err.println(msg));
    }
}