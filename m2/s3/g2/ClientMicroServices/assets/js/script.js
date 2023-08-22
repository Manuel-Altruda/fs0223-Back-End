document.addEventListener("DOMContentLoaded", function() {
    var getStringBtn = document.getElementById("getStringBtn");
    var getPeopleBtn = document.getElementById("getPeopleBtn");
    var getFromService8082Btn = document.getElementById("getFromService8082Btn");
    
    getStringBtn.addEventListener("click", function() {
        fetchData("http://localhost:8080/os/get-string", "stringResponse");
    });
    
    getPeopleBtn.addEventListener("click", function() {
        fetchData("http://localhost:8080/os/get-people", "peopleResponse");
    });
    
    getFromService8082Btn.addEventListener("click", function() {
        fetchData("http://localhost:8082/app/data3", "service8082Response");
    });

    getFromService8082Data2Btn.addEventListener("click", function() {
        fetchData("http://localhost:8082/app/data2", "service8082Data2Response");
    });
});

function fetchData(url, targetId) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    
    xhr.onload = function() {
        if (xhr.status === 200) {
            var response = xhr.responseText;
            document.getElementById(targetId).textContent = response;
        } else {
            document.getElementById(targetId).textContent = "Error: " + xhr.statusText;
        }
    };
    
    xhr.onerror = function() {
        document.getElementById(targetId).textContent = "Request failed";
    };
    
    xhr.send();
}
