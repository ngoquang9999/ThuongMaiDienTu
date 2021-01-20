package com.example.demo.services;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Schedule;
import com.example.demo.entity.Shift;
import com.example.demo.models.ScheduleEntity;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.RepoCustom;
import com.example.demo.repository.ScheduleRepo;
import com.example.demo.repository.ShiftRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.tools.CreateRandomID;

@Service
public class ScheduleServices {

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ScheduleRepo scheduleRepo;

	@Autowired
	ShiftRepo shiftRepo;

	@Autowired
	RepoCustom repoCustom;

	@Autowired
	CourseServices courseService;

	public List<ScheduleEntity> getListScheduleCourse(String idCourse) {
		List<ScheduleEntity> result = new ArrayList<>();
		Schedule sch = scheduleRepo.findAllByCourse(courseRepo.getOne(idCourse));
		if (sch.getDaysOfWeek().contains("-")) {
			String[] thu = sch.getDaysOfWeek().split("-");
			for (int i = 0; i < thu.length; i++) {
				Shift shi = shiftRepo.findAllByNameShiftAndSchedule(thu[i], sch);
				ScheduleEntity schEn = new ScheduleEntity(thu[i], shi.getStartTime().toString(),
						shi.getEndTime().toString());
				result.add(schEn);
			}
		}
		return result;
	}

	public boolean haveSchedule(String idCourse, String date, String time) {
		List<ScheduleEntity> list = getListScheduleCourse(idCourse);
		for (ScheduleEntity s : list) {
			System.out.println(s.getDate());
			System.out.println(s.getStartTime());
			if (s.getDate().equalsIgnoreCase(date) && s.getStartTime().contains(time))
				return true;
		}
		return false;
	}

	public boolean haveScheduleByTeacher(String username, String date, String time) {
		List<Course> listCourse = courseService.getCourseOfTeacher(userRepo.findAllByUsername(username).getIduser());
		for (int i = 0; i < listCourse.size(); i++) {
			List<ScheduleEntity> list = getListScheduleCourse(listCourse.get(i).getIdCourse());
			for (ScheduleEntity s : list) {
				System.out.println(s.getDate());
				System.out.println(s.getStartTime());
				if (s.getDate().equalsIgnoreCase(date) && s.getStartTime().contains(time))
					return true;
			}
		}
		return false;
	}

	public String nameCourseBySchedule(String username, String date, String time) {
		List<Course> listCourse = courseService.getCourseOfTeacher(userRepo.findAllByUsername(username).getIduser());
		for (int i = 0; i < listCourse.size(); i++) {
			List<ScheduleEntity> list = getListScheduleCourse(listCourse.get(i).getIdCourse());
			for (ScheduleEntity s : list) {
				System.out.println(s.getDate());
				System.out.println(s.getStartTime());
				if (s.getDate().equalsIgnoreCase(date) && s.getStartTime().contains(time))
					return listCourse.get(i).getNameCourse();
			}
		}
		return "";
	}

	public String scheduleOfStudent(String username, String date, String time) {
		String result = "";
		List<Course> listCourse = courseService.getMyCourse(username);
		for (int i = 0; i < listCourse.size(); i++) {
			List<ScheduleEntity> list = getListScheduleCourse(listCourse.get(i).getIdCourse());
			for (ScheduleEntity s : list) {
				System.out.println(s.getDate());
				System.out.println(s.getStartTime());
				if (s.getDate().equalsIgnoreCase(date) && s.getStartTime().contains(time))
					result += listCourse.get(i).getNameCourse() + "\n";
			}
		}
		return result;
	}

	public void makeSchedule(String idCourse, String schedule) throws SQLException {
		Schedule sche = scheduleRepo.findAllByCourse(courseRepo.getOne(idCourse));
		schedule = schedule.substring(0, schedule.length() - 1);
		String[] cutSche = schedule.split(" ");
		String dayOfWeek = "";
		for (int i = 0; i < cutSche.length; i++) {
			String[] cutEntry = cutSche[i].split("-");
			System.out.println("Cat lich: " + cutSche[i]);
			int time = Integer.parseInt(cutEntry[1]) + 1;
			int timeEnd = time + 2;
			Shift sh = new Shift(CreateRandomID.getShiftID(), cutEntry[0], Time.valueOf(time + ":00:00"),
					Time.valueOf(timeEnd + ":00:00"), sche);
			repoCustom.add_editShift(sh);
			if (!dayOfWeek.contains(cutEntry[0]) && i == 0)
				dayOfWeek += cutEntry[0];
			else if (!dayOfWeek.contains(cutEntry[0]) && i != 0)
				dayOfWeek += "-" + cutEntry[0];
		}
		sche.setDaysOfWeek(dayOfWeek);
		repoCustom.add_editSchedule(sche);
	}

}
