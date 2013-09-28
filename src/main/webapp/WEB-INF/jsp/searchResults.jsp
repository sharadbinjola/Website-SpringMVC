<%@ include file="/WEB-INF/jsp/include.jsp" %>

<div class="list results apsList">
	<table>
	<tr>
	<c:forEach var="searchResult" items="${searchResults}">
		<td>
			<div style='height:100%; overflow:auto;'>
				<center><b>${searchResult.title}</b></center><br />
				${searchResult.result}<br /><br />
				<a href="${searchResult.url}" target="_blank"><b>See more recommendations>></b></a>
			</div>
		</td>
	</c:forEach>
	</tr>
	</table>
</div>