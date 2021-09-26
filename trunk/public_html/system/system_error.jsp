<%@ page language="java"%>
<%
    Exception e = (Exception)request.getAttribute("losException");
    String msg = "NO MESSAGE";
    if(e != null) {
        msg = e.getMessage();
    }
%>


<html><!-- InstanceBegin template="Templates/ContentPage.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="doctitle" -->
<title>Untitled Document</title>
<!-- InstanceEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="CssStyle" -->
<link href="css/smartlender.css" rel="stylesheet" type="text/css" />
<!-- InstanceEndEditable --> <!-- InstanceBeginEditable name="head" --> <!-- InstanceEndEditable --> 
</head>

<body>
<!-- InstanceBeginEditable name="Content" --> 
<table width="460" height="260" border="0" align="center" cellpadding="0" cellspacing="0" class="tblInfo" style="margin-top:30px">
  <thead>
  </thead>
  <tbody>
    <tr class="odd"> 
      <td style="text-align:center" valign="middle"><table width="400" height="200" border="0" cellpadding="10" cellspacing="0" class="tblInfo">
          <thead>
          </thead>
          <tbody>
            <tr> 
              <td class="even" style="text-align:center" valign="middle"> 
                <table width="300" border="0" cellspacing="0" cellpadding="0" class="tblInfo">
                  <tr class="even"> 
                      
                    <td style="border:none;text-align:right;padding-right:5px" width="80"><img src="img/stoplit.gif" width="25" height="32" /></td>
                    <td style="border:none" width="220"><strong><font size="2">Transaction 
                      Denied</font></strong></td>
                    </tr>
                    <tr class="even"> 
                      
                    <td colspan="2" style="border:none;text-align:center"><br />
                      We apologise that we are not able to process your transaction 
                      at this moment. 
                      <p>Please try again later or <br />
                        Contact your administrator if the problem persists.</p>
                      </td>
                    </tr>
                </table> </td>
            </tr>
          </tbody>
        </table></td>
    </tr>
  </tbody>
</table>
<!-- InstanceEndEditable --> 
</body>
<!-- InstanceEnd --></html>





<!-- ********* Begin Exception Message ********* -->


<!-- <%=msg%> -->


<!-- ********* End Exception Message ********* -->