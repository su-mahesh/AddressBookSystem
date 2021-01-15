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

	private Map<String, Map> AddressBook = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	
	private Map<String, String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	
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
		Map<String, String> contact = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		Scanner sc = new Scanner(System.in);
		String searchName = new String();
		String field = new String();
		int choice = 1;
		System.out.print("Enter person's name: ");		
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
		System.out.print("Enter person name: ");		
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
		String AddressBookName = new String("default");
		String AddressBookNameTemp = new String(); 
		
		AddressBookMain AddressBookObject1 = new AddressBookMain();
		
		HashMap<String, AddressBookMain> AddressBook = new HashMap<String, AddressBookMain>();
		
		AddressBook.put(AddressBookName, AddressBookObject1);
		
		System.out.println("\n***Welcome to Address Book Program***");

		
		while(choice != 7){
		AddressBookMain AddressBookObject = new AddressBookMain();
			System.out.println("******** address book : "+AddressBookName+" ********");
			System.out.println("\n1. create contact         2. edit contact by name");
			System.out.println("3. delete contact by name 4. create address book");
			System.out.println("5. delete address book    6. change address book   ");
			System.out.println("7. exit");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					 (AddressBook.get(AddressBookName)).createContact();
					break;
				case 2:
					(AddressBook.get(AddressBookName)).editContactByName();
					break;
				case 3:
					(AddressBook.get(AddressBookName)).deleteContactByName();
					break;
				case 4:
					System.out.println("Enter address book name");
					sc.nextLine();
					AddressBookNameTemp = sc.nextLine();
					
					if(!AddressBook.containsKey(AddressBookNameTemp)){
						AddressBook.put(AddressBookNameTemp, AddressBookObject);
						AddressBookName = AddressBookNameTemp;
					}
					else
						System.out.println("address book already exist");	
					break;	 
				case 5:
					System.out.println("Enter address book name");
					sc.nextLine();
					AddressBookNameTemp = sc.nextLine();
					if(AddressBook.containsKey(AddressBookNameTemp)){
						AddressBook.remove(AddressBookNameTemp);
						System.out.println("address book deleted");
						if(AddressBookNameTemp.equalsIgnoreCase(AddressBookName))
							AddressBookName = "default";
						if(AddressBookNameTemp.equalsIgnoreCase("default"))
							AddressBook.put(AddressBookName, AddressBookObject);
					}
					else
						System.out.println("address book doesn't exist");	
					break;	 
				case 6:
					System.out.println("Enter address book name");
					sc.nextLine();
					AddressBookNameTemp = sc.nextLine();
					if(AddressBook.containsKey(AddressBookNameTemp)){
					
						AddressBook.put(AddressBookName, AddressBookObject);
						AddressBookName = AddressBookNameTemp;
						System.out.println("address book added");	
					}
					else
						System.out.println("address book doesn't exist");	
					break;
				case 7:
					break;		
				default:		
					System.out.println("wrong choice");
			}
			AddressBookObject = null;
		}
	}


}
