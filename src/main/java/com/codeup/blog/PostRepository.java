package com.codeup.blog;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<Post, Long> {
    
}
