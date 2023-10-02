public class Official extends Recipient{
    private final String Designation;
    public Official(String name, String emailAddress,
                    String designation) {
        super(name, emailAddress);
        this.Designation = designation;
        this.setBirthday(null);
        recipientCount++;
    }
}
