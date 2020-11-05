<nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-dark navbar-shadow">
    <div class="navbar-wrapper">
      <div class="navbar-header">
        <ul class="nav navbar-nav flex-row">
          <li class="nav-item mobile-menu d-md-none mr-auto"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu font-large-1"></i></a></li>
          <li class="nav-item mr-auto">
            <a class="navbar-brand" href="/dashboard">
        
              <h3 class="brand-text"><img src="app-assets/images/logo.png" height = "50px" width="50px"/>Insta Money</h3>
            </a>
          </li>
          
        </ul>
      </div>
      <div class="navbar-container content">
        <div class="collapse navbar-collapse" id="navbar-mobile">
          <ul class="nav navbar-nav mr-auto float-left">
            <li class="nav-item d-none d-md-block"><a class="nav-link nav-link-expand" href="#"><i class="ficon ft-maximize"></i></a></li>

           
          </ul>
          <ul class="nav navbar-nav float-right">
            <li class="dropdown dropdown-user nav-item">
              <a class="dropdown-toggle nav-link dropdown-user-link" href="#" data-toggle="dropdown">
                <span class="mr-1">Hello,
                  <span class="user-name text-bold-700">
                  	${LoginId}
                  </span>
                </span>
                <span class="avatar avatar-online">
                  <img src="app-assets/images/avatar-s-19.png" alt="avatar"><i></i></span>
              </a>
              <div class="dropdown-menu dropdown-menu-right"><a class="dropdown-item" href="change-password.php"><i class="ft-user"></i> Edit Profile</a>
                
                <div class="dropdown-divider"></div><a class="dropdown-item" href="/logout"><i class="ft-power"></i> Logout</a>
              </div>
            </li>

            <li class="dropdown dropdown-notification nav-item">
              <a class="nav-link nav-link-label" href="#" data-toggle="dropdown"><i class="ficon ft-bell"></i>
                <span class="badge badge-pill badge-default badge-danger badge-default badge-up badge-glow">
${totalNotificationcount}

                </span>
              </a>
              <ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
                <li class="dropdown-menu-header">
                  <h6 class="dropdown-header m-0">
                    <span class="grey darken-2">Notifications</span>
                  </h6>
                  <span class="notification-tag badge badge-default badge-danger float-right m-0">${totalNotificationcount}  New</span>
                </li>
                <li class="scrollable-container media-list w-100">
<?php 
 $isread=1;      
$sql ="SELECT beneficiary_name,PostingDate,id from loans where Is_Read!=:isread AND NearestAPGVBBank=:branch";
$query = $dbh -> prepare($sql);
$query-> bindParam(':isread', $isread, PDO::PARAM_STR);
$query-> bindParam(':branch', $branch, PDO::PARAM_STR);
$query->execute();
$results=$query->fetchAll(PDO::FETCH_OBJ);
$cnt=1;
if($query->rowCount() > 0):
foreach($results as $result):
  ?>

                  <a href="javascript:void(0)">
                    <div class="media">
                      <div class="media-left align-self-center"><i class="ft-plus-square icon-bg-circle bg-cyan"></i></div>
                      <div class="media-body">
                        <h6 class="media-heading">You have Application form</h6>
                        <p class="notification-text font-small-3 text-muted">
      <a href="contact-details.php?cid=<?php echo htmlentities($result->id);?>"><?php echo htmlentities($result->FullName);?></a></p>
                        <small>
                          <time class="media-meta text-muted" datetime="2015-06-11T18:29:20+08:00"><?php echo htmlentities($result->PostingDate);?></time>
                        </small>
                      </div>
                    </div>
                  </a>
         
                       <?php
                  
endforeach;
else: ?>

                    <div class="media">
                      <div class="media-left align-self-center"><i class="ft-alert-triangle icon-bg-circle bg-yellow bg-darken-3"></i></div>
                      <div class="media-body">
                        <h6 class="media-heading yellow darken-3">No Notification</h6>
                    
                        
                      </div>
                    </div>
               
<?php  

endif;
  ?>
              
                </li>
           
              </ul>
            </li>
     
          </ul>
        </div>
      </div>
    </div>
  </nav>