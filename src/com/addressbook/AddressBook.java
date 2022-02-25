package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

	HashMap<String, ContactPerson> list = new HashMap<String, ContactPerson>();

	Scanner scanner = new Scanner(System.in);
	static AddressBook book = new AddressBook();

	public static void main(String[] args) {
		System.out.println("Welcome to adressbook");

		book.getUserChoice();
	}

	private void updateContact() {
		System.out.println("Enter EmailId to update");
		String EmailId = scanner.next();

		if (list.containsKey(EmailId) == false) {
			System.out.println("provided email Id is wrong !");
			updateContact();
		}

		ContactPerson person = list.get(EmailId);
		System.out.println("Select choice to update \n 1: First name \n" + "2: Last Name \n" + "3: Address \n"
				+ "4: City \n" + "5: State \n" + "6: ZipCode \n " + "7: MobileNumber");

		int selectedOption = scanner.nextInt();
		switch (selectedOption) {
		case 1:
			System.out.println("Enter First Name ");
			String FirstName = scanner.next();
			person.setFirstName(FirstName);
			break;
		case 2:
			System.out.println("Enter Last Name");
			String LastName = scanner.next();
			person.setLastName(LastName);
			break;
		case 3:
			System.out.println("Enter Address");
			String Address = scanner.next();
			person.setAddress(Address);
			break;
		case 4:
			System.out.println("Enter City");
			String City = scanner.next();
			person.setCity(City);
			break;
		case 5:
			System.out.println("Enter State");
			String State = scanner.next();
			person.setState(State);
			break;
		case 6:
			System.out.println("Enter Zip Code");
			String ZIPCode = scanner.next();
			person.setZIPCode(ZIPCode);
			break;
		case 7:
			System.out.println("Enter Phone Number");
			String MobileNo = scanner.next();
			person.setMobileNo(MobileNo);
			break;
		default:
			System.out.println("please select valid option");
			break;
		}
	}

	private void deletePerson() {
		System.out.println("Enter EmailId to delete");
		String EmailId = scanner.next();
		if (!list.containsKey(EmailId)) {
			System.out.println("Provided email Id is not found");
			deletePerson();
		}
		list.remove(EmailId);
		System.out.println("Deleted Successesfully.");
	}

	private ContactPerson getUserInput() {
		System.out.print("Enter FirstName:");
		String FirstName = scanner.next();

		System.out.println("Enter LastName: ");
		String LastName = scanner.next();

		System.out.print("Enter Address: ");
		String Address = scanner.next();

		System.out.print("Enter City: ");
		String City = scanner.next();

		System.out.print("Enter State: ");
		String State = scanner.next();

		System.out.print("Enter ZipCode: ");
		String ZIPCode = scanner.next();

		System.out.print("Enter Mobile Number: ");
		String MobileNo = scanner.next();

		System.out.println("Enter Email Id:");
		String emailId = scanner.next();

		ContactPerson person = new ContactPerson();
		person.setFirstName(FirstName);
		person.setLastName(LastName);
		person.setAddress(Address);
		person.setCity(City);
		person.setZIPCode(ZIPCode);
		person.setState(State);
		person.setMobileNo(MobileNo);
		person.setEmailId(emailId);
		System.out.println(person);
		return person;
	}

	private void getUserChoice() {
		boolean isTerminate = false;
		while (!isTerminate) {
			System.out.println("1:Adding new person \n" + "2:Print address book \n" + "3:Update the person details \n "
					+ "4:Delete the person \n" + "5:Exit");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				ContactPerson person = book.getUserInput();
				list.put(person.getEmailId(), person);
				break;

			case 2:
				System.out.println(list);
				break;
			case 3:
				book.updateContact();
				break;
			case 4:
				book.deletePerson();
				break;
			case 5:
				isTerminate = true;
				break;
			default:
				System.out.println("please select valid option");
				break;
			}
		}

	}
}