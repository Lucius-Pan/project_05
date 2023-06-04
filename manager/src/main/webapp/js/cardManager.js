let page = 1;
let totalPage ;
let cardNum;
loadPage();
function loadPage(cardNum, empName, beginTime, endTime,bState) {
    $.ajax({
        url: "selectAllCard",
        type: "post",
        dataType: "json",
        data: {
            "cardNum": cardNum,
            "empName": empName,
            "beginTime": beginTime,
            "endTime": endTime,
            "bState": bState,
            "page": page
        },
        success: function (reps) {
            console.log(reps)
            if (reps.code=="200"){
                document.getElementById("table").innerHTML = `<table class="table table-bordered" id="table">
        <tr>
            <th style="text-align: center;">序号</th>
            <th>卡号</th>
            <th>持卡人</th>
            <th>状态</th>
            <th>注册时间</th>
            <th>截止时间</th>
            <th style="width: 300px">操作</th>
        </tr>`;
                for (let i = 0; i < reps.data.list.length; i++) {
                    console.log("序号："+(i+1));
                    let cardNum = reps.data.list[i].cardNum;
                    console.log("cardNum: "+cardNum)
                    let empName = reps.data.list[i].empName ==null ? "暂未分配" : reps.data.list[i].empName;
                    console.log("empName: "+empName)
                    let beginTime = new Date(reps.data.list[i].beginTime);
                    console.log("beginTime: "+beginTime)
                    let endTime = reps.data.list[i].endTime == null ? "暂未分配" : new Date(reps.data.list[i].endTime);
                    console.log("endTime: "+endTime)
                    let bState = reps.data.list[i].bState == 0 ? "未分配" : "已分配";
                    let allocationBtn = reps.data.list[i].bState == 0 ? `<button class="btn btn-warning " type="button" data-toggle="modal" data-target="#allocateModal" onclick="getCardNum(this)">分配</button>` : `<button class="btn btn-warning " type="button" onclick="resetCard(this)">重置</button>`;
                    console.log("bState: "+bState)
                    document.getElementById("table").innerHTML += `<tr>
            <td style="text-align: center;">${(i + 1)}</td>
            <td>${cardNum}</td>
            <td>${empName}</td>
            <td>${bState}</td>
            <td>${beginTime}</td>
            <td>${endTime}</td>
            <td style="width: 300px"> 
            <button class="btn btn-primary"  type="button">查看</button>
            <button class="btn  btn-info" type="button" >修改</button>
            <button class="btn  btn-danger" type="button" onclick="deleteCard(this)">删除</button>
            ${allocationBtn}
            </td>
        </tr>`
                }
                document.getElementById("table").innerHTML += `</table>`;
                let num = reps.data.num;
                $("#detail").html("详情---共"+num+"条数据");
                totalPage = Math.ceil(num / 5);
                document.getElementById("page").innerText = page + "/" + totalPage;
            }else {
                alert(reps.msg);
            }
        },
        error: function (reps) {
            document.write(reps.responseText)
        }
    })
}



function getCardNum(e) {
    cardNum =e.parentNode.parentNode.children[1].innerHTML;
}
$("#insertConfirm").click(function () {
  let cardNum = $("#insertCardNum").val();
    if (cardNum == null || cardNum == ""){
        alert("请输入卡号");
        return;
    }
    $.ajax({
        url: "insertCard",
        type: "post",
        dataType: "json",
        data: {
            "cardNum": cardNum
        },
        success: function (reps) {
            if (reps.code=="200"){
                alert("添加成功");
                loadPage();
            }else {
                alert(reps.msg);
            }
        },
        error: function (reps) {
            document.write(reps.responseText)

        }
    })

})
$("#allocateCard").click(function () {
    let empId = $("#allocateEmpId").val();
    if (empId == null || empId == ""){
        alert("请输入员工编号");
        return;
    }
    let endTime = $("#allocateEndTime").val();
    if (endTime == null || endTime == ""){
        alert("请选择截止时间");
        return;
    }
    console.log("empId: "+empId+" endTime: "+endTime+" cardNum: "+cardNum);
    $.ajax({
        url: "allocateCard",
        type: "post",
        dataType: "json",
        data: {
            "empId": empId,
            "endTime": endTime,
            "cardNum": cardNum
        },
        success: function (reps) {
            if (reps.code=="200"){
                alert("分配成功");
                loadPage();
            }else {
                alert(reps.msg);
            }
        },
        error: function (reps) {
            document.write(reps.responseText)

        }
    })
})


function resetCard(e) {
    let cardNum = e.parentNode.parentNode.children[1].innerHTML;
    console.log(cardNum);
    $.ajax({
        url: "resetCard",
        type: "post",
        dataType: "json",
        data: {
            "cardNum": cardNum
        },
        success: function (reps) {
            if (reps.code=="200"){
                alert("重置成功");
                loadPage();
            }else {
                alert(reps.msg);
            }
        },
        error: function (reps) {
            document.write(reps.responseText)

        }
    })
}
function deleteCard(e) {
    let cardNum = e.parentNode.parentNode.children[1].innerHTML;
    console.log(cardNum);
    $.ajax({
        url: "deleteCard",
        type: "post",
        dataType: "json",
        data: {
            "cardNum": cardNum
        },
        success: function (reps) {
            if (reps.code=="200"){
                alert("删除成功");
                loadPage();
            }else {
                alert(reps.msg);
            }
        },
        error: function (reps) {
            document.write(reps.responseText)

        }
    })
}
$("#searchCard").click(function () {
    let cardNum = $("#cardNum").val();
    let empName = $("#empName").val();
    let beginTime = $("#beginTime").val();
    let endTime = $("#endTime").val();
    let bState = $('#pickerState').data('zui.picker').value;
    console.log(cardNum, empName, beginTime, endTime,bState);
    loadPage(cardNum, empName, beginTime, endTime,bState);

});

// 选择时间和日期
$(".form-date").datetimepicker(
    {
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: "yyyy-mm-dd"
    });
let optionList = [
        {text: '未分配', value: '0', keys: 'options'},
        {text: '已分配', value: '1', keys: 'options'},
];

$('#pickerState').picker({list: optionList});

