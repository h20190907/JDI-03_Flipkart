package com.flipkart.service;

import java.util.UUID;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

/**
 * 
 * @author JEDI-03
 * Notification logic for sending notifications for multiple events such as
 * 1. Student Registration
 * 2. Registration Approval
 * 3. Fee payment
 */
public interface NotificationInterface {
	
	/**
	 * Method to send notification
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: payment mode used
	 * @return notification id for the record added in the database
	 */
	public int sendNotification(NotificationType type,int studentId,ModeOfPayment modeOfPayment,double amount);
	
	/**
	 * Method to return UUID for a transaction
	 * @param notificationId: notification id added in the database
	 * @return transaction id of the payment
	 */
	public UUID getReferenceId(int notificationId); 
}
