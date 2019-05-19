//index.html
function featured_meals() {

    get("/dishes/menu/?page=0&size=30", fmcb);
    var id = document.getElementById("L");
    if (!id) {
        return false;
    } else {

        var id = document.getElementById("L").textContent;
        get("/clients/getid/" + id, getIdcb);
    }

}

function fmcb() {
    if (this.readyState == 4 && this.status == 200) {
        //console.log(this.responseText);
        let dishesDto = JSON.parse(this.responseText);
        var div = document.getElementById('meal');
        var i = 0;
        for (i; i < 3; i++) {

            var div2 = div.cloneNode(true);
            div.parentNode.insertBefore(div2, div);
        }
        div.hidden = true;
        document.getElementsByName("id")[0].textContent = dishesDto[0].id;
        document.getElementsByName("name")[0].textContent = dishesDto[0].name;
        document.getElementsByName("cost")[0].textContent = dishesDto[0].cost + "$";
        document.getElementsByName("descriptionn")[0].textContent = dishesDto[0].description;
        document.getElementsByName("img")[0].src = "http://localhost:8080" + dishesDto[0].imgSource;

        document.getElementsByName("id")[1].textContent = dishesDto[11].id;
        document.getElementsByName("name")[1].textContent = dishesDto[11].name;
        document.getElementsByName("cost")[1].textContent = dishesDto[11].cost + "$";
        document.getElementsByName("descriptionn")[1].textContent = dishesDto[11].description;
        document.getElementsByName("img")[1].src = "http://localhost:8080" + dishesDto[11].imgSource;

        document.getElementsByName("id")[2].textContent = dishesDto[8].id;
        document.getElementsByName("name")[2].textContent = dishesDto[8].name;
        document.getElementsByName("cost")[2].textContent = dishesDto[8].cost + "$";
        document.getElementsByName("descriptionn")[2].textContent = dishesDto[8].description;
        document.getElementsByName("img")[2].src = "http://localhost:8080" + dishesDto[8].imgSource;


    }
}

function getIdcb() {
    if (this.readyState == 4 && this.status == 200) {
        let ClientsDto = JSON.parse(this.responseText);
        console.log("сработало");
        var id = document.getElementById("I");
        if (!id) {
            return false;
        } else {
            document.getElementById("I").textContent = ClientsDto.id;
            document.getElementById("burgers").href = "/burgers?userId=" + document.getElementById("I").textContent;
            document.getElementById("pizza").href = "/pizza?userId=" + document.getElementById("I").textContent;
            document.getElementById("drinks").href = "/drinks?userId=" + document.getElementById("I").textContent;
            document.getElementById("deserts").href = "/deserts?userId=" + document.getElementById("I").textContent;
            document.getElementById("check").href = "/check-out?userId=" + document.getElementById("I").textContent;
            document.getElementById("orders").href = "/orders?userId=" + document.getElementById("I").textContent;
        }
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
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = cb;
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(body));
}

function get(url, cb) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = cb;
    xhr.open("GET", url, true);
    xhr.send();
}

function delet(url, cb) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = cb;
    xhr.open("DELETE", url, true);
    xhr.send();
}

/////////////////
function loadburgers() {
    get("/dishes/category/Burger", loadb);
    var id = document.getElementById("L");
    if (!id) {
        return false;
    } else {
        var id = document.getElementById("L").textContent;
        get("/clients/getid/" + id, getIdcb);
        document.getElementById("I").textContent = getRequestParam("userId");

    }


}

function getRequestParam(name) {
    if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
        return decodeURIComponent(name[1]);
}

function loadpizza() {

    get("/dishes/category/Pizza", loadp);
    var id = document.getElementById("L");
    if (!id) {
        return false;
    } else {
        var id = document.getElementById("L").textContent;
        get("/clients/getid/" + id, getIdcb);
        document.getElementById("I").textContent = getRequestParam("userId");
        console.log(id);


    }


}

function loaddrinks() {
    get("/dishes/category/Drink", loaddr);
    var id = document.getElementById("L");
    if (!id) {
        return false;
    } else {
        var id = document.getElementById("L").textContent;
        get("/clients/getid/" + id, getIdcb);
        document.getElementById("I").textContent = getRequestParam("userId");

    }


}

function loaddesserts() {
    get("/dishes/category/Dessert", loadde);
    var id = document.getElementById("L");
    if (!id) {
        return false;
    } else {
        var id = document.getElementById("L").textContent;
        get("/clients/getid/" + id, getIdcb);
        document.getElementById("I").textContent = getRequestParam("userId");

    }


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
            div2.id = "dishId" + dishesDto[i].id;
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
            div2.id = "dishId" + dishesDto[i].id;
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
            div2.id = "dishId" + dishesDto[i].id;
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

function loadde() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let dishesDto = JSON.parse(this.responseText);
        var col = dishesDto.length;

        var div = document.getElementById('menu');
        var i = 0;
        for (i; i < col; i++) {

            var div2 = div.cloneNode(true);
            div2.id = "dishId" + dishesDto[i].id;
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

//////////////
function add_to_cart(e) {
    console.log(e.parentElement.parentNode.parentNode.parentNode.id);
    let shoppingCartDto = {};

    var clientid = document.getElementById("I");
    if (!clientid) {
        alert("Необходимо авторизироваться!");
        return false;
    } else {
        var dishId = e.parentElement.parentNode.parentNode.parentNode.id;
        var newdishId = dishId.split("dishId").join("");
        let client_id = document.getElementById("I").textContent;

        if (newdishId == null || newdishId == "" || client_id == null || client_id == "") {
            alert("Необходимо авторизироваться!");
            return false;
        } else {
            shoppingCartDto.dishId = newdishId;
            shoppingCartDto.clientId = client_id;
            console.log(newdishId);
            post("/shoppingCart/create", shoppingCartDto, addtocartcb);
        }
    }


}

function addtocartcb() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let shoppingCartDto = JSON.parse(this.responseText);
        if (shoppingCartDto.id != null) {
            alert("Блюдо успешно добавлено в корзину!");
        } else {
            alert("Ошибка!");
        }
    }
}

/////////////check-out
function check_out_load() {

    document.getElementById("I").textContent = getRequestParam("userId");
    get("/shoppingCart/" + document.getElementById("L").textContent, checkcb);

}

function checkcb() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let shoppingCartDto = JSON.parse(this.responseText);

        var col = shoppingCartDto.length;

        var div = document.getElementById('dishes');
        var i = 0;
        var total = 0;
        for (i; i < col; i++) {

            var div2 = div.cloneNode(true);
            div2.id = "dishId" + shoppingCartDto[i].id;
            div2.childNodes[2].nextSibling.childNodes[2].nextSibling.childNodes[1].id = "count" + shoppingCartDto[i].id;
            div2.childNodes[2].nextSibling.childNodes[5].nextSibling.nextSibling.childNodes[1].id = "totalcost" + shoppingCartDto[i].id;
            div2.childNodes[2].nextSibling.childNodes[3].nextSibling.nextSibling.childNodes[1].id = "itemcost" + shoppingCartDto[i].id;


            div.parentNode.insertBefore(div2, div);
            document.getElementsByName("id")[i].textContent = shoppingCartDto[i].id;
            document.getElementsByName("name")[i].textContent = shoppingCartDto[i].name;
            document.getElementsByName("category")[i].textContent = shoppingCartDto[i].category;
            document.getElementsByName("mass")[i].textContent = shoppingCartDto[i].mass;
            document.getElementsByName("cost")[i].value = shoppingCartDto[i].cost + "$";
            document.getElementsByName("totalcost")[i].value = shoppingCartDto[i].cost + "$";
            document.getElementsByName("descriptionn")[i].textContent = shoppingCartDto[i].description;
            document.getElementsByName("img")[i].src = "http://localhost:8080" + shoppingCartDto[i].img_source;


            total = total + parseInt(document.getElementsByName("totalcost")[i].value.split("$").join("").toString());

        }
        div.hidden = true;
        document.getElementById("total").textContent = "$" + total;
        //document.getElementById("total").textContent =
    }
}

function deleteShoppingCartDish(e) {
    console.log(e.parentElement.id);

    var ShoppingCartId = e.parentElement.id;
    var newShoppingCartId = ShoppingCartId.split("dishId").join("");
    console.log(newShoppingCartId);
    if (newShoppingCartId == null || newShoppingCartId == "") {
        alert("Необходимо авторизироваться!");
        return false;
    } else {
        delet("/shoppingCart/" + newShoppingCartId, null);
        window.location.reload();
    }
}

function item_total(e) {

    var countId = e.id;
    console.log(countId);
    console.log(document.getElementById(countId));


    var totalcostId = countId.split("count").join("totalcost");
    var itemcostId = countId.split("count").join("itemcost");
    document.getElementById(totalcostId).value =
        parseInt(document.getElementById(countId).value.toString()) *
        parseInt(document.getElementById(itemcostId).value.toString()) + "$";

    get("/shoppingCart/" + document.getElementById("L").textContent, cb);

    function cb() {
        if (this.readyState == 4 && this.status == 200) {
            var total = 0;
            var i = 0;
            let shoppingCartDto = JSON.parse(this.responseText);
            var col = shoppingCartDto.length;
            for (i; i < col; i++) {
                total = total + parseInt(document.getElementsByName("totalcost")[i].value.split("$").join("").toString());
            }
            document.getElementById("total").textContent = "$" + total;
        }
    }


}

function clearShoppingCart() {

    get("/shoppingCart/" + document.getElementById("L").textContent, cb);

    function cb() {
        if (this.readyState == 4 && this.status == 200) {

            var i = 0;
            let shoppingCartDto = JSON.parse(this.responseText);
            var col = shoppingCartDto.length;
            for (i; i < col; i++) {

                delet("/shoppingCart/" + document.getElementsByName("id")[i].textContent, null);

            }
            window.location.reload();
        }
    }

}

function orders() {
    var dishList =[];
    dishList.push(document.getElementsByName("count17").textContent);
    dishList[0];
}
//////////////orders.html
function orders_load(){
    document.getElementById("I").textContent = getRequestParam("userId");
    get("/orders/{login}/" + document.getElementById("L").textContent, orderscb);
}
function orderscb() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let ordersDto = JSON.parse(this.responseText);

        var col = ordersDto.length;

        var div = document.getElementById('dishes');
        var i = 0;
        var total = 0;
        for (i; i < col; i++) {

            var div2 = div.cloneNode(true);
            div2.id = "dishId" + shoppingCartDto[i].id;
            div2.childNodes[2].nextSibling.childNodes[2].nextSibling.childNodes[1].id = "count" + shoppingCartDto[i].id;
            div2.childNodes[2].nextSibling.childNodes[5].nextSibling.nextSibling.childNodes[1].id = "totalcost" + shoppingCartDto[i].id;
            div2.childNodes[2].nextSibling.childNodes[3].nextSibling.nextSibling.childNodes[1].id = "itemcost" + shoppingCartDto[i].id;


            div.parentNode.insertBefore(div2, div);
            document.getElementsByName("id")[i].textContent = shoppingCartDto[i].id;
            document.getElementsByName("name")[i].textContent = shoppingCartDto[i].name;
            document.getElementsByName("category")[i].textContent = shoppingCartDto[i].category;
            document.getElementsByName("mass")[i].textContent = shoppingCartDto[i].mass;
            document.getElementsByName("cost")[i].value = shoppingCartDto[i].cost + "$";
            document.getElementsByName("totalcost")[i].value = shoppingCartDto[i].cost + "$";
            document.getElementsByName("descriptionn")[i].textContent = shoppingCartDto[i].description;
            document.getElementsByName("img")[i].src = "http://localhost:8080" + shoppingCartDto[i].img_source;


            total = total + parseInt(document.getElementsByName("totalcost")[i].value.split("$").join("").toString());

        }
        div.hidden = true;
        document.getElementById("total").textContent = "$" + total;
        //document.getElementById("total").textContent =
    }
}