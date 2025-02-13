package com.example.nbcscheduledev.controller;

import com.example.nbcscheduledev.dto.MemberRequestDto;
import com.example.nbcscheduledev.dto.MemberResponseDto;
import com.example.nbcscheduledev.dto.SignUpRequestDto;
import com.example.nbcscheduledev.dto.SignUpResponseDto;
import com.example.nbcscheduledev.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // Creat
    @PostMapping("/members/signup")
    public ResponseEntity<SignUpResponseDto> singUp(
            @RequestBody SignUpRequestDto requestDto
    ){
        SignUpResponseDto responseDto =
                memberService.signUp(
                        requestDto.getUserName(),
                        requestDto.getEmail()
                );
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberResponseDto> findById(
            @PathVariable Long id
    ){
        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponseDto>> findAll() {
        return  ResponseEntity.ok(memberService.findAll());
    }

    // Update
    @PutMapping("/members/{id}")
    public ResponseEntity<MemberResponseDto> update(
            @PathVariable Long id,
            @RequestBody MemberRequestDto dto
    ){
        return ResponseEntity.ok(memberService.update(id, dto));
    }

    // Delete
    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }
}
