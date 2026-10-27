package com.klef.soa.docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.docker.entity.DaycareCenter;
import com.klef.soa.docker.repository.DaycareCenterRepository;

@Service
public class DaycareCenterServiceImpl implements DaycareCenterService{

	@Autowired
	private DaycareCenterRepository repository;
	
	
	@Override
	public DaycareCenter add(DaycareCenter ds) {
		// TODO Auto-generated method stub
		return repository.save(ds);
	}

	@Override
	public List<DaycareCenter> displayAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public String deleteById(long id) {
		// TODO Auto-generated method stub
		boolean flag = repository.existsById(id);
		
		if(flag) {
			
			repository.deleteById(id);
			return "Record Deleted Successfully..!!";
		}
		
		else {
			return "Record Not found..!!";
		}
	}

}
