<html>
    <head>
        <title>sign up</title>
    </head>
    <body>
        <form action="signup_form.php" method="post">
            <table>
            <tr>
                <td>
                    <label>NAME:</label>
                </td>
                <td>
                    <input type="text" name="name" required>
                </td>
            </tr>
            <tr>
            <td>
                    <label>PASSWORD:</label>
                </td>
                <td>
                    <input type="password" name="password" required>
                </td>
            </tr>
            <tr>
                <td>
                    <label>SECURITY CODE:</label>
                </td>
                <td>
                    <input type="text" name="code" required>
                </td>
            </tr>
</table>
            <br><input type="submit">
        </form>
    </body>
</html>