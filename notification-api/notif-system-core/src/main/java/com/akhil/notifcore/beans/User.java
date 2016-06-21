/**
 * 
 */
package com.akhil.notifcore.beans;

/**
 * @author akhil
 *
 */
public class User {
	private Long id;
	private String firstName;
	private String lasteName;
	private String email;
	private String dpPath;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lasteName
	 */
	public String getLasteName() {
		return lasteName;
	}

	/**
	 * @param lasteName
	 *            the lasteName to set
	 */
	public void setLasteName(String lasteName) {
		this.lasteName = lasteName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dpPath
	 */
	public String getDpPath() {
		return dpPath;
	}

	/**
	 * @param dpPath
	 *            the dpPath to set
	 */
	public void setDpPath(String dpPath) {
		this.dpPath = dpPath;
	}
}
