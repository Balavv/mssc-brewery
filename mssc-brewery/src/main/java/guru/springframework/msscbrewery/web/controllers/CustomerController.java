package guru.springframework.msscbrewery.web.controllers;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;

/**
 * @author Balavv
 *
 */
@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);

	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> handlePost(@RequestBody CustomerDto customerDto){
		CustomerDto savedCustomer=customerService.saveNewCustomer(customerDto);
		HttpHeaders header =new HttpHeaders();
		header.add("location", "/api/customer/v1/"+savedCustomer.getId().toString());
		return new ResponseEntity<>(header, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") UUID customerId){
		customerService.updateCustomer(customerId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteById(customerId);
		
	}

}
