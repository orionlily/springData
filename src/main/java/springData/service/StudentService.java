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
    @Transactional   //�����˷�����ʹ������  
   // @Rollback(false)  //����ʹ����˷��������񲻻ع�,trueʱΪ�ع�  //Ĭ��true������������ݿ�
	public void test(){
		/*Student student = new Student();
		student.setName("���");
		student.setSex("��");*/
		//List<Student> list=studentDao.findAll();
		/*for (Student student2 : list) {
			System.out.println(student2);
		}*/
		//List<Student> list =  studentDao.findByNameAndSex("���", "��");
		
		//List<Student> list = studentDao.findByNameContaining("��");
		
		Sort sort = new Sort(Direction.DESC, "id");
		
		/*
		 * ��ҳ
		 * Pageable pageable = new PageRequest(0, 5,sort);//ҳ����0��ʼ
		
		
		Page<Student> page = studentDao.findAll(pageable);
		
		for(Student student:page.getContent()){
			System.out.println(student);
		}*/
		
		/*for (Student student2 : list) {
			System.out.println(student2);
		}*/
		
		
		
		
		//List<Student> list = studentDao.findBySexAndNameContaining("��","��");
		//List<Student> list = studentDao.getGirls("Ů");
		List<Student> list = studentDao.getBoys("��");
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
