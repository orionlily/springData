package testUtil;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//��ʾ����JUnit4���в���
@ContextConfiguration(locations={"classpath:application.xml"})//����spring�����ļ�
public class BaseJunit4Test {

}
