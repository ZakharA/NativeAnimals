
$(document).ready(function() {

    $("#CreateAnimal\\:countries").keyup(function(event) {
        var msg = "Handler for .keyup() called  time(s).";
        getCountries($("#CreateAnimal\\:countries").val());
    }).keydown(function(event) {
        if (event.which == 13) {
            event.preventDefault();
        }
    });

    function getCountries(partialName) {
        $.ajax({
            url: "http://localhost:54070/NativeAnimalsREST/webresources/country/" + partialName,
        }).then(function(data) {
            UpdateAutoCompleteData(data.countries);
        });

    }
    function UpdateAutoCompleteData(data) {
        $("#CreateAnimal\\:countries").autocomplete({
            source: data
        });
    }
});

