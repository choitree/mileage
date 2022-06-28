package com.triple.mileage.repository.pointLog;

import com.triple.mileage.domain.PointLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointLogRepository extends JpaRepository<PointLog, Long> {
}
