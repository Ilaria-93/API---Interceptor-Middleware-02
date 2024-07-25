package com.example.InterceptorMiddlewareApplication2.repositories;

import com.example.InterceptorMiddlewareApplication2.entities.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {

    Optional<Month> findByMonthNumber(Integer monthNumber);
}
