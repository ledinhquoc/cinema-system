$(document).ready(function(){
  // Activate tooltips
  $('[data-toggle="tooltip"]').tooltip();
  // var actions = $("table tbody td:last-child").html();
  // alert(actions);
  // Filter table rows based on searched term
  $("#search").on("keyup", function() {
    var term = $(this).val().toLowerCase();
    $("table tbody tr").each(function(){
      $row = $(this);
      var name = $row.find("td:nth-child(1)").html().toLowerCase()+
        $row.find("td:nth-child(2)").html().toLowerCase()+
        $row.find("td:nth-child(3)").html().toLowerCase()+
        $row.find("td:nth-child(5)").html().toLowerCase()+
        $row.find("td:nth-child(6)").html().toLowerCase()+
        $row.find("td:nth-child(4)").html().toLowerCase();
      console.log(name);
      // console.log(term);
      if(name.search(term) < 0){
        $row.hide();
      } else{
        $row.show();
      }
    });
  });
});
