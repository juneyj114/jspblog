package com.cos.util;

import java.security.MessageDigest;

// 256bit 길이의 암호
public class SHA256 {
	// password를 암호화해서 리턴
	
	public static String getEncrypt(String rawPassword, String salt) {
		String result = "";
		
		byte[] b = (rawPassword+salt).getBytes();
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(b); // b를 암호화
			byte[] bResult = md.digest();
//			for (byte by : bResult) {
//				System.out.print(by+ " ");
//			}
			StringBuffer sb = new StringBuffer();
			for (byte item : bResult) {
				sb.append(Integer.toString(item & 0xff, 16));
			}
			result = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
//	public static void main(String[] args) {
//		byte b = 117;
//		String s = Integer.toString(b);
//		System.out.println(s);
//		
//		// 00000000 00000000 00000000 10010110 = int
//		// 11111111 11111111 11111111 10010110 = binary
//		// 00000000 00000000 00000000 11111111 = 0xff
//		// 데이터 변조를 막기 위해 둘을 and연산
//		int i = 150;
//		System.out.println(Integer.toBinaryString(i));
//		
//		System.out.println(Integer.toString((byte)i & 0xff, 16));
//	}
	
}
