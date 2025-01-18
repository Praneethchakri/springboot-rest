package com.hibernate.learning.Advance.Hiberate.dao.impl;

import com.hibernate.learning.Advance.Hiberate.dao.InstructorDAO;
import com.hibernate.learning.Advance.Hiberate.dto.InstructorDTO;
import com.hibernate.learning.Advance.Hiberate.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import static com.hibernate.learning.Advance.Hiberate.mapper.InstructorMapperStruct.INSTRUCTOR_MAPPER_STRUCT;

@Repository
public class InstructorDaoImpl implements InstructorDAO {
    @PersistenceContext
    private EntityManager entityManager;
  
    @Transactional
    @Override
    public InstructorDTO saveInsturctor(Instructor instructor) {
        System.out.println("Instructor "+instructor.toString());
        entityManager.persist(instructor);
        System.out.println("after Save "+instructor.toString());
        return INSTRUCTOR_MAPPER_STRUCT.mapToInstructorDTO(instructor);
    }

    @Transactional
    @Override
    public void deleteInstructor(int instructorId) {
        try {
            Instructor instructor =entityManager.find(Instructor.class,instructorId);
            entityManager.remove(instructor);
        }catch(Exception e){
                e.getMessage();
            }
    }
    @Transactional
    @Override
    public Instructor getInstructorById(int instructorId){
       return entityManager.find(Instructor.class,instructorId);
    }


}
