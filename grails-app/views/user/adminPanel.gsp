<!doctype html>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Welcome to Grails</title>

  <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<div class="links"><a href="${g.createLink(controller: 'User', action: 'index')}">Users</a></div>
<div class="links"><a href="${g.createLink(controller: 'Customer', action: 'index')}">Customers</a></div>
<div class="links"><a href="${g.createLink(controller: 'PricingPlan', action: 'index')}">Pricing Plans</a></div>
</body>
</html>
