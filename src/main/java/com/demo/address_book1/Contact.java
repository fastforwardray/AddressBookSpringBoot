package com.demo.address_book1;

import java.util.Map;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Harsha.Ramakrishnapp
 *
 */
/*
 * Entity Class that maps the Java object to Table
 */

@Entity
@Table(name = "CONTACT", schema = "public")
public class Contact {

	@Id
	private Integer contactId;
	private String firstName;
	private String lastName;
	@ElementCollection
	private Map<String, String> addresses;
	@ElementCollection
	private Map<String, String> phoneNumbers;
	@ElementCollection
	private Map<String, String> email;

	public Contact() {

	}

	public Contact(Integer contactId) {

		this.contactId = contactId;
	}

	public Contact(Integer contactId, String firstName, String lastName,
			Map<String, String> addresses, Map<String, String> phoneNumbers,
			Map<String, String> email) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresses = addresses;
		this.phoneNumbers = phoneNumbers;
		this.email = email;
	}

	/**
	 * @return the contactId
	 */
	public Integer getContactId() {
		return contactId;
	}

	/**
	 * @param contactId
	 *            the contactId to set
	 */
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the addresses
	 */
	public Map<String, String> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(Map<String, String> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the phoneNumbers
	 */
	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers
	 *            the phoneNumbers to set
	 */
	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return the email
	 */
	public Map<String, String> getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(Map<String, String> email) {
		this.email = email;
	}

}
