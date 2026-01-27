package com.vlad.spring.database.repository;

import com.vlad.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("select c from Company c " +
           "join fetch c.locales cl " +
           "where c.name = :name")
    Optional<Company> findByName(String name);//@Param("name2") -> вручную указываем название параметра

    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
