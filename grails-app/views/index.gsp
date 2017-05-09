<!doctype html>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Welcome to Grails</title>

  <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<div class="links"><a href="${g.createLink(controller: 'login', action: 'auth')}">Login</a></div>
<div class="links"><a href="${g.createLink(controller: 'registration', action: 'index')}">Registration</a>
</div>
</body>
</html>
