<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


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
  <%@ include file="header.jsp" %>  
  <!-- ////////////////////////////////////////////////////////////////////////////-->
 <%@ include file="leftbar.jsp" %>
 
  <div class="app-content content">
    <div class="content-wrapper">
      <div class="content-header row">
        <div class="content-header-left col-md-6 col-12 mb-2 breadcrumb-new">
          <h3 class="content-header-title mb-0 d-inline-block">Today's Applications</h3>
          <div class="row breadcrumbs-top d-inline-block">
            <div class="breadcrumb-wrapper col-12">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/dashBoard">Dashboard</a>
                </li>
                
                <li class="breadcrumb-item active">Today's Applications
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
                        <th>#</th>
                        <th>Unique ID</th>
                        <th>Beneficiary Name</th>
                        <th>Occupation</th>
                        <th>Tenure Period</th>
                        <th>Loan Status</th>
                        <th>Status</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                    
               <c:forEach var="loan" items="${resultList}" varStatus="loop">
					    <tr>
		                  <th scope="row">${loop.index+1}</th>
		                  <td>${loan.uniqueId}</td>
		                  <td>${loan.beneficiary_name}</td>
		                  <td>${loan.beneficiary_lineofactivity}</td>
		                  <td>${loan.beneficiary_tenor}</td>

						<td>
							<c:choose>
							    <c:when test="${loan.status=='1'}">
							        InProgress 
							    </c:when>    
							    <c:when test="${loan.status=='2'}">
							        Accepted 
							    </c:when>    
							    <c:when test="${loan.status=='3'}">
							        Rejected 
							    </c:when>    
							    <c:otherwise>
							        Submited 
							    </c:otherwise>
							</c:choose>
						
						</td>
						<td>
							<c:choose>
							    <c:when test="${loan.is_Read!=1}">
							        Unread 
							    </c:when>    
							    <c:otherwise>
							        Read 
							    </c:otherwise>
							</c:choose>
						</td>
	                  <td>
	                  	<a href="contact-details.php?cid=<?php echo htmlentities($result->id);?>"><button type="button" class="btn btn-info btn-min-width btn-glow mr-1 mb-1">View Details</button>
	                  </td>
                      </tr>
                      </c:forEach>
                      <c:if test="${resultList.isEmpty()}">
						<tr>
							<td colspan="5" style="color:red; font-size:22px;" align="center">No Record found</td>
						</tr>
						                      
                      </c:if>
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
<%@ include file="footer.jsp" %>
  <!-- BEGIN VENDOR JS-->
  <script src="app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>

  <script src="app-assets/js/core/app-menu.js" type="text/javascript"></script>
  <script src="app-assets/js/core/app.js" type="text/javascript"></script>
  <script src="app-assets/js/scripts/customizer.js" type="text/javascript"></script>
  <script type="text/javascript">

    $(document).ready(function () {

        //Disable full page

        $("body").on("contextmenu",function(e){

           // alert("right click functionality is disabled for this page.");

            return false;

        });        

    });

 </script>
 
 
 <script type="text/javascript">

    $(document).ready(function () {       

       //Disable cut copy paste

        $('body').bind('cut copy paste', function (e) {

            //alert("cut copy paste functionalities are disabled for this page.");

            e.preventDefault();

        });       

    });

 </script>
 
</body>
</html>
