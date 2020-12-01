package com.Project.AddressBook;

import java.util.HashMap;

public interface IAddressBook {

	public AddressBookVariables newAddressBook();
	public void printAllDetails();
	public void deleteAddress(long key);
	public void fetchDetailById(long key);
	public void sortByZipCode();
	public void sortByFName();
	public HashMap<Long, AddressBookVariables> updateValue(long key, AddressBookVariables addressBookDAO);
	
}
