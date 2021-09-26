<%@ page import="java.util.Collection,
                 java.util.Iterator,
                 com.integrosys.course.ui.test.*, com.integrosys.course.app.test.bus.*,
                 java.util.HashMap"%>


<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ page import="java.util.List"%>

<%
    HashMap countryListHM = (HashMap)request.getAttribute("countryMap");

    Collection countryList =   countryListHM.keySet();
    Collection countryLabelList =   countryListHM.values();
    if (countryList != null)
        pageContext.setAttribute("countryList", countryList);
    if ( countryLabelList != null )
        pageContext.setAttribute("countryLabelList", countryLabelList);

    HashMap role_accessRight = (HashMap)request.getAttribute("role_accessRight");
    pageContext.setAttribute("role_accessRight", role_accessRight);
    Collection roleList =   role_accessRight.keySet();
    Collection rightList =   role_accessRight.values();
    if (countryList != null)
        pageContext.setAttribute("roleList", roleList);
    if ( countryLabelList != null )
        pageContext.setAttribute("rightList", rightList);
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
    document.forms[0].submit()
}

const rightSection = document.getElementById("right")
function updateRight(selectObj) 	{
    let ans = selectObj.options[sel.selectedIndex].text ;
	if (ans !== "") {
        rightSection.textContent = role_accessRight.get(ans);
	}
}
//-->
</script>
<!-- InstanceEndEditable -->
</head>

<body onload="MM_preloadImages('img/submit2.gif','img/cancel2.gif')">
<!-- InstanceBeginEditable name="Content" -->
<html:form action="A.do?event=create">


<table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td><h3>User Details</h3></td>
        </tr>
        <tr>
          <td><hr /></td>
        </tr>
      </table>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tblInput">
        <thead>
        </thead>
        <tbody>
          <tr class="odd">
            <td width="20%" class="fieldname">Id</td>
            <td width="80%" > <html:text property="id" />
            	<html:errors property="id"/>
          	</td>          	
          </tr>
          <tr class="odd">
              <td width="20%" class="fieldname">Full Name</td>
              <td width="80%" > <html:text property="name" />
                <html:errors property="name"/>
                </td>
          </tr>

          <tr class="odd">
            <td width="20%" class="fieldname">Role</td>
            <td width="80%" >
              <html:select property="role" >
              <option value="">Please Select</option>
              <html:options name="roleList" labelName="roleList"
                />
              </html:select><html:errors property='role'/>
            </td>
         </tr>

          <!-- <tr class="odd">
             <td width="20%" class="fieldname">Access rights: </td>
             <td width="80%" id="right">

             </td>
          </tr> --!>

          <tr class="even">
            <td class="fieldname">Country</td>
          	<td><html:select property="country" >
            	<option value="">Please Select</option>
                <html:options name="countryList" labelName="countryLabelList" />
                </html:select><html:errors property="country"/>
            </td>
           </tr>
        </tbody>
      </table></td>
  </tr>
</table>
<table align="center">
  <tr>
    <td><a href="#" onClick="javascript:submitPage()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image1','','img/submit2.gif',1)"><img src="img/submit1.gif" name="Image1" width="70" height="20" border="0" id="Image1" /></a>
    <a href="A.do?event=list" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image2','','img/cancel2.gif',1)"><img src="img/cancel1.gif" name="Image2" width="70" height="20" border="0" id="Image2" /></a></td>
  </tr>
</table>
</html:form>
<!-- InstanceEndEditable -->
</body>
<!-- InstanceEnd --></html>
