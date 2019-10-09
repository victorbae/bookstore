
    $(document).ready(function () {
        $('.openModal').on('click', function () {
            var codigo = $(this).data('codigo');
            var nome = $(this).data('nome');

            $('#novoBookType').modal('show');
            $('#modal-codigo').val(codigo);
            $('#modal-nome').val(nome);
        });


        $('#new').on('click', function () {
            $('#modal-codigo').val('');
            $('#modal-nome').val('');
            $('#novoBookType').modal('show');
        });

    })