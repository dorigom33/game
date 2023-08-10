<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <input type="text" id="uiId"><br>
	이름 : <input type="text" id="uiName"><br>
	비밀번호 : <input type="password" id="uiPwd"><br>
	소개 : <textarea id="uiDesc"></textarea><br>
	생년월일 : <input type="date" id="uiBirth"><br>
	<button onclick="sendObj()">등록</button>
	<script>
    function sendObj() {
        const param = {
            uiId: document.querySelector('#uiId').value,
            uiName: document.querySelector('#uiName').value,
            uiPwd: document.querySelector('#uiPwd').value,
            uiDesc: document.querySelector('#uiDesc').value,
            uiBirth: document.querySelector('#uiBirth').value
        }
        
        const json = JSON.stringify(param);

        const xhr = new XMLHttpRequest();

        xhr.open('POST', '/user-info/insert');
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    if (xhr.responseText === '1') {
                        alert('정상적으로 등록되었습니다.');
                        location.href = '/views/list';
                    } else {
                        alert('오류가 발생했습니다. 다시 시도해주세요.');
                    }
                }
            }
        }
        xhr.send(json);
    }
	</script>
</body>
</html>
