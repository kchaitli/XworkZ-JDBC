package com.xworkz.matrimony.service;

import java.util.List;

import com.xworkz.matrimony.dto.BrideDTO;

public interface MatrimonyService {
	public BrideDTO getBride(int id);
	public BrideDTO getAllBride();
	public int validateAndCreate(BrideDTO bride);
	public int validateAndUpdateBridePhoneNumById(String phoneNum, int id);
	public int validateAndDeleteBrideById(int id);
	public int[] validateAndInsertBrides(List<BrideDTO> brides);
	public int[] validateAndUpdateBrides(List<BrideDTO> brides);
	public int[] validateAndDeleteBrides(List<Integer> ids);
}
