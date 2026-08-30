package com.springboot.GymMembership;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/gymMembers")
public class GymMemberController {
	@Autowired
	private GymMemberService service;
	
	@PostMapping
	public ResponseEntity<?> addMember(@Valid @RequestBody GymMember member, BindingResult result) {
		if(result.hasErrors()) {
	        // collect all error messages
	        List<String> errors = result.getAllErrors()
	            .stream()
	            .map(e -> e.getDefaultMessage())
	            .collect(Collectors.toList());
	        return ResponseEntity.status(400).body(errors);  // 400 Bad Request
	    }
		return ResponseEntity.status(201).body(service.addMember(member));
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<List<GymMember>> addAllMembers(@RequestBody List<GymMember> members) {
		return ResponseEntity.status(201).body(service.addAllMembers(members));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GymMember> getMemberById(@PathVariable int id) {
		GymMember exist=service.getMemberById(id);
		if(exist!=null) {
		return ResponseEntity.ok(exist);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<GymMember>> getAllMembers(){
		return ResponseEntity.ok(service.getAllMembers());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMemberById(@PathVariable int id) {
		 service.deleteMemberById(id);
		 String message="Deleted SuccessFully";
		 return ResponseEntity.ok(message);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMemberById(@PathVariable int id,@Valid @RequestBody GymMember member, BindingResult result) {
		if(result.hasErrors()) {
	        // collect all error messages
	        List<String> errors = result.getAllErrors()
	            .stream()
	            .map(e -> e.getDefaultMessage())
	            .collect(Collectors.toList());
	        return ResponseEntity.status(400).body(errors);  // 400 Bad Request
	    }
		GymMember updated=service.updateMemberById(id, member);
		if(updated!=null) {
			return ResponseEntity.ok(updated);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/membershipType/{type}")
	public ResponseEntity<List<GymMember>> getMembersByMembershipType(@PathVariable String type){
		return ResponseEntity.ok(service.getMembersByMembershipType(type));
	}
}
