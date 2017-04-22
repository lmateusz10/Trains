<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Trains manager</h2>


<h3>Add wagon</h3>
<form action="addwagon" method="POST">
    <input type="text" name="mark" placeholder="Oznaczenie wagonu" />
    <br />
    <input type="text" name="type" placeholder="Typ wagonu" />
    <br />
    <input type="text" name="owner" placeholder="Wlasciciel wagonu" />
    <br />
    <input type="text" name="producer" placeholder="Producent Wagonu" />
    <br />
    <input type="number" name="seatingareas" placeholder="Ilość miejsc siedzacych" />
    <br />
    <input type="number" name="quantity" placeholder="Ilość wagonow" />
    <br />
    <input type="submit" value="Add Wagon" />
</form>

<h3>Add loco</h3>
<form action="addloco" method="post">
    <input type="text" name="name" placeholder="Nazwa lokomotywy" />
    <br />
    <input type="number" name="maxspeed" placeholder="Predkosc maksymalna" />
    <br />
    <input type="text" name="powertype" placeholder="Typ silnika" />
    <br />
    <input type="text" name="weight" placeholder="Waga" />
    <br />
    <input type="submit" value="Add loco" />
</form>

<h3>Add train</h3>
<form action="addtrain" method="post">
    <input type="text" name="name" placeholder="nazwa pociagu" />
    <br />
    <input type="submit" value="Add train" />
</form>


<h3>Add loco to train</h3>
<form action="addlocototrain" method="post">
    <input type="number" name="trainid" placeholder="id pociagu" />
    <br />
    <input type="number" name="locoid" placeholder="id lokomotowy" />
    <br />
    <input type="submit" value="Add loco to train" />
</form>
<h3>Add wagon to train</h3>
<form action="addwagontotrain" method="post">
    <input type="number" name="trainid" placeholder="id pociagu" />
    <br />
    <input type="number" name="wagonid" placeholder="id wagonu" />
    <br />
    <input type="submit" value="Add wagon to train" />
</form>



<h3>Add client</h3>
<form action="addclient" method="post">
    <input type="text" name="firstName" placeholder="Client first name" />
    <br />
    <input type="text" name="lastName" placeholder="Client last name" />
    <br />
    <input type="text" name="address" placeholder="Address" />
    <br />
    <input type="submit" value="Add Client" />
</form>

<h3>Add order</h3>
<form action="addorder" method="post">
    <input type="number" name="clientId" placeholder="Client ID" />
    <br />
    <input type="text" name="orderDetails" placeholder="Details" />
    <br />
    <input type="submit" value="Add Order" />
</form>

<h3>Add product</h3>
<form action="addproduct" method="post">
    <input type="text" name="productName" placeholder="Product name" />
    <br />
    <input type="text" name="productPrice" placeholder="Product price" />
    <br />
    <input type="text" name="productDetails" placeholder="Details" />
    <br />
    <input type="submit" value="Add Product" />
</form>

<h3>Add product to order</h3>
<form action="addproduct-order" method="post">
    <input type="number" name="orderId" placeholder="Order ID" />
    <br />
    <input type="number" name="productId" placeholder="Product ID" />
    <br />
    <input type="submit" value="Add Product" />
</form>



<h3>Get train</h3>
<form action="gettrain" method="post">
    <input type="number" name="trainid" placeholder="Train ID" />
    <input type="submit" value="Get Train" />
</form>

<h3>Get loco</h3>
<form action="getloco" method="post">
    <input type="number" name="locoid" placeholder="Loco ID" />
    <input type="submit" value="Get loco" />
</form>

<h3>Remove loco from train</h3>
<form action="removelocofromtrain" method="post">
    <input type="number" name="trainid" placeholder="id pociagu" />
    <br />
    <input type="number" name="locoid" placeholder="id lokomotowy" />
    <br />
    <input type="submit" value="Remove loco from train" />
</form>

<h3>Remove wagon from train</h3>
<form action="removewagonfromtrain" method="post">
    <input type="number" name="trainid" placeholder="id pociagu" />
    <br />
    <input type="number" name="wagonid" placeholder="id wagonu" />
    <br />
    <input type="submit" value="Remove wagon from train" />
</form>

<h3>Remove train</h3>
<form action="removetrain" method="post">
    <input type="number" name="trainid" placeholder="Train ID" />
    <input type="submit" value="Remove Train" />
</form>
<h3>Remove loco</h3>
<form action="removeloco" method="post">
    <input type="number" name="locoid" placeholder="Loco ID" />
    <input type="submit" value="Remove Loco" />
</form>

</body>
</html>