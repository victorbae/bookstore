
    $(document).ready(function () {

        $('#new').on('click', function () {
            $('#modal-codigo').val('');
            $('#modal-nomeCliente').val('');
            $('#modal-codigoCliente').val('');
            $('#modal-codigoLivro').val('');
            $('#modal-nomeLivro').val('');
            $('#modal-devolucao').val('');
            $('#novoRent').modal('show');
        });

        var optionsPeople = {
            url: function (phrase) {
                return 'http://localhost:8080/person/getList';
            },
            getValue: function (element) {
                return element.nome;
            },
            list: {
                onSelectItemEvent: function () {
                    var codigo = $("#novoRent #modal-nomeCliente").getSelectedItemData().codigo;
                    $('#novoRent #modal-codigoCliente').val(codigo);
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
                data.phrase = $("#novoRent #modal-nomeCliente").val();
                return data;
            },
            requestDelay: 400
        };

        var optionsBooks = {
            url: function (phrase) {
                return 'http://localhost:8080/books/getList';
            },
            getValue: function (element) {
                return element.nome;
            },
            list: {
                onSelectItemEvent: function () {
                    var codigo = $("#novoRent #modal-nomeLivro").getSelectedItemData().codigo;
                    $('#novoRent #modal-codigoLivro').val(codigo);
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
                data.phrase = $("#novoRent #modal-nomeLivro").val();
                return data;
            },
            requestDelay: 400
        };
        $("#novoRent #modal-nomeCliente").easyAutocomplete(optionsPeople);
        $("#novoRent #modal-nomeLivro").easyAutocomplete(optionsBooks);

        $('.coloca-width-no-porco-dio').find('.easy-autocomplete').removeAttr("style");
    })