package com.flipkart.bean;

import com.flipkart.constant.NotificationType;

/**
 * 
 * @author JEDI-03
 * Class that sends notification for different events
 *
 */
public class Notification {
	private int notificationId;
	private int studentId;
	private NotificationType type;
	private String referenceId;
	
	/**
	 * Parameterized constructor
	 * @param notificationId: notification id in the database
	 * @param studentId: student id of the student
	 * @param type: type of notificaton
	 * @param referenceId: reference id for the payment
	 */
	public Notification(int notificationId,int studentId, NotificationType type,String referenceId)
	{
		this.notificationId = notificationId;
		this.studentId = studentId;
		this.type = type;
		this.referenceId = referenceId;
	}
	
	/**
	 * Method to get Notification Id
	 * @return Notification Id
	 */
	public int getNotificationId() {
		return notificationId;
	}
	
	/**
	 * Method to get Student Id of student enrolled in the course
	 * @return Student Id
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Method to set Student Id of student enrolled in the course
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Method to get Notification Type
	 * @return Notification Type
	 */
	public NotificationType getType() {
		return type;
	}
	
	/** 
	 * Method to set Notification Type
	 * @param type
	 */
	public void setType(NotificationType type) {
		this.type = type;
	}

	/**
	 * Method to get Reference Id
	 * @return Reference Id
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * Method to set Reference Id
	 * @param referenceId
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
