package com.human.jdbc251022.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private Long postId;
    private String memberEmail;
    String content;
    private LocalDateTime regDate;
    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "게시글 ID: " + postId + "\n" +
                "이메일: " + memberEmail + "\n" +
                "내용: " + content + "\n" +
                "----------------------------";
    }
}
