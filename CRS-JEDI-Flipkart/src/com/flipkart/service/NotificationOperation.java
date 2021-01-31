package com.flipkart.service;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;
import com.flipkart.dao.NotificationDaoInterface;
import com.flipkart.dao.NotificationDaoOperation;

/**
 * 
 * @author JEDI-03
 * This method implements all the method related to the notification system
 */
public class NotificationOperation implements NotificationInterface {

	private static volatile NotificationOperation instance=null;
	NotificationDaoInterface notificationDaoInterface=NotificationDaoOperation.getInstance();
	private static Logger logger = Logger.getLogger(NotificationOperation.class);
	private NotificationOperation()
	{

	}
	
	/**
	 * Method to make NotificationDaoOperation Singleton
	 * @return
	 */
	public static NotificationOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(NotificationOperation.class){
				instance=new NotificationOperation();
			}
		}
		return instance;
	}
	
	/**
	 * Method to send notification
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: payment mode used
	 * @return notification id for the record added in the database
	 */
	@Override
	public int sendNotification(NotificationType type, int studentId,ModeOfPayment modeOfPayment,double amount) {
		int notificationId=0;
		try
		{
			notificationId=notificationDaoInterface.sendNotification(type, studentId,modeOfPayment,amount);
			
		}
		catch(SQLException ex)
		{
			logger.error("Error occured "+ex.getMessage());
		}
		return notificationId;
	}

	/**
	 * Method to return UUID for a transaction
	 * @param notificationId: notification id added in the database
	 * @return transaction id of the payment
	 */
	@Override
	public UUID getReferenceId(int notificationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
