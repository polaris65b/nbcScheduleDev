package com.example.nbcscheduledev.repository;

import com.example.nbcscheduledev.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositorty extends JpaRepository<Member, Long> {
}
