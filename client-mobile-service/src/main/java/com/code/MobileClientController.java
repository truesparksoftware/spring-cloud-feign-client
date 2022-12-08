package com.code;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class MobileClientController {

	@Autowired
	private MobileServiceProxy proxy;

	@GetMapping("/mobile/{id}")
	public Mobile getMobileById(@PathVariable Integer id) {
		Mobile response = proxy.retrieveMobileById(id);
		return new Mobile(response.getId(), response.getAddress(), response.getName(), response.getPort());
	}

	@GetMapping("/all")
	public List<Mobile> getAllMobile() {
		List<Mobile> response = proxy.retriveAllMobile();
		List<Mobile> lst = new ArrayList<Mobile>();
		lst.addAll(response);
		return lst;
	}

	@PostMapping("/savemobile")
	public ResponseEntity<Mobile> saveMobile(@RequestBody Mobile mb) {
		ResponseEntity<Mobile> mg=proxy.saveMobile(mb);
		return mg;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Mobile> deleteMobile(@PathVariable Integer id) {
		proxy.deleteMobile(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Mobile> updateMobile(@RequestBody Mobile mobile) {
		proxy.updateMobile(mobile);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
