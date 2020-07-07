<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ConverterNumeralSystem</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Quick start with dhtmlxGrid</title>
    <link rel="STYLESHEET" type="text/css" href="../../codebase/dhtmlxgrid.css">
    <script src="../../codebase/dhtmlxcommon.js"></script>
    <script src="../../codebase/dhtmlxgrid.js"></script>
    <script src="../../codebase/dhtmlxgridcell.js"></script>
    <script src="../../codebase/prototype.js"></script>
</head>
<body>         <%-- /run.jsp--%>

<fieldset>
    <form action="/WebProject/resultServlet" method="POST">
        <h1><b>Conversion of numbers between numeral systems</b></h1>
        <p><b>Number:</b><br>
            <input type="text" name="number" value="${number}" size="40">
        </p>
        <p><b>Input base:</b><br>
            <input type="text" name="a" value="${a}" size="40">
        </p>
        <p><b>Target base:</b><br>
            <input type="text" name="b" value="${b}" size="40">
        </p>
        <p><b>Result:</b><br>
            <input type="text" name="result" value="${result}" size="40">
        </p>
        <p>
            <button type="submit" id="btn_convert">Calculate</button>
        </p>
    </form>
</fieldset>
<fieldset>
    <div id="grid" style="width:400px;height:200px;"></div>
    <div id="values" style="width:700px;height:200px;">
        <p><b>Number:</b><br>
            <input type="text" id="number_" name="number" size="40">
        </p>
        <p><b>Input base:</b><br>
            <input type="text" id="a_" name="a" size="40">
        </p>
        <p><b>Target base:</b><br>
            <input type="text" id="b_" name="b" size="40">
        </p>
        <p>
            <button type="submit" id="btn_convert_2">Calculate</button>
        </p>
    </div>
</fieldset>

<script>
    var gridObjectMatrix = new dhtmlXGridObject("grid");
    gridObjectMatrix.setHeader("Number,Input base,Target base,Result");
    gridObjectMatrix.setInitWidths("100,100,100,100");
    gridObjectMatrix.init();

  //  var name=$('#number_');

    function btnClick() {
           new Ajax.Request('http://localhost:8080/WebProject/resultServlet', {
               method: 'get',
               datatype:'json',
               parameters: {number: $F('number_'), a: $F('a_'), b: $F('b_')},
               onSuccess: function (transport) {
                   var response = transport.responseText || "no response text";
                   var y = response.evalJSON(true);
                   gridObjectMatrix.parse(y,"json");
               },
               onFailure: function () {
                   alert('Something went wrong...')
               }
           });


       }
       document.observe('dom:loaded',
           function () {
               Event.observe('btn_convert_2', 'click', btnClick);
           }
       );
</script>
</body>
</html>
