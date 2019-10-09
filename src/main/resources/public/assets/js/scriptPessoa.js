$(document).ready(function () {
	$('.openModal').on('click', function () {
    	var codigo = $(this).data('codigo');
        var nome = $(this).data('nome');
        var telefone = $(this).data('telefone');

        $('#novaPessoa').modal('show');
        $('#modal-codigo').val(codigo);
        $('#modal-nome').val(nome);
        $('#modal-telefone').val(telefone);
    }),
	$('#new').on('click', function() {
		$('#modal-codigo').val('');
        $('#modal-nome').val('');
        $('#modal-telefone').val('');
        $('#novaPessoa').modal('show');
        console.log('Chegou');
    })
})