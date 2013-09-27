<%@ include file="/WEB-INF/jsp/include.jsp" %>
<link type="text/css" href="http://z-ecx.images-amazon.com/images/G/01/browser-scripts/mx-site-wide-css-beacon/site-wide-6371769550._V1_.css" rel="stylesheet">
<link type="text/css" href="http://z-ecx.images-amazon.com/images/G/01/browser-scripts/search-css/search-css-2960538377._V1_.css" rel="stylesheet">
<link type="text/css" href="http://z-ecx.images-amazon.com/images/G/01/browser-scripts/clickWithinSearchPageStatic/clickWithinSearchPageStatic-152100381._V1_.css" rel="stylesheet">
<link type="text/css" href="http://z-ecx.images-amazon.com/images/G/01/browser-scripts/us-site-wide-css-beacon/site-wide-6164419306._V1_.css" rel="stylesheet">


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