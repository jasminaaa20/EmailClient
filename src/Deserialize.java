import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Deserialize {
    public static ArrayList<Email> sentMail =
            new ArrayList<>();
    public static ArrayList<String> todayBorn
            = new ArrayList<>();
    public static void deserialize() throws Exception{
        try {
            FileInputStream fis =
                    new FileInputStream("sentMails.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            sentMail = (ArrayList<Email>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            System.out.println("error!");
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        for (Email email: sentMail){
            if (email.getDate().equals(LocalDate.now())
                    && email.getSubject().
                    equals("Birthday Wishes"))
                todayBorn.add(email.getEmail());
        }
    }
}
