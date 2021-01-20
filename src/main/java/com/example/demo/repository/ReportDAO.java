package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Income;
import com.example.demo.entity.Report;

@Repository
public interface ReportDAO extends JpaRepository<Report, String> {

	List<Report> findAllByIncome(Income income);

}
