package com.aytugakin.ttablegen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TtablegenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtablegenApplication.class, args);
	}
	//TODO TimetableService'te groupSize'ları 0 olanları hiç db'ye yazdırma.
	//TODO Frontend için uygun GET endpointlerini yaratmaya başla.
}
