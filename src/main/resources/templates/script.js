
window.onload = function() {
var convertBtn = document.getElementById("convert-button")
var URLinput = document.getElementById("URL-input")
convertBtn.addEventListener('click', () => {
    console.log(`URL: ${URLinput.value}`);
    sendURL(URLinput.value);
});
}
function sendURL(URL) {
    window.location.href = `http://localhost:4000/download?URL=${URL}`;
}