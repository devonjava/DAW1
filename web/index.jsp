<%-- 
    Document   : index
    Created on : 22.05.2015, 17:47:15
    Author     : micx
--%>


<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="home.work.dto.ControlApp"%>
<%@page import="home.work.dto.Prod"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! private int count = 0; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Прайс лист v0.1. Date: <%=new java.util.Date()%></h1>
        <form name="form1" action="index.jsp">
            <input type="submit" value="Refresh page" name="SearchButtom" />
            
        
        <table border="2">
              <tr> 
                <td>Category</td>
                <td>Name</td>
                <td>Price</td>
                <td>Id</td>
            </tr>
            <%  
             try {
                    ControlApp app = new ControlApp();
                    List<Prod> resault = app.getAllProducts();                  
                    for(Prod product: resault) {
            %>                              
            <tr> 
                <td><%=product.getCat().getCatName() %> </td> 
                <td><%=product.getProdName() %> </td>
                <td><%=product.getPrice() %> </td>>
                <td><%=product.getProdId() %> </td>
                <!-- product.getCat().getCatName()); -->
            </tr>
            <%
                    } 
                 
                        
                } catch (Exception ex) {
                    out.println("Exception. Страница была показана " + ++count +" раз.");                
                    ex.printStackTrace();                 
                } 
              
             %>
           
        </table>
             </form>
    </body>
</html>
