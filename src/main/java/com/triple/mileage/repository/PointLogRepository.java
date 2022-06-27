package com.triple.mileage.repository;

import com.triple.mileage.domain.PointLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointLogRepository extends JpaRepository<Long, PointLog> {
}
