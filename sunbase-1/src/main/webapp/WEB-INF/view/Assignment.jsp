<%@page import="com.sunbase.CustomerClass.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.sunbase.CustomerClass.CustomerDao"%>
<%@page import="com.sunbase.CustomerClass.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
.hiddenCell {
            display: none;
        }
</style>
</head>
<body>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Address</th>
      <th scope="col">Street</th>
      <th scope="col">City</th>
      <th scope="col">State</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <% 
    ConnectionProvider provider =new ConnectionProvider();
    Connection con = provider.getConnection();
    CustomerDao dao = new CustomerDao(con);
    
    List<Customer> l = dao.getCustomers();
    for(Customer c:l)
    {%>
    <tr>
      <th scope="row"><%= c.getFirst_name() %></th>
      <td><%= c.getLast_name() %></td>
      <td><%= c.getAddress() %></td>
      <td><%= c.getCity() %></td>
      <td><%= c.getStreet()%></td>
      <td><%= c.getState() %></td>
      <td><%= c.getEmail()%></td>
      <td><%= c.getPhone()%></td>
      <td><button type="button" data-value=<%= c.getId() %> class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"><span class="fa fa-pencil" aria-hidden="true"></span></button>
      <br>
      <button type="button" data-value=<%= c.getId() %> class="btn btn-primary"><span class="fa fa-minus-circle" aria-hidden="true"></span></button></td> 
    </tr>
    <%}
    %>
  </tbody>
</table>

</body>
</html>