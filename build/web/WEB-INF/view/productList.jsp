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
        <h1>Product list page</h1>
        <form name="form1" action="productList.jsp">
            <input type="submit" value="refresh" name="Refresh">
        <table border="2">
              <tr> 
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <%  
             try {
                    ControlApp app = new ControlApp();
                    List<Prod> resault = null;
                    resault = app.getAllProducts();                  
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
                 
                        
                } catch (NullPointerException ex) {
                    %><br><%
                    //out.println("Exception. Страница была показана " + ++count +" раз.");   
                    out.println("Exception:[" + ex + "]");
                    ex.printStackTrace();                 
                } 
              
             %>
           
        </table>
             </form>
    </body>
</html>
