package com.shad.SpringStarter.SpringApp.repositories;

import com.shad.SpringStarter.SpringApp.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Long> {

}
