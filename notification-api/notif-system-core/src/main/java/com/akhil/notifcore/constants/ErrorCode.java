/**
 * 
 */
package com.akhil.notifcore.constants;

/**
 * @author akhil
 *
 */
public enum ErrorCode {
	INVALID_USER_ID("NOTIF_100"),
	INTERNAL_ERROR("NOTIF_101");
	private final String code;

	ErrorCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

}
