function callService(method, url, data, callback, errorcab) {
    $.ajax({
        type: method,
        url: url,
        data: data,
        dataType: "JSON",
        success: callback,
        errors: errorcab
    });
}
function callServiceJson(method, url, data, callback, errorcab) {
    $.ajax({
        type: method,
        url: url,
        data: data,
        contentType:'application/json',
        dataType: "JSON",
        success: callback,
        errors: errorcab
    });
}