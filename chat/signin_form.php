<?php
include("db.php");
$name=$_POST['uname'];
$pwd=$_POST['upass'];
if(!($con->select_db($name))) 
{
    echo "we can't find your name in our database, please <a href='signup.php'>register</a>";
}
else 
{
    $query="select password from details where password='$pwd'";
    $result=$con->query($query);
    if($result) {
        session_start();
        $_SESSION['name']=$name;
        // $con->select_db('admin');
        // $con->query("insert into online(name) values('$name')");
        echo "<script>window.open('send_to.php','_self')</script>";
    }
    else
    {
        echo "wrong password , please enter right password <script>window.open('signin.php')</script>";
    }
}
?>