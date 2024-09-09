package springBoot.annotations.springAnnotations_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBoot.annotations.springAnnotations_project.daoModel.BusinessUserEntity;

@Repository
public interface UserRepository extends  JpaRepository<BusinessUserEntity, Integer>{
	

}
