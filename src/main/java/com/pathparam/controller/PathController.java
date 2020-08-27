package com.pathparam.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class PathController {
	@GetMapping({"","/{date}"})
	public String greet(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Optional<LocalDate> date ) {
		
		if(date.isPresent()) {
			return "Hello "+date.get();
		}
		
		else
			return "hello "+new SimpleDateFormat("dd/mm/yyyy").format(new Date());
	}

}
