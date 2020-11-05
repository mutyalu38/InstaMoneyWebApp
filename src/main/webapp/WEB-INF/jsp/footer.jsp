<script type="text/javascript">

    $(document).ready(function () {

        //Disable full page

        $("body").on("contextmenu",function(e){

            alert("right click functionality is disabled for this page.");

            return false;

        });        

    });

 </script>
 
 
 <script type="text/javascript">

    $(document).ready(function () {       

       //Disable cut copy paste

        $('body').bind('cut copy paste', function (e) {

            alert("cut copy paste functionalities are disabled for this page.");

            e.preventDefault();

        });       

    });

 </script>







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

  <footer class="footer footer-static footer-light navbar-border navbar-shadow">
    <p class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2">
    	
      <span class="float-md-left d-block d-md-inline-block">GramTarang Inclusive Development Services (GTIDS), Visakhapatanam. All Rights Reserved Copyright.  &copy; 2020 <a class="text-bold-800 grey darken-2" href="https://gramtarang.org" target="_blank"> Designed, Developed and maintained by IT Team, GTIDS

</a></span>
      <span class="float-md-right d-block d-md-inline-blockd-none d-lg-block"></i></span>
    </p>
  </footer>