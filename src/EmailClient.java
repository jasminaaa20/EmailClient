import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmailClient {
    public static void main(String[] args) throws Exception {
// create clientList file if it doesn't exist
        WriteNewRecipient write = new WriteNewRecipient();
        write.checkClientFile();
        MailSerialization serialization = new MailSerialization();
// create serialized file if it doesn't exist
        serialization.checkSerializationFile();
// deserialize sentMails file
        Deserialize.deserialize();
// to create objects for each client
        ReadRecipients.readRecipients();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
Enter option type:\s
1 - Adding a new recipient
2 - Sending an email
3 - Printing out all the recipients who have birthdays
4 - Printing out details of all the emails sent
5 - Printing out the number of recipient objects in the application""");
        byte option = Byte.parseByte(scanner.nextLine());
        switch (option) {
            case 1 -> {
// input format - Official: animal,nimal@gmail.com,ceo
// Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12
// Use a single input to get all the details of a recipient
// code to add a new recipient
// store details in clientList.txt file
// Hint: use methods for reading and writing files
                String recipientDetails = scanner.nextLine();
                CreateNewRecipient.addRecipient(recipientDetails);
                write.writeRecipient(recipientDetails);
            }

            case 2 -> {
// input format - email, subject, content
                String mailingInfo = scanner.nextLine();
                String[] mailingInformation
                        = mailingInfo.strip().split(", ", 3);
                Email email = new Email(mailingInformation[0]
                        , mailingInformation[1], mailingInformation[2]);
                email.sendEmail();
            }
            case 3 -> {
// input format - yyyy/MM/dd (ex: 2018/09/17)
// code to print recipients who have birthdays
// on the given date
                LocalDate date = LocalDate.parse(scanner.nextLine()
                        , DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                CheckBirthday checkBirthday = new CheckBirthday();
                checkBirthday.checkBirthday(IRecipient.recipients, date);
            }
            case 4 -> {
// input format - yyyy/MM/dd (ex: 2018/09/17)
// code to print the details of all the emails sent
// on the input date
                LocalDate date1 = LocalDate.parse(scanner.nextLine()
                        , DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                for (Email mail : Deserialize.sentMail)
                    if (mail.getDate().equals(date1))
                        System.out.println
                                (mail.getEmail()
                                        + "," + mail.getSubject());
            }
            case 5 ->
// code to print the number of recipient objects
// in the application
                    System.out.println(Recipient.recipientCount);
        }
// start email client
// code to create objects for each recipient in clientList.txt
// use necessary variables, methods and classes
// serialize updated file
        serialization.serialize(Deserialize.sentMail);
    }
}