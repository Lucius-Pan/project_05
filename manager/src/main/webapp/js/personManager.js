let page = 1;
let totalPage;
let chooseEid;

// 加载页面
loadPage();



function setUser(e) {
    chooseEid = e.parentNode.parentNode.children[0].innerText;
    let empName = e.parentNode.parentNode.children[1].innerText;
    let roomName = e.parentNode.parentNode.children[2].innerText;
    let roleName = e.parentNode.parentNode.children[3].innerText;
    let roomId = selectRoomIdByName(roomName);
    let roleId = selectRoleIdByName(roleName);
    console.log(empName);
    console.log(roomName + " : " + roleName);
    console.log(roomId + " : " + roleId);
    $('#updateInputAcc').val(empName);
    $('#pickerUpdateRoom').data('zui.picker').setValue(roomId);
    $('#pickerUpdateRole').data('zui.picker').setValue(roleId);
}

$("#updateConfirm").click(function () {
    let empName = $('#updateInputAcc').val();
    let roleId = $('#pickerUpdateRole').data('zui.picker').value;
    let roomId = $('#pickerUpdateRoom').data('zui.picker').value;
    console.log(empName + " : " + roleId + " : " + roomId);
    $.ajax({
        type: "POST",
        url: "updateEmp",
        data: {
            'empId': chooseEid,
            'roleId': roleId,
            'roomId': roomId
        },
        dataType: 'json',
        async: true,
        success: function (reps) { //连接成功
            if (reps.code == "200") {
                alert("修改成功");
                loadPage();
            }
        }, error: function (reps) { //连接失败
            document.write(reps.responseText)
        }
    })
})


// 添加
$("#insertConfirm").click(function () {
    let userName = $('#insertInputAcc').val();
    let roleId = $('#pickerInsertRole').data('zui.picker').value;
    let roomId = $('#pickerInsertRoom').data('zui.picker').value;
    console.log(userName + " : " + roleId + " : " + roomId);
    $.ajax({
        type: "POST",
        url: "insertEmp",
        data: {
            'userName': userName,
            'roleId': roleId,
            'roomId': roomId
        },
        dataType: 'json',
        async: true,
        success: function (reps) { //连接成功
            if (reps.code == "200") {
                alert("添加成功");
                loadPage();
            }
        },
        error: function (reps) { //连接失败
            document.write(reps.responseText)
        }
    })
})
// 搜索
$("#search").click(function () {
    page = 1;
    // let value = $("#pickerRole").getValue();
    // 获取选择器实例对象 获取选中的值。
    let userName = $('#inputAcc').val();
    console.log(userName);
    let roleId = $('#pickerRole').data('zui.picker').value;
    let roomId = $('#pickerRoom').data('zui.picker').value;
    let stateId = $('#pickerState').data('zui.picker').value;
    loadPage(userName, roleId, roomId, stateId);
})
// 重置
$("#reset").click(function () {
    loadPage();
})
// 上一页
$("#previousPage").click(function () {
    if (page == 1) {
        alert("已经是第一页了");
    } else {
        page--;
        loadPage();
    }
})
// 下一页
$("#nextPage").click(function () {
    if (page == totalPage) {
        alert("已经是最后一页了")
    } else {
        page++;
        loadPage();

    }
})

//加载页面
function loadPage(userName, role, room, b_state) {
    $.ajax({
        type: "POST",
        url: "selectAllEmp",
        data: {
            'userName': userName,
            'role': role,
            'room': room,
            'b_state': b_state,
            'page': page
        },
        dataType: 'json',
        async: true,
        success: function (reps) { //连接成功
            if (reps.code == "200") {
                console.log(reps.list.length);
                document.getElementById("table").innerHTML = `<table class="table table-bordered" id="table">
   <tr>
       <th style="text-align: center;">序号</th>
       <th>姓名</th>
       <th>科室</th>
       <th>角色</th>
       <th>状态</th>
       <th style="width: 300px">操作</th>
   </tr>`
                for (let i = 0; i < reps.list.length; i++) {
                    let roleName = selectRoleNameById(reps.list[i].roleId);
                    let roomName = selectRoomNameById(reps.list[i].roomId);
                    let stateName = selectStateNameById(reps.list[i].bState);
                    document.getElementById("table").innerHTML += `<tr>
        <td>${reps.list[i].empId}</td>
        <td>${reps.list[i].empName}</td>
        <td>${roomName}</td>
        <td>${roleName}</td>
        <td>${stateName}</td>
        <td>
            <button class="btn btn-primary"  type="button" data-toggle="modal" data-target="#UpdateModal" onclick="setUser(this)">修改</button>
            <button class="btn btn-danger " type="button">删除</button>
            <button class="btn btn-info " type="button">禁用</button>
            <button class="btn btn-warning " type="button">重置密码</button>
        </td>
    </tr>`
                    document.getElementById("table").innerHTML += `</table>`
                    let num = reps.num;
                    totalPage = Math.ceil(num / 5);
                    document.getElementById("page").innerText = page + "/" + totalPage;
                }
            }
            if (reps.code == "500") {
                alert("没有数据");
            }
        }, error: function (reps) { //连接失败
            document.write(reps.responseText)
        }
    })
}

// 根据id选择角色名
function selectRoleIdByName(roleName) {
    if (roleName == '未分配') {
        return 0;
    } else if (roleName == '管理员') {
        return 1;
    } else if (roleName == '收费员') {
        return 2;
    } else if (roleName == '医生') {
        return 3;
    }
}

// 根据角色名选择Id
function selectRoleNameById(roleId) {
    if (roleId == 0) {
        return '未分配';
    } else if (roleId == 1) {
        return '管理员'
    } else if (roleId == 2) {
        return '收费员'
    } else if (roleId == 3) {
        return '医生'
    }
}

// 根据id选择科室名
function selectRoomIdByName(roomName) {
    if (roomName == '未分配') {
        return 0;
    } else if (roomName == '管理中心') {
        return 1;
    } else if (roomName == '收费处') {
        return 2;
    } else if (roomName == '急诊科') {
        return 3;
    } else if (roomName == '普通内科') {
        return 4;
    }
}

// 根据id选择科室名
function selectRoomNameById(roomId) {
    if (roomId == 0) {
        return '未分配';
    } else if (roomId == 1) {
        return '管理中心'
    } else if (roomId == 2) {
        return '收费处'
    } else if (roomId == 3) {
        return '急诊科'
    } else if (roomId == 4) {
        return '普通内科'
    }
}

// 根据id选择状态名
function selectStateNameById(stateId) {
    if (stateId == 0) {
        return '未启用';
    } else if (stateId == 1) {
        return '启用'
    } else if (stateId == 2) {
        return '封禁'
    }
}

// 根据角色名选择id
function selectStateIdByName(stateName) {
    if (stateName == '未启用') {
        return 0;
    } else if (stateName == '启用') {
        return 1;
    } else if (stateName == '封禁') {
        return 2;
    }
}


let optionListInsert1 = [
    {text: '未分配', value: '0', keys: 'options'},
    {text: '管理员', value: '1', keys: 'options'},
    {text: '收费员', value: '2', keys: 'options'},
    {text: '医生', value: '3', keys: 'options'}
];

$('#pickerInsertRole').picker({list: optionListInsert1});

let optionListInsert2 = [
    {text: '未分配', value: '0', keys: 'options'},
    {text: '管理中心', value: '1', keys: 'options'},
    {text: '收费处', value: '2', keys: 'options'},
    {text: '急诊科', value: '3', keys: 'options'},
    {text: '普通内科', value: '4', keys: 'options'}
];

$('#pickerInsertRoom').picker({list: optionListInsert2});

let optionListUpdate1 = [
    {text: '未分配', value: '0', keys: 'options'},
    {text: '管理员', value: '1', keys: 'options'},
    {text: '收费员', value: '2', keys: 'options'},
    {text: '医生', value: '3', keys: 'options'}
];

$('#pickerUpdateRole').picker({list: optionListUpdate1});

let optionListUpdate2 = [
    {text: '未分配', value: '0', keys: 'options'},
    {text: '管理中心', value: '1', keys: 'options'},
    {text: '收费处', value: '2', keys: 'options'},
    {text: '急诊科', value: '3', keys: 'options'},
    {text: '普通内科', value: '4', keys: 'options'}
];

$('#pickerUpdateRoom').picker({list: optionListUpdate2});


let optionList1 = [
    {text: '未分配', value: '0', keys: 'options'},
    {text: '管理员', value: '1', keys: 'options'},
    {text: '收费员', value: '2', keys: 'options'},
    {text: '医生', value: '3', keys: 'options'}
];


$('#pickerRole').picker({list: optionList1});

let optionList2 = [
    {text: '未分配', value: '0', keys: 'options'},
    {text: '管理中心', value: '1', keys: 'options'},
    {text: '收费处', value: '2', keys: 'options'},
    {text: '急诊科', value: '3', keys: 'options'},
    {text: '普通内科', value: '4', keys: 'options'}
];

$('#pickerRoom').picker({list: optionList2});

let optionList3 = [
    {text: '未启用', value: '0', keys: 'options'},
    {text: '启用', value: '1', keys: 'options'},
    {text: '封禁', value: '2', keys: 'options'}
];

$('#pickerState').picker({list: optionList3});