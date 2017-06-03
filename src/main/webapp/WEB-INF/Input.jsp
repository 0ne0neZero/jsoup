<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/search">
    请输入地址：<input name="url" type="text"/>
    <input type="submit" value="确定"/>
    </form>
  </body>
</html>
