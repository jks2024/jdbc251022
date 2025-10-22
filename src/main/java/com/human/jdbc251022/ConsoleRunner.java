package com.human.jdbc251022;

import com.human.jdbc251022.dao.MemberDao;
import com.human.jdbc251022.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

// 콘솔 입력 만들기 위한 파일
@Component  // 읜존성 주입, 자동 스캔
@RequiredArgsConstructor
public class ConsoleRunner implements CommandLineRunner {
    private final Scanner sc = new Scanner(System.in);
    private final MemberDao memberDao;
    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("====== 콘솔 회원 관리 시스템 ======");
            System.out.println("[1]회원 등록");
            System.out.println("[2]회원 목록 조회");
            System.out.println("[3]회원 정보 수정");
            System.out.println("[4]회원 삭제");
            System.out.println("[6]종료");

            int sel = sc.nextInt();
            sc.nextLine();
            switch (sel) {
                case 1: signUp(); break;
                case 2: memberList(); break;
                case 3: updateMember(); break;
                case 4: deleteMember(); break;
            }
        }
    }
    private void signUp() {
        System.out.println("======== 회원 등록 ========");
        System.out.print("이메일: ");
        String email = sc.nextLine();
        System.out.print("비밀번호: ");
        String pwd = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        boolean isSuccess = memberDao.insert(new Member(email, pwd, name, null));
        System.out.println("회원 가입 : " + (isSuccess ? "성공" : "실패"));
    }

    private void memberList() {
        List<Member> memberList = memberDao.memberList();
        if (memberList.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        for(Member e : memberList) System.out.println(e);
    }

    private void updateMember() {

    }

    private void deleteMember() {

    }

}
