<html>
<head>
	<title>Integro UI Framework Training - Assignment Test</title>
	<link href="css/smartlender.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form method="post" action="assignment_result.jsp">
	<table border="0" align="center" class="info">
	<tr><td>
		<h3>Please select one of the assignment to run</h3>
		<hr>
		<input type="radio" name="assignment" value="1">Assignment 1 - Count Data</input>
		<br><br>
		<u>Description</u><br>
		Given the file with multiple lines of data. Count the number of digits and letter for each line.
		<br><br>
		<u>Examples</u><br>
		<table class="tblinput" cellspacing="0" border="0" cellpadding="0">
		<thead>
		<tr>
			<td>S/N</td>
			<td>Data</td>
			<td>Number of digits</td>
			<td>Number of letters</td>
		</tr>
		</thead>
		<tbody>
		<tr class="odd">
			<td class="index">1</td>
			<td>uasd123sd1agd9a12</td>
			<td>7</td>
			<td>10</td>
		<tr>
		<tr class="even">
			<td class="index">2</td>
			<td>klam g23adj 230 jah8</td>
			<td>6</td>
			<td>11</td>
		<tr>
		</tbody>
		</table>
		<br><hr color="Indigo"/>
		<input type="radio" name="assignment" value="2">Assignment 2 - Play with Numbers</input>
		<br><br>
		<u>Description</u><br>
		Given the file with multiple lines of data. For each line, sum and multiply the numbers given. 
		Apart from that, also count the number of odd and even numbers given for each line.
		<br><br>
		<u>Examples</u><br>
		<table class="tblinfo" cellspacing="0" border="0" cellpadding="0">
		<thead>
		<tr>
			<td>S/N</td>
			<td>Data</td>
			<td>Sum</td>
			<td>Multiply</td>
			<td>Total Odd Numbers</td>
			<td>Total Even Numbers</td>
		</tr>
		</thead>
		<tbody>
		<tr class="odd">
			<td class="index">1</td>
			<td>1 4 3 8 1 9</td>
			<td>26</td>
			<td>864</td>
			<td>4</td>
			<td>2</td>
		<tr>
		<tr class="even">
			<td class="index">2</td>
			<td>6 4 3 10 15 0 88</td>
			<td>126</td>
			<td>0</td>
			<td>2</td>
			<td>5</td>
		<tr>		
		</tbody>
		</table>		
		<br><hr color="Indigo"/>
		<input type="radio" name="assignment" value="3">Assignment 3 - Reverse the String</input>
		<br><br>
		<u>Description</u><br>
		Given the file with multiple lines of data. Display the data in the reverse order.
		<br><br>
		<u>Examples</u><br>
		<table class="tblinfo" cellspacing="0" border="0" cellpadding="0">
		<thead>
		<tr>
			<td>S/N</td>
			<td>Data</td>
			<td>Reverse Data</td>
		</tr>
		</thead>
		<tbody>
		<tr class="odd">
			<td>1</td>
			<td>xyz</td>
			<td>zyx</td>
		<tr>
		<tr class="even">
			<td>2</td>
			<td>abccba</td>
			<td>abccba</td>
		<tr>		
		</tbody>
		</table>		
		<br><br>
		Upload data file (full path): &nbsp;<input type="text" name="filepath" size="80"/>
		<br><br>
		<center><input type="submit" name="submit" value="Generate Result"></center>
	</td></tr>
	</table>
	</form>
</body>
</html>