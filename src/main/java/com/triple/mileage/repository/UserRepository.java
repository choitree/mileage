package com.triple.mileage.repository;

import com.triple.mileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {
}
