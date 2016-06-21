/**
 * 
 */
package com.akhil.notifcore.service;

import com.akhil.notifcore.beans.UserNotificationMeta;

/**
 * @author akhil
 *
 */
public interface NotificationService {
	UserNotificationMeta getUserNotifications(Long userId, Integer noOfRecords)
			throws Exception;

	String updateNotifications(Long userId) throws Exception;
}
