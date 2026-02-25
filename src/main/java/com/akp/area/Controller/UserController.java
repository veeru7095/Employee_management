package com.akp.area.Controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.akp.area.EmployeManageApplication;
import com.akp.area.Service.UserService;
import com.akp.area.entity.User;
@RestController
@RequestMapping("/api/emp")
public class UserController {

    private final EmployeManageApplication employeManageApplication;

	@Autowired
	private UserService userService;

    UserController(EmployeManageApplication employeManageApplication) {
        this.employeManageApplication = employeManageApplication;
    }
	
	@PostMapping("/AddEmp")
	public ResponseEntity<User> Register(@RequestBody User user){
		return new ResponseEntity<>(userService.insertEmp(user),HttpStatus.OK);		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllEmp(){
		return new ResponseEntity<>(userService.getAllEmp(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable long id){
		return new ResponseEntity<String>(userService.deleteEmp(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<User> updateEmp(@RequestBody User user,@PathVariable long id){
		return  new ResponseEntity<User>(userService.updateEmp(user, id),HttpStatus.OK);
	}
}
