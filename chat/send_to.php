<?php
include("db.php");
session_start();
?>
<html>
    <head>
        <title>
            friends
        </title>
    </head>
    <body>
        <form action="send_form.php" method="post">
            <input type="text" name="to" required>
            <input type="submit" value="open chat">
        </form>
    </body>
</html>
