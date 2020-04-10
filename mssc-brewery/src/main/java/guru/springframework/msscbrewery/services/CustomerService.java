package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDto;

/**
 * @author Balavv
 *
 */
public interface CustomerService {
	CustomerDto getById(UUID customerId);
	CustomerDto saveNewCustomer(CustomerDto customerDto);
	void updateCustomer(UUID customerId);
	void deleteById(UUID customerId);
}
