package springBoot.annotations.springAnnotations_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.annotations.springAnnotations_project.daoModel.BusinessUserEntity;
import springBoot.annotations.springAnnotations_project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public BusinessUserEntity fetchUserById(int userId) {

		return repository.getOne(userId);
	}

	@Override
	public BusinessUserEntity addUserDetails(BusinessUserEntity userObject) {
		return repository.save(userObject);
	}

	@Override
	public List<BusinessUserEntity> fetchAllUsers() {
		return repository.findAll();
	}

}
