/**
 * 
 */
package com.akhil.notifcore.beans;

import java.util.List;

/**
 * @author akhil
 *
 */
public class UserNotificationMeta {
	private List<UserNotification> notifications;
	private Long unreadRecords;

	/**
	 * @return the notifications
	 */
	public List<UserNotification> getNotifications() {
		return notifications;
	}

	/**
	 * @param notifications
	 *            the notifications to set
	 */
	public void setNotifications(List<UserNotification> notifications) {
		this.notifications = notifications;
	}

	/**
	 * @return the unreadRecords
	 */
	public Long getUnreadRecords() {
		return unreadRecords;
	}

	/**
	 * @param unreadRecords
	 *            the unreadRecords to set
	 */
	public void setUnreadRecords(Long unreadRecords) {
		this.unreadRecords = unreadRecords;
	}
}
