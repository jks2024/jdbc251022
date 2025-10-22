package com.human.jdbc251022.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Member {
    private String email;
    private String pwd;
    private String name;
    public LocalDateTime regDate;

    @Override
    public String toString() {
        return  "이메일: " + email + "\n" +
                "비밀번호: " + pwd + "\n" +
                "이름: " + name + "\n" +
                "가입일: " + regDate + "\n" +
                "---------------------------------";
    }
}
