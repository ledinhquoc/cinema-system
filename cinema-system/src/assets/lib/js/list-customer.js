$(document).ready(function () {
  $('[data-toggle="tooltip"]').tooltip();
  const actions = $("table td:last-child").html();
  // Append table with add row form on add new button click
  $(".add-new").click(function () {
    $(this).attr("disabled", "disabled");
    var index = $("table tbody tr:last-child").index();
    var row = '<tr>' +
      '<td><input type="text" class="form-control" name="id" id="id" ></td>' +
      '<td><input type="text" class="form-control" name="name" id="name"></td>' +
      '<td><input type="text" class="form-control" name="date" id="date"></td>' +
      '<td><input type="text" class="form-control" name="gender" id="gender"></td>' +
      // '<td><select name="gender" id="gender" style="width: 100%">' +
      // '<option value="Male" selected>Male</option>' +
      // '<option value="Female">Female</option>' +
      // '</select></td>' +
      '<td><input type="text" class="form-control" name="idCard" id="idCard"></td>' +
      '<td><input type="text" class="form-control" name="email" id="email"></td>' +
      '<td><input type="text" class="form-control" name="address" id="address"></td>' +
      '  <td>\n' +
      '          <a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>\n' +
      '          <a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>\n' +
      '          <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>\n' +
      '        </td>'+'</tr>';
    $("table").append(row);
    $("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
    $('[data-toggle="tooltip"]').tooltip();

    $(".add").click(function() {
      var str = $("#name").val();
      console.log(str);
    })
  });
  // Add row on add button click
  $(document).on("click", ".add", function () {
    let empty = false;
    var input = $(this).parents("tr").find('input[type="text"]');
    input.each(function () {
      if (!$(this).val()) {
        $(this).addClass("error");
        empty = true;
      } else {
        $(this).removeClass("error");

      }
    });
    $(this).parents("tr").find(".error").first().focus();
    if (!empty) {
      input.each(function () {
        $(this).parent("td").html($(this).val());
      });
      $(this).parents("tr").find(".add, .edit").toggle();
      $(".add-new").removeAttr("disabled");
    }
  });
  // Edit row on edit button click
  $(document).on("click", ".edit", function () {
    $(this).parents("tr").find("td:not(:last-child)").each(function () {
      $(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
    });
    $(this).parents("tr").find(".add, .edit").toggle();
    $(".add-new").attr("disabled", "disabled");
  });
  // Delete row on delete button click
  $(document).on("click", ".delete", function () {
    $(this).parents("tr").remove();
    $(".add-new").removeAttr("disabled");
  });
});
