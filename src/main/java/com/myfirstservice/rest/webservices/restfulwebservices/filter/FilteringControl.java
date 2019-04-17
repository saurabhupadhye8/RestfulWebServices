package com.myfirstservice.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringControl {
	
	@GetMapping(path = "/filtering")
	public MappingJacksonValue retriewBean() {
		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
		
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
		
	}
	
	@GetMapping(path = "/filtering-list")
	public MappingJacksonValue retrieveListBean() {
		
		List <SomeBean> listBean = Arrays.asList((new SomeBean("Value1", "Value2", "Value3")), new SomeBean("One", "Two", "Three"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3 ");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(listBean);
		
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}

}
