package springData.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import springData.dao.StudentDao;
import springData.pojo.Student;
import testUtil.BaseJunit4Test;

@Service
@Transactional
public class StudentService extends BaseJunit4Test implements Specification<Student>{
	@Autowired
	private StudentDao studentDao ;
	
	@Transactional
	public void save(Student student) {
		studentDao.save(student);
	}
	
	public void delete(Integer id) {
		studentDao.delete(id);
	}
	
	@Test
    @Transactional   //标明此方法需使用事务  
   // @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚  //默认true，不会插入数据库
	public void test(){
		/*Student student = new Student();
		student.setName("李白");
		student.setSex("男");*/
		//List<Student> list=studentDao.findAll();
		/*for (Student student2 : list) {
			System.out.println(student2);
		}*/
		//List<Student> list =  studentDao.findByNameAndSex("李白", "男");
		
		//List<Student> list = studentDao.findByNameContaining("李");
		
		Sort sort = new Sort(Direction.DESC, "id");
		
		/*
		 * 分页
		 * Pageable pageable = new PageRequest(0, 5,sort);//页数从0开始
		
		
		Page<Student> page = studentDao.findAll(pageable);
		
		for(Student student:page.getContent()){
			System.out.println(student);
		}*/
		
		/*for (Student student2 : list) {
			System.out.println(student2);
		}*/
		
		
		
		
		//List<Student> list = studentDao.findBySexAndNameContaining("男","李");
		//List<Student> list = studentDao.getGirls("女");
		List<Student> list = studentDao.getBoys("男");
		for (Student student2 : list) {
			System.out.println(student2);
		}
	}

	@Override
	public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
		return null;
	}
}
