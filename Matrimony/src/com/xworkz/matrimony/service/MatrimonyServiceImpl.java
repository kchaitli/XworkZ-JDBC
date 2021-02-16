package com.xworkz.matrimony.service;

import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dto.BrideDTO;

public class MatrimonyServiceImpl implements MatrimonyService {
	private MatrimonyDAO matrimonyDAO;

	public MatrimonyServiceImpl(MatrimonyDAO matrimonyDAO) {
		this.matrimonyDAO = matrimonyDAO;
	}

	@Override
	public BrideDTO getBride(int id) {
		if (id == 0) {
			System.out.println("invalid id");
			return null;
		}
		return matrimonyDAO.getById(1);
	}

	@Override
	public int validateAndCreate(BrideDTO bride) {
		if (null == bride) {
			System.out.println("bride can not be null");
			return 0;
		} else if (bride.getId() == 0) {
			System.out.println("Invalid Id");
			return 0;
		} else {
			return matrimonyDAO.createBride(bride);
		}

	}

	@Override
	public int validateAndUpdateBridePhoneNumById(String phoneNum, int id) {
		if (null == phoneNum || 10 != phoneNum.length() || 0 == id) {
			System.out
					.println("validation failed either the phone number is null or length is not 10 or id is invalid");
			return 0;
		} else {
			return matrimonyDAO.updatePhoneNumById(phoneNum, id);
		}

	}

	@Override
	public BrideDTO getAllBride() {
		return matrimonyDAO.getAll();
	}

	@Override
	public int validateAndDeleteBrideById(int id) {
		if (0 == id) {
			System.out.println("id is not valid");
			return 0;
		} else {
			return matrimonyDAO.deleteBrideById(id);
		}
	}

	@Override
	public int[] validateAndInsertBrides(List<BrideDTO> brides) {
		if (brides == null) {
			System.out.println("bride list cannot be null");
			int[] result = new int[brides.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = 0;
			}
			return result;
		}
		// conflict id validations
		else {
			return matrimonyDAO.insertBride(brides);
		}
	}

	@Override
	public int[] validateAndUpdateBrides(List<BrideDTO> brides) {
		if (brides == null) {
			System.out.println("Brides list can not be null");
			int[] results = new int[brides.size()];
			for (int i = 0; i < results.length; i++) {
				results[i] = 0;
			}
			//timespeedDistance(train), time & work, pipes and cisterns, probability, profit&loss
			return results;
		} else {
			return matrimonyDAO.updateBrides(brides);
		}

	}

	public int[] validateAndDeleteBrides(List<Integer> ids){
		if (ids == null) {
			System.out.println("brides list can not be null");
			int[] results = new int[ids.size()];
			for (int i = 0; i < results.length; i++) {
				results[i] = 0;
			}
			return results;
		} else {
			return matrimonyDAO.deleteBridesUsingPreparedstmt(ids);
		}

	}

}
