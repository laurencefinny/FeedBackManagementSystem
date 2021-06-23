package com.cognizant.api;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.cognizant.model.Event;
import com.cognizant.model.EventReport;
import com.cognizant.model.User;
import com.cognizant.model.VolunteerRegistered;
import com.cognizant.model.VolunteerUnRegistered;
import com.cognizant.repository.EventReportRepository;
import com.cognizant.repository.EventRepository;
import com.cognizant.repository.UserRepository;
import com.cognizant.repository.VolunteerRegisteredRepository;
import com.cognizant.repository.VolunteerUnRegisteredRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-06T15:35:34.885+05:30[Asia/Calcutta]")
@Controller
public class DataSourceController implements DataSourceApi {

	public static final String EVENT_REPORT = "/data-docs/OutReach_Event_Information.xlsx";
	public static final String EVENT_SUMMARY = "/data-docs/Outreach_Event_Summary.xlsx";

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventReportRepository eventReportRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VolunteerRegisteredRepository volunteerRegisteredRepository;
	@Autowired
	private VolunteerUnRegisteredRepository volunteerUnRegisteredRepository;

	@Override
	public Flux<ResponseEntity<Void>> addEvent()
			throws IOException, EncryptedDocumentException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(new File(EVENT_SUMMARY));
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		List<User> userList = new ArrayList<>();
		List<Event> eventList = new ArrayList<>();
		int index = 0;
		for (Row row : sheet) {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yy");
			if (index != 0) {

				String eventId = dataFormatter.formatCellValue(row.getCell(0));
				String month = dataFormatter.formatCellValue(row.getCell(1));
				String baseLocation = dataFormatter.formatCellValue(row.getCell(2));
				String beneficiaryName = dataFormatter.formatCellValue(row.getCell(3));
				String ventureAddress = dataFormatter.formatCellValue(row.getCell(4));
				String councilName = dataFormatter.formatCellValue(row.getCell(5));
				String project = dataFormatter.formatCellValue(row.getCell(6));
				String category = dataFormatter.formatCellValue(row.getCell(7));
				String eventName = dataFormatter.formatCellValue(row.getCell(8));
				String eventDescription = dataFormatter.formatCellValue(row.getCell(9));
				LocalDate eventDate = LocalDate.parse(dataFormatter.formatCellValue(row.getCell(10)), df);
				String totalNoOfVolunteers = dataFormatter.formatCellValue(row.getCell(11));
				String totalVolunteerHours = dataFormatter.formatCellValue(row.getCell(12));
				String totalTravelHours = dataFormatter.formatCellValue(row.getCell(13));
				String overallVolunteerHours = dataFormatter.formatCellValue(row.getCell(14));
				String livesImpacted = dataFormatter.formatCellValue(row.getCell(15));
				String activityType = dataFormatter.formatCellValue(row.getCell(16));
				String status = dataFormatter.formatCellValue(row.getCell(17));
				String pocId = dataFormatter.formatCellValue(row.getCell(18));
				String pocName = dataFormatter.formatCellValue(row.getCell(19));
				String pocContact = dataFormatter.formatCellValue(row.getCell(20));

				Mono<Event> eventSum = eventRepository.findByEventId(eventId);
				Mono<User> usList = userRepository.findByEmpId(pocId);

				if (usList.block() == null) {
					User user = new User();
					String name[] = pocName.split(" ");
					user.setUs_emp_id(pocId);
					user.setUs_fs_name(name[0]);
					user.setUs_ls_name(name[name.length - 1]);
					user.setRole("Poc");
					user.setUs_password(passwordEncoder().encode(pocId));
					userList.add(user);

				}
				if (eventSum.block() == null) {
					Event event = new Event();
					event.setEventId(eventId);
					event.setMonth(month);
					event.setBaseLocation(baseLocation);
					event.setBeneficiaryName(beneficiaryName);
					event.setVentureAddress(ventureAddress);
					event.setCouncilName(councilName);
					event.setProject(project);
					event.setEventName(eventName);
					event.setEventDescription(eventDescription);
					event.setEventDate(eventDate);
					event.setTotalNoOfVolunteers((int) Double.parseDouble(totalNoOfVolunteers));
					event.setTotalVolunteerHours((int) Double.parseDouble(totalVolunteerHours));
					event.setTotalTravelHours((int) Double.parseDouble(totalTravelHours));
					event.setOverallVolunteerHours((int) Double.parseDouble(overallVolunteerHours));
					event.setLivesImpacted(Integer.parseInt(livesImpacted));
					event.setActivityType(Integer.parseInt(activityType));
					event.setStatus(status);
					event.setCategory(category);
					event.setPocId(Integer.parseInt(pocId));
					event.setPocName(pocName);
					event.setPocContact(Long.parseLong(pocContact));
					eventList.add(event);

				}
			}
			index++;
		}
		workbook.close();

		return eventRepository.saveAll(eventList).thenMany(userRepository.saveAll(userList))
				.flatMap(user -> userRepository.findAll().then(Mono.just(ResponseEntity.ok().<Void>build())))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public Flux<ResponseEntity<Void>> addEventSum()
			throws IOException, EncryptedDocumentException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(new File(EVENT_REPORT));
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yy");

		List<EventReport> eventReportList = new ArrayList<>();
		List<VolunteerRegistered> volRegList = new ArrayList<>();
		List<VolunteerUnRegistered> volUnRegList = new ArrayList<>();
		int index = 0;
		for (Row row : sheet) {
			if (index != 0) {

				String eventId = dataFormatter.formatCellValue(row.getCell(0));
				String baseLocation = dataFormatter.formatCellValue(row.getCell(1));
				String beneficiaryName = dataFormatter.formatCellValue(row.getCell(2));
				String councilName = dataFormatter.formatCellValue(row.getCell(3));
				String eventName = dataFormatter.formatCellValue(row.getCell(4));
				String eventDescription = dataFormatter.formatCellValue(row.getCell(5));
				LocalDate eventDate = LocalDate.parse(dataFormatter.formatCellValue(row.getCell(6)), df);
				String employeeId = dataFormatter.formatCellValue(row.getCell(7));
				String employeeName = dataFormatter.formatCellValue(row.getCell(8));
				String volunteerHours = dataFormatter.formatCellValue(row.getCell(9));
				String travelHours = dataFormatter.formatCellValue(row.getCell(10));
				String livesImpacted = dataFormatter.formatCellValue(row.getCell(11));
				String buisness_unit = dataFormatter.formatCellValue(row.getCell(12));
				String status = dataFormatter.formatCellValue(row.getCell(13));
				String iiep_category = dataFormatter.formatCellValue(row.getCell(14));

				Flux<EventReport> event = eventReportRepository.findByEventId(eventId);
				Mono<VolunteerRegistered> volunteerRegistered = volunteerRegisteredRepository
						.findByEmployeeId(employeeId);
				Mono<VolunteerUnRegistered> volunteerUnRegistered = volunteerUnRegisteredRepository
						.findByEmployeeId(employeeId);
				System.err.println(
						volunteerRegistered.block() + " " + volunteerUnRegistered.block() + " " + event.blockFirst());
				if (volunteerRegistered.block() == null && status.equals("Approved")) {
					VolunteerRegistered vol_reg = new VolunteerRegistered();
					vol_reg.setEventId(eventId);
					vol_reg.setEventName(eventName);
					vol_reg.setBaseLocation(baseLocation);
					vol_reg.setBeneficiaryName(beneficiaryName);
					vol_reg.setEmployeeId(Long.parseLong(employeeId));
					vol_reg.setEventDate(eventDate);
					volRegList.add(vol_reg);

				} else if (volunteerUnRegistered.block() == null) {
					VolunteerUnRegistered vol_unreg = new VolunteerUnRegistered();
					vol_unreg.setEventId(eventId);
					vol_unreg.setEventName(eventName);
					vol_unreg.setBaseLocation(baseLocation);
					vol_unreg.setBeneficiaryName(beneficiaryName);
					vol_unreg.setEmployeeId(Long.parseLong(employeeId));
					vol_unreg.setEventDate(eventDate);
					volUnRegList.add(vol_unreg);

				}

				EventReport eventReport = new EventReport();
				eventReport.setEventId(eventId);
				eventReport.setBaseLocation(baseLocation);
				eventReport.setBeneficiaryName(beneficiaryName);
				eventReport.setCouncilName(councilName);
				eventReport.setEventName(eventName);
				eventReport.setEventDescription(eventDescription);
				eventReport.setEventDate(eventDate);
				eventReport.setVolunteerHours((int) Double.parseDouble(volunteerHours));
				eventReport.setTravelHours((int) Double.parseDouble(travelHours));
				eventReport.setLivesImpacted(Integer.parseInt(livesImpacted));
				eventReport.setBuisnessUnit(buisness_unit);
				eventReport.setStatus(status);
				eventReport.setIiepCategory(iiep_category);
				eventReport.setEmployeeId(Integer.parseInt(employeeId));
				eventReport.setEmployeeName(employeeName);
				eventReportList.add(eventReport);

			}
			index++;
		}
		workbook.close();

		return eventReportRepository.saveAll(eventReportList)
				.thenMany(volunteerRegisteredRepository.saveAll(volRegList))
				.thenMany(volunteerUnRegisteredRepository.saveAll(volUnRegList))
				.flatMap(user -> userRepository.findAll().then(Mono.just(ResponseEntity.ok().<Void>build())))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}
}