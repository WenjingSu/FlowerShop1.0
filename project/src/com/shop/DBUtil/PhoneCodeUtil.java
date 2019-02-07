package com.shop.DBUtil;

public class PhoneCodeUtil {
	public int getRandNum(int min, int max) {
		int randNum = min + (int) (Math.random() * ((max - min) + 1));
		return randNum;
	}
}
