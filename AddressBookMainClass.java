package com.Project.AddressBook;
import java.util.*;
public class AddressBookMainClass {

	public static void main(String[] args) {

		
		Scanner sc=new Scanner(System.in);
        AddressBookVariables addressBookVariables=new AddressBookVariables();
        AddressBookOperations addressBookOperation = new AddressBookOperations();
       
        boolean terminate=false;
        while(terminate != true)
        {
            System.out.println("1: For add new Address");
            System.out.println("2: To Print all From Address Hash Map");
            System.out.println("3: To Print address by Phone Number");
            System.out.println("4: To Update the existing address");
            System.out.println("5: To delete the Address by Phone Number");
            System.out.println("6: To sort the Address by Zip Code");
            System.out.println("7: To short the Address First Name");
            System.out.println("8: For terminate the program");
            int option=sc.nextInt();
            switch (option)
            {
                //
                case 1:
                    addressBookVariables=addressBookOperation.newAddressBook();
                    System.out.println(addressBookOperation.save(addressBookVariables.getPhone(), addressBookVariables));
                    break;
                
                case 2:
                    addressBookOperation.printAllDetails();
                    break;
                    
                case 3:
                    System.out.println("Enter the Phone Number to Search");
                    long phoneNumber=sc.nextLong();
                    addressBookOperation.fetchDetailById(phoneNumber);
                    break;
                
                case 4:
                    System.out.println("enter the Phone Number to update");
                    long key=sc.nextLong();
                    addressBookVariables=addressBookOperation.newAddressBook();
                    addressBookOperation.updateValue(key,addressBookVariables);
                    break;
                case 5:
                    System.out.println("Enter the Phone Number to delete address");
                    long phoneToDelete=sc.nextLong();
                    addressBookOperation.deleteAddress(phoneToDelete);
                    break;
                case 6:
                    addressBookOperation.sortByZipCode();
                    break;
                case 7:
                    addressBookOperation.sortByFName();
                    break;
                case 8:
                    System.out.println("Terminated");
                    terminate=true;
                    break;

                default:
                    System.out.println("Please select valid option");
                    break;

            }

        }

	}

}
