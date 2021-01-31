package com.flipkart.dao;

import java.sql.SQLException;
import java.util.UUID;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

/**
 * 
 * @author JEDI-03
 * Interface for Notification Dao Operations
 * Used for adding the notification to the database
 *
 */
public interface NotificationDaoInterface {
	
	/**
	 * Send Notification using SQL commands
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @param amount
	 * @return notification id for the record added in the database
	 * @throws SQLException
	 */
	public int sendNotification(NotificationType type,int studentId,ModeOfPayment modeOfPayment,double amount) throws SQLException;
}
