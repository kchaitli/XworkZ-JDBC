package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class UpdateBrideApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService service = new MatrimonyServiceImpl(dao);
		
		BrideDTO bride = new BrideDTO();
		bride.setId(6);
		bride.setName("Aparna");
		bride.setAge(27);
		bride.setHeight(5.3);
		bride.setWeight(55.7);
		bride.setQualification("B.E");
		bride.setExpectation("well qualified");
		bride.setPhoneNumber("8971665455");
		bride.setSalary(50000);
		bride.setOccupation("Software dveloper");
		bride.setAddress("Bellary");
			
		
		service.validateAndUpdateBridePhoneNumById(bride.getPhoneNumber(), bride.getId());
	}

}
