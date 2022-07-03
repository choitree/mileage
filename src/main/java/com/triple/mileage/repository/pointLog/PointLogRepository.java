package com.triple.mileage.repository.pointLog;

import com.triple.mileage.domain.PointLog;
import com.triple.mileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointLogRepository extends JpaRepository<PointLog, Long>, PointLogRepositoryCustom {

        List<PointLog> findAllByUser(User user);
}
