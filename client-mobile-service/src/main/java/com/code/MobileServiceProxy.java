package com.code;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="cl",url = "localhost:8000")
public interface MobileServiceProxy {
	@GetMapping("/mobile/{id}")
	public Mobile retrieveMobileById(@PathVariable("id") Integer id);

	@GetMapping("/all")
	public List<Mobile> retriveAllMobile();

	@PostMapping("/savemobile")
	public ResponseEntity<Mobile> saveMobile(@RequestBody Mobile mobile);
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Mobile> deleteMobile(@PathVariable Integer id);
	
	@PutMapping("/update")
	public ResponseEntity<Mobile> updateMobile(@RequestBody Mobile mobile);
	
}
