function traerReporteStatus(){
    $.ajax({
        url:"http://localhost:80/api/Reservation/report-status",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta)
            pintarStatus(respuesta);
        }
    });
}

function  pintarStatus(json_clouds){

    let myTable="<table>";

        myTable+="<tr>";
        myTable+="<td>"+json_clouds.completed+"</td>";
        myTable+="<td>"+json_clouds.cancelled+"</td>";
        myTable+="</tr>";
  
    myTable+="</table>";
    $("#resultado1").html(myTable);
}

function traerReportesFechas(){
    $.ajax({
        url:"http://localhost:80/api/Reservation/report-dates/{dateOne}/{dateTwo}",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta)
            pintarFechas(respuesta);
        }
    });
}

function pintarFechas(items){
    let myTable='<div class="container"><div class="row">';
    for(i=0;i<items.length;i++){
        contador+=1
    }
    <div class="card-body">
        <h5 class="card-title">RESERVAS PARA ESTAS FECHAS</h5>
        <h6 class="card-subtitle mb-2 text-muted">$contador</h6>;
        </div>
        myTable="</div></div>";
    $("#resultadoFechas").append(myTable);
}

function traerReportesClientes(){
    
    $.ajax({
        url:"http://localhost:80/api/Reservation/report-clients",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta)
            pintarConteoClient(respuesta);
        }
    });
}

function pintarConteoClient(items){f
    let myTable='<div class="container"><div class="row">';
    <div class="card-body">
        <h5 class="card-title">TOTAL CLIENTES</h5>
        <h6 class="card-subtitle mb-2 text-muted">${items.total}</h6>;
        </div>
        myTable="</div></div>";
    $("#resultadoTotal").html(myTable);
}
