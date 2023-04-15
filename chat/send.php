<?php
include( 'db.php' );
session_start();
$name = $_SESSION[ 'name' ];
?>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>Hello! <?php echo $_SESSION[ 'name' ];
?></h1>
<form method = 'post'>
<textarea name = 'msg' id="msg" cols = '80' rows = '3' required></textarea><br>
<cnter><input type = 'submit' value = 'send'></cnter>
</form>
<!-- <script>
    let inputBox = document.getElementById("msg");
    let cancel;
    inputBox.value=localStorage.getItem('msg');
    inputBox.addEventListener('keyup',function(event) {
        if(cancel) clearTimeout(cancel);
        cancel=setTimeout(() => {
        localStorage.setItem('msg',event.target.value);
        }, 100);
    })
</script> -->
</body>
</html>
<?php
if ( isset( $_SESSION[ 'to' ] ) )
{
    $to = $_SESSION[ 'to' ];
    echo "<h1>sending messages to $to</h1>";
    // checking the to existence in db
    if ( !( $con -> select_db( $to ) ) ) echo "<script>alert('no such user')</script>";
    // -------------------------------
    else {
        // $con->query('select')
        $con->select_db( $name );
        if ( isset( $_POST[ 'msg' ] ) ) {
            $msg = $_POST[ 'msg' ];
            $rs = $con->query( "insert into $to(message,sr) values('$msg','s')" );
            if ( $rs ) $con->query( "insert into $to.$name(message,sr) values('$msg','r')" );
            else {
                $con->query( "create table $to(message text,sr varchar(1))" );
                $con->query( "insert into $to(message,sr) values('$msg','s')" );
                $con->query( "create table $to.$name(message text,sr varchar(1))" );
                $con->query( "insert into $to.$name(message,sr) values('$msg','r')" );
            }
            echo "<script>
            if ( window.history.replaceState ) {
              window.history.replaceState( null, null, window.location.href );
            }
            </script>";
        }
    }
    $rs = $con->query( "select * from $to" );
    echo "<hr>";
    if ( $rs ){
        if ( $rs-> num_rows > 0 ){
            while( $row = $rs->fetch_assoc() ){
                if ( $row[ 'sr' ] == 'r' ){
                    echo '<b>'.$to.':</b>'.$row[ 'message' ].'<br>';
                } else {
                    echo '<div style="float:right ;padding-right:20px;"> <b> '.$name.':</b>'.$row[ 'message' ].'</div><br>';
                }
            }
            echo '<hr>';
        } 
        else echo 'no records';
    } 
    else echo 'no such table';
} 
else echo 'did not set the reciever name go back and try again';
?>