package com.example.nbcscheduledev.service;


import com.example.nbcscheduledev.dto.*;
import com.example.nbcscheduledev.entity.Member;
import com.example.nbcscheduledev.entity.Schedule;
import com.example.nbcscheduledev.repository.MemberRepositorty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepositorty memberRepositorty;

    // create
    @Transactional
    public SignUpResponseDto signUp(
            String userName,
            String email
    ) {
        Member member = new Member(userName, email);
        Member savedMember = memberRepositorty.save(member);

        return new SignUpResponseDto(
                savedMember.getId(),
                savedMember.getUserName(),
                savedMember.getEmail()
        );
    }

    // read
    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id) {
        Optional<Member> member = memberRepositorty.findById(id);

        if(member.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found");
        }

        Member findMember = member.get();

        return new MemberResponseDto(findMember.getId(), findMember.getUserName(), findMember.getEmail());
    }
    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepositorty.findAll();

        List<MemberResponseDto> dtos = new ArrayList<>();
        for(Member member : members) {
            dtos.add(new MemberResponseDto(
                    member.getId(),
                    member.getUserName(),
                    member.getEmail())
            );
        }
        return dtos;
    }
    // update
    @Transactional
    public MemberResponseDto update(Long id, MemberRequestDto dto) {
        Member member = memberRepositorty.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found")
        );
        return new MemberResponseDto(
                member.getId(),
                member.getUserName(),
                member.getEmail()
        );
    }

    @Transactional
    public void delete(Long id) {
        if (!memberRepositorty.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found");
        }
        memberRepositorty.deleteById(id);
    }
}
