package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext-mybatis.xml");
		//ApplicationContext act = new ClassPathXmlApplicationContext("classpath:springmvc-servlet.xml");
		String[]beans = act.getBeanDefinitionNames();
		for (String string : beans) {
			System.out.println("========"+string);
		}
	}

}
