package services;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import proxy.MyProxy;

public class Test {

	public static void main(String[] args) {
		//ioc依赖注入,aop
		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		StudentServices ss = (StudentServices) bf.getBean("studentServices");
		ss.insertStudent();
		
		//动态代理
//		MyProxy mp = new MyProxy();
//		ISayHello ish =  (ISayHello) mp.Binder(new SayHello());
//		ish.sayHello();
	}

}
