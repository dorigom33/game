<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/> 
</head>
<body>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">설명</th>
				</tr>
			</thead>
			<tbody id="tBody">
			</tbody>
		</table>
	</div>
<script>
function loadFunc(){
	const xhr = new XMLHttpRequest();
	xhr.open('GET','/test-info/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.responseText);
				const list = JSON.parse(xhr.responseText);
				let html = '';
				for(const test of list){
					html += '<tr>';
					html += '<td>' + test.tiNum + '</td>';
					html += '<td>' + test.tiName + '</td>';
					html += '<td>' + test.tiDesc + '</td>';
					html += '</tr>';
				}
				document.querySelector('#tBody').innerHTML = html;
			}
		}
	}
	xhr.send();
}
window.addEventListener('load',loadFunc);
</script>
</body>
</html>




