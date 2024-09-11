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

}
public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book");
        AddressBook addressBook =new AddressBook(4);
        Scanner sc =new Scanner(System.in);

        while (true){
            System.out.println("Menu :");
            System.out.println("1 Add new Contact ");
            System.out.println("2 Display Conatcts");
            System.out.println( "3 Exit :");
            System.out.print("Choose the option :");
            int choice = sc.nextInt();
//            sc.nextLine();

            switch (choice){
                case 1:
                    // new contact
                    Contact newContact =creatNewContact(sc);
                    addressBook.addContact(newContact);
                    break;

                case 2:
                    addressBook.displayAllContact();
                    break;

                case 3:
                    System.out.println("Exit addres Book ");
                    return;

                default:
                    System.out.println("Invalid option ");
            }


        }



    }
    private static  Contact creatNewContact(Scanner sc){//use Scanner to take input
        System.out.print("Enter First Name: ");
        sc.nextLine(); //new line
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
        //we creat contact
        return  new Contact(firstname,lastname,address,city,state,zip,contact,email);
    }
}
