<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Fjalla+One|League+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="makepagesexy.css"/>
<title>View</title>
</head>
<body>
	<table>
		<tbody>
			<c:forEach var="row" items="${result}"> <!-- comes from controller -->
				<tr>
					<c:forEach var="column" items="${row}">
						<td>${column}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>