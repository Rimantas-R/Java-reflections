package main.java;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


class Test{  
	
	void printName(Object obj){  
		  Class c=obj.getClass();    
		  System.out.println(c.getName());  
		  }  
   
        public static void main(String args[]){  
         
        	try {
				Class c = Boolean.TYPE;   
       System.out.println(c.getName()); 
       
      
       Class<?> c2 = Class.forName("main.java.Le");  
       Class<?> mu = Class.forName("main.java.Me");
       System.out.println(mu.isInterface());
       System.out.println(mu.getName());   		   
    		   
       Le le = new Le();
      new Test().printName(le);
      new Test().printName(c2);
       System.out.println(c2.getName());
       System.out.println(le.getClass().getName());
       Iterator<Method> meth = Arrays.stream(c2.getDeclaredMethods()).iterator();// c2.getMethods()
       while (meth.hasNext())
       {
    	   Method m = meth.next();
    	   System.out.println(m);
    	   System.out.println(m.getReturnType());
       
       Class[] pars = m.getParameterTypes();
       for (Class p:pars) {
    	   System.out.println(p);
       }
       
       Class[] exs = m.getExceptionTypes();
       for (Class e:exs) {
    	   System.out.println(e);
       }
       }
       
       Field[] fArray = c2.getDeclaredFields();
       for(Field f:fArray) {
    	   System.out.println(f);
       }
       
       /*    */
       Constructor<?> ct = c2.getConstructor();
       Object c2Instance = ct.newInstance();
       Field iI = fArray[0];
//       Field iI = c2.getDeclaredField("i");
       System.out.println(iI.getInt(c2Instance));
       fArray[0].setInt(c2Instance, 5);
       System.out.println(iI.getInt(c2Instance));
       System.out.println(iI.getInt(c2.getConstructor().newInstance()));
       Method method = c2.getDeclaredMethods()[1];
       Method meth2 = c2.getDeclaredMethods()[0];
       Integer[] in = {7};
       meth2.invoke(c2Instance, in);
       method.invoke(c2Instance, null);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
         
       }  
      }  

class Le{
	int i=2;
	long lon=33;
	
	public Le() {
		super();
	}
	
	void go(int i) throws Exception {
		System.out.println("going  " + i);
	}
	
	public boolean stop() {
		System.out.println("stopped");
		return true;
	}
}
interface Me{
	default void no() {
		System.out.println("No is no");
	};
}