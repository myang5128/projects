const name1 = document.getElementById("resumepic");
const btnname = document.getElementById("viewResume");
function showResume() {
    if (name1.style.display === "none") {
        name1.style.display = "block";
        name1.style.scale = "1rem";
        btnname.innerText = 'Hide Resume!';
    }
    else {
        name1.style.display = "none";
        btnname.innerText = 'Show Resume!'; 
    }
}