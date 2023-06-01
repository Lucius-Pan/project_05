let item = localStorage.getItem("userAcc");
$("#uname").text("欢迎您：" + item);

$("#menu").click(function (e) {
    let target = e.target;
    let children = target.parentElement.children;
    for (let i = 0; i < children.length; i++) {
        if (children[i].className == "menuItem") {
            console.log("change page!")
            let page = target.getAttribute("page");
            console.log(page)
            let frame = document.getElementById("frame");
            frame.src = "toManager?page=" + page;
        }
    }
})