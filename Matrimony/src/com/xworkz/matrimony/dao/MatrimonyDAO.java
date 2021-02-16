package com.xworkz.matrimony.dao;

import java.util.List;

import com.xworkz.matrimony.dto.BrideDTO;

public interface MatrimonyDAO {
	public BrideDTO getById(int id);
	public BrideDTO getAll();
	public int createBride(BrideDTO bride);
	public int updatePhoneNumById(String phoneNum, int id);
	public int deleteBrideById(int id);
	public int[] insertBride(List<BrideDTO> brides);
	public int[] insertBrideUsingPreparedstmt(List<BrideDTO> brides);
	public int[] updateBrides(List<BrideDTO> brides);
	public int[] deleteBridesUsingPreparedstmt(List<Integer> ids);
}
