package com.example.nbcscheduledev.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;    // 유저명

    @Column(nullable = false)
    private String email;       // 이메일

    public Member() {}

    public Member(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
