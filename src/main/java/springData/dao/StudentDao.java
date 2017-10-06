package springData.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springData.orm.BaseDao;
import springData.pojo.Student;

@Repository
public interface StudentDao extends  BaseDao<Student, Integer> {
	
	 List<Student> findByNameAndSex(String name,String sex) ;
	 
	 List<Student> findByNameLike(String name);
	 
	 List<Student> findByNameStartingWith(String name);
	 
	 List<Student> findByNameEndingWith(String name);
	 
	 List<Student> findByNameContaining(String name);
	 
	 List<Student> findBySexAndNameContaining(String sex,String name);
	 
	 
	 
	 @Query("from Student where sex=:sex")
	 List<Student>  getGirls(@Param("sex")String sex);
	 
	 @Query(value= "select * from student where sex=:sex",nativeQuery=true)
	 List<Student>  getBoys(@Param("sex")String sex);
}
/**
 * ͨ��ǰ������ÿ��Կ�����Spring �� JPA ��֧���Ѿ��ǳ�ǿ�󣬿�������������ע EntityManager �Ĵ������������ JPA ��صĴ���
 * ***********************************************************************
 * Ȼ��spring��Jpa��֧�ֲ�ֹ�ڴˣ���Ҫ�Ӹ������������ǵ�ҵ�����                        **
 * ��û��ʹ��jpa֧�ֵ�ʱ�����ǵĴ���Ӧ���������ģ�                                    **
 *     1��IUserDao   �־ò�ӿ�                                                **
 *     2��IUserDaoImpl   �־ò�ʵ����                                            **                
 *     3��IUserService    ҵ���ӿ�.....���治���о�                                    **
 * ÿдһ��ʵ���࣬��Ҫ������5��6�������������в�������ʹ����ע�⣬���ǿ�������ע�뷽ʽ���õ�ʵ���࣬    **
 * ����ͨ�õ�CRUD�Ȳ���ȴ������ÿ��ʵ����������������˵���ҿ��Զ���һ�����࣬���÷��ͷ���ԭ��Ϳ����ˣ�    **
 * �������㻹��ҪΪÿ��Dao�����Լ���ʵ�������̳���ĸ���                                    **
 * ***********************************************************************
 * ��ô��������...�������ھ���������Գ־ò�ļ򻯼����ļ�ǿ��      Spring Data Jpa            **
 * ��ΨһҪ���ľ�ֻ�������־ò�Ľӿڣ����̳��������Ѿ���װ�õĳ־ò�ӿڣ����籾��IUserDaoһ��        **
 * ��ʹ�õĽӿ��У�                                                            **********
 *��    Repository���� Spring Data��һ�����Ľӿڣ������ṩ�κη�������������Ҫ���Լ�����Ľӿ���������Ҫ�ķ�����**
 *     CrudRepository���̳�Repository���ṩ��ɾ�Ĳ鷽��������ֱ�ӵ��á�                            **
 *     PagingAndSortingRepository���̳�CrudRepository�����з�ҳ��ѯ�������ܣ�����ʵ����        **
 *     JpaRepository��                         �̳�PagingAndSortingRepository�����JPA�����ṩ�Ľӿ�            **
 *     JpaSpecificationExecutor��          ����ִ��ԭ��SQL��ѯ                                    **
 *    �̳в�ͬ�Ľӿڣ���������ͬ�ķ��Ͳ����������Ǹó־ò�������������������͡�                            **
 *********************************************************************************
 */