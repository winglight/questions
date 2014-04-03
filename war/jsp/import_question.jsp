<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Import Questions</title>
  </head>

  <body>
  	
  	<script language = javascript>
		function check(){
			var file=document.getElementsByName("files");
			var checked=0;
			for(var i=0;i<file.length;i++){
				if(file[i].checked){
					checked++;
					break;
				}
			}
			if(checked==0){
				alert("Please select a file to import!");
				return;
			}
			
			document.getElementById("form1").submit();
			
		}
	</script> 
  	
    <h1>Import Questions</h1>
	
	<form id="form1" action="/import_file" method="post">
		<%
			java.util.List fileList = (java.util.List)request.getAttribute("fileList");
			for(int i=0;i<fileList.size();i++){
		%>	
				<input type="radio" name="files" value="<%=fileList.get(i)%>"/><%=fileList.get(i)%><br/>
		<%		
			}
		%>
		<br/>
		
		<input type="button" onclick="check();" value="import"/>
    <from/>
  </body>
</html>