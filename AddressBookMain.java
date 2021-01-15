import java.util.*;

class AddressBookMain
{
	private String firstName;
	private String lastName;
	private String address;	
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	HashMap<String,HashMap> AddressBook = new HashMap<String,HashMap>();
	
	HashMap<String,String> contact = new HashMap<String,String>();
	Scanner sc = new Scanner(System.in);

	public void createContact(){
			System.out.print("Enter first name: ");
			firstName = sc.nextLine();
			
			System.out.print("Enter last name: ");
			lastName = sc.nextLine();
			
			System.out.print("Enter address: ");
			address = sc.nextLine();
			
			System.out.print("Enter city: ");
			city = sc.nextLine();
			
			System.out.print("Enter state: ");
			state = sc.nextLine();
			
			System.out.print("Enter zip: ");
			zip = sc.nextLine();
			
			System.out.print("Enter phone number: ");
			phoneNumber = sc.nextLine();
			
			System.out.print("Enter email: ");
			email = sc.nextLine();
			
			contact.put("First Name", firstName); 
			contact.put("Last Name", lastName);
			contact.put("Address", address); 
			contact.put("City", city); 
			contact.put("State", state);
			contact.put("Zip", zip); 
			contact.put("Phone Number", phoneNumber); 
			contact.put("Email", email);					
	}

	public static void main(String argd[])	{
	
	
		AddressBookMain AddressBook = new AddressBookMain();
		System.out.println("***Welcome to Address Book Program***");
		
		AddressBook.createContact();
		
	}


}
