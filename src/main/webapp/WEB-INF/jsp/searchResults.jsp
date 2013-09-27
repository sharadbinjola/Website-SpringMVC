<%@ include file="/WEB-INF/jsp/include.jsp" %>

<div class="list results apsList">
	<table>
	<tr>
	<c:forEach var="searchResult" items="${searchResults}">
		<td width="33%">
			<div style='height:100%; overflow:auto;'>
				${searchResult.title} <br /><br />
				${searchResult.result}
			</div>
		</td>
	</c:forEach>
	</tr>
	</table>
</div>