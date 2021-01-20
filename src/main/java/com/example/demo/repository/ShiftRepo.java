package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Schedule;
import com.example.demo.entity.Shift;

public interface ShiftRepo  extends JpaRepository<Shift,String>{

	Shift findAllByNameShiftAndSchedule(String string, Schedule sch);

}
