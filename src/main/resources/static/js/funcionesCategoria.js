//GET, POST , PUT Y DELETE

function getCategoria (){
    $.ajax({
        url:"http://localhost:80/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            
            pintarCategoria(respuesta.items);
        }
    });

}

function postCategoria(){

    if($("#name").val().length==0 || $("#description").val().length==0 ){
        alert("Todos los campos son obligatorios");
    }else{
    
    let cajas = {
        name:$("#name").val(),
        description:$("#description").val()
    };
    $.ajax({
        url:"http://localhost:80/api/Category/save",
        type:"POST",
        datatype:"JSON",
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(cajas),
        success:function(respuesta){
            alert("se creo correctamente la categoria");
            window.location.reload();
    
            }
        });
    }
}

function putCategoria(idDesdeBoton){
    console.log(idDesdeBoton);
    if($("#name").val().length==0 || $("#description").val().length==0 ){
        alert("Todos los campos son obligatorios");
    }else{
    
    let cajas = {
        id:idDesdeBoton,
        name:$("#name").val(),
        description:$("#description").val()
    };
    $.ajax({
        url:"http://localhost:80/api/Category/update",
        type:"PUT",
        datatype:"JSON",
        contentType:"application/json",
        data: JSON.stringify(cajas),
        success:function(respuesta){
            alert("se actualizo correctamente la informacion de la categoria");
            window.location.reload();
    
            }
        });
    }
    

}

function deleteCategoria(idDesdeBoton){
  
    let myData={
        id:idDesdeBoton
    };
    $.ajax({
        url:"http://localhost:80/api/Category/"+idDesdeBoton,
        type:"DELETE",
        datatype:"JSON",
        data: JSON.stringify(myData),
        contentType:"application/json",
        success:function(respuesta){
            alert("se borro correctamente la categoria");
            window.location.reload();
        }
    });

}

////////////////////////////////////////////

function pintarCategoria(items){
    let myTable='<div class="container"><div class="row">';
    for(i=0;i<items.length;i++){
        myTable+=`
            <div class="card m-2" style="width: 18rem;" >
                <div class="card-body">
                    <h5 class="card-title">${items[i].name}</h5>
                    <p class= "card-text">${items[i].description}</p>
                    <button class="btn btn-danger" onclick="deleteCategoria(${items[i].id})">Borrar</button>
                </div>
            </div>
            `
    }
    myTable+="</div></div>";
    $("#resultado1").append(myTable);
}