package com.demo.address_book1;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Harsha.Ramakrishnapp
 *
 */
public interface AddressRepository extends CrudRepository<Contact, Integer> {

}
