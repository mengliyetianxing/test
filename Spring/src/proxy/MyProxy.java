package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.xml.bind.Binder;

public class MyProxy implements InvocationHandler{
	Object obj;
	
	public Object Binder(Object obj) {
		this.obj=obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我张嘴了");
		
		Object object = method.invoke(obj, null);
		
		System.out.println("我闭嘴了");

		
		return object;
	}

}
