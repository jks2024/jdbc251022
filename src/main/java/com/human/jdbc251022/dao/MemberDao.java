package com.human.jdbc251022.dao;

import com.human.jdbc251022.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository  // Spring container Bean 등록
@Slf4j
@RequiredArgsConstructor  // 생성자를 통해서 의존성 주입을 받음
public class MemberDao {
    private final JdbcTemplate jdbcTemplate;

    // 회원 전체 조회
    public List<Member> memberList() {
        String sql = "SELECT * FROM member";
        try {
            return jdbcTemplate.query(sql, new MemberRowMapper());
        } catch (Exception e) {
            log.error("회원 목록 조회 실패: {}", e.getMessage());
            return null;
        }
    }
    // 회원 등록
    public boolean insert(Member member) {
        int result = 0;
        String sql = "INSERT INTO member(email, pwd, name) VALUES(?, ?, ?)";
        try {
            result = jdbcTemplate.update(sql, member.getEmail(),
                    member.getPwd(), member.getName());

        } catch (Exception e) {
            log.error("회원 정보 추가 실패 : {}", e.getMessage());
        }
        return result > 0;
    }

    // 회원 수정
    public boolean update(Member member) {
        String sql = "UPDATE member SET name=?, pwd=? WHERE email=?";
        int result = jdbcTemplate.update(sql, member.getName(), member.getPwd(), member.getEmail());
        return  result > 0;
    }

    // 회원 삭제
    public boolean delete(String email) {
        String sql = "DELETE FROM member WHERE email=?";
        int result = jdbcTemplate.update(sql, email);
        return result > 0;
    }

    private static class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Member(
                    rs.getString("email"),
                    rs.getString("pwd"),
                    rs.getString("name"),
                    rs.getTimestamp("reg_date").toLocalDateTime()
            );
        }
    }
}
