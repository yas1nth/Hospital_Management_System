package com.example.hms.repository;

import com.example.hms.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository  extends JpaRepository<Bill, Long> {

}
