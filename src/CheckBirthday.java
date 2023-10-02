import java.time.LocalDate;
import java.util.ArrayList;

public class CheckBirthday {
    public void checkBirthday(ArrayList<IRecipient> recipients,
                              LocalDate date) {
        ArrayList<String> dayBorn= new ArrayList<>();
        for (IRecipient recipient: recipients) {
            if (recipient.getBirthday().getMonthValue()
                    == date.getMonthValue()
                    && recipient.getBirthday().
                    getDayOfMonth() == date.getDayOfMonth()
                    && !(dayBorn.contains(recipient.
                    getName() + ","
                    + recipient.getEmailAddress())))
                dayBorn.add(recipient.getName()
                        + "," + recipient.getEmailAddress());
        }
        for (String person : dayBorn)
            System.out.println(person);
    }
}
