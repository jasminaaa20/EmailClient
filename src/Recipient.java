import java.time.LocalDate;

public abstract class Recipient implements IRecipient{
    private final String name;
    private final String emailAddress;
    private LocalDate birthday;
    protected final String SENDER = "Akmal";
    public static int recipientCount;
    public Recipient(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
    @Override
    public LocalDate getBirthday() {
        return birthday;
    }
    @Override
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
