document.getElementById("gyLogin").addEventListener("click", function() {
    // 버튼 클릭 시 GET 요청 보내기
    fetch('/login', {
        method: 'GET'
    })
        .then(response => response.text())
        .then(data => {
            // 서버에서 받아온 데이터 처리
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
});