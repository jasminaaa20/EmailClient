import java.time.LocalDate;
import java.util.ArrayList;

public interface IRecipient {
    ArrayList<IRecipient> recipients = new ArrayList<>();
    String getName();
    String getEmailAddress();
    LocalDate getBirthday();
    void setBirthday(LocalDate birthday);
}
