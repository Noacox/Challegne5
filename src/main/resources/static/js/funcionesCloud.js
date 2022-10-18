//GET, POST , PUT Y DELETE

function getCloud (){
    $.ajax({
        url:"http://localhost:80/api/Cloud/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            
            pintarCloud(respuesta);
        }
    });

}

function postCloud(){
    let cajas = {
        name:$("#name").val(),
        brand:$("#brand").val(),
        year:$("#year").val(),
        description:$("#description").val(),
        category:{id: +$("#select-categoria").val()}
    };
    console.log(cajas);
    $.ajax({
        url:"http://localhost:80/api/Cloud/save",
        type:"POST",
        datatype:"JSON",
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(cajas),
        success:function(respuesta){
            alert("se creo correctamente la cloud");
            window.location.reload();
    
        }
    });

}

function putCloud(){

}

function deleteCloud(){
    
}

////////////////////////////////////////////////////////

function pintarCloud(json_clouds){
    let myTable="<table>";
    for(i=0;i<json_clouds.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+json_clouds[i].name+"</td>";
        myTable+="<td>"+json_clouds[i].brand+"</td>";
        myTable+="<td>"+json_clouds[i].year+"</td>";
        myTable+="<td>"+json_clouds[i].description+"</td>";
        myTable+="<td>"+json_clouds[i].category.name+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultadoCloud").html(myTable);

}

function getCategoria_Cloud(){
    $.ajax({
        url:"http://localhost:80/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            let $select = $("#select-categoria");
            $.each(respuesta, function(id, name){
                $select.append('<option value='+name.id+'>'+name.name+'</option>' )
            })
        }
    });
}