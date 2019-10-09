$(document).ready(function () {
        $('.openModal').on('click', function () {
            var codigo = $(this).data('codigo');
            var nome = $(this).data('nome');
            var codigoCat = $(this).data('cod-categoria');
            var nomeCat = $(this).data('categoria');
            var quantidade = $(this).data('quantidade');

            $('#novoBook').modal('show');
            $('#modal-codigo').val(codigo);
            $('#modal-nome').val(nome);
            $('#modal-codigoCat').val(codigoCat);
            $('#modal-nomeCat').val(nomeCat);
            $('#modal-quantidade').val(quantidade);
        });

        $('#new').on('click', function () {
            $('#modal-codigo').val('');
            $('#modal-nome').val('');
            $('#modal-codigoCat').val('');
            $('#modal-nomeCat').val('');
            $('#modal-quantidade').val('');
            $('#novoBook').modal('show');
        });

        var optionsCatBook = {
            url: function (phrase) {
                return 'http://localhost:8080/booktypes/getList';
            },
            getValue: function (element) {
                return element.nome;
            },
            list: {
                onSelectItemEvent: function () {
                    var codigo = $("#novoBook #modal-nomeCat").getSelectedItemData().codigo;
                    $('#novoBook #modal-codigoCat').val(codigo);
                }
            },
            ajaxSettings: {
                dataType: "json",
                method: "GET",
                data: {
                    dataType: "json"
                }
            },
            preparePostData: function (data) {
                data.phrase = $("#novoBook #modal-nomeCat").val();
                return data;
            },
            requestDelay: 400
        };
        $("#novoBook #modal-nomeCat").easyAutocomplete(optionsCatBook);

        $('.coloca-width-no-porco-dio').find('.easy-autocomplete').removeAttr("style");
    })