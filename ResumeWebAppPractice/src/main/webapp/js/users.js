function idForDelete(id) {
    var elem = document.getElementById("idForDelete");
    elem.value = id;
}

function showHide() {
    var elem = document.getElementById("btnsearch");
    if (elem.visible) {
        elem.visible = false;
        btnsearch.style = "display:none";
    } else {
        elem.visible = true;
        btnsearch.style = "display: inline";
    }
}

function check(userId, countryId) {
    var elem = document.getElementById("checkedRadio");
    if (userId == countryId)
        elem.checked = true;
};