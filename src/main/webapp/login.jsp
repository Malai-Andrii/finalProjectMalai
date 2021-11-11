<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
  <title>Авторизація</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<form method="post">
          <div class="form-group">
            <h3>Логін:</h3>
            <input type="text" class="form-control" id="username" placeholder="Введіть логін" name="username">
          </div>
          <div class="form-group">
            <h3>Пароль:</h3>
            <input type="password" class="form-control" id="password" placeholder="Введіть пароль" name="password">
          </div>
          <div class="form-group form-check">
            <label class="form-check-label">
              <input class="form-check-input" type="checkbox" name="remember"> Запам'ятати мене
            </label>
          </div>
          <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-success btn-lg">Увійти!</button>
          </div>
          <div class="d-flex justify-content-center">
            <a href="#" style="margin-top: 0.5em;">Забули пароль?</a>
          </div>
        </form>
</body>
</html>