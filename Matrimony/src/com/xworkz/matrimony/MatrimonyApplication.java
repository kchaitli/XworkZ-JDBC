package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class MatrimonyApplication {

	public static void main(String[] args) {
		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(dao);
		BrideDTO brideDTO=matrimonyService.getBride(1);
		if(brideDTO!=null) {
		System.out.println(brideDTO);
		}
		matrimonyService.getAllBride();
	}

}
