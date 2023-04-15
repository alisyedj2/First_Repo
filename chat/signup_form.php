<?php
include("db.php");
$name=$_POST['name'];
$pwd=$_POST['password'];
$code=$_POST['code'];
if($con->connect_errno) echo "no connection";
else{
    $query="create database $name";
    $result=$con->query($query);
    if(!$result) echo " signup failed - name may exists in our database , kindly enter other name";
    $con->select_db($name);
    $query="create table details(password varchar(25),code varchar(25),friends varchar(100))";
    if($con->query($query)) echo "ok";
    $query="insert into details(password,code) values('$pwd','$code')";
    $con->query($query); 
    echo "<script>window.open('signin.php','_self')</script>";
}
?>