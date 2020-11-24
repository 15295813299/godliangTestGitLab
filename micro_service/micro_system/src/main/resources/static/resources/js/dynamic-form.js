var index = 0;

/**
 * 新增动态表单的字段
 */
function addDynamicField(){
    var html = "";
    html += '<div id="dynamicField' + index + '"><hr/>\n' +
        '<p>\n' +
        '<label>动态字段名称（字段显示的名称）</label>\n' +
        '<input class="text-input small-input datepicker" type="text" name="dynamicSubject" />\n' +
        '</p>\n' +
        '<p>\n' +
        '<label>动态字段表示（输入框中name属性的值）</label>\n' +
        '<input class="text-input small-input datepicker" type="text" name="dynamicName" />\n' +
        '</p>\n' +
        '<p>\n' +
        '<label>动态字段输入类型</label>\n' +
        '<select name="dynamicInputType">\n' +
        '<option value="0">文本框</option>\n' +
        '<option value="1">密码框</option>\n' +
        '<option value="2">日期选择框</option>\n' +
        '</select>\n' +
        '<button onclick="removeDynamicField(' + index + ')" type="button" class="mybutton">-</button>\n' +
        '</p></div>';

    //追加到div中
    $("#dynamicDiv").append(html);

    index++;
}

/**
 * 删除动态字段
 */
function removeDynamicField(index){
    $("#dynamicField" + index).remove();
}

/**
 * 提交动态表单
 */
function submitTemplate(){
    //收集搜索的动态属性
    //[{"subject":"满","name":"xxxx","type":0},{},{}]
    //放入一个表单的隐藏域
    //提交这个表单

    //获得所有动态属性的标题
    var subjects = $("input[name='dynamicSubject']"); //数组
    //获得所有动态属性的名称
    var names = $("input[name='dynamicName']"); //数组
    //获得所有动态属性的输入类型
    var types = $("select[name='dynamicInputType']"); //数组

    //动态属性的数组
    var fieldsArray = [];

    //循环各个动态属性
    for (var i = 0; i < subjects.length; i++) {

        //创建一个对象
        var fieldObject = {};

        //获得当前的标题
        var subject = subjects[i].value;
        //获得当前字段的名称
        var name = names[i].value;
        //获得当前的输入类型
        var type = $(types[i]).find("option:selected").val();

        //将每个Field包装成一个JSON对象 {}
        fieldObject.subject = subject;
        fieldObject.name = name;
        fieldObject.type = type;

        //将对象放入数组
        fieldsArray.push(fieldObject);
    }

    //输出数组
    //alert(JSON.stringify(fieldsArray));

    //json放入隐藏域
    $("#templateDynamic").val(JSON.stringify(fieldsArray));

    //提交表单
    $("#templateForm").submit();
}

/**
 * 获得当前模板列表，并且生成两个下拉框
 */
function getTemplateList(){
    $.ajax({
        url: "/system/coupon/templatelistajax",
        success: function(data){
            //循环模板列表
            for(var i = 0; i < data.length; i++){
                //获得其中一个模板对象
                var temp = data[i];

                var html = "<option value='" + temp.id + "' templateClass='" + temp.templateClass + "' templateDynamic='" + temp.templateDynamic + "'>" + temp.tname + "</option>";

                //获得查询的模板类型
                if (temp.templateType == 0) {
                    //规则
                    $("#rule_template").append(html);
                } else {
                    //限制
                    $("#limit_template").append(html);
                }
            }
        }
    });
}

/**
 * 动态生成模板的表单字段
 */
function createDynamicField(index, selected){
    //获得当前被选中的options
    var options = $(selected).find("option:selected");
    //获得模板名称
    var tname = options.html();
    //获得模板id
    var tid = options.val();
    //获得模板的对应实现类的全路径限定名
    var templateClass = options.attr("templateClass");
    //获得模板的动态表单字段 - json
    var templateDynamic = JSON.parse(options.attr("templateDynamic"));

    //生成一个隐藏域 - 保存模板的对应实现类的全路径限定名
    var htmlClass = "<input type='hidden' id='" + (index == 0 ? 'ruleHidden' : 'limitHidden') + "' value='" + templateClass + "'/>";

    //循环生成表单字段
    for(var i = 0; i < templateDynamic.length; i++){
        htmlClass += "<p>";
        //获得一个模板的动态字段
        var fieldJson = templateDynamic[i];
        htmlClass += parseDynamicField(fieldJson);
        htmlClass += "</p>";
    }

    if (index == 0) {
        //规则
        $("#ruleFields").html(htmlClass);
    } else {
        //限制
        $("#limitFields").html(htmlClass);
    }
}

/**
 * 解析动态字段的json - 生成并且返回对应的html文本
 * @param fieldJson
 */
function parseDynamicField(fieldJson){
    //显示的标签
    var subject = fieldJson.subject;
    //输入框的name属性
    var name = fieldJson.name;
    //输入框的类型
    var type = fieldJson.type;

    //拼接一个HTML输入框
    var html = "<label>" + subject + "</label>";

    //判断输入框的类型
    switch (parseInt(type)) {
        case 0:
            //文本框
            html += "<input name='" + name + "' class=\"text-input small-input\" fieldSubject='" + subject + "' fieldType='" + type + "'/>";
            break;
        case 1:
            //密码
            html += "<input type='password' name='" + name + "' class=\"text-input small-input\" fieldSubject='" + subject + "' fieldType='" + type + "'/>";
            break;
        case 2:
            //日期选择框
            html += "<input type='date' name='" + name + "' class=\"text-input small-input\" fieldSubject='" + subject + "' fieldType='" + type + "'/>";
            break;
    }

    return html;
}

/**
 * 提交优惠券表单
 *
 * {"ruleClass":"com.qf.xxxxx", "fields":[{"subject":"满", "name":"must", "value":100},{},{}....]}
 *
 */
function submitCoupon(){

    //获得规则的属性
    //生成json
    //放到隐藏域 提交到实体类的ruleInfo属性
    var ruleObject = {};
    //处理实现类
    var ruleClass = $("#ruleHidden").val();
    ruleObject.ruleClass = ruleClass;

    var fieldsArray = [];
    //处理动态字段
    var ruleInputs = $("#ruleFields [fieldType]");
    for(var i = 0; i < ruleInputs.length; i++){
        var input = ruleInputs[i];

        var inputObject = {};

        var subject = input.fieldSubject;
        var name = input.name;
        var type = input.fieldType;
        var value = input.value;

        inputObject.subject = subject;
        inputObject.name = name;
        inputObject.type = type;
        inputObject.value = value;

        fieldsArray.push(inputObject);
    }
    ruleObject.fields = fieldsArray;
    $("#ruleInfo").val(JSON.stringify(ruleObject));


    //获得限制的属性
    //生成json
    //放到隐藏域 提交到实体类的limitInfo属性
    var limitObject = {};
    //处理实现类
    var limitClass = $("#limitHidden").val();
    limitObject.limitClass = limitClass;

    var fieldsArray2 = [];
    //处理动态字段
    var limitInputs = $("#limitFields [fieldType]");
    for(var i = 0; i < limitInputs.length; i++){
        var input = limitInputs[i];

        var inputObject = {};

        var subject = input.fieldSubject;
        var name = input.name;
        var type = input.fieldType;
        var value = input.value;

        inputObject.subject = subject;
        inputObject.name = name;
        inputObject.type = type;
        inputObject.value = value;

        fieldsArray2.push(inputObject);
    }
    limitObject.fields = fieldsArray2;
    $("#limitInfo").val(JSON.stringify(limitObject));

    //提交表单
    $("#couponForm").submit();
}