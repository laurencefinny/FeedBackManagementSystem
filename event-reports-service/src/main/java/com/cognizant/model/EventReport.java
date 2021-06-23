package com.cognizant.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * EventReport
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
public class EventReport {
	@JsonProperty("id")
	@Id
	private Integer id = null;

	@JsonProperty("event_id")
	private String eventId = null;

	@JsonProperty("base_location")
	private String baseLocation = null;

	@JsonProperty("beneficiary_name")
	private String beneficiaryName = null;

	@JsonProperty("council_name")
	private String councilName = null;

	@JsonProperty("event_name")
	private String eventName = null;

	@JsonProperty("event_description")
	private String eventDescription = null;

	@JsonProperty("employee_id")
	private Integer employeeId = null;

	@JsonProperty("employee_name")
	private String employeeName = null;

	@JsonProperty("event_date")
	private LocalDate eventDate = null;

	@JsonProperty("volunteer_hours")
	private Integer volunteerHours = null;

	@JsonProperty("travel_hours")
	private Integer travelHours = null;

	@JsonProperty("lives_impacted")
	private Integer livesImpacted = null;

	@JsonProperty("buisness_unit")
	private String buisnessUnit = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("iiep_category")
	private String iiepCategory = null;

	public EventReport eventId(String eventId) {
		this.eventId = eventId;
		return this;
	}

	/**
	 * Get eventId
	 * 
	 * @return eventId
	 **/
	@ApiModelProperty(value = "")

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public EventReport baseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
		return this;
	}

	/**
	 * Get baseLocation
	 * 
	 * @return baseLocation
	 **/
	@ApiModelProperty(value = "")

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public EventReport beneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
		return this;
	}

	/**
	 * Get beneficiaryName
	 * 
	 * @return beneficiaryName
	 **/
	@ApiModelProperty(value = "")

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public EventReport councilName(String councilName) {
		this.councilName = councilName;
		return this;
	}

	/**
	 * Get councilName
	 * 
	 * @return councilName
	 **/
	@ApiModelProperty(value = "")

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public EventReport eventName(String eventName) {
		this.eventName = eventName;
		return this;
	}

	/**
	 * Get eventName
	 * 
	 * @return eventName
	 **/
	@ApiModelProperty(value = "")

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public EventReport eventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
		return this;
	}

	/**
	 * Get eventDescription
	 * 
	 * @return eventDescription
	 **/
	@ApiModelProperty(value = "")

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public EventReport employeeId(Integer employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	/**
	 * Get employeeId
	 * 
	 * @return employeeId
	 **/
	@ApiModelProperty(value = "")

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public EventReport employeeName(String employeeName) {
		this.employeeName = employeeName;
		return this;
	}

	/**
	 * Get employeeName
	 * 
	 * @return employeeName
	 **/
	@ApiModelProperty(value = "")

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public EventReport eventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
		return this;
	}

	/**
	 * Get eventDate
	 * 
	 * @return eventDate
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public EventReport volunteerHours(Integer volunteerHours) {
		this.volunteerHours = volunteerHours;
		return this;
	}

	/**
	 * Get volunteerHours
	 * 
	 * @return volunteerHours
	 **/
	@ApiModelProperty(value = "")

	public Integer getVolunteerHours() {
		return volunteerHours;
	}

	public void setVolunteerHours(Integer volunteerHours) {
		this.volunteerHours = volunteerHours;
	}

	public EventReport travelHours(Integer travelHours) {
		this.travelHours = travelHours;
		return this;
	}

	/**
	 * Get travelHours
	 * 
	 * @return travelHours
	 **/
	@ApiModelProperty(value = "")

	public Integer getTravelHours() {
		return travelHours;
	}

	public void setTravelHours(Integer travelHours) {
		this.travelHours = travelHours;
	}

	public EventReport livesImpacted(Integer livesImpacted) {
		this.livesImpacted = livesImpacted;
		return this;
	}

	/**
	 * Get livesImpacted
	 * 
	 * @return livesImpacted
	 **/
	@ApiModelProperty(value = "")

	public Integer getLivesImpacted() {
		return livesImpacted;
	}

	public void setLivesImpacted(Integer livesImpacted) {
		this.livesImpacted = livesImpacted;
	}

	public EventReport buisnessUnit(String buisnessUnit) {
		this.buisnessUnit = buisnessUnit;
		return this;
	}

	/**
	 * Get buisnessUnit
	 * 
	 * @return buisnessUnit
	 **/
	@ApiModelProperty(value = "")

	public String getBuisnessUnit() {
		return buisnessUnit;
	}

	public void setBuisnessUnit(String buisnessUnit) {
		this.buisnessUnit = buisnessUnit;
	}

	public EventReport status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EventReport iiepCategory(String iiepCategory) {
		this.iiepCategory = iiepCategory;
		return this;
	}

	/**
	 * Get iiepCategory
	 * 
	 * @return iiepCategory
	 **/
	@ApiModelProperty(value = "")

	public String getIiepCategory() {
		return iiepCategory;
	}

	public void setIiepCategory(String iiepCategory) {
		this.iiepCategory = iiepCategory;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EventReport eventReport = (EventReport) o;
		return Objects.equals(this.eventId, eventReport.eventId)
				&& Objects.equals(this.baseLocation, eventReport.baseLocation)
				&& Objects.equals(this.beneficiaryName, eventReport.beneficiaryName)
				&& Objects.equals(this.councilName, eventReport.councilName)
				&& Objects.equals(this.eventName, eventReport.eventName)
				&& Objects.equals(this.eventDescription, eventReport.eventDescription)
				&& Objects.equals(this.employeeId, eventReport.employeeId)
				&& Objects.equals(this.employeeName, eventReport.employeeName)
				&& Objects.equals(this.eventDate, eventReport.eventDate)
				&& Objects.equals(this.volunteerHours, eventReport.volunteerHours)
				&& Objects.equals(this.travelHours, eventReport.travelHours)
				&& Objects.equals(this.livesImpacted, eventReport.livesImpacted)
				&& Objects.equals(this.buisnessUnit, eventReport.buisnessUnit)
				&& Objects.equals(this.status, eventReport.status)
				&& Objects.equals(this.iiepCategory, eventReport.iiepCategory);
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventId, baseLocation, beneficiaryName, councilName, eventName, eventDescription,
				employeeId, employeeName, eventDate, volunteerHours, travelHours, livesImpacted, buisnessUnit, status,
				iiepCategory);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventReport {\n");

		sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
		sb.append("    baseLocation: ").append(toIndentedString(baseLocation)).append("\n");
		sb.append("    beneficiaryName: ").append(toIndentedString(beneficiaryName)).append("\n");
		sb.append("    councilName: ").append(toIndentedString(councilName)).append("\n");
		sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
		sb.append("    eventDescription: ").append(toIndentedString(eventDescription)).append("\n");
		sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
		sb.append("    employeeName: ").append(toIndentedString(employeeName)).append("\n");
		sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
		sb.append("    volunteerHours: ").append(toIndentedString(volunteerHours)).append("\n");
		sb.append("    travelHours: ").append(toIndentedString(travelHours)).append("\n");
		sb.append("    livesImpacted: ").append(toIndentedString(livesImpacted)).append("\n");
		sb.append("    buisnessUnit: ").append(toIndentedString(buisnessUnit)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    iiepCategory: ").append(toIndentedString(iiepCategory)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
