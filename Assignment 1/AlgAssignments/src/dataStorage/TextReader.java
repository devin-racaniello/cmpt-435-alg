package dataStorage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TextReader {
    public static void main(String[] args) {
        boolean isPalandrome = true;
        try {
            File myObj = new File("C:\\Users\\djrac\\Documents\\GitHub\\cmpt-435-alg\\Assignment 1\\AlgAssignments\\src\\dataStorage\\magicitems.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.trim();
                data = data.toLowerCase();

                MyStack s1 = new MyStack();
                MyQueue q1 = new MyQueue();

                isPalandrome = true;

                for (int i = 0, n = data.length(); i < n; i++) {
                    s1.push(String.valueOf(data.charAt(i)));
                    q1.enqueue(String.valueOf(data.charAt(i)));
                }
                for (int i = 0, n = data.length(); i < n; i++) {
                    if (!s1.pop().equals(q1.deque())){
                        isPalandrome = false;
                    }
                }

                
                if (isPalandrome){
                    System.out.println("Success:"+data);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
