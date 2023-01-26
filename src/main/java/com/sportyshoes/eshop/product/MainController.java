package com.sportyshoes.eshop.product;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.eshop.Entity.AdminEntity;
import com.sportyshoes.eshop.Entity.OrderEntity;
import com.sportyshoes.eshop.Entity.ShoeEntity;
import com.sportyshoes.eshop.Entity.UserEntity;
import com.sportyshoes.eshop.service.AdminService;
import com.sportyshoes.eshop.service.OrderImp;
import com.sportyshoes.eshop.service.ShoeServices;
import com.sportyshoes.eshop.service.UserImp;


@RestController
public class MainController {
	@Autowired
	private ShoeServices shoservice;
	
	@Autowired
	private UserImp ui;
	
	@Autowired
	private OrderImp oi;
	
	@Autowired
	AdminService as;
	
	
	
// *****************for Admin userID and password ************* Spring secutiry isn't working properly, so using normal way. 
	
	@PostMapping("/admin/createadmin")
	public String createadmin(@RequestBody AdminEntity ae) {
		if(ae.getUserName() !=null && ae.getPassword() !=null) {
			as.userID(ae);
			return "Login done";
		}else {
			return "Login failed";
		}
		
	}

	@GetMapping("/admin/{username}/{password}/{newpassword}") // If you know the password, you change the password with the following parten localhost:8080/admin/admin/pass/password
	public String changepassword(@PathVariable("username") String name, @PathVariable("password") String password, @PathVariable("newpassword") String newpassword) {
		AdminEntity ae=AdminEntity.builder().userName(name).password(password).build();
		
		if(as.isValid(ae)) {
			ae.setPassword(newpassword);
			as.userID(ae);
			return "Password changed";
		}else {
			return "fail to change password";
		}
	}
	
	
	
//	*******************for shoe***********************
	
	@PostMapping("/admin/addProduct")
	public void addShoe(@RequestBody ShoeEntity se) { // to add the product
		shoservice.add(se);
	}
	@GetMapping("/admin/getallproduct") // get all the product
	public List<ShoeEntity> getallproduct() {
		return shoservice.getallproduct();
	}
	@DeleteMapping("/admin/delete/{id}") // delete the product by id
	public void deleteproductbyID(@PathVariable("id") int id) {
		shoservice.deleteproductbyId(id);
	}
	@GetMapping("/admin/getbyid/{id}") //get the product by id
	public ShoeEntity getallproduct(@PathVariable("id") int id) {
		return shoservice.getbyid(id);
	}
	
	@GetMapping("/admin/getorderdetails")
	public List<OrderEntity> getAllOrderDetails(){
		return oi.getAllOrder();
	}
	
	@GetMapping("/admin/orderfilter/{brand}")
	public List<OrderEntity> filterbyName(@PathVariable("brand") String brand)
	{
		return oi.filterbybrandName(brand);
	}
	
	
	
//	 @GetMapping("/admin/orderfilter") // http://localhost:8080/admin/orderfilter?startDate=2023-01-01&endDate=2023-01-31
//     public List<OrderEntity> getOrdersByDate(@RequestParam(name = "startDate") Timestamp startDate,
//             @RequestParam(name = "endDate") Timestamp endDate) {
//         return oi.filterbydate(startDate, endDate);
//     }
	
	 
	 @GetMapping("/admin/listusers")
	 public List<UserEntity> userList(){
		 return ui.getalltheuser();
	 }
	
	
//	******************user****************** Browse the list of users who have signed up and be able to search users: User need to choose the product and sign up
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserEntity ue) {
		ui.addUser(ue);		
		return "User Registered";
	}
	
		
	
//	******************purchase details*********************
	
	
	@PostMapping("/purchase/{username}/{productid}") 
	public void purchase(@PathVariable("username") String name, @PathVariable("productid") int pid) { //localhost:8080/purchase/Jenish/1
		ShoeEntity se=shoservice.getbyid(pid);
		UserEntity ue=ui.getUserbyName(name);
		OrderEntity oe=OrderEntity.builder().customerName(ue.getUsername()).productName(se.getBandName()).productId(se.getProductID()).build();
		oi.purchase(oe);
		
	}
	
	
	
	
	
	
	

	

}
