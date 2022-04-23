package com.example.demo.Service;

import java.util.ArrayList;
import com.example.demo.Model.Candidate;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Model.DashBoard;
import com.example.demo.Model.Job;
import com.example.demo.Model.Pagedata;
import com.example.demo.Model.Interview;
import com.example.demo.Model.Employee.Employee;
import com.example.demo.Model.Employee.EmployeePagedata;
import com.example.demo.Repository.CandidateRepo;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Repository.InterViewRepo;
import com.example.demo.Repository.JobsRepo;
import com.example.demo.Response.CandidateRespon;
import com.example.demo.Response.DashBoardRepo;
import com.example.demo.Response.Data;
import com.example.demo.Response.Interviewerresponse;
import com.example.demo.Response.Interviewrespon;
import com.example.demo.Response.Responese;

@Service
public class ServiceCon {
	
	@Autowired
	CandidateRepo can;
	@Autowired
	EmployeeRepo emp;
	@Autowired
	DashBoardRepo dash;
	@Autowired 
	JobsRepo job;
	@Autowired
	InterViewRepo inter;
	public String Name;
	
	//Candidate Add And Update
	public ResponseEntity<CandidateRespon> Candidate(Candidate ob)
	{
		if(ob.getId() == null) {
			if(can.existsByEmail(ob.getEmail()) == false) {
				if(can.existsByPhoneno(ob.getPhoneno()) == false) {
					can.insert(ob);
				   // Data data=new Data(ob.getId(),ob.getFirstname(),ob.getEmail(),ob.getPhoneno(),ob.getStatus());
					return new ResponseEntity<>(new CandidateRespon(true,"Sucess"),HttpStatus.ACCEPTED);
					
				}else
				{
					return new ResponseEntity<>(new CandidateRespon(false,"Already Phoneno Taken"),HttpStatus.UNAUTHORIZED);
				}
			}else {
				return new ResponseEntity<>(new CandidateRespon(false,"Alredy Email Taken"),HttpStatus.UNAUTHORIZED);
			}
		}
		else
		{
			
			if(can.existsByEmailAndIdIsNot(ob.getEmail(),ob.getId()) == false); {
		if(can.existsByPhonenoAndIdIsNot(ob.getPhoneno(),ob.getId()) == false);	{
		can.save(ob);
		return new ResponseEntity<>(new CandidateRespon(true,"Susess update"),HttpStatus.ACCEPTED);
		}
		}
		}
		}
	

	//Candidate Pagination
	public ArrayList<Pagedata> Pageable(Pageable pageable) 
	{
		Page<Candidate> ob1=can.findAll(pageable);
		ArrayList<Pagedata> list=new ArrayList<Pagedata>();
		for(Candidate ob:ob1) {
		Pagedata data=new Pagedata(ob.getId(),ob.getFirstname(),ob.getEmail(),ob.getPhoneno(),ob.getStatus());
		
		list.add(data);
		}
		return list;
	}

	//Login
	public ResponseEntity<Responese> Login(Employee ob) {
		Employee ob1=emp.findByEmail(ob.getEmail());
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(ob1 != null) {
			if(passwordEncoder.matches(ob.getPassword(),ob1.getPassword())) 
			{
				Data data=new Data(ob1.getId(),ob1.getUsername(),ob1.getEmail(),ob1.getRoll());
			return new ResponseEntity<>(new Responese(true,ob1.getRoll(),data),HttpStatus.ACCEPTED);
		}else 
		{
	return new ResponseEntity<>(new Responese(false,"Password Incorrect",null),HttpStatus.UNAUTHORIZED);
		}
		}
		else 
		{
	return new ResponseEntity<>(new Responese(false,"Email Incorrect",null),HttpStatus.UNAUTHORIZED);
		}
	}

	//DashBoard
	public ArrayList<DashBoard> DashBoard() {
		/*DashBoard dashBoard = new DashBoard();
		dashBoard.setRequested(can.countByStatus("requested"));
		dashBoard.setProgress(can.countByStatus("progress"));	
		dashBoard.setHired(can.countByStatus("hired"));	
		dashBoard.setWaitinglist(can.countByStatus("waitinglist"));
		dashBoard.setRejected(can.countByStatus("rejected"));
		dashBoard.setTotalcandidate(dashBoard.getRequested() + dashBoard.getProgress() + dashBoard.getHired() + dashBoard.getWaitinglist() + dashBoard.getRejected());	
			return dashBoard;*/
		ArrayList<DashBoard> data=new ArrayList<DashBoard>();
		DashBoard title1 = new DashBoard("requested",can.countByStatus("requested"));
		data.add(title1);
		DashBoard title2 = new DashBoard("progress",can.countByStatus("progress"));
		data.add(title2);
		DashBoard title3 = new DashBoard("hired",can.countByStatus("hired"));
		data.add(title3);
		DashBoard title4 = new DashBoard("waitinglist",can.countByStatus("waitinglist"));
		data.add(title4);
		DashBoard title5 = new DashBoard("rejected",can.countByStatus("rejected"));
		data.add(title5);
		DashBoard title6 = new DashBoard("totalcandidate",title1.getCount()+title2.getCount()+title3.getCount()+title4.getCount()+title5.getCount());
		data.add(title6);
		return data;
		
		
	}

	//Candidate Full Details
		public com.example.demo.Model.Candidate fulldetails(String id) {
			
			Candidate ob=can.findById(id).get();
			
			return ob;
		}
		
		//Candidate Delete
		public String deletecandidate(String id) {
			can.deleteById(id);
			return "sucessfully delete";
		}

	
	//DropDownList
	public Job Jobs() {
		
		String[] Jobs={"Reative","springboot","reativenative","devops"};
		return new Job(Jobs);
		
	}




	//User Management
	//Interviewer
	public String Interviewer(Interview ob) {
		//Candidate ob1=can.findById(ob.getCandidateid()).get();
		//if(ob1.getId().equals(ob.getCandidateid()))
		try
		{
			inter.save(ob);
			return "sucess";
		}catch(Exception ae){
			return "failed";
		}
		
	}
 
	//InterViwer List
	public ResponseEntity<Interviewerresponse> today(Interview ob) 
	{
		if(inter.findByIndate(ob.getIndate()) != null) {
			if(emp.findByUsername(ob.getInterviewerusername()) !=null) {
		Interview ob1=inter.findByIndate(ob.getIndate());
		//Employee ob2=emp.findByUsername(ob.getInterviewerusername());
		        Candidate ob3=can.findById(ob1.getCandidateid()).get();
				Interviewrespon data=new Interviewrespon(ob3.getId(),ob3.getFirstname(),ob3.getLastname(),ob1.getTime(),ob3.getQualification(),ob3.getExperience());
			return new ResponseEntity<>(new Interviewerresponse(null,data),HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(new Interviewerresponse("Today Not Fixed",null),HttpStatus.OK);
		}}
		else {
		return new ResponseEntity<>(new Interviewerresponse("Today Not Fixed",null),HttpStatus.OK);
		}
	}
		

	

	//Employee Add And Update
	public String employee(Employee ob) {
			if(ob.getUsername() == null) {
					if(emp.existsByEmail(ob.getEmail()) == false) {
				if(emp.existsByPhoneno(ob.getPhoneno()) == false) {
					do {
					Random random = new Random();
					 //R
					//and = random.nextInt(10000);
				    int user=random.nextInt(10000);
				    System.out.println(user);
					ob.setUsername(ob.getFirstname()+ user +"@icannio.com");
					}while(emp.existsByUsername(ob.getUsername()));
					PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
					String encodedPassword = passwordEncoder.encode("abc123");
				     System.out.println(encodedPassword);
					ob.setPassword(encodedPassword );
				   
					emp.insert(ob);
					return "sucess";
				}
				else {
					return "Already Phone no Taken";
				}}
			else
				{
					return "Already Email Taken";
				}}
		else
				{
			if(emp.existsByEmailAndIdIsNot(ob.getEmail(),ob.getId()) == false);{
				if(emp.existsByPhonenoAndIdIsNot(ob.getPhoneno(),ob.getId()) ==false);{
			
					emp.save(ob);
					return "sucess update";
				}
			}
				}
	}


	//Employee Pagination
	public ArrayList<EmployeePagedata> employeepage(Pageable pageable) 
	{
		Page<Employee> ob=emp.findAll(pageable);
		ArrayList<EmployeePagedata> list=new ArrayList<EmployeePagedata>();
		for(Employee ob1:ob) {
			EmployeePagedata data=new EmployeePagedata(ob1.getUsername(),ob1.getFirstname(),ob1.getEmail(),ob1.getRoll());
		    list.add(data);
		}
		return list;
	}

   //Employee Full details
	public Employee Employeefulldetails(String username)
	{
		Employee ob=emp.findByUsername(username);
		return ob;
	}

    //UserName Checking
	public String usernamecheck(String username) {
		Employee ob=emp.findByUsername(username);
		if(ob.getUsername().equals(username)) {
			Name=username;
			return "sucess";
		}else {
		return "not found";
		}
	}

	//Password change
	public String changeotp(Employee ob) {
		Employee ob1=emp.findByUsername(Name);
		System.out.println(ob.getPassword());
		if(ob.getPassword().equals(ob.getCpassord()))
		{
			ob1.setPassword(ob.getPassword());
			System.out.println(ob1);
			emp.save(ob1);
			return "Sucessfully Password Update";
		}else {
		return "password And Conformpassword not match";
		}
		
	}

	//Delete Employee
	public String employeedelete(String username) {
		emp.deleteByUsername(username);
		return "Sucessfully Delete";
	}

}
