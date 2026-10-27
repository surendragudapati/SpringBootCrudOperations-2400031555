package com.klef.soa.docker.service;

import java.util.List;

import com.klef.soa.docker.entity.DaycareCenter;

public interface DaycareCenterService {

	DaycareCenter add(DaycareCenter ds);
	
	List<DaycareCenter> displayAll();
	
	String deleteById(long id);
}
