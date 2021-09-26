<html>
<head>
	<title>Integro UI Framework Training - Assignment Result</title>
	<link href="css/smartlender.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table border="0" align="center" valign="bottom" class="info">
	<tr><td>
	<%
		String assignment = request.getParameter("assignment");
		String filepath = request.getParameter("filepath");
		// todo... task by developers
		out.println("Assignment task: "+assignment+"<br>");
		out.println("File path: "+filepath+"<br><hr>");
	%>
	Display results.
	<tr><td>
	</table>
</body>
</html>