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
//		System.out.println("事务开始");
//	}
//	@After("execution(* *.*.*(..))")
//	public void after() {
//		System.out.println("事务结束");
//	}
	
	@Around("execution(* *.*.*(..))")
	public int aroud(ProceedingJoinPoint pjp) {
		System.out.println("事务开始");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			System.out.println("事务回滚");
			e.printStackTrace();
			return 0;
		}
		System.out.println("事务结束");
		return 0;
	}
}
