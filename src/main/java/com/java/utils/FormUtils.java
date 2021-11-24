package com.java.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtils {

	//hàm lấy giá trị chuỗi
	public String getString(HttpServletRequest request, String name, String def) {
		String value = request.getParameter(name);
		
		return value == null || value.equals("") ? def : value;
	}
	
	//hàm lấy giá trị số nguyên
	public int getInt(HttpServletRequest request, String name, int def) {
		String value = getString(request, name, String.valueOf(def));
		return Integer.parseInt(value);
	}
	
	//hàm lấy đối tượng 
	public <T> T getBean(HttpServletRequest request, Class<T> cls) {
		try {
			T bean = cls.newInstance();
			
			BeanUtils.populate(bean, request.getParameterMap());
			
			return bean;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
