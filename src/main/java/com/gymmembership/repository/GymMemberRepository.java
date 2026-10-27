package com.gymmembership.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymmembership.entity.GymMember;

@Repository
public interface GymMemberRepository extends JpaRepository<GymMember,Integer>{
	List<GymMember> findByMembership(String membershipType);
}
