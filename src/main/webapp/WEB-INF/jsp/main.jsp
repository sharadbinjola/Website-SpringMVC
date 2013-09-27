
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head>
	<title>Dreamscape 1.0</title>
	<link type="text/css" href="${path}/resources/css/bootstrap.min.css" rel="stylesheet"/>
	<%@ include file="/WEB-INF/jsp/js/pageJS.jsp" %>
  </head>
  <body>
    <%@ include file="/WEB-INF/jsp/NavigationBar/navbar.jsp" %>	
	
	<table border="1" cellpadding="5" width="100%" height="100%">
		<tr valign="top">
			<td width="15%" align="center">
				<h3>Selector</h3><br />
				Select a Clothing item... <br /><br />
				<select id="firstDropdown" onchange="nextSecondAction()">
					<option value=""></option>
				</select>
				
				<br /><br /><br /><br />
				
				<div id="firstGoesWellWith" hidden="true">... goes well with...</div><br />
				<select id="secondDropdown" onchange="nextThirdAction()" hidden="true">
					<option value=""></option>
				</select>
				
				<br /><br /><br /><br />
				
				<div id="secondGoesWellWith" hidden="true">... goes well with...</div><br />
				<select id="thirdDropdown" onchange="visualize()" hidden="true">
					<option value=""></option>
				</select>
				
				<br /><br />
				<%@ include file="/WEB-INF/jsp/js/dreamscape.jsp" %>
			</td>
			
			<td width="25%" align="center">
				<h3>Visualizer</h3>
				<div id="visualizer_div">
				</div>
				
				<input type="button" id="reset" onclick="startOver()" value="Reset" hidden="true" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="realize" hidden="true" value="Realize" align="bottom" />
			</td>
			
			<td align="center">
				<h3>Realizer</h3>
				<div id="realizer_div"></div>
				
			</td>
		</tr>
	</table>	
	<%@ include file="/WEB-INF/jsp/js/loadJS.jsp" %>
  </body>
</html>