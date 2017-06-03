package cn.tarena.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;



import cn.tarena.pojo.Person;

public final class fields {
	
	public static Person getFields(Person person,List infos){
		
		Class personClass = person.getClass();
		 Field[] field = personClass.getDeclaredFields();
	        for (int i = 9; i < field.length; i++) {
	           
	            //属性名称
	            String name = field[i].getName();
	            
				StringBuffer sb = new StringBuffer();       				  
			    sb.append("set");       			  
			    sb.append(name.substring(0, 1).toUpperCase());       			  
			    sb.append(name.substring(1));
				String info =(String) infos.get(i-9);
				
				try {
					Method m2 = personClass.getDeclaredMethod(sb.toString(), String.class);
					m2.invoke(person, info);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("没有此方法");
				} 
	            
	        }
		return person;
	}
}
