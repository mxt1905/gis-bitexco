var prevScrollpos = window.pageYOffset;
var directScrollpos = 1304.800048828125;
window.onscroll = function() {
    var currentScrollPos = window.pageYOffset;
    if (prevScrollpos > currentScrollPos) {
        document.getElementById("navbar").style.top = "0";
    } else {
        document.getElementById("navbar").style.top = "-95px";

    }
    prevScrollpos = currentScrollPos;
}
