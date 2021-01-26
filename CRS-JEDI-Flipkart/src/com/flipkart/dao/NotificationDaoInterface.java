package com.flipkart.dao;

import java.sql.SQLException;
import java.util.UUID;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

/**
 * 
 * @author JEDI-03
 * used for adding the notification to the database
 *
 */
public interface NotificationDaoInterface {
	/**
	 * 
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @return notification id for the record added in the database
	 */
	public int sendNotification(NotificationType type,int studentId,ModeOfPayment modeOfPayment) throws SQLException;
}
