import java.time.LocalDate;

public class PersonalFriend extends Recipient{
    private final String nickname;
    public PersonalFriend(String name, String nickname,
                          String emailAddress,
                          LocalDate birthday) {
        super(name, emailAddress);
        this.setBirthday(birthday);
        this.nickname = nickname;
        recipientCount++;
        sendWish();
        recipients.add(this);
    }
    private void sendWish() {
        if (this.getBirthday().getMonthValue()
                == LocalDate.now().getMonthValue()
                && this.getBirthday().getDayOfMonth()
                == LocalDate.now().getDayOfMonth()
                && !(Deserialize.todayBorn
                .contains(this.getEmailAddress()))){
            Email email = new Email(this.getEmailAddress(),
                    "Birthday Wishes",
                    "Wish you a happy birthday - " + SENDER);
            email.sendEmail();
        }
    }
}
