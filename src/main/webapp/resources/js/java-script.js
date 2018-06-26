function deleteProduto(id) {
	if($.get("/delete/" + id)){
		$.get("/listaProdutos");
	}
}

function confirmDelete() {
	var id = parseInt($("#id-produto").val());
	deleteProduto(id);
}

function modalDelete(id) {
	$("#id-produto").val(id);
	$("#delete-modal").modal('show');

}