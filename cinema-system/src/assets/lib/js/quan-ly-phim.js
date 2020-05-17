$(document).ready(function () {
$('#dtHorizontalVerticalExample').DataTable({
	"scrollX": true,
	"scrollY": 300,
	"bPaginate": false,
	"bInfo" : false,
	"info": false,
	"bLpmChange": false,
	"searching": false,   // Search Box will Be Disabled

	"ordering": false,    // Ordering (Sorting on Each Column)will Be Disabled


	"lengthChange": false, // Will Disabled Record number per page

});

$('.dataTables_length').addClass('bs-select');
});