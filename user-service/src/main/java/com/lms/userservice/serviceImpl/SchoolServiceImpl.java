package com.lms.userservice.serviceImpl;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.userservice.entity.Schools;
import com.lms.userservice.model.ResponseModel;
import com.lms.userservice.repository.SchoolRepository;
import com.lms.userservice.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepo;
	@Override
	public void save(Schools schools) {
		schoolRepo.save(schools);
		
	}
	
	public ResponseEntity<?> update(String id, Schools schools) {
		Object responseModel = null;
		
		Optional<Schools> schooldata=schoolRepo.findById(id);
		if (schooldata.isPresent())
		{
			Schools updatedschool=schooldata.get();
			updatedschool.setSchoolName(schools.getSchoolName());
			updatedschool.setCityName(schools.getCityName());
			updatedschool.setPocEmail(schools.getPocEmail());
			updatedschool.setPhoneNumber(schools.getPhoneNumber());
			updatedschool.setWebsite(schools.getWebsite());
			updatedschool.setSignatoryName(schools.getSignatoryName());
			updatedschool.setSignatoryRole(schools.getSignatoryRole());
			updatedschool.setSchoolType(schools.getSchoolType());
			schoolRepo.save(updatedschool);	
			responseModel = new ResponseModel(true, "School Updated Suessfully", null);
			return ResponseEntity.accepted().body(responseModel);

		}
		else
		{
			 responseModel = new ResponseModel(false, "School details not found", null);
			 return ResponseEntity.accepted().body(responseModel);


		}
	

		
	}

}
