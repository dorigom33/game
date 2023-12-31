<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List3</title>
<style>
tr.link{
    background-color:white;
    color:black;
    cursor:pointer;
}
tr.link:hover{
    color:blue;
}
</style>
</head>
<body>
    <table border="3">
        <tr>
            <th scope="col">번호</th>
            <th scope="col">이름</th>
            <th scope="col">나이</th>
            <th scope="col">주소</th>
        </tr>
        <tbody id="tBody"> 
        </tbody>
    </table>
    <script>
    function goPage(num){
        location.href = '/views/one?num=' + num;
    }
    function goUpdatePage(num){
        location.href = '/views/update.jsp?num=' + num;
    }
    function getList(){
        const xhr = new XMLHttpRequest();
        xhr.open('GET', '/list/list');
        xhr.onreadystatechange = function(){
            if(xhr.readyState === 4){
                if(xhr.status === 200){
                    const list = JSON.parse(xhr.responseText);
                    let html = '';
                    for(const map of list){
                        html += '<tr class="link" onclick="goPage('+ map.num +')">';
                        html += '<td>' + map.num + '</td>';
                        html += '<td>' + map.name + '</td>';
                        html += '<td>' + map.age + '</td>';
                        html += '<td>' + map.address + '</td>';
                        html += '</tr>';
                    }

                    document.querySelector('#tBody').innerHTML = html;
                    console.log(html);
                }
            }
        }
        xhr.send();
    }
    window.addEventListener('load',getList);
    </script>
</body>
</html>
