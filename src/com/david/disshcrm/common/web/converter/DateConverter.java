package com.david.disshcrm.common.web.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import org.apache.commons.beanutils.Converter;
import java.text.ParseException;

/*
 * 实现自定义日期格式转换，格式为：yyyy-MM-dd
 * 
 * 	
 * 为何在springmvc-servlet.xml中配置不起作用，直接controller中声明起作用
	<!-- 拦截器 -->
	<bean id="annotationMethodHandlerAdapter" class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
		<!-- 日期格式转换 -->
        <property name="webBindingInitializer">
         <bean class="cn.itcast.jk.util.DateConverter"/>
        </property>
	</bean>
	
	
 */
public class DateConverter implements WebBindingInitializer,Converter {
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
		binder.registerCustomEditor(Timestamp.class, new CustomDateEditor(df, true));
	}
	/**
	 * 把String转换成java.util.Date的类型转换器
	 */
	public Object convert(Class type, Object value) {
		if (value == null)
			return null;// 如果要转换成值为null，那么直接返回null
		if (!(value instanceof String)) {// 如果要转换的值不是String，那么就不转换了，直接返回
			return value;
		}
		String val = (String) value;// 把值转换成String

		// 使用SimpleDateFormat进行转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(val);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
