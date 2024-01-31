package com.example.rest.webservices.restfultwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	@GetMapping("/static-filtering")
	public SomeBean staticFiltering() {
		return new SomeBean("valu1", "value2", "value3", "value4", "valuee5");
	}

	@GetMapping("/static-filtering/list")
	public List<SomeBean> staticFilteringList() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4", "valuee5"),
				new SomeBean("value6", "value7", "value8", "vcalue9", "value10"),
				new SomeBean("value11", "value12", "value13", "value14", "value15"));
	}

}
