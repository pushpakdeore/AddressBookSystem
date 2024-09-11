import java.util.Scanner;

class Contact{
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private  String state;
    private  String zip;
    private String contact;
    private String email;

    Contact(String firstname,String lastname,String address,String city,String state,String zip,String contact,String email){
        this.firstname =firstname;
        this.lastname =lastname;
        this.address =address;
        this.city =city;
        this.state =state;
        this.zip=zip;
        this.contact=contact;
        this.email =email;
    }

    public String getFirstName() { return firstname; }
    public void setFirstName(String firstName) { this.firstname = firstName; }

    public String getLastName() { return lastname; }
    public void setLastName(String lastName) { this.lastname = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getPhoneNumber() { return contact; }
    public void setPhoneNumber(String phoneNumber) { this.contact = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public void display(){
        System.out.println("Fist name: "+firstname);
        System.out.println("Last name: "+lastname);
        System.out.println("Address: "+address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Phone Number: " +contact);
        System.out.println("Email: " + email);
    }

}
class AddressBook {
    private Contact[] contacts;
    private int contactCount;

    public AddressBook(int size) {
        contacts = new Contact[size];
        contactCount = 0;
    }

    public void addContact(Contact newContact) {
        if (contactCount < contacts.length) {
            contacts[contactCount] = newContact;
            contactCount++;
            System.out.println("Contact added Successfully");
        } else {
            System.out.println("Address book is full ,cannot add more contact");
        }

    }

    public void displayAllContact() {
        if (contactCount == 0)
        {
            System.out.println("no contact available");
        }else{
            for (int i = 0; i < contactCount; i++) {
                System.out.println("contact " + (i + 1) + " :");
                contacts[i].display();
            }
        }
    }
    public Contact findContact(String firstName){
        for (int i =0;i<contactCount;i++){
            if(contacts[i].getFirstName().equalsIgnoreCase(firstName)){
                return contacts[i];
            }
        }return null;

    }

    public void updateContact(String firstName){
        Contact contact =  findContact(firstName);

            if(contact !=null){
                Scanner sc =new Scanner(System.in);

                System.out.println("Edit contact :");
                contact.display();

                System.out.print("Enter new First Name (leave blank to keep unchanged): ");
                String newFirstName = sc.nextLine();
                if (!newFirstName.isEmpty()) contact.setFirstName(newFirstName);

                System.out.print("Enter new Last Name (leave blank to keep unchanged): ");
                String newLastName = sc.nextLine();
                if (!newLastName.isEmpty()) contact.setLastName(newLastName);

                System.out.print("Enter new Address (leave blank to keep unchanged): ");
                String newAddress = sc.nextLine();
                if (!newAddress.isEmpty()) contact.setAddress(newAddress);

                System.out.print("Enter new City (leave blank to keep unchanged): ");
                String newCity = sc.nextLine();
                if (!newCity.isEmpty()) contact.setCity(newCity);

                System.out.print("Enter new State (leave blank to keep unchanged): ");
                String newState = sc.nextLine();
                if (!newState.isEmpty()) contact.setState(newState);

                System.out.print("Enter new Zip (leave blank to keep unchanged): ");
                String newZip = sc.nextLine();
                if (!newZip.isEmpty()) contact.setZip(newZip);

                System.out.print("Enter new Phone Number (leave blank to keep unchanged): ");
                String newContact = sc.nextLine();
                if (!newContact.isEmpty()) contact.setPhoneNumber(newContact);

                System.out.print("Enter new Email (leave blank to keep unchanged): ");
                String newEmail = sc.nextLine();
                if (!newEmail.isEmpty()) contact.setEmail(newEmail);

                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Contact with the given first name not found.");
            }

        }
    public void deleteContact(String fistName){
        for (int i =0;i<contactCount;i++){
            if(contacts[i].getFirstName().equalsIgnoreCase(fistName)){
                for(int j =i;j<contactCount-1;j++){
                    contacts[j]=contacts[j+1];
                }
                contacts[contactCount-1] = null;
                contactCount--;
                System.out.println("Contact deleted successfully");
                return;
            }

        }
        System.out.println("contact not forund with name");
    }
}



class AddressBookSystem {
    private AddressBook[] addressBooks;
    private String[] bookNames;
    private int bookCount;

    public AddressBookSystem(int size) {
        addressBooks = new AddressBook[size];
        bookNames = new String[size];
        bookCount = 0;
    }

    public void addAddressBook(String name, int size) {
        if (bookCount < addressBooks.length) {
            addressBooks[bookCount] = new AddressBook(size);
            bookNames[bookCount] = name;
            bookCount++;
            System.out.println("Address book '" + name + "' added.");
        } else {
            System.out.println("Cannot add more address books.");
        }
    }

    public AddressBook findAddressBook(String name) {
        for (int i = 0; i < bookCount; i++) {
            if (bookNames[i].equalsIgnoreCase(name)) {
                return addressBooks[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookSystem addressBookSystem = new AddressBookSystem(5);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 Add new Address Book");
            System.out.println("2 Access Address Book");
            System.out.println("3 Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name of new Address Book: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter size of Address Book: ");
                    int size = sc.nextInt();
                    sc.nextLine();
                    addressBookSystem.addAddressBook(bookName, size);
                    break;

                case 2:
                    System.out.print("Enter name of the Address Book to access: ");
                    String name = sc.nextLine();
                    AddressBook addressBook = addressBookSystem.findAddressBook(name);
                    if (addressBook != null) {
                        while (true) {
                            System.out.println("1 Add new Contact ");
                            System.out.println("2 Display Contacts");
                            System.out.println("3 Edit Contact ");
                            System.out.println("4 Delete Contact");
                            System.out.println("5 Go back to main menu");
                            System.out.print("Choose an option: ");
                            int subChoice = sc.nextInt();
                            sc.nextLine();

                            switch (subChoice) {
                                case 1:
                                    Contact newContact = createNewContact(sc);
                                    addressBook.addContact(newContact);
                                    break;
                                case 2:
                                    addressBook.displayAllContact();
                                    break;
                                case 3:
                                    System.out.print("Enter the first name of the contact to edit: ");
                                    String firstName = sc.nextLine();
                                    addressBook.updateContact(firstName);
                                    break;
                                case 4:
                                    System.out.print("Enter the first name of the contact to delete: ");
                                    String firstNameDel = sc.nextLine();
                                    addressBook.deleteContact(firstNameDel);
                                    break;
                                case 5:
                                    System.out.println("Returning to main menu...");
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                            }
                            if (subChoice == 5) break;
                        }
                    } else {
                        System.out.println("Address book not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static Contact createNewContact(Scanner sc) {
        System.out.print("Enter First Name: ");
        String firstname = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastname = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Zip: ");
        String zip = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String contact = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        return new Contact(firstname, lastname, address, city, state, zip, contact, email);
    }
}
