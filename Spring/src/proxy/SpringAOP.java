package proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringAOP {
	
//	@Before("execution(* *.*.*(..))")
//	public void before() {
//		System.out.println("����ʼ");
//	}
//	@After("execution(* *.*.*(..))")
//	public void after() {
//		System.out.println("�������");
//	}
	
	@Around("execution(* *.*.*(..))")
	public int aroud(ProceedingJoinPoint pjp) {
		System.out.println("����ʼ");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			System.out.println("����ع�");
			e.printStackTrace();
			return 0;
		}
		System.out.println("�������");
		return 0;
	}
}
