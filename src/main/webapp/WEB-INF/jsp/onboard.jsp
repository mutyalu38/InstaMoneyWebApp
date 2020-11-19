<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
  <title>Admin- Today's Loan Applications</title>

  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Quicksand:300,400,500,700"
  rel="stylesheet">
  <link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css"
  rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="app-assets/css/vendors.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/app.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-menu-modern.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/core/colors/palette-gradient.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/core/colors/palette-callout.css">
  <link rel="stylesheet" type="text/css" href="assets/css/style.css">
  <!-- END Custom CSS-->

</head>
<body class="vertical-layout vertical-menu-modern 2-columns   menu-expanded fixed-navbar"
data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
 
  <div class="app-content content">
    <div class="content-wrapper">
      <div class="content-header row">
        <div class="content-header-left col-md-6 col-12 mb-2 breadcrumb-new">
          <h3 class="content-header-title mb-0 d-inline-block">OnBoard Application</h3>
          <div class="row breadcrumbs-top d-inline-block">
            <div class="breadcrumb-wrapper col-12">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/dashBoard">Dashboard</a>
                </li>
                
                <li class="breadcrumb-item active">OnBoard Applications
                </li>
              </ol>
            </div>
          </div>
        </div>
     
      </div>
      <div class="content-body">
        <!-- Basic Tables start -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
             
                <div class="heading-elements">
                  <ul class="list-inline mb-0">
                  
                    <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                    <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                 
                  </ul>
                </div>
              </div>
              <div class="card-content collapse show">
                
                <p class="px-1">
                
                <div class="table-responsive">
                  <table class="table mb-0">
                    <thead>
                      <tr>
                        <td>Name</td>
                        <td>
                        	<input type="text" name="name" value="Mutyalu"/>
                        </td>
                      </tr>
                      <tr>
                        <td>Name</td>
                        <td>
                        	<input type="text" name="name" value="Mutyalu"/>
                        </td>
                      </tr>
                      <tr>
                        <td>Name</td>
                        <td>
                        	<input type="text" name="name" value="Mutyalu"/>
                        </td>
                      </tr>
                      <tr>
                        <td>email</td>
                        <td>
                        	<input type="text" name="email" value="Mutyalu"/>
                        </td>
                      </tr>
                      <tr>
                        <td>Name</td>
                        <td>
                        	<input type="text" name="name" value="Mutyalu"/>
                        </td>
                      </tr>
                      <tr>
                        <td>Name</td>
                        <td>
                        	<input type="text" name="name" value="Mutyalu"/>
                        </td>
                      </tr>
                      <tr>
                      	<td colspan="1">
                      		<input type="button" value="Submit" />
                      	</td>
                      </tr>
                    </thead>
                    <tbody>
                    
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Basic Tables end -->

             
                 
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Responsive tables end -->
      </div>
    </div>
  </div>
  <!-- ////////////////////////////////////////////////////////////////////////////-->
  <!-- BEGIN VENDOR JS-->
  <script src="app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>

  <script src="app-assets/js/core/app-menu.js" type="text/javascript"></script>
  <script src="app-assets/js/core/app.js" type="text/javascript"></script>
  <script src="app-assets/js/scripts/customizer.js" type="text/javascript"></script>
  <script type="text/javascript">
  
  var formData = {
		    "mobile": "9014583389",
		    "email": "mutyam.38@gmail.com",
		    "company": "General Stores",
		    "name": "Mutyalu",
		    "pan": "BBBBB5733H",
		    "pincode": "535250",
		    "address": "test",
		    "otp": "839496"
		}; 
  var USERNAME = "user1";
  var PASSWORD = "user1Pass";
  $.ajax({
      url : "http://localhost:8080/rest/totalLoansCount",
      type: "GET",
      //data : formData,
      dataType: 'json',
      headers: {
    	 "Authorization": "Basic " + btoa(USERNAME + ":" + PASSWORD)
      },
      success: function(data, textStatus, jqXHR)
      {
          alert("Success Response >>"+data);
    	  //data - response from server
      },
      error: function (jqXHR, textStatus, errorThrown)
      {
    	  alert("Error Response >>"+jqXHR);
      }
  });
  

    $(document).ready(function () {

        //Disable full page

        /*$("body").on("contextmenu",function(e){

           // alert("right click functionality is disabled for this page.");

            return false;

        });*/        

    });

 </script>
 
 
 <script type="text/javascript">

    $(document).ready(function () {       

       //Disable cut copy paste

        /* $('body').bind('cut copy paste', function (e) {

            //alert("cut copy paste functionalities are disabled for this page.");

            e.preventDefault();

        });*/       

    });

 </script>
 
</body>
</html>
