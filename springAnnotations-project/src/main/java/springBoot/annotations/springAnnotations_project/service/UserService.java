package springBoot.annotations.springAnnotations_project.service;

import java.util.List;

import springBoot.annotations.springAnnotations_project.daoModel.BusinessUserEntity;

public interface UserService<T> {

	public BusinessUserEntity fetchUserById(int userId);
	public BusinessUserEntity addUserDetails(BusinessUserEntity userObject);
	
	public List<BusinessUserEntity> fetchAllUsers();
}
