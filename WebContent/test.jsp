<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<c:forEach items="${itemsList}" var="item">
		
 <li>${item.name}</li><li> <img src = "./items/${item.itemImages[0]}" }/> </li>
	</c:forEach>
	</ul>
	
	<ul>
		<c:forEach items="${categoriesList}" var="category">
		 <li>${category.name}</li>
   <li>${category.subcategoryList[0].itemsList[0].name}</li>
   <li>${category.subcategoryList[0].itemsList[0].description}</li>
 <li>${category.subcategoryList[0].itemsList[0].maxPrice}</li>
	</c:forEach>
	</ul>
</body>
</html>