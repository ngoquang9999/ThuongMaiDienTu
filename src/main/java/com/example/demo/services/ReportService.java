package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Income;
import com.example.demo.entity.Report;
import com.example.demo.repository.IncomeRepo;
import com.example.demo.repository.RepoCustom;
import com.example.demo.repository.ReportDAO;
import com.example.demo.repository.UserRepo;
import com.example.demo.tools.CreateRandomID;

@Service
public class ReportService {

	private static String UPLOADED_FOLDER = "target/classes/static/img/";
	private static String UPLOADED_FOLDER_ADMIN = "target/classes/static/admin/img/";

	@Autowired
	ReportDAO reportDao;

	@Autowired
	IncomeRepo incomeRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	RepoCustom repoCustom;

	public void saveNewReport(Report report, String username, MultipartFile file) throws SQLException, IOException {
		// Upload file
		String idReport = CreateRandomID.getReportID();
		byte[] bytes = file.getBytes();
		Path path1 = Paths.get(UPLOADED_FOLDER + idReport + ".jpg");
		Files.write(path1, bytes);
		Path path2 = Paths.get(UPLOADED_FOLDER_ADMIN + idReport + ".jpg");
		Files.write(path2, bytes);

		report.setLink("img/" + idReport + ".jpg");
		report.setIdReport(idReport);
		report.setMoney(0);
		report.setIncome(incomeRepo.findAllByUser(userRepo.findAllByUsername(username)));
		report.setStatus("WAITING");
		reportDao.save(report);
	}

	public void refeshSalary(Report report) {
		Income income = report.getIncome();
		List<Report> listReport = reportDao.findAllByIncome(income);
		int salary = 0;
		for (Report r : listReport) {
			if (r.getDateReport().getTime() >= income.getDate().getTime()
					&& r.getStatus().equalsIgnoreCase("CONFIRMED"))
				salary += r.getMoney();
		}
		income.setTotalCost(salary);
		repoCustom.add_editIncome(income);
	}

	public void updateReport(Report rp) {
		repoCustom.add_editReport(rp);
	}

	public List<Report> getReports() {
		return reportDao.findAll();
	}

	public void deleteReportWithId(String id) {
		reportDao.deleteById(id);
	}

	public Report getReportWithId(String id) {
		return reportDao.findById(id).orElse(null);
	}

}
