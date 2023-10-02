import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteNewRecipient {
    public void checkClientFile() {
        try {
            File clientFile = new File("clientList.txt");
            if (!(clientFile.exists()))
                if (clientFile.createNewFile())

                    System.out.println("clientFile.txt created");
        }catch (IOException e){
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
    public void writeRecipient(String recipientDetails) {
        try{
            var fileWriter =
                    new FileWriter
                            ("clientList.txt",true);
            fileWriter.write(recipientDetails + "\n");
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
