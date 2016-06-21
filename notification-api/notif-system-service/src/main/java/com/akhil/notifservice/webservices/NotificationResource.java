/**
 * 
 */
package com.akhil.notifservice.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akhil.notifcore.beans.UserNotificationMeta;
import com.akhil.notifcore.service.NotificationService;

/**
 * @author akhil
 *
 */
@Component
@Path("/notification/")
public class NotificationResource {
	@Autowired
	NotificationService notificationService;

	@GET
	@Produces("application/json")
	public UserNotificationMeta getUserNotifications(
			@QueryParam("userId") Long userId,
			@QueryParam("noOfRecords") Integer noOfRecords) throws Exception {
		return notificationService.getUserNotifications(userId, noOfRecords);
	}

	@PUT
	@Produces("application/json")
	@Path("/{id}")
	public String updateNotificationStatus(@PathParam("id") Long userId)
			throws Exception {
		return notificationService.updateNotifications(userId);
	}
}
