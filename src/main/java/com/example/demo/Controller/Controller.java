package com.example.demo.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Job;
import com.example.demo.Model.Pagedata;
import com.example.demo.Model.Interview;
import com.example.demo.Model.Employee.Employee;
import com.example.demo.Model.Employee.EmployeePagedata;
import com.example.demo.Response.CandidateRespon;
import com.example.demo.Response.Interviewerresponse;
import com.example.demo.Response.Responese;
import com.example.demo.Service.ServiceCon;
import com.example.demo.Model.Candidate;

@RestController
@CrossOrigin
public class Controller {
	
	
	@Autowired
	ServiceCon service;
	

	//Candidate Add And Update
	@PostMapping("Candidate")
	public ResponseEntity<CandidateRespon> Candidate(@RequestBody com.example.demo.Model.Candidate ob)
	{
		return service.Candidate(ob);
	}
	
	//Candidate PageNation
		@GetMapping("page")
		public ArrayList<Pagedata> Pageable(Pageable pageable) 
		{
			return service.Pageable(pageable);
		}
		
		//Candidate full details
		@GetMapping("fulldetails/{id}")
		public Candidate fulldetails(@PathVariable String id)
		{
			return service.fulldetails(id);
		}
		
		//Candidate Delete
		@DeleteMapping("deletecandidate/{id}")
		public String deletecandidate(@PathVariable String id)
		{
			return service.deletecandidate(id);
		}
		
		//Login
		@PutMapping("Login")
		public ResponseEntity<Responese> Login(@RequestBody Employee ob) {
			return service.Login(ob);
    	 
     }
		
		//DashBoard
	@GetMapping("DashBoard")
	public ArrayList<com.example.demo.Model.DashBoard> DashBoard()
	{
	
	return service.DashBoard();
	}
	
	//DropDownList
	@GetMapping("Jobs")
	public Job Jobs()
	{
		return service.Jobs();
	}
	
	//User Management
	//Interviewer add
	@PostMapping("Interviewer")
	public String Interviewer(@RequestBody Interview ob)
	{
		return service.Interviewer(ob);
	}
	
	@GetMapping("today")
	public ResponseEntity<Interviewerresponse> today(@RequestBody Interview ob)
	{
		return service.today(ob);
	}



	//Employee Add And Update
	@PostMapping("employee")
	public String employee(@RequestBody Employee ob)
	{
		return service.employee(ob);
	}
	
	//Employee Pagination
	@GetMapping("employeepage")
	public ArrayList<EmployeePagedata> employeepage(Pageable pageable)
	{
		return service.employeepage(pageable);
	}
	
	//Employee FullList
	@GetMapping("Employee/{username}")
	public Employee Employeefulldetails(@PathVariable String username) {
		return service.Employeefulldetails(username);
	}
	
	//UserName Checking
	@PostMapping("usernamecheck")
	public String usernamecheck(@RequestParam("username") String username)
	{
		return service.usernamecheck(username);
	}
	
	//Password change
	@PostMapping("changeotp")
	public String changeotp(@RequestBody Employee ob)
	{
		return service.changeotp(ob);
	}
	
	//Delete Employee
	@DeleteMapping("employeedelete/{username}")
	public String employeedelete(@PathVariable String username)
	{
		return service.employeedelete(username);
	}
	
}
