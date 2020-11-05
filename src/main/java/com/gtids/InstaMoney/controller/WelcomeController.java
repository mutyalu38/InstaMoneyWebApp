package com.gtids.InstaMoney.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtids.InstaMoney.exception.ErrorDetails;
import com.gtids.InstaMoney.model.Loans;
import com.gtids.InstaMoney.model.TblBankAdmin;
import com.gtids.InstaMoney.repository.LoansRepository;

@Controller
public class WelcomeController {
	
	
	@Autowired
	private LoansRepository loansRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Value("${app.title}")
    private String appTitle;
	
	@RequestMapping(value="/")
	public String welcome(HttpSession session) {
		System.out.println("Index page >>"+session.getAttribute("LoginId")+"\t>>>1."+appTitle);
		return "index";
	}
	
	@RequestMapping(value="/about")
	public String about(HttpSession session) {
		System.out.println("About page >>"+session.getAttribute("LoginId"));
		return "about";
	}
	
	@RequestMapping(value="/contact")
	public String contact(HttpSession session) {
		System.out.println("Contact page >>"+session.getAttribute("LoginId"));
		return "contact";
	}
	
	
	
	/*@RequestMapping(value = "/logout2", method = RequestMethod.GET)	
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("logout is calling...!");
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response,
					authentication);
		}

		return "redirect:/";
	}*/
	

	
	@RequestMapping(value="/test")
	public String welcomeTest() {
		return "test";
	}
	
	@RequestMapping(value="/todayLoanDetails",method = RequestMethod.GET)
	public String todayLoanDetails(Model model) {
		//set Model 
		System.out.println("Calling............todayLoanDetails()");
		
		List<Loans> loans= loansRepository.findCurrentDateWithBranchLoanApps();
		
		model.addAttribute("resultList", loans);
		
		return "todayLoanDetails";
	}
	
	
	
	
	@RequestMapping(value = "/dashBoard", method = RequestMethod.POST)
	public String login(Model model,TblBankAdmin tblBankAdmin,HttpSession session,HttpServletRequest request) throws MalformedURLException {
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.set("Content-Type", "application/json");

        HttpEntity<TblBankAdmin> requestEntity = new HttpEntity<>(tblBankAdmin, headers);
        
        String endpointUrl=getURLBase(request)+"/rest/isValidUser";
        System.out.println("Endpoint URL >> "+endpointUrl);
        ResponseEntity<TblBankAdmin> responseEntity= null;
        try {
        	responseEntity= restTemplate.exchange(endpointUrl, HttpMethod.POST, requestEntity, TblBankAdmin.class);
        } catch (HttpClientErrorException e) {
        	e.printStackTrace();
        	//printLog( "callToRestService Error :" + exception.getResponseBodyAsString());
        	//Handle exception here
        	ObjectMapper objectMapper = new ObjectMapper();
        	try {
        		ErrorDetails errorDetails = objectMapper.readValue(e.getResponseBodyAsString(), ErrorDetails.class);
        		if(errorDetails.getMessage()!=null) {
        			model.addAttribute("errorMsg", errorDetails.getMessage());
        		}
        	} catch (JsonMappingException e1) {
        		// TODO Auto-generated catch block
        		e1.printStackTrace();
        	} catch (JsonProcessingException e1) {
        		// TODO Auto-generated catch block
        		e1.printStackTrace();
        	}
        	return "index";
        }catch (HttpStatusCodeException e) {
        	e.printStackTrace();
        	
        	/*ResponseEntity<String> responseEntity1 = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());*/
        	ObjectMapper objectMapper = new ObjectMapper();
        	 try {
				ErrorDetails errorDetails = objectMapper.readValue(e.getResponseBodyAsString(), ErrorDetails.class);
				if(errorDetails.getMessage()!=null) {
					model.addAttribute("errorMsg", errorDetails.getMessage());
				}
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	//responseEntity1.getBody();
        	return "index";
        }catch(RestClientException e){
            //no response payload, tell the user sth else
        	return "index";
        }

        model.addAttribute("todayscount", loansRepository.findCurrentDateLoanAppCount());
        model.addAttribute("last7dayscount",loansRepository.findSevenDaysLoanAppCount());
        
        model.addAttribute("totalNotificationcount","1");
        model.addAttribute("allcount",loansRepository.count());

        
		session.setAttribute("LoginId", tblBankAdmin.getUserName());
		return "dashboard";
	}
	
	
	public String getURLBase(HttpServletRequest request) throws MalformedURLException {

	    URL requestURL = new URL(request.getRequestURL().toString());
	    String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
	    return requestURL.getProtocol() + "://" + requestURL.getHost() + port;

	}
}
