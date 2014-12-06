package com.maxfields;

import java.io.IOException;

import javax.servlet.http.*;

import org.mortbay.util.ajax.JSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


@SuppressWarnings("serial")
public class MaxfieldsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		System.out.println("gettingMaxEcvents");
	    JSON events = getMaxEvents();
	    insertMaxEvents();
		
		System.out.println("gettingMaxEvents result" + events);
		
//		resp.setContentType("text/plain");
//		resp.getWriter().println("Hello, world");
	}
	
	
	public static JSON getMaxEvents() {
		JSON eventJSON = new JSON();
		String strTemp = new String();
		try {
			URL url = new URL("https://www.kimonolabs.com/api/38jx3tdm?apikey=zWrn2ebELarjVeEJpAgP9rS6t1EM4bXQ");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			while (null != (strTemp = br.readLine())) {
				System.out.println(strTemp);
			}
			strTemp = br.toString();
			eventJSON.fromJSON(strTemp);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eventJSON;
	}
	
	public static void insertMaxEvents() {
		try {
			System.out.println("Call Calendar Insert API with JSON");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
 

