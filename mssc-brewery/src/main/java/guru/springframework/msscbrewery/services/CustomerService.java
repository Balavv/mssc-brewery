package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDto;

/**
 * @author Balavv
 *
 */
public interface CustomerService {
	CustomerDto getById(UUID customerId);
}
