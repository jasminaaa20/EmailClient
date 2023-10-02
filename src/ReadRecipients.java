import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadRecipients {
    public static void readRecipients() {
        ArrayList<String> recipientList = new ArrayList<>();
        try {
            File clientFile = new File("clientList.txt");
            Scanner scanner = new Scanner(clientFile);
            while (scanner.hasNextLine())
                recipientList.add(scanner.nextLine());
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (String recipient: recipientList) {
            CreateNewRecipient.addRecipient(recipient);
        }
    }
}
