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

public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book");
        Contact pushpak =new Contact("pushpak","deore","At po Karnjad","Nashik","Maharashtra","423301","8080685915","deorepushpak@gmail.com");
        pushpak.display();
    }
}
