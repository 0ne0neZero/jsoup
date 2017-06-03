<%@page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ultrapower.Test"%>
<%
	String starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
	String json = new Test().getNumbers(starttime,endtime);
	System.out.println(json);
	response.getWriter().write(json);
%>
