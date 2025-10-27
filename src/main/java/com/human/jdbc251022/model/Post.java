package com.human.jdbc251022.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;
    private String memberEmail;
    private LocalDateTime regDate;
    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "이메일: " + memberEmail + "\n" +
                "제목: " + title + "\n" +
                "내용: " + content + "\n" +
                "----------------------------";
    }
}
