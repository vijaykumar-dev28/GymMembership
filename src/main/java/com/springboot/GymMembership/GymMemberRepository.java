package com.springboot.GymMembership;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMemberRepository extends JpaRepository<GymMember,Integer>{
	List<GymMember> findByMembership(String membershipType);
}
