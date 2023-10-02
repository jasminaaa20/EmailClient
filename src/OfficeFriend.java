import java.time.LocalDate;

public class OfficeFriend extends Recipient{
    private final String designation;
    public OfficeFriend(String name,
                        String emailAddress,
                        String designation, LocalDate birthday) {
        super(name, emailAddress);
        this.setBirthday(birthday);
        this.designation = designation;
        recipientCount++;
        sendWish();
        recipients.add(this);
    }

    private void sendWish() {
        if (this.getBirthday().getMonthValue()
                == LocalDate.now().getMonthValue()
                && this.getBirthday().getDayOfMonth()
                == LocalDate.now().getDayOfMonth()
                && !(Deserialize.todayBorn.
                contains(this.getEmailAddress()))){
            Email email = new Email(this.getEmailAddress(),
                    "Birthday Wishes",
                    "Hugs and love on your birthday - "
                            + SENDER);
            email.sendEmail();
        }
    }
}
