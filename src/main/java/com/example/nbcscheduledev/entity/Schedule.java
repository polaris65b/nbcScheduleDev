package com.example.nbcscheduledev.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;        // 작성 유저명
    private String title;           // 할일 제목
    private String description;     // 할일 내용
    // 작성일, 수정일 -> BaseEntity에서

    public Schedule(String userName, String title, String description) {
        this.userName = userName;
        this.title = title;
        this.description = description;
    }

    public void update(String userName, String title, String description) {
        this.userName = userName;
        this.title = title;
        this.description = description;
    }
}
