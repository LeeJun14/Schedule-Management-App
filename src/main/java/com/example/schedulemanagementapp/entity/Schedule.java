package com.example.schedulemanagementapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;
    // lv.7 [일정 제목] 최대 30자 이내로 제한, 필수값 처리
    @Column(length = 30, nullable = false)
    private String title;
    // lv.7 [일정 내용] 최대 200자 이내로 제한, 필수값 처리
    @Column(length = 200, nullable = false)
    private String content;
    // lv.7 [작성자명] 필수값 처리
    @Column(nullable = false)
    private String name;
    // lv.7 [비밀번호] 필수값 처리
    @Column(nullable = false)
    private String password;

    public Schedule(String title, String content, String name, String password) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    // 일정 수정을 위한 메서드
    public void update(String title, String name) {
        this.title = title;
        this.name = name;
    }
}
