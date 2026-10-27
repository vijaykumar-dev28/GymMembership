package com.gymmembership.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymmembership.entity.GymMember;
import com.gymmembership.repository.GymMemberRepository;

@Service
public class GymMemberService {
	@Autowired
	private GymMemberRepository repo;
	
	public GymMember addMember(GymMember member) {
		return repo.save(member);
	}
	
	public List<GymMember> addAllMembers(List<GymMember> members) {
		return repo.saveAll(members);
	}
	
	public GymMember getMemberById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<GymMember> getAllMembers(){
		return repo.findAll();
	}
	
	public void deleteMemberById(int id) {
		repo.deleteById(id);
	}
	
	public GymMember updateMemberById(int id,GymMember member) {
		GymMember exist=repo.findById(id).orElse(null);
		if(exist!=null) {
			exist.setName(member.getName());
			exist.setEmail(member.getEmail());
			exist.setPhone(member.getPhone());
			exist.setMembership(member.getMembership());
			exist.setFee(member.getFee());
			exist.setJoinDate(member.getJoinDate());
			return repo.save(exist);
		}
		return null;
	}
	
	public List<GymMember> getMembersByMembershipType(String membershipType){
		return repo.findByMembership(membershipType);
	}
}
