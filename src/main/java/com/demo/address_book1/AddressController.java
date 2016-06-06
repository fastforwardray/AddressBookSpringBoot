package com.demo.address_book1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harsha.Ramakrishnapp
 *
 */
@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	/*
	 * Create method is using POST method to send the Contact object to save in
	 * the database
	 */
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody ContactObject contact) {
		Contact createObject;
		try {

			createObject = new Contact(contact.getContactId(),
					contact.getFirstName(), contact.getLastName(),
					contact.getAddresses(), contact.getPhoneNumbers(),
					contact.getEmail());
			addressRepository.save(createObject);
		} catch (Exception ex) {
			return "Error creating the Contact" + ex.toString();
		}

		return "Contact successfully created!\n" + +contact.getContactId() + "\n"
				+ contact.getFirstName() + "\n" + contact.getLastName() + "\n"
				+ contact.getAddresses() + "\n" + contact.getEmail();

	}

	/*
	 * Method to Delete the contact from the record based on Id specified
	 */
	@RequestMapping(path = "/delete")
	@ResponseBody
	public String delete(Integer contactId) {
		Contact deleteObject;
		try {

			deleteObject = new Contact(contactId);
			addressRepository.delete(deleteObject);
		} catch (Exception ex) {

			return "Error deleting the Contact" + ex.toString();

		}

		return "Contact Successfully deleted!";
	}

	/*
	 * update method will find the record based on the id provided in the JSON
	 * body to update the existing records
	 */
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(@RequestBody ContactObject contact) {
		Contact updateObject;
		try {
			updateObject = addressRepository.findOne(contact.getContactId());
			updateObject.setFirstName(contact.getFirstName());
			updateObject.setLastName(contact.getLastName());
			updateObject.setAddresses(contact.getAddresses());
			updateObject.setPhoneNumbers(contact.getPhoneNumbers());
			updateObject.setEmail(contact.getEmail());
			addressRepository.save(updateObject);
		} catch (Exception ex) {

			return "Error updating the Contact" + ex.toString();
		}
		return "Contact successfully updated!\n" + +contact.getContactId() + "\n"
				+ contact.getFirstName() + "\n" + contact.getLastName() + "\n"
				+ contact.getAddresses() + "\n" + contact.getEmail();
	}

	/*
	 * Search method to search the contacts based on the contactId
	 */

	@RequestMapping(path = "/search")
	@ResponseBody
	public String search(Integer contactId) {
		Contact searchObject;
		try {
			searchObject = addressRepository.findOne(contactId);
		} catch (Exception ex) {

			return "Error deleting the Contact" + ex.toString();

		}

		return "Contact found!\n" + +searchObject.getContactId() + "\n"
				+ searchObject.getFirstName() + "\n"
				+ searchObject.getLastName() + "\n"
				+ searchObject.getAddresses() + "\n" + searchObject.getEmail();
	}

}
