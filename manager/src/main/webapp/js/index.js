// 选择时间和日期
$(".form-datetime").datetimepicker(
    {
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        format: "yyyy-mm-dd hh:ii"
    });

$("#sendBtn").click(function () {
    let userAcc = $("#userAcc").val();
    console.log("userAcc: " + userAcc)
    let userPwd = $("#userPwd").val();
    console.log("pwd: " + userPwd)
    userPwd = $.md5(userPwd);
    console.log(userPwd);
    $.ajax({
        url: "userLogin",
        type: "POST",
        data: {
            "userName": userAcc,
            "userPwd": userPwd
        },
        dataType: 'json',
        async: true,
        success: function (reps) {
            if (reps.code == "200") {
                alert("登陆成功！");
                window.location.href = "toManager?page=" + reps.location;
                localStorage.setItem("userAcc", userAcc);
            }
        },
        error: function (reps) {
            document.write(reps.responseText);
        }


    })

//
})
