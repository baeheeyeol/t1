package com.study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.domain.post.PostMapper;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        postMapper.save(params);

        List<PostResponse> posts = postMapper.findAll(null);
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }
    @Test
    void findById() {
        PostResponse post = postMapper.findById(10L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void update() {
        // 1. 게시글 수정
        PostRequest params = new PostRequest();
        params.setId(10L);
        params.setTitle("1번 게시글 제목 수정합니다.");
        params.setContent("1번 게시글 내용 수정합니다.");
        params.setWriter("도뎡2이");
        params.setNoticeYn(true);
        postMapper.update(params);

        // 2. 게시글 상세정보 조회
        PostResponse post = postMapper.findById(10L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void delete() {
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
        postMapper.deleteById(10L);
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
    }
//    create table TB_POST
//    (
//      ID            NUMBER(20) not null,
//      TITLE         VARCHAR2(100),
//      CONTENT       VARCHAR2(3000),
//      WRITER        VARCHAR2(20),
//      VIEW_CNT      NUMBER(11),
//      NOTICE_YN     NUMBER(1),
//      DELETE_YN     NUMBER(1),
//      CREATED_DATE  DATE,
//      MODIFIED_DATE DATE
//    )
//    create table TB_COMMENT
//    (
//      ID            NUMBER,
//      POST_ID       NUMBER,
//      CONTENT       VARCHAR2(1000),
//      WRITER        VARCHAR2(20),
//      DELETE_YN     NUMBER,
//      CREATED_DATE  DATE,
//      MODIFIED_DATE DATE
//    )
//    create sequence TB_POST_seq
//       increment by 1
//       start with 1
//       maxvalue integer 999999
//       minvalue integer 999999
//       ;
//    create sequence TB_comment_seq
//       increment by 1
//       start with 1
//       maxvalue integer 999999
//       minvalue integer 999999
//       ;
}