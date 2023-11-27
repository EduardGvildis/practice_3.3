import java.io.*;

public class FilePrinter implements Printable {
    private String fileName;
    public FilePrinter(){}
    public FilePrinter(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print(String msg) {
        fileName = "C:\\Users\\Acer\\Desktop\\Новий Текстовий документ.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // We write the message to a file
            writer.write(msg);
            System.out.println("The message was successfully saved to the file");
        } catch (IOException e) {
            System.err.println("Error writing to file");
        }
    }
}
