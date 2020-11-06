package com.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

import org.springframework.stereotype.Controller;
@Controller
public class OtpGenerator {
	static char[] generateOTP(int len) 
	{ 
		System.out.println("Generating OTP using random() : ");  
		// Using numeric values 
		String numbers = "0123456789"; 

		// Using random method 
		Random rndm_method = new Random(); 

		char[] otp = new char[len]; 

		for (int i = 0; i < len; i++) 
		{ 
			// Use of charAt() method : to get character value 
			// Use of nextInt() as it is scanning the value as int 
			otp[i] = 
					numbers.charAt(rndm_method.nextInt(numbers.length())); 
		} 
		//char[] otpArray = generateOTP(4); 	
		String otpval = String.valueOf(otp);
		String otpStr = otpval;  
		
		OtpGenerator.sendSMS(otpval);
		System.out.println(" Generated otp is : "+ otpval);
		System.out.println(" sendSMS called successfully");
		return otp;	
	}

	public static void sendSMS(String otpStr) {
		try {
			String apiKey ="apiKey=" + "0ywgnPA6rfo-iBzRgzRmGbxAFZyKINcH7D3nJlBFDo";
			String message = "&message=" + URLEncoder.encode("Dear Customer Your OTP from supriya is: " + otpStr,"UTF-8");
			String numbers = "&numbers=" + "957398345";
			String apiURL ="https://api.textlocal.in/send/?" + apiKey + message + numbers;
			URL url = new URL(apiURL);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			StringBuilder sb = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			System.out.println(sb.toString());

		}
	catch(Exception e) {
		e.printStackTrace();
	}
}
} 