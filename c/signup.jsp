<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="signup.css">
</head>
<body>
    <div class="main">
        <div class="form">
            <h1>login</h1>
            <div class="foram">
                <form action="signupcode.jsp">
                    <label>FullName</label>
                    <input type="text"  name='name' required>

                    <label>Password</label>
                    <input type="password" name='pass' required>

                    <label>E-mail</label>
                    <input type="email" name='mail' required>

                    <label>Number</label>
                    <input type="number" name='num' required>

                    <label>Area/Ward/Zone</label>
                    <input type="text" name='wrd' required>

                    <label>Designation</label>
                    <input type="text" name='desig' required>

                    <input type="button" value="Sign Up">
                </form>
            </div>
        </div>
    </div>
</body>
</html>