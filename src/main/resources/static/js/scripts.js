/*!
* Start Bootstrap - Shop Homepage v5.0.5 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

function delete_confirm(){

    if(confirm("정말로 삭제하시겠습니까?")){
        alert("삭제되었습니다");
        document.getElementById("delete_form").submit();
        return true;
    }
    else{
        return false
    }
}