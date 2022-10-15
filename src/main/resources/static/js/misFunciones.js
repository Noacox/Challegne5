/*$(document).ready(function(){
    //instrucciones que se ejecutan cuando carga la página!
   traerInformacionCloud()
    });*/

function traerInformacionCloud(){
    $.ajax({
        url:"http://localhost:80/api/Cloud/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            $("#resultadoCloud").empty();
            $("#brand").val("");
            $("#year").val("");
            $("#category").val("");
            $("#name").val("");
            $("#description").val("");
            pintarRespuestaCloud(respuesta)
        }
    });
}

function pintarRespuestaCloud(items){
    let myTable='<div class="container"><div class="row">';
    for(i=0;i<items.length;i++){
        myTable+=`
            <div class="card m-2" style="width: 18rem;" >
                <div class="card-body">
                    <h5 class="card-title">${items[i].brand}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${items[i].year}</h6>
                    <p class= "card-text">${items[i].name}</p>
                    <button class="btn btn-danger" onclick="borrarElementoCloud(${items[i].id})">Borrar</button>
                </div>
            </div>
            `
    }
    myTable+="</div></div>";
    $("#resultadoCloud").append(myTable);
}


function guardarInformacionCloud(){
    let myData={
        brand:$("#brand").val(),
        year:$("#year").val(),
       //category:{id:$("#category").val()},
        name:$("#name").val(),
        description:$("#description").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:80/api/Cloud/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/JSON",
        success:function(respuesta){
            $("#resultadoCloud").empty();
            $("#brand").val("");
            $("#year").val("");
            //$("#category").val("");
            $("#name").val("");
            $("#name").val("");
            traerInformacionCloud();
            alert("Se ha creado la nube")
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function editarInformacionCloud(){
    let myData={
        id:$("#id").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:80/api/Cloud/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoCloud").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            traerInformacionCloud();
            alert("Se ha actualizado")
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function borrarElementoCloud(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:80/api/Cloud/{id}",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoCloud").empty();
            traerInformacionCloud();
            alert("Se ha eliminado nube")
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function traerInformacionClient(){
    $.ajax({
        url:"http://localhost:80/api/Client/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            $("#resultadoClient").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            pintarRespuestaClient(respuesta)
        }
    });
}

function pintarRespuestaClient(items){
    let myTable= "<table> <th>ID</th> <th>NAME</th> <th>EMAIL</th> <th>AGE</th>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        //myTable+="<td> <button onclick='borrarElementoClient("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultadoClient").append(myTable);
}

function guardarInformacionClient(){
    let myData={
        name:$("#name").val(),
        email:$("#email").val(),
        password:$("#password").val(),
        age:$("#age").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
   $.ajax({
        url:"http://localhost:80/api/Client/save",
        type:"POST",
        data:dataToSend,
        contentType:"application/JSON",
        success:function(respuesta){
            $("#resultadoClient").empty();
            $("#name").val("");
            $("#email").val("");
            $("#password").val("");
            $("#age").val("");
            alert("Se ha registrado el cliente")
            location.href = "/index.html"
        }, error: function (xhr, status) {
           console.log(status);
       }
    });
}

function editarInformacionClient(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:80/api/Client/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoClient").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            traerInformacionClient();
            alert("Se ha actualizado")
        }
    });
}

function borrarElementoClient(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:80/api/Client/{id}",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoClient").empty();
            traerInformacionClient();
            alert("Se ha eliminado cliente")
        }
    });
}

function traerInformacionMensaje(){
    $.ajax({
        url:"https://gab0589806bba4f-brbufv9edxenupkn.adb.eu-frankfurt-1.oraclecloudapps.com/ords/admin/message/message",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            $("#resultadoMensaje").empty();
            $("#id").val("");
            $("#messagetext").val("");
            pintarRespuestaMensaje(respuesta.items)
        }
    });
}

function pintarRespuestaMensaje(items){
    let myTable= "<table> <th>ID</th> <th>MESSAGE</th>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].messagetext+"</td>";
        myTable+="<td> <button onclick='borrarElementoMensaje("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultadoMensaje").append(myTable);
}

function guardarInformacionMensaje(){
    let myData={
        id:$("#id").val(),
        messagetext:$("#messagetext").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gab0589806bba4f-brbufv9edxenupkn.adb.eu-frankfurt-1.oraclecloudapps.com/ords/admin/message/message",
        type:"POST",
        data:myData,
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoMensaje").empty();
            $("#id").val("");
            $("#messagetext").val("");
            traerInformacionMensaje();
            alert("Se ha registrado el mensaje")
        }
    });
}

function editarInformacionMensaje(){
    let myData={
        id:$("#id").val(),
        messagetext:$("#messagetext").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gab0589806bba4f-brbufv9edxenupkn.adb.eu-frankfurt-1.oraclecloudapps.com/ords/admin/message/message",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoMensaje").empty();
            $("#id").val("");
            $("#messagetext").val("");
            traerInformacionMensaje();
            alert("Se ha actualizado el mensaje")
        }
    });
}

function borrarElementoMensaje(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gab0589806bba4f-brbufv9edxenupkn.adb.eu-frankfurt-1.oraclecloudapps.com/ords/admin/message/message",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultadoMensaje").empty();
            traerInformacionMensaje();
            alert("Se ha eliminado Mensaje")
        }
    });
}

function validarcreden(name, password){
    if (name=="admin@admin.com"){
        alert("ingreso con exito")
        location.href = "/cloud.html"
    }

}