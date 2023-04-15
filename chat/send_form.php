<?php
session_start();
if(isset($_POST['to']))
$_SESSION['to'] = $_POST['to'];
echo "<script>window.open('send.php','_self')</script>"
?>