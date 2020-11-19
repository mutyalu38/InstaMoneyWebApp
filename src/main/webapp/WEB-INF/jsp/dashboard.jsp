<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
  <title> Insta Money |</title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Quicksand:300,400,500,700"
  rel="stylesheet">
  <link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css"
  rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="app-assets/css/vendors.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/app.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/core/menu/menu-types/vertical-menu-modern.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/core/colors/palette-gradient.css">
  <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/charts/jquery-jvectormap-2.0.3.css">
  <link rel="stylesheet" type="text/css" href="app-assets/vendors/css/charts/morris.css">
  <link rel="stylesheet" type="text/css" href="app-assets/fonts/simple-line-icons/style.css">
  <link rel="stylesheet" type="text/css" href="app-assets/css/core/colors/palette-gradient.css">
  <link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>
<body class="vertical-layout vertical-menu-modern 2-columns   menu-expanded fixed-navbar"
data-open="click" data-menu="vertical-menu-modern" data-col="2-columns">
  <!-- fixed-top-->
  <%@ include file="header.jsp" %>  
  <!-- ////////////////////////////////////////////////////////////////////////////-->
 <%@ include file="leftbar.jsp" %>
  <div class="app-content content">
    <div class="content-wrapper">
      <div class="content-header row">
      </div>
      <div class="content-body">
        <!-- Revenue, Hit Rate & Deals -->
        <div class="row">
          <div class="col-xl-4 col-lg-6 col-12">
            <div class="card pull-up">
              <div class="card-content">
                   <a href="/onboard">
                <div class="card-body">
                  <div class="media d-flex">
                    <div class="media-body text-left">
 <h3 class="info">${todayscount}</h3>
                      <h6>Todays Loan Applications</h6>
                    </div>
                    <div>
         <i class="icon-user-follow success font-large-2 float-right"></i>
                    </div>
                  </div>
                  <div class="progress progress-sm mt-1 mb-0 box-shadow-2">
                    <div class="progress-bar bg-gradient-x-info" role="progressbar" style="width: 100%"
                    aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                  </div>
                </div>
              </a>
              </div>
            </div>
          </div>

     <!-- Last Seven Days Complaints --->
    
          <div class="col-xl-4 col-lg-6 col-12">
            <div class="card pull-up">
              <div class="card-content">
                <a href="last-sevendays-contacts.php">
                <div class="card-body">
                  <div class="media d-flex">
                    <div class="media-body text-left">
 <h3 class="warning">${last7dayscount}</h3>
                      <h6>Last 7 Days Loan Applications</h6>
                    </div>
                    <div>
    <i class="icon-user-follow success font-large-2 float-right"></i>
                    </div>
                  </div>
                  <div class="progress progress-sm mt-1 mb-0 box-shadow-2">
                    <div class="progress-bar bg-gradient-x-warning" role="progressbar" style="width: 100%"
                    aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                  </div>
                </div>
                </a>
              </div>
            </div>
          </div>

          <div class="col-xl-4 col-lg-6 col-12">
            <div class="card pull-up">
              <div class="card-content">
                 <a href="all-contacts.php">
                <div class="card-body">
                  <div class="media d-flex">
                    <div class="media-body text-left">

<h3 class="success">${allcount}</h3>
                      <h6>Total Loan Applications</h6>
                    </div>
                    <div>
                      <i class="icon-user-follow success font-large-2 float-right"></i>
                    </div>
                  </div>
                  <div class="progress progress-sm mt-1 mb-0 box-shadow-2">
                    <div class="progress-bar bg-gradient-x-success" role="progressbar" style="width: 100%"
                    aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                  </div>
                </div>
              </a>
              </div>
            </div>
          </div>
          
          </div>

        
        </div>
      </div>
    </div>
    




          
          
       




    



<%@ include file="footer.jsp" %>
       

  <!-- BEGIN VENDOR JS-->

  <script>
    $(function()
{

    function timeChecker()
    {
        setInterval(function()
        {
            var storedTimeStamp = sessionStorage.getItem("lastTimeStamp");  
            timeCompare(storedTimeStamp);
        },3000);
    }


    function timeCompare(timeString)
    {
        var maxMinutes  = 1;  //GREATER THEN 1 MIN.
        var currentTime = new Date();
        var pastTime    = new Date(timeString);
        var timeDiff    = currentTime - pastTime;
        var minPast     = Math.floor( (timeDiff/60000) ); 

        if( minPast > maxMinutes)
        {
            sessionStorage.removeItem("lastTimeStamp");
            window.location = "logout.php";
            return false;
        }else
        {
            //JUST ADDED AS A VISUAL CONFIRMATION
            console.log(currentTime +" - "+ pastTime+" - "+minPast+" min past");
        }
    }

    if(typeof(Storage) !== "undefined") 
    {
        $(document).mousemove(function()
        {
            var timeStamp = new Date();
            sessionStorage.setItem("lastTimeStamp",timeStamp);
        });

        timeChecker();
    }  
});//END JQUERY
  </script>
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
  <script src="app-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
  <!-- BEGIN VENDOR JS-->
  <!-- BEGIN PAGE VENDOR JS-->
  <script src="app-assets/vendors/js/charts/chart.min.js" type="text/javascript"></script>
  <script src="app-assets/vendors/js/charts/raphael-min.js" type="text/javascript"></script>
  <script src="app-assets/vendors/js/charts/morris.min.js" type="text/javascript"></script>
  <script src="app-assets/vendors/js/charts/jvector/jquery-jvectormap-2.0.3.min.js"
  type="text/javascript"></script>
  <script src="app-assets/vendors/js/charts/jvector/jquery-jvectormap-world-mill.js"
  type="text/javascript"></script>
  <script src="app-assets/data/jvector/visitor-data.js" type="text/javascript"></script>
  <!-- END PAGE VENDOR JS-->
  <!-- BEGIN MODERN JS-->
  <script src="app-assets/js/core/app-menu.js" type="text/javascript"></script>
  <script src="app-assets/js/core/app.js" type="text/javascript"></script>
  <script src="app-assets/js/scripts/customizer.js" type="text/javascript"></script>
  <!-- END MODERN JS-->
  <!-- BEGIN PAGE LEVEL JS-->
  <script src="app-assets/js/scripts/pages/dashboard-sales.js" type="text/javascript"></script>
  <!-- END PAGE LEVEL JS-->
  
<!--BEGIN PAGE PIE CHARTS-->
 <title>Webslesson Tutorial | Make Simple Pie Chart by Google Chart API with PHP Mysql</title>  
           <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>  
          <?php 
$sql = "SELECT NearestAPGVBBank, count(NearestAPGVBBank) as number FROM loans GROUP BY NearestAPGVBBank";
$fire = mysqli_query($con,$sql);
$mergeArr = array(
  array("Task1","Houers per day")
);

while ($chartresult = mysqli_fetch_assoc($fire)) {

$tempArr = array(
array($chartresult[NearestAPGVBBank],intval($chartresult[number]))
);

$mergeArr = array_merge($mergeArr,$tempArr);

//  echo "['".$chartresult[NearestAPGVBBank]."',".$chartresult[number]."]";
  # code...
}


echo "".$mergeArr."";




          ?>

           <script type="text/javascript"> 

var arrayData = <?php echo json_encode($mergeArr); ?>;
//document.write(arrayData1); 

 

          //   var arrayData =[]; 
          //        arrayData.push(["Task", "Houers pr Day"]);
          //        arrayData.push(["Work", 11]);
          //        arrayData.push(["Eat", 2]);
          //        arrayData.push(["Commute", 3]);
          //        arrayData.push(["Watch TV", 2]);
          //       arrayData.push(["Sleep", 7]); 
          // document.write("2>>"+arrayData);
           google.charts.load('current', {'packages':['corechart']});  
           google.charts.setOnLoadCallback(drawChart);  
           function drawChart()  
           {  
                // var data = google.visualization.arrayToDataTable([  
                //           ['NearestAPGVBBank', 'Number'],  
                //           <?php  

                //           while($row = mysqli_fetch_array($result))  
                //           {  
                //                echo "['".$row["NearestAPGVBBank"]."', ".$row["number"]."],";  
                //           }  
                //           ?>  
                //      ]);  
                

                // var data = google.visualization.arrayToDataTable(arrayData);


                var data = google.visualization.arrayToDataTable(arrayData);
                var options = {  
                      title: 'Loans Applications',  
                      //is3D:true,  
                      pieHole: 0.4  
                     };  
                var chart = new google.visualization.PieChart(document.getElementById('piechart'));  
                chart.draw(data, options);  
           }  
           </script>
           <!--ENDING PIE CHART-->
           
           <br /><br />  
           <div style="width:900px;">  
                <h3 align="center">Make Simple Pie Chart by Google Chart API with PHP Mysql</h3>  
                <br />  
                <div id="piechart" style="width: 900px; height: 500px;"></div> 

               
           </div>
</body>
</html>
<?php endif;?>