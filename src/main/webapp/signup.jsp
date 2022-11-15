
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup Page</title>
        <%@include file="all_component/all_css.jsp"%>
    </head>
    <body style="background-color: #f0f1f2;">
        <%@include file="all_component/navbar.jsp"%>
        
         <div class="continer-fluid">
               <div class="row p-4">
                   <div class="col-md-4 offset-md-4">
                       <div class="card">
                           <div class="card-body">
                               <div class="text-center">
                                   <i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
                                   
                                   <h5>Registration</h5>
                           </div>
                           
                            <c:if test="${not empty succMsg }">
                                <h4 class="text-center text-dange">${succMsg }</h4>
                                <c:remove var="succMsg" />
                           </c:if> 
                           
                           <form action="add_user" method="post">    
                               <div class="form-group">
                                   <label>Enter Full Name</label> <input type="text"
                                       required="required" class="form-control"
                                       id="exampleInputEmail1" aria-describedby="emailHelp"
                                       name="name">
                               </div>
                               
                               <div class="form-group">
                                   <label>Enter Qualification</label> <input type="text"
                                       required="required" class="form-control"
                                       id="exampleInputEmail1" aria-describedby="emailHelp" name="qua">
                               </div>
                               <div class="form-group">
                                   <label>Enter Email</label> <input type="email"
                                       required="required" class="form-control"
                                       id="exampleInputEmail1" aria-describedby="emailHelp"
                                       name="email">
                               </div>
                               <div class="form-group">
                                   <label for=exampleInputPassword1>Enter Password</label> <input
                                       required="required" type="password" class="form-control"
                                       id="exampleInputPassword1" name="ps">
                               </div>
                               
                               <button type="submit"
                                       class="btn btn-primary badge-pill btn-block">Register</button>
                           </form>
                     </div>
               </div>
          </div>
      </div>
   </div>
                           
    </body>
</html>
