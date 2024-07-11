//package com.example.demo.repository;
//
//import com.example.demo.entity.Member;
//import org.springframework.data.jdbc.repository.query.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.jdbc.repository.query.Query;
//
//public interface MemberCrudRepository extends CrudRepository<Member, Integer> {
//    @Query("SELECT * FROM member ORDER BY id")
//    Iterable<Member> sortById();
//
//    @Query("SELECT * FROM member WHERE name LIKE CONCAT('%',:name,'%') ORDER BY id")
//    Iterable<Member> searchByName(@Param("name") String name);
//}
