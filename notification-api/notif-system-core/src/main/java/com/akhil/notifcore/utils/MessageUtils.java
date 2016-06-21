/**
 * 
 */
package com.akhil.notifcore.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.akhil.notifcore.constants.ErrorCode;

/**
 * @author akhil
 *
 */
@Component
public class MessageUtils {
	
	@Resource
	private MessageSource notifSystemMessageSource;

	public Map<String, String> getErrorMapForCode(ErrorCode errorCode) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put(errorCode.getCode(),
				notifSystemMessageSource.getMessage(
						errorCode.getCode(), null, null));
		return errorMap;
	}
	
	public Map<String, String> getErrorMapForCode(ErrorCode errorCode, Object[] args) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put(errorCode.getCode(),
				notifSystemMessageSource.getMessage(
						errorCode.getCode(), args, null));
		return errorMap;
	}
	public String getErrorMessage(ErrorCode errorCode){
		return notifSystemMessageSource.getMessage(
				errorCode.getCode(), null, null);
	}
}
