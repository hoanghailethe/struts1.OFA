
<%
	session = request.getSession(true); 
	
	if(session.getAttribute("global.USER_LOGIN_ID")!=null)
		session.removeAttribute("global.USER_LOGIN_ID");
	
	session.setAttribute("global.USER_LOGIN_ID", "123");
	
	System.out.println("something wrong");
%>
<meta http-equiv="refresh" content="0;url=A.do?event=list">A