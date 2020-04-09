package guru.springframework.msscbrewery.web.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;


/**
 * @author Balavv
 *
 */
@RestController
@RequestMapping("/api/beer/v1")
public class BeerController {
     
	private BeerService beerService;
	
	public BeerController(BeerService beerService) {
		this.beerService=beerService;
	}
	
	@GetMapping("/{beerId}")
	 public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId),HttpStatus.OK);
			 
	 }
}
