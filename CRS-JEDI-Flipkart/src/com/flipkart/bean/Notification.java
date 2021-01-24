package com.flipkart.bean;

import com.flipkart.constant.NotificationType;

public class Notification {
	private int notificationId;
	private int studentId;
	private NotificationType type;
	private String referenceId;
	
	public Notification(int notificationId,int studentId, NotificationType type,String referenceId)
	{
		this.studentId = studentId;
		this.type = type;
		this.setReferenceId(referenceId);
	}
	
	public int getNotificationId() {
		return notificationId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public NotificationType getType() {
		return type;
	}
	public void setType(NotificationType type) {
		this.type = type;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
