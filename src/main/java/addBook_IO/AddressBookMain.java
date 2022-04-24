package addBook_IO;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ch,count;
		int ans;
		String state, city;
		Add_Book c = new  Add_Book();
		do {
			System.out.println("Enter the choice : ");
			System.out.println("1.Add ");
			System.out.println("2.Display");
			System.out.println("3.Edit");
			System.out.println("4.Delete");
			System.out.println("5.Search By State name");
			System.out.println("6.Search By City name");
			System.out.println("7.view By State name");
			System.out.println("8.View By City name");
			System.out.println("9.Count Persons By City");
			System.out.println("10.Count Persons By State");
			System.out.println("11.Sort by first name");
			System.out.println("12.Sort by city name");
			System.out.println("13.Sort by state name");
			System.out.println("14.Sort by zip code");
			System.out.println("15.Write data to file");
			System.out.println("16.Read data from file");
			System.out.println("17.Write data to csv file");
			System.out.println("18.Read data from csv file");
			ch= s.nextInt();
			switch(ch) {
			case 1: 
				c.readData();
				break;
			case 2:
				c.DisplayContacts();
				break;
			case 3:
				System.out.println("\nEnter first name to edit :- ");
				String name = s.next();
				c.DataEdit(name);
				break;
			case 4:
				c.DataDelete();
				break;
			case 5:
				System.out.println("\nEnter the state to display details :- ");
				state = s.next();
				c.searchPersonByState(state);
				break;
			case 6:
				System.out.println("\nEnter the city to display details :- ");
				city = s.next();
				c.searchPersonByCity(city);
				break;
			case 7:
				System.out.println("\nEnter the state :- ");
				state = s.next();
				c.viewPersonByState(state);;
				break;
			case 8:
				System.out.println("\nEnter the city :- ");
				city = s.next();
				c.viewPersonByCity(city);;
				break;
			case 9:
				System.out.println("\nEnter the city to find person in city :- ");
				city = s.next();
				count = c.countPersonsByCity(city);
				System.out.println("Number of persons by city "+city+" is "+count);
				break;
			case 10:
				System.out.println("\nEnter the state to find person in state  :- ");
				state = s.next();
				count = c.countPersonsByState(state);
				System.out.println("Number of persons by state "+state+" is "+count);
				break;
			case 11:
				c.sortByFirstName();
				break;
			case 12:
				c.sortByCity();
				break;
			case 13:
				c.sortByState();
				break;
			case 14:
				c.sortByZip();
				break;
			case 15:
				c.writeData();
				break;
			case 16:
				c.readData();
				break;
			case 17:
				c.writeDataCSV();
				break;
			case 18:
				c.readFileDataCSV();
				break;
			}System.out.println("Do you want to continue? if yes press '1' ");
			ans = s.nextInt();
		}while(ans == 1);
		s.close();
	}
}