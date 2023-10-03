# Email Client Project

An efficient and modular email client designed to perform various operations related to email management. The project is structured in a clear manner with classes and functions focusing on single responsibilities for better maintainability.

## Features:

1. **File Checks**: Ensure essential files for storing recipient details and serialized emails exist. If not, they are created.
2. **Menu-Driven Interaction**: User is provided with options to:
   - Add a new recipient.
   - Send an email.
   - Print recipients having birthdays on a specific date.
   - Display details of all emails sent on a specific date.
   - Display the count of recipient objects in the application.
3. **Birthday Check**: For recipients whose birthday data is available, the application automatically sends birthday wishes.
4. **Serialization**: Sent emails are serialized for persistence, ensuring a record is kept even after the application is closed.
5. **Recipient Management**: Ability to add different types of recipients such as Official, Office Friends, and Personal Friends.

## Directory Structure:

- **src**: Contains all the source code for the project.
- **Libraries**: Contains all the libraries used in the project.

## Usage:

1. Run the `EmailClient` class to start the email client.
2. Follow on-screen prompts to perform desired operations.
3. For sending emails, ensure you have proper credentials and configurations.

## Installation:

1. Clone the repository.
2. Navigate to the project directory.
3. Add the files in Libraries folder to the project libraries.
4. Compile and run the `EmailClient` class.
