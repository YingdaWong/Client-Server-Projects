

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here JSP 1</title>
</head>
<%-- <body>
	THIS IS A TEST

	<jsp:useBean id="ResultsBean" type="middlewareSide.AccountEntry"
		scope="session"></jsp:useBean>
		
		<% String display = currencyFormat.format(<jsp:getProperty name="ResultsBean"
property="displayedBalance" />);%>

	<jsp:getProperty name="ResultsBean" property="accountType" />

	<jsp:getProperty name="ResultsBean" property="ownerID" />

	<jsp:getProperty name="ResultsBean" property="balance" /> --%>


<body>
    
	<h1 align=center>The Results of the Transaction</h1>
	<jsp:useBean id="ResultsBean" type="middlewareSide.AccountEntry"
		scope="session"></jsp:useBean>

	<ul>
		<li><b>Card Number</b>: <jsp:getProperty name="ResultsBean"
				property="cardNumber" />
		<li><b>Account Number</b>: <jsp:getProperty name="ResultsBean"
				property="ownerID" />
		<li><b>New Balance1</b>: <jsp:getProperty name="ResultsBean"
				property="displayedBalance" />
	</ul>




</body>
</html>