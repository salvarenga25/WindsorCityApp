<?php
    $db = "(DESCRIPTION=(ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = 10.176.1.94)(PORT = 8080)))(CONNECT_DATA=(SID=Doable)))" ;
    if($c = OCILogon("sys as sysdba", "Oracle_1", $db))
    {
        echo "Successfully connected to Oracle.\n";
        OCILogoff($c);
    }
    else
    {
        $err = OCIError();
        echo "Connection failed." . $err[text];
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./public/main.css" type ="text/css"/>
    <title>CoW Web-Based App</title>
</head>
    
    
<body>
    <!-- <div class="toggler">
    <span id = "openNav">&#9776; Menu </span>
    </div>

    <nav id="nav" class="sidenav"> 
        <ul>
            <li><h2>City of Windsor </h2></li>
            <a href="#" class="closebtn" id ="closeNav">&times;</a>
            <li><a href="create.html">New Post</a></li> 


        </ul>
 


    </nav>
-->

    <header>
        <div class="container"> 
        
            <img src="https://www.citywindsor.ca/residents/Culture/PublishingImages/City%20Logo%20-%201%20Colour%20-%20White%20-%20JPEG.jpg" alt="logo" class="logo">
            
            <nav>
            <ul>
                <li><a href= "#"> Main</a></li>
                <li><a href= "#"> Community Centres</a></li>
                <li><a href= "#"> Parking Lots</a></li>
                <li><a href= "#"> Garbage Collection</a></li>
                <li><a href= "#"> Bus Routes</a></li>
                <li><a href= "#"> Special Events</a></li>
                <li><a href= "#"> Other</a></li>
                
            </ul>
            </nav>
            
            
        </div>
        </header>
     
    
<!--   
    <h1>CoW Information App</h1>

    <main id="main">
        <div id= "adminPosts"></div>
    </main>

    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-firestore.js"></script>
    <script>src="./functions/main.js"</script>
-->

</body>
</html>