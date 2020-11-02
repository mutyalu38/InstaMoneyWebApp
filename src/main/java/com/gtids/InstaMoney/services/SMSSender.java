package com.gtids.InstaMoney.services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.gtids.InstaMoney.model.SmsDTO;
public class SMSSender {
	public static void main(String[] args) throws IOException {
		String result =sendSms();
		System.out.println("result :" + result);
	}
	
	public static String sendSms(SmsDTO smsDTO){
		String sResult = null;
		try
		{
			// Construct data
			String phonenumbers=smsDTO.getMobile();
			String data="user=" + URLEncoder.encode("GRAMTARANG", "UTF-8");
			data +="&password=" + URLEncoder.encode("Gramtarang@2020", "UTF-8");
			data +="&message=" + URLEncoder.encode(smsDTO.getMessage(), "UTF-8");
			data +="&sender=" + URLEncoder.encode("INVITE", "UTF-8");
			data +="&mobile=" + URLEncoder.encode(phonenumbers, "UTF-8");
			data +="&type=" + URLEncoder.encode("3", "UTF-8");
			// Send data 
			URL url = new URL("http://login.bulksmsgateway.in/sendmessage.php?"+data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult1="";
			while ((line = rd.readLine()) != null)
			{
				// Process line...
				sResult1=sResult1+line+" ";
			}
			wr.close();
			rd.close();
			return sResult1;
		}
		catch (Exception e)
		{
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}	
	public static String sendSms(){
		String sResult = null;
		try
		{
			// Construct data
			String phonenumbers="9014583389";
			String data="user=" + URLEncoder.encode("GRAMTARANG", "UTF-8");
			data +="&password=" + URLEncoder.encode("Gramtarang@2020", "UTF-8");
			data +="&message=" + URLEncoder.encode("hi hello", "UTF-8");
			data +="&sender=" + URLEncoder.encode("INVITE", "UTF-8");
			data +="&mobile=" + URLEncoder.encode(phonenumbers, "UTF-8");
			data +="&type=" + URLEncoder.encode("3", "UTF-8");
			// Send data 
			URL url = new URL("http://login.bulksmsgateway.in/sendmessage.php?"+data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult1="";
			while ((line = rd.readLine()) != null)
			{
				// Process line...
				sResult1=sResult1+line+" ";
			}
			wr.close();
			rd.close();
			return sResult1;
		}
		catch (Exception e)
		{
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}