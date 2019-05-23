<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список заказов</title>
    <link rel="stylesheet" href="css/orders.css">
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>Никнейм заказчика</td>
        <td>Запчасти</td>
        <td></td>
    </tr>
    <#list orders as order>
        <tr>
            <td>#{order.number}</td>
            <td>${order.owner}</td>
            <td>${order.details}</td>
            <td>
                <form action="/deleteOrder" method="post">
                    <input type="hidden" name="number" value="#{order.number}">
                    <input type="submit" value="Удалить заказ">
                </form>
            </td>
        </tr>
    </#list>
</table>

<form action="/logout" method="post">
    <input type="submit" value="Выйти">
    </form>
</body>
</html>