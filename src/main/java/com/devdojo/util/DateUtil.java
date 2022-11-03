package com.devdojo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	public String formatLocalDAteTimeToDatabaseStyle(LocalDateTime localDateTime) {
		
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:ms").format(localDateTime);
	}
	

}
