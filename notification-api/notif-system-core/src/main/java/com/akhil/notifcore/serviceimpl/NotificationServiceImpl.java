/**
 * 
 */
package com.akhil.notifcore.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.notifcore.beans.UserNotification;
import com.akhil.notifcore.beans.UserNotificationMeta;
import com.akhil.notifcore.constants.ErrorCode;
import com.akhil.notifcore.dao.NotificationDao;
import com.akhil.notifcore.service.NotificationService;
import com.akhil.notifcore.utils.MessageUtils;
import com.akhil.notifcore.utils.exceptions.ServiceException;

/**
 * @author akhil
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService {
	private static final Logger LOGGER = Logger
			.getLogger(NotificationServiceImpl.class);
	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	MessageUtils messageUtils;

	@Override
	public UserNotificationMeta getUserNotifications(Long userId,
			Integer noOfRecords) throws Exception {
		LOGGER.info("Getting " + noOfRecords
				+ " latest notifications for userID: " + userId);
		UserNotificationMeta metaInfoWithNotifications = new UserNotificationMeta();
		List<UserNotification> notifications = null;
		Long totalUnreadRecords = 0l;
		try {
			notifications = notificationDao.getNotifications(userId,
					noOfRecords);
			totalUnreadRecords = notificationDao.getTotalUnreadRecords(userId);
		} catch (Exception e) {
			LOGGER.error("Error occurred while getting notifications for userId:"
					+ userId);
			throw new ServiceException(
					messageUtils.getErrorMapForCode(ErrorCode.INTERNAL_ERROR));
		}

		metaInfoWithNotifications.setNotifications(notifications);
		metaInfoWithNotifications.setUnreadRecords(totalUnreadRecords);
		return metaInfoWithNotifications;
	}

	@Override
	public String updateNotifications(Long userId) throws Exception {
		Integer retVal = 0;
		try {
			retVal = notificationDao.markNotificationsAsRead(userId);
		} catch (Exception e) {
			LOGGER.error("Error occurred while marking notifications in DB for userId: "
					+ userId);
			throw new ServiceException(
					messageUtils.getErrorMapForCode(ErrorCode.INTERNAL_ERROR));
		}
		if (retVal > 0) {
			LOGGER.info(retVal + " notifications updated successfully");
			return "{\"message\":\"notifications updated successfully\"}";
		} else {
			LOGGER.warn("No notifications updated");
			return "{\"message\":\"No notifications updated\"}";
		}
	}
}
