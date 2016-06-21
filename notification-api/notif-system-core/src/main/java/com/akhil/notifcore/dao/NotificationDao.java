/**
 * 
 */
package com.akhil.notifcore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.akhil.notifcore.beans.UserNotification;

/**
 * @author akhil
 *
 */
public interface NotificationDao {
	public List<UserNotification> getNotifications(
			@Param("userId") Long userId,
			@Param("noOfRecords") Integer noOfRecords);

	public Integer markNotificationsAsRead(@Param("userId") Long userId);

	public Long getTotalUnreadRecords(@Param("userId") Long userId);
}
