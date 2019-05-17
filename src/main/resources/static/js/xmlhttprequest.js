//index.html
function featured_meals() {
    get("/dishes/menu/?page=0&size=20", fmcb);
    var id = document.getElementById("L");
    if(!id)
    {
        return false;
    }
    else
    {
        var id = document.getElementById("L").textContent;
        get("/clients/getid/" + id, getIdcb);
        console.log(id);
    }

}

function fmcb() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let dishesDto = JSON.parse(this.responseText);
        var div = document.getElementById('meal');
        var i = 0;
        for (i; i < 3; i++) {

            var div2 = div.cloneNode(true);
            div.parentNode.insertBefore(div2, div);

            //console.log(document.getElementsByName("description")[i].textContent);
        }
        div.hidden = true;
        document.getElementsByName("name")[0].textContent = dishesDto[0].name;
        document.getElementsByName("cost")[0].textContent = dishesDto[0].cost + "$";
        document.getElementsByName("descriptionn")[0].textContent = dishesDto[0].description;
        document.getElementsByName("img")[0].src = "http://localhost:8080" + dishesDto[0].imgSource;
        console.log(dishesDto[0].imgSource);

        document.getElementsByName("name")[1].textContent = dishesDto[11].name;
        document.getElementsByName("cost")[1].textContent = dishesDto[11].cost + "$";
        document.getElementsByName("descriptionn")[1].textContent = dishesDto[11].description;
        document.getElementsByName("img")[1].src = "http://localhost:8080" + dishesDto[11].imgSource;

        document.getElementsByName("name")[2].textContent = dishesDto[8].name;
        document.getElementsByName("cost")[2].textContent = dishesDto[8].cost + "$";
        document.getElementsByName("descriptionn")[2].textContent = dishesDto[8].description;
        document.getElementsByName("img")[2].src = "http://localhost:8080" + dishesDto[8].imgSource;


    }
}

function getIdcb() {
    if (this.readyState == 4 && this.status == 200) {
        let ClientsDto = JSON.parse(this.responseText);
        console.log(ClientsDto.id);
        document.getElementById("I").textContent = ClientsDto.id;

    }
}

//registration
function registration() {
    let clientsDto = {};
    let surname = document.getElementById("surname").value;
    let address = document.getElementById("address").value;
    let phone = document.getElementById("phone").value;
    let login = document.getElementById("login").value;
    let clientPassword = document.getElementById("clientPassword").value;
    if (surname == null || surname == "" || address == null || address == "" || phone == null || phone == "" || login == null || login == "" || clientPassword == null || clientPassword == "") {
        alert("Необходимо заполнить все поля!");
        return false;
    } else {
        console.log(surname);
        clientsDto.surname = surname;
        clientsDto.address = address;
        clientsDto.phone = phone;
        clientsDto.login = login;
        clientsDto.password = clientPassword;
        post("/clients/create", clientsDto, testCb);
    }

}

function testCb() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let clientsDto = JSON.parse(this.responseText);
        if (clientsDto.id != null) {
            alert("Регистрация прошла успешно!");
        } else {
            alert("Пользователь с таким логином уже существует!");
        }
    }

}

///////
function post(url, body, cb) {
    console.log(body);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = cb;
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(body));
}

function get(url, cb) {
    console.log("hello world");
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = cb;
    xhr.open("GET", url, true);
    xhr.send();
}


function loadburgers() {

    get("/dishes/category/Burger", loadb)

}

function loadpizza() {

    get("/dishes/category/Pizza", loadp)

}

function loaddrinks() {

    get("/dishes/category/Drink", loaddr)

}

function loaddesserts() {

    get("/dishes/category/Dessert", loadde)

}

function loadb() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let dishesDto = JSON.parse(this.responseText);
        var col = dishesDto.length;

        var div = document.getElementById('menu');
        var i = 0;
        for (i; i < col; i++) {

            var div2 = div.cloneNode(true);
            div.parentNode.insertBefore(div2, div);
            document.getElementsByName("id")[i].textContent = dishesDto[i].id;
            document.getElementsByName("name")[i].textContent = dishesDto[i].name;
            document.getElementsByName("category")[i].textContent = dishesDto[i].category;
            document.getElementsByName("mass")[i].textContent = dishesDto[i].mass;
            document.getElementsByName("cost")[i].textContent = dishesDto[i].cost + "$";
            document.getElementsByName("descriptionn")[i].textContent = dishesDto[i].description;
            document.getElementsByName("img")[i].src = "http://localhost:8080" + dishesDto[i].img_source;
        }
        div.hidden = true;

    }

}

function loadp() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let dishesDto = JSON.parse(this.responseText);
        var col = dishesDto.length;

        var div = document.getElementById('menu');
        var i = 0;
        for (i; i < col; i++) {

            var div2 = div.cloneNode(true);
            div.parentNode.insertBefore(div2, div);
            //console.log(document.getElementsByName("id")[i].value);
            document.getElementsByName("id")[i].textContent = dishesDto[i].id;
            document.getElementsByName("name")[i].textContent = dishesDto[i].name;
            document.getElementsByName("category")[i].textContent = dishesDto[i].category;
            document.getElementsByName("mass")[i].textContent = dishesDto[i].mass;
            document.getElementsByName("cost")[i].textContent = dishesDto[i].cost + "$";
            document.getElementsByName("descriptionn")[i].textContent = dishesDto[i].description;
            document.getElementsByName("img")[i].src = "http://localhost:8080" + dishesDto[i].img_source;
            console.log(document.getElementsByName("img")[i].src)
        }
        div.hidden = true;

    }

}

function loaddr() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let dishesDto = JSON.parse(this.responseText);
        var col = dishesDto.length;

        var div = document.getElementById('menu');
        var i = 0;
        for (i; i < col; i++) {

            var div2 = div.cloneNode(true);
            div.parentNode.insertBefore(div2, div);
            //console.log(document.getElementsByName("id")[i].value);
            document.getElementsByName("id")[i].textContent = dishesDto[i].id;
            document.getElementsByName("name")[i].textContent = dishesDto[i].name;
            document.getElementsByName("category")[i].textContent = dishesDto[i].category;
            document.getElementsByName("mass")[i].textContent = dishesDto[i].mass;
            document.getElementsByName("cost")[i].textContent = dishesDto[i].cost + "$";
            document.getElementsByName("descriptionn")[i].textContent = dishesDto[i].description;
            document.getElementsByName("img")[i].src = "http://localhost:8080" + dishesDto[i].img_source;
        }
        div.hidden = true;

    }

}

function loadde() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let dishesDto = JSON.parse(this.responseText);
        var col = dishesDto.length;

        var div = document.getElementById('menu');
        var i = 0;
        for (i; i < col; i++) {

            var div2 = div.cloneNode(true);
            div.parentNode.insertBefore(div2, div);
            //console.log(document.getElementsByName("id")[i].value);
            document.getElementsByName("id")[i].textContent = dishesDto[i].id;
            document.getElementsByName("name")[i].textContent = dishesDto[i].name;
            document.getElementsByName("category")[i].textContent = dishesDto[i].category;
            document.getElementsByName("mass")[i].textContent = dishesDto[i].mass;
            document.getElementsByName("cost")[i].textContent = dishesDto[i].cost + "$";
            document.getElementsByName("descriptionn")[i].textContent = dishesDto[i].description;
            document.getElementsByName("img")[i].src = "http://localhost:8080" + dishesDto[i].img_source;
        }
        div.hidden = true;

    }

}

    