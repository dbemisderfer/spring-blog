package com.codeup.blog;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> { //<Bean Class, Id(Primary Key)>
//
//    List<Post> findAll();  // this is a built-in method
//    Post findOne(Long id);  // this is a built-in method
//    void save(Post post); // this is a built-in method (handles Create and Update)
//    void delete(Post post);  // this is a built-in method
//
//    List<Post> findByTitle(String title);

    @Modifying
    @Transactional
    @Query("delete from Post p where p.id = ?1")
    void deleteById(Long id);

//    @Query("update Post p set p.body = ?1 where p.id = ?1")
//    String editPostBodyById (long id);
//
//    @Query("update Post p set p.title = ?1 where p.id = ?1")
//    String editPostTitleById (long id);
//
//    void deletePostById(long id);
//
}