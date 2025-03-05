package com.study;

import com.study.domain.comment.CommentRequest;

import com.study.domain.comment.CommentService;
import com.study.domain.comment.CommentRequest;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;
    
    @Autowired
    CommentService commentService;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        int k =1;
        for(int i=0;i<300;i++) {
        	params.setTitle(k+"번 게시글 제목");
        	params.setContent(k+"번 게시글 내용");
        	params.setWriter("테스터"+k);
        	params.setNoticeYn(false);
        	Long id = postService.savePost(params);
        	k++;
        	System.out.println("생성된 게시글 ID : " + id);
        	
        }
    }

}