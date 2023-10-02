import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MailSerialization {
    public void checkSerializationFile() {
        File sentMailFile
                = new File("sentMails.ser");
        if (!(sentMailFile.exists())) {
            try {
                FileOutputStream
                        fos
                        = new
                        FileOutputStream("sentMails.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(Deserialize.sentMail);
                oos.close();
                fos.close();
                System.out.println("sentMails serialized");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    public void serialize(ArrayList<Email> sentMails) {
        try {
            FileOutputStream fos =
                    new FileOutputStream("sentMails.ser");
            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);
            oos.writeObject(sentMails);
            oos.close();
            fos.close();
        } catch (IOException ioe) {

            ioe.printStackTrace();
        }
    }
}
