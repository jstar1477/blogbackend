package com.blog.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.posts.Post;
import com.blog.posts.PostRepository;

@RestController
@RequestMapping("/api/public")
@CrossOrigin
public class PublicController {

	@Autowired
	PostRepository repo;
	
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> approvedPosts(){
		List<Post> posts = repo.findApprovedPosts();
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Long id) {
	    Post post = repo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
	    return ResponseEntity.ok(post);
	}

}
