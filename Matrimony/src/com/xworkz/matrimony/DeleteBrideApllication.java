package com.xworkz.matrimony;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class DeleteBrideApllication {

	public static void main(String[] args) {
		MatrimonyDAO dao = new MatrimonyDAOImpl();
		MatrimonyService service = new MatrimonyServiceImpl(dao);

		//service.validateAndDeleteBrideById(6);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(8);
		ids.add(9);
		int[] results = service.validateAndDeleteBrides(ids);
		for (int i = 0; i < results.length; i++) {
			if (results[i] == 0) {
				System.out.println(ids.get(i) + "bride failed to delete");

			} else {
				System.out.println(ids.get(i) + "bride deleted");
			}

		}
	}
}
