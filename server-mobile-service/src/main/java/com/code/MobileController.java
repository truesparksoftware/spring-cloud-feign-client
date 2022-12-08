package com.code;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController {
	@Autowired
	private MobileRepository repository;

	@GetMapping("/mobile/{id}")
	public Mobile retrieveExchangeValue(@PathVariable Integer id) {
		Optional<Mobile> exchangeValue = repository.findById(id);
		Mobile m1 = exchangeValue.get();
		return m1;
	}

	@GetMapping("/all")
	public List<Mobile> retrieveMobile() {
		List<Mobile> mobileList = repository.findAll();
		return mobileList;
	}

	@PostMapping("/savemobile")
	public ResponseEntity<Mobile> saveMobile(@RequestBody Mobile mobile) {
		Mobile mobileList = repository.save(mobile);
		return new ResponseEntity<Mobile>(mobileList, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Mobile> deleteMobile(@PathVariable Integer id) {
		repository.deleteById(id);
		return new ResponseEntity<Mobile>(HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Mobile> updateMobile(@RequestBody Mobile mobile) {
		Mobile mb = repository.save(mobile);
		return new ResponseEntity<>(mb, HttpStatus.OK);
	}

}
