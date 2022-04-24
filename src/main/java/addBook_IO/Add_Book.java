package addBook_IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Add_Book {
	private String first;
	private String last;
	private String add;
	private String city;
	private String state;
	private int zip;
	private long phoneNo;
	private String email;
	ArrayList<Contact> contactBook = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	public void readData() {
		boolean duplicate;
		System.out.println("Enter the first name : ");
		first = s.next();
		System.out.println("Enter the last name : ");
		last = s.next();
		System.out.println("Enter the address : ");
		add = s.next();
		System.out.println("Enter the city : ");
		city = s.next();
		System.out.println("Enter the state : ");
		state = s.next();
		System.out.println("Enter the zip code : ");
		zip = s.nextInt();
		System.out.println("Enter the phone number : ");
		phoneNo = s.nextLong();
		System.out.println("Enter the email : ");
		email = s.next();
		Add_Book book = new Add_Book();
		duplicate = book.DuplicateNameCheck( first ,last);
		if(duplicate == false) {
			Contact contact = new Contact(first , last , add , city , state , zip , phoneNo , email);
			contactBook.add(contact);
			System.out.println("\nContact added Successfully.");
		}
		else {
			System.out.println("This contact is already exist");
		}
	}

	public boolean DuplicateNameCheck(String first,String last) {
		int i;
		boolean duplicate = false ;
		for(i=0;i<contactBook.size();i++) {
			if(contactBook.get(i).getFirstName().equals(first)&&contactBook.get(i).getLastName().equals(last)) {
				duplicate = true;
				break;
			}
		}
		return duplicate;
	}
	public void DataEdit(String name) {
		int i,ans;
		for(i=0;i<contactBook.size();i++) {
			if(contactBook.get(i).getFirstName().equals(name)) {
				do {
					System.out.print("\nSelect option to edit----\n1.First_name \n2.Last_name \n3.Address \n4.City \n5.State \n6.Zip_code \n7.Phone_number \n8.Email :- ");
					int ch = s.nextInt();
					switch(ch) {
					case 1:
						System.out.print("Enter new first name :- ");
						contactBook.get(i).setFirstName(s.next());
						System.out.println("First name is updated.");
						break;
					case 2:
						System.out.print("Enter new last name :- ");
						contactBook.get(i).setLastName(s.next());
						System.out.println("Last name is updated.");
						break;
					case 3:
						System.out.print("Enter new address :- ");
						contactBook.get(i).setAddress(s.next());
						System.out.println("Address is updated.");
						break;
					case 4:
						System.out.print("Enter new city :- ");
						contactBook.get(i).setCity(s.next());
						System.out.println("City is updated.");
						break;
					case 5:
						System.out.print("Enter new state :- ");
						contactBook.get(i).setState(s.next());
						System.out.println("State is updated.");
						break;
					case 6:
						System.out.print("Enter new zip code :- ");
						contactBook.get(i).setZip(s.nextInt());
						System.out.println("Zip code is updated.");
						break;
					case 7:
						System.out.print("Enter new phone number :- ");
						contactBook.get(i).setPhoneNo(s.nextLong());
						System.out.println("Phone number is updated.");
						break;
					case 8:
						System.out.print("Enter new email :- ");
						contactBook.get(i).setEmail(s.next());
						System.out.println("Email is updated.");
						break;
					}
					System.out.println("Enter 1 if you want to continue");
					ans = s.nextInt();
				}while(ans == 1);
			}
			else
				System.out.println("Please enter the correct first name");
		}
	}

	public void DataDelete() {
		int i;
		System.out.println("\nEnter first name to delete : ");
		String name = s.next();
		for(i=0;i<contactBook.size();i++) {
			if(contactBook.get(i).getFirstName().equals(name)) {
				contactBook.remove(i);
				System.out.println("deleted");
			}
			else {
				System.out.println("not deleted");
			}
		}
	}

	public void searchPersonByState(String state) {
		ArrayList<Contact> list = (ArrayList<Contact>) contactBook.stream().filter(contactName -> contactName.getState().equals(state))
				.collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("Name: " + contact.getFirstName() +" "+ contact.getLastName());
		}
	}

	public void searchPersonByCity(String city) {
		ArrayList<Contact> list = (ArrayList<Contact>) contactBook.stream().filter(contactName -> contactName.getCity().equals(city))
				.collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("First Name: " + contact.getFirstName()+ "  " + contact.getLastName());
		}
	}
	public void viewPersonByState(String state) {
		ArrayList<Contact> list = (ArrayList<Contact>) contactBook.stream().filter(contactName -> contactName.getState().equals(state))
				.collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("Name: " + contact.getFirstName() +" "+ contact.getLastName());
			System.out.println("State: " + contact.getState());
			System.out.println("\n");
		}
	}

	public void viewPersonByCity(String city) {
		ArrayList<Contact> list = (ArrayList<Contact>) contactBook.stream().filter(contactName -> contactName.getCity().equals(city))
				.collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("First Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("City: " + contact.getCity());
			System.out.println("\n");
		}
	}
	public int countPersonsByState(String state) {
		int count= 0;
		ArrayList<Contact> list = (ArrayList<Contact>) contactBook.stream().filter(contactName -> contactName.getState().equals(state))
				.collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			count ++;
		}
		return count;
	}

	public int countPersonsByCity(String city) {
		int count = 0 ;
		ArrayList<Contact> list = (ArrayList<Contact>) contactBook.stream().filter(contactName -> contactName.getCity().equals(city))
				.collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			count +=1;
		}
		return count;
	}

	public void sortByFirstName() {
		ArrayList<Contact>  sortedList = (ArrayList<Contact>) contactBook.stream().sorted((type1, type2) -> (type1.getFirstName().compareTo(type2.getFirstName()))).collect(Collectors.toList());
		for (Contact contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
		}
	}
	public void sortByCity() {
		ArrayList<Contact>  sortedList = (ArrayList<Contact>) contactBook.stream().sorted((type1, type2) -> (type1.getCity().compareTo(type2.getCity()))).collect(Collectors.toList());
		for (Contact contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("City: " + contact.getCity());
			System.out.println("\n");
		}
	}
	public void sortByState() {
		ArrayList<Contact>  sortedList = (ArrayList<Contact>) contactBook.stream().sorted((type1, type2) -> (type1.getState().compareTo(type2.getState()))).collect(Collectors.toList());
		for (Contact contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("State: " +contact.getState());
			System.out.println("\n");
		}
	}
	public void sortByZip() {
		ArrayList<Contact>  sortedList = (ArrayList<Contact>) contactBook.stream().sorted((type1, type2) -> (int)(type1.getZip() - type2.getZip())).collect(Collectors.toList());
		for (Contact contact : sortedList) {
			System.out.println("Name: " + contact.getFirstName()+ "  " + contact.getLastName());
			System.out.println("Zip: " + contact.getZip());
			System.out.println("\n");
		}
	}
	
	public void DisplayContacts() {
		System.out.println("\nContacts Present in Address Book:");
		for(int i=0;i<contactBook.size();i++) {
			System.out.println(contactBook.get(i));
		}
	}
	
	 public void writeData() {
	        StringBuffer personBuffer = new StringBuffer();
	        contactBook.forEach(person -> {
	            String personDataString = person.toString().concat("\n");
	            personBuffer.append(personDataString);
	        });
	        try {
	            Files.write(Paths.get("Data.txt"), personBuffer.toString().getBytes());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void readFileData() {
	        try {
	            Files.lines(new File("Data.txt").toPath()).map(String::trim).forEach(System.out::println);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		 public void writeDataCSV() {
		        StringBuffer personBuffer = new StringBuffer();
		        contactBook.forEach(person -> {
		            String personDataString = person.toString().concat("\n");
		            personBuffer.append(personDataString);
		        });
		        try {
		            Files.write(Paths.get("Data.csv"), personBuffer.toString().getBytes());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    public void readFileDataCSV() {
		        try {
		            Files.lines(new File("Data.csv").toPath()).map(String::trim).forEach(System.out::println);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }  
}