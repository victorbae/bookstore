
    $(document).ready(function () {
        $('.date').mask('00/00/0000');
    
        var optionsPeople = {
            url: function (phrase) {
                return 'http://localhost:8080/person/getList';
            },
            getValue: function (element) {
                return element.nome;
            },
            list: {
                onSelectItemEvent: function () {
                    var codigo = $("#nomeCliente").getSelectedItemData().codigo;
                    $('#codigoCliente').val(codigo);
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
                data.phrase = $("#nomeCliente").val();
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
                    var codigo = $("#nomeLivro").getSelectedItemData().codigo;
                    $('#codigoLivro').val(codigo);
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
                data.phrase = $("#nomeLivro").val();
                return data;
            },
            requestDelay: 400
        };
        $("#nomeCliente").easyAutocomplete(optionsPeople);
        $("#nomeLivro").easyAutocomplete(optionsBooks);

        $('.coloca-width-no-porco-dio').find('.easy-autocomplete').removeAttr("style");
    })