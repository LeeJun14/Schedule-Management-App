package com.example.schedulemanagementapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    @Column(name = "schedule_id")
    private Long scheduleId;
    // lv.7 [댓글 내용] 필수값 처리
    @Column(length = 100, nullable = false)
    private String content;
    // lv.7 [작성자명] 필수값 처리
    @Column(nullable = false)
    private String name;
    // lv.7 [비밀번호] 필수값 처리
    @Column(nullable = false)
    private String password;

    public Comment(String content, String name, String password) {
        this.content = content;
        this.name = name;
        this.password = password;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
}
