package com.couriermanagement.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Courier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String senderName;
	private String senderAddress;
	private long senderNumber;
	private String receiverName;
	private String receiverAddress;
	private long receiverNumber;
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	private int weight;
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff assignstaff;
	private String trackingNo;
	private LocalDateTime dateTime;
	private String updatestatus;

	@PrePersist
	public void prePersist() {
		if (this.dateTime == null) {
			this.dateTime = LocalDateTime.now(); // Set current date and time
		}
		if (this.trackingNo == null || this.trackingNo.isEmpty()) {
			this.trackingNo = generateTrackingNumber();
		}
	}

	private String generateTrackingNumber() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return "100" + dateTime.format(formatter) + "-" + id; // or use UUID if needed
	}

	public Courier(long id, String senderName, String senderAddress, long senderNumber, String receiverName,
			String updatestatus, String receiverAddress, long receiverNumber, Branch branch, int weight,
			String trackingNo, LocalDateTime dateTime, Staff assignstaff) {
		super();
		this.id = id;

		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderNumber = senderNumber;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverNumber = receiverNumber;
		this.branch = branch;
		this.weight = weight;
		this.assignstaff = assignstaff;
		this.trackingNo = trackingNo;
		this.dateTime = dateTime;
		this.updatestatus = updatestatus;
	}

	public String getUpdatestatus() {
		return updatestatus;
	}

	public void setUpdatestatus(String updatestatus) {
		this.updatestatus = updatestatus;
	}

	public Staff getAssignstaff() {
		return assignstaff;
	}

	public void setAssignstaff(Staff assignstaff) {
		this.assignstaff = assignstaff;
	}

	public String getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Courier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public long getSenderNumber() {
		return senderNumber;
	}

	public void setSenderNumber(long senderNumber) {
		this.senderNumber = senderNumber;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public long getReceiverNumber() {
		return receiverNumber;
	}

	public void setReceiverNumber(long receiverNumber) {
		this.receiverNumber = receiverNumber;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Courier [id=" + id + ", senderName=" + senderName + ", senderAddress=" + senderAddress
				+ ", senderNumber=" + senderNumber + ", receiverName=" + receiverName + ", receiverAddress="
				+ receiverAddress + ", receiverNumber=" + receiverNumber + ", branch=" + branch + ", weight=" + weight
				+ ", trackingNo=" + trackingNo + ", dateTime=" + dateTime + "]";
	}

	public void setPrice(double price) {
		// TODO Auto-generated method stub

	}

	public void setStaffId(Long staffId) {
		// TODO Auto-generated method stub

	}
}
