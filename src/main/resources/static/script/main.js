const checkbox = document.getElementById('one-way');
const datetime = document.getElementById('return');

// When the checkbox is clicked, toggle the datetime input's disabled attribute
checkbox.addEventListener('click', function() {
    datetime.disabled = !datetime.disabled;
});

function toogleReturnTime() {
    var returnTime = document.getElementById("return");
    var oneWayCheckbox = document.getElementById("one-way");

    if (oneWayCheckbox.checked) {
        returnTime.disabled = true;
    } else {
        returnTime.disabled = false;
    }
}