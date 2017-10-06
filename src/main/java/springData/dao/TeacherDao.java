package springData.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springData.pojo.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
