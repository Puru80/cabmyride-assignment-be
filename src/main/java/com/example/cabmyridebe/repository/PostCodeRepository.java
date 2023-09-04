package com.example.cabmyridebe.repository;

import com.example.cabmyridebe.db.PostCodes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCodeRepository extends JpaRepository<PostCodes, Long> {
    boolean existsByPostCode(String postCode);

    Page<PostCodes> findAll(Pageable pageable);
}
