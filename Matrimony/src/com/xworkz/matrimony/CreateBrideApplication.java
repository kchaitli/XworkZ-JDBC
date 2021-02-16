package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class CreateBrideApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService service= new MatrimonyServiceImpl(dao);
		
		BrideDTO bride = new BrideDTO();
		bride.setId(6);
		bride.setName("Aparna");
		bride.setAge(27);
		bride.setHeight(5.3);
		bride.setWeight(55.7);
		bride.setQualification("B.E");
		bride.setExpectation("well qualified");
		bride.setPhoneNumber("8374882737");
		bride.setSalary(50000);
		bride.setOccupation("Software dveloper");
		bride.setAddress("Bellary");
		
		int result = service.validateAndCreate(bride);
		if(result==1) {
			System.out.println("bride created successfully");
		}else {
			System.out.println("failed to create bride");
		}
	}

}
