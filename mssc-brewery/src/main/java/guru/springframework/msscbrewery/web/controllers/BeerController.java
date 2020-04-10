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
	
	@PostMapping
	public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto) {
		
		BeerDto savedBeer =beerService.saveNewBeer(beerDto);
		HttpHeaders header = new HttpHeaders();
		header.add("location", "/api/beer/v1/"+savedBeer.getId().toString());
		return new ResponseEntity<>(header,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId,
			   @RequestBody BeerDto beerDto){
		
		beerService.updateBeer(beerId,beerDto);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		
		beerService.deleteById(beerId);
		
	}
}
