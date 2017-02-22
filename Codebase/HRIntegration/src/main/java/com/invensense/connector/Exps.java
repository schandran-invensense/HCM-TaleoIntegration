package com.invensense.connector;

import java.text.DateFormat;
import com.invensense.model.hcmtaleo.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.format.datetime.joda.DateTimeFormatterFactory;

public class Exps {

	public static void main(String[] args) {
		
		reverse();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
	dateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		String dateTime=dateFormat.format(cal.getTime());
		System.out.println("Final date:::"+dateTime.replace("Z", "PST"));
		System.out.println("Time : "+dateFormat.format(cal.getTime()));
	//	Date date = new Date();
	//	System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		
		/*String date = "2009-07-16T19:20:30-05:00";
		String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
		DateTimeFormatter dtf = DateTimeFormatterFactory.forPattern(pattern);
		DateTime dateTime = dtf.parseDateTime(date);
		System.out.println(dateTime); // 2009-07-16T19:20:30-05:00
*/	}

	public static void reverse()
	{
		List<HCMTaleoEmployee> hcmTaleoEmps = new ArrayList<HCMTaleoEmployee>();
		HCMTaleoEmployee hcmTaleoEmp= new HCMTaleoEmployee();
		hcmTaleoEmp.setEmployeeId("E1");
		hcmTaleoEmp.setHcmPersonId("P1");
		hcmTaleoEmp.setHcmPersonName("Pname1");
		hcmTaleoEmps.add(hcmTaleoEmp);
		HCMTaleoEmployee hcmTaleoEmp1= new HCMTaleoEmployee();
		
		hcmTaleoEmp1.setEmployeeId("E2");
		hcmTaleoEmp1.setHcmPersonId("P2");
		hcmTaleoEmp1.setHcmPersonName("Pname2");
		hcmTaleoEmps.add(hcmTaleoEmp1);
		HCMTaleoEmployee hcmTaleoEmp2= new HCMTaleoEmployee();
		
		hcmTaleoEmp2.setEmployeeId("E3");
		hcmTaleoEmp2.setHcmPersonId("P3");
		hcmTaleoEmp2.setHcmPersonName("Pname3");
		hcmTaleoEmps.add(hcmTaleoEmp2);
		
		for(int i=0;i<hcmTaleoEmps.size();i++)
		{
			System.out.println("Person id :: "+hcmTaleoEmps.get(i).getHcmPersonId());
		}
		Collections.reverse(hcmTaleoEmps);
		for(int i=0;i<hcmTaleoEmps.size();i++)
		{
			System.out.println("Person id :: "+hcmTaleoEmps.get(i).getHcmPersonId());
		}
	}
}
