package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;

/**
 * @author Balavv
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getById(UUID customerId) {
	   return CustomerDto.builder()
			             .id(UUID.randomUUID())
			             .customerName("Bala")
			             .build();
	}

}
