package com.Project.AddressBook;
import java.util.*;

public class AddressBookOperations implements IAddressBook {

	HashMap<Long, AddressBookVariables> addressBookContainer=new HashMap<Long, AddressBookVariables>();
    Scanner sc=new Scanner(System.in);
    public HashMap<Long, AddressBookVariables> save(long phoneNumber,AddressBookVariables addressBookDAO) {
            addressBookContainer.put(phoneNumber,addressBookDAO);
            return addressBookContainer;
    }
    
    	@Override
    	public AddressBookVariables newAddressBook() {
        AddressBookVariables newAddressBookDAO=new AddressBookVariables();
        System.out.println("Enter the First Name");
        String fName=sc.next();
        System.out.println("Enter the Last Name");
        String lName=sc.next();
        System.out.println("Enter The Address");
        String address=sc.next();
        System.out.println("Enter the city");
        String city=sc.next();
        System.out.println("Enter the state");
        String state=sc.next();
        System.out.println("Enter the zip Code");
        int zip=sc.nextInt();
        System.out.println("Enter the Phone number");
        long phone = sc.nextLong();
        newAddressBookDAO.setfName(fName);
        newAddressBookDAO.setlName(lName);
        newAddressBookDAO.setAddress(address);
        newAddressBookDAO.setCity(city);
        newAddressBookDAO.setState(state);
        newAddressBookDAO.setZip(zip);
        newAddressBookDAO.setPhone(phone);
        return newAddressBookDAO;
    }

    
    	@Override
    	public void printAllDetails()
    	{
            Set keys = addressBookContainer.keySet();
            Iterator it= keys.iterator();
            Collection<AddressBookVariables> getValues = addressBookContainer.values();
            it =getValues.iterator();
            while (it.hasNext())
            {
                System.out.println("Details are : "+it.next());
            }
    	}

    	@Override
    	public void deleteAddress(long key) {
    	
            if(addressBookContainer.containsKey(key)==false)
            {
                System.out.println("Invalid Key !!!!!!!");
            }
            else {
                addressBookContainer.remove(key);
                System.out.println(key +" Deleted Successfully");

            }
            
        }

    
    	@Override
    	public void fetchDetailById(long key) {
    
            if(addressBookContainer.containsKey(key)==false)
            {
                System.out.println("Phone Number not found");
            }
            else
            {
                System.out.println("Found values are: ");
                System.out.println(addressBookContainer.get(key));
            }
        }
    

    	@Override
    	public void sortByZipCode() {
	   
    		List<AddressBookVariables> value= new ArrayList<>();
    		if(addressBookContainer!=null) {
    			value.addAll(addressBookContainer.values());
		   
    			Collections.sort(value, new Comparator<AddressBookVariables>() {
    				public int compare(AddressBookVariables o1, AddressBookVariables o2) {
    					return o1.getZip() - o2.getZip();
	            }
	        });  
	   }
	   for (AddressBookVariables sortedValue : value) {
	   		System.out.println(sortedValue);
	   }
   }
    
    	@Override
    	public void sortByFName()
    	{
    		List<AddressBookVariables> value= new ArrayList<>();
    		if(addressBookContainer!=null) {
    			value.addAll(addressBookContainer.values());
    			Collections.sort(value, new Comparator<AddressBookVariables>() {
    				public int compare(AddressBookVariables o1, AddressBookVariables o2) {
    					return o1.getfName().compareTo(o2.getfName());
    				}
    			});  
    		}
            for (AddressBookVariables valueList : value)
            {
                System.out.println(valueList);
            }
    }
    	
    	@Override
    	public HashMap updateValue(long key, AddressBookVariables addressBookDAO) {
		
            if(addressBookContainer.containsKey(key) == false)
            {
                System.out.println("Key Not Found");
            }
            else if (addressBookContainer.containsKey(key)== true)
            {
                addressBookContainer.put(key, addressBookDAO);
                System.out.println("Values Updated");
            }
            return addressBookContainer;
	}

	
}
