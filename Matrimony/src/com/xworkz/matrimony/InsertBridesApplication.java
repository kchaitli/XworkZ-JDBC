package com.xworkz.matrimony;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class InsertBridesApplication {

	public static void main(String[] args) {
		
		BrideDTO bride = new BrideDTO();
		bride.setId(8);
		bride.setName("Nagashree");
		bride.setAge(23);
		bride.setHeight(5.3);
		bride.setWeight(40);
		bride.setQualification("B.E");
		bride.setExpectation("6 feet height");
		bride.setPhoneNumber("8374882737");
		bride.setSalary(50000);
		bride.setOccupation("Software engineer");
		bride.setAddress("Mandya");
		
		BrideDTO bride2= new BrideDTO();
		bride2.setId(9);
		bride2.setName("Lalitha");
		bride2.setAge(22);
		bride2.setHeight(4.9);
		bride2.setWeight(45);
		bride2.setQualification("B.E");
		bride2.setExpectation("No existing loans");
		bride2.setPhoneNumber("8374882737");
		bride2.setSalary(80000);
		bride2.setOccupation("Software dveloper");
		bride2.setAddress("Gadag");
		
		MatrimonyDAO matrimonyDAO= new MatrimonyDAOImpl();
		MatrimonyService service = new MatrimonyServiceImpl(matrimonyDAO);
		
		List<BrideDTO> brides = new ArrayList<BrideDTO>();
		brides.add(bride);
		brides.add(bride2);
		int[] results=service.validateAndInsertBrides(brides);
		for(int i=0;i<results.length;i++) {
			if(results[i]==0) {
				System.out.println(brides.get(i).getName()+" th bride failed to create");
			}else {
				System.out.println(brides.get(i).getName()+" th bride created sucessfully");
			}
		}
		
	}

}
