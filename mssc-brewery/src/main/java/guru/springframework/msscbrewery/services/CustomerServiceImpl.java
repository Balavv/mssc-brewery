package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Balavv
 *
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getById(UUID customerId) {
	   return CustomerDto.builder()
			             .id(UUID.randomUUID())
			             .customerName("Bala")
			             .build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder()
				          .id(UUID.randomUUID())
				           .customerName(customerDto.getCustomerName())
				           .build();
	}

	@Override
	public void updateCustomer(UUID customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(UUID customerId) {
		log.debug("Selected customer has been deleted");
		
	}

}
