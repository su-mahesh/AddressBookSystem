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

	private Map<String,Map> AddressBook = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	
	private Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	
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
		contact.put("Phone number", phoneNumber); 
		contact.put("Email", email);	
			
		AddressBook.put(firstName+" "+lastName, contact);		
	}
	
	public void editContactByName(){
		Map<String,String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		Scanner sc = new Scanner(System.in);
		String searchName = new String();
		String field = new String();
		int choice = 1;
		System.out.print("Enter contact name: ");		
		searchName = sc.nextLine();
		
		if(AddressBook.containsKey(searchName)){
			
			contact = AddressBook.get(searchName);
			
			while(choice > 0 && choice < 9){
								
				System.out.println("\n**edit contact**\n1. first name   2. last name");
				System.out.println("3. address      4. city");
				System.out.println("5. state        6. zip");
				System.out.println("7. phone number 8. email");
				System.out.println("0. exit");
										
				choice = sc.nextInt();
				sc.nextLine();	
				if(choice < 1 || choice > 8)
					break;
				AddressBook.remove(searchName);	
				System.out.print("Enter field: ");
				
				field = sc.nextLine();	
									
				switch(choice){
					case 1:	contact.replace("First Name", field);
								searchName = field+" "+contact.get("Last Name");
							break;
					case 2:	contact.replace("Last Name", field);		
								searchName = contact.get("First Name")+" "+field;											
							break;
					case 3:	contact.replace("Address", field);							
							break;
					case 4:	contact.replace("City", field);							
							break;
					case 5:	contact.replace("State", field);
							break;
					case 6:	contact.replace("Zip", field);
							break;
					case 7:	contact.replace("Phone number", field);
							break;
					case 8:	contact.replace("Email", field);
							break;
					case 0:	
							break;
					default:				
				}
			AddressBook.put(searchName, contact);	
			}
		}
		else
			System.out.println("Contact Not Found");
	}
	public void deleteContactByName(){
		Scanner sc = new Scanner(System.in);
		String searchName = new String();
		System.out.print("Enter contact name: ");		
		searchName = sc.nextLine();
		
		if(AddressBook.containsKey(searchName)){
			AddressBook.remove(searchName);	
			System.out.println("Contact Deleted");		
		}	
		else
			System.out.println("Contact Not Found");	
	}

	public static void main(String argd[])	{
		Scanner sc = new Scanner(System.in);
		int choice = 1;
		AddressBookMain AddressBook = new AddressBookMain();
		System.out.println("***Welcome to Address Book Program***");
		while(choice != 4){
			System.out.println("\n1. create contact         2. edit contact by name");
			System.out.println("3. delete contact by name 4. exit");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					AddressBook.createContact();
					break;
				case 2:
					AddressBook.editContactByName();
					break;
				case 3:
					AddressBook.deleteContactByName();
					break;
				case 4:
					break;	
				default:		
					System.out.println("wrong choice");
			}
		}
	}


}
