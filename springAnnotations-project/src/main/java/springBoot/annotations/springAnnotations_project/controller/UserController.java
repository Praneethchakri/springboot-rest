package springBoot.annotations.springAnnotations_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBoot.annotations.springAnnotations_project.daoModel.BusinessUserEntity;
import springBoot.annotations.springAnnotations_project.model.ResponseModel;
import springBoot.annotations.springAnnotations_project.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService<?> userService;

	@GetMapping()
	public BusinessUserEntity getUserDetails(@RequestParam(name = "userId") int userId) {
		return userService.fetchUserById(userId);
	}
	@PostMapping
	public ResponseEntity<ResponseModel> addUser(@RequestBody BusinessUserEntity userObject) {
			userService.addUserDetails(userObject);
			System.out.println(userObject.getUserId());
		return new ResponseEntity<ResponseModel>( HttpStatus.ACCEPTED);
	}
	@GetMapping(path = "/all")
	public List<BusinessUserEntity> getAllUsers(){
		return userService.fetchAllUsers();
	}

}
