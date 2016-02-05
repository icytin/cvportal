<%@tag description="Layout Template" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CvPortal</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/_shared/bootstrap.min.css" rel="stylesheet">
    
    <!-- Bootstrap Optional theme -->
    <link href="${pageContext.request.contextPath}/resources/css/_shared/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/_shared/shop-item.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/_shared/layout.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/_shared/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/_shared/bootstrap.min.js"></script>
    
    <!-- Angular Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/_shared/angular.min.js"></script>
    
    <!--  App init -->
    <script src="${pageContext.request.contextPath}/resources/js/_shared/app.js"></script>
    
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">CvPortal</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Mina CV</a>
                    </li>
                    <li>
                        <a href="#">Utskrift</a>
                    </li>
                    <li>
                        <a href="#">Rapporter</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

<div class="container">
    <!-- Page Content -->
    <div id="main-content">
  		<div class="col-lg-8 col-md-4 col-xs-8">
			
		</div>
		<div class="col-lg-4 col-md-8 col-xs-4" style="text-align: right">
			<i class="glyphicon glyphicon-user"></i> Inloggad som Hen. Doe
		</div>
		
    	<jsp:doBody />
    	
	</div>
    

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p style="text-align: center">Copyright &copy; CGI 2015</p>
                </div>
            </div>
        </footer>
    </div>
    <!-- /.container -->

    
	
</body>

</html>
