import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateNewRecipient {
    public static void addRecipient(String recipientDetails) {
        String[] type = recipientDetails.split(": ");
        String[] details = type[1].split(",");
        switch (type[0]) {
            case "Official" -> new Official(details[0],
                    details[1], details[2]);
            case "Office_friend" ->
                    new OfficeFriend(details[0], details[1],
                            details[2], getBirthday(details[3]));
            case "Personal" -> new PersonalFriend(details[0],
                    details[1], details[2],
                    getBirthday(details[3]));
        }
    }
    private static LocalDate getBirthday(String date) {
        return LocalDate.parse(date,
                DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
