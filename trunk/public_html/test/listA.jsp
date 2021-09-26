<%@ page import="java.util.Collection,
                 java.util.Iterator,
                 com.integrosys.course.ui.test.*, com.integrosys.course.app.test.bus.*"%>


<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%
      Collection OBList = (Collection)request.getAttribute("request.OBAList");
      if (OBList != null && OBList.size() > 0) {
      	pageContext.setAttribute("OBList",OBList);
  	  }
%>
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="../Templates/ContentPage.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="doctitle" -->
<title>Integro UI Framework Training</title>
<!-- InstanceEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- InstanceBeginEditable name="CssStyle" -->
<link href="css/smartlender.css" rel="stylesheet" type="text/css" />
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function submitPage() {
    document.forms["AForm"].submit()
}

function addUserPage(){
    document.forms["AForm"].action="A.do?event=prepare_create";
    document.forms["AForm"].submit();
}


function JumpOnSelectactive(selectObj, uID) 	{
	if (selectObj.selectedIndex == 1) {
    	document.forms["AForm"].action="A.do?event=prepare_update&id="+uID;
	} else if (selectObj.selectedIndex == 2) {
    	document.forms["AForm"].action="A.do?event=read&id="+uID;
	} else if (selectObj.selectedIndex == 3) {
    	document.forms["AForm"].action="A.do?event=delete&id="+uID;
	}
	document.forms["AForm"].submit();
}
//add Search function here
function search(){
    let choice = document.getElementById("searchField").value;
    let key = document.getElementById("searchKey").value;
    if(key !== "") {
        document.forms[0].action="A.do?event=search" + choice + "/" +key;
        document.forms[0].submit();
    }
}

//-->
</script>
<!-- InstanceEndEditable -->
</head>

<body>
<!-- InstanceBeginEditable name="Content" -->

<div width="80%" border="0" align="center" cellpadding="0" cellspacing="0"
<form name="search" action="A.do?event=search" method="post">
    <select id="searchField">
      <option value="name" selected>Full Name</option>
      <option value="id">Id</option>
       <option value="country">Country</option>
      <option value="role">Role</option>
      <option value="rights">Rights to access</option>
    </select>
    <input type="text" id="searchKey" placeholder= "enter search key"></input>
    <input type="submit" onclick="javascript:search()"></input>
</form>
</div>
<html:form action="A.do?event=prepare_create">
<html:hidden property="event"/>
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="64%"><h3>User Details</h3></td>
          <td width="36%" align="right"><input name="Submit2" type="button" class="btnNormal" value="Add New" onclick="javascript:addUserPage()"/></td>
        </tr>
        <tr>
          <td colspan="2"><hr /></td>
        </tr>
      </table>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tblInput">
        <thead>
        <tr>
        <td width="5%">S/N</td>
        <td width="5%">Id</td>
        <td width="15%">Full Name</td>
        <td width="15%">Role</td>
        <td width="30%">Access Rights</td>
        <td width="15%">Country</td>
        <td width="15%">Action</td>
        </tr>
        </thead>
        <tbody>
    <logic:present name="OBList">
    <% int count = 0; %>
   <logic:iterate id="OB" name="OBList"  type="com.integrosys.course.app.test.bus.OBA" scope="page">
        <tr class="<%=count++%2==0?"even":"odd"%>">
        	<td class="index"><%=count%></td>
        	<td><%=OB.getId()%></td>
            <td><%=OB.getName()%></td>
            <td><%=OB.getRole()%></td>
            <td><%=OB.getRights()%></td>
            <td><%=AHelper.getCountryName(OB.getCountry()) %></td>
            <td style="text-align:center"><select name="select3" onChange="JumpOnSelectactive(this, '<%=OB.getId()%>')">
                <option selected="selected" >Please Select</option>
                <option value="edit">Edit</option>
                <option value="view">View</option>
                <option value="delete">Delete</option>
              </select>
              </td>
          </tr>
	</logic:iterate>
    </logic:present>
	<logic:notPresent name="OBList">
		<tr class="even">
			<td colspan="4">There is no user found.</td>
		</tr>
	</logic:notPresent>
        </tbody>
      </table></td>
  </tr>
</table></td>
  </tr>
</table>
</html:form>


<!-- InstanceEndEditable -->
</body>
<!-- InstanceEnd --></html>
