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
<%@page import="home.work.dto.Cat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! private int count = 0; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
       
        <h1>Прайс лист v0.2 <br>Date: <%=new java.util.Date()%></h1>
        
        <form name="header" action="index.jsp" method="post">
           <table border="0">     
              <tr> 
                <td>Категория</td>
                <td>Наименование</td>
                <td>Цена от:</td>
                <td>Цена до:</td>>
                <td><input type="reset" value="Обновить" name="Update" ></td>
             </tr>   
             <tr>
                <td>               
                    <!-- Select product type -->
                    <input type="search" name="catModel" value="" size="20"  >
                    <select name="selectCatalog" >  
                        
                        <option > All </option>
                        <option>1</option>
                        
                    </select>  
                </td>
                <td> 
                    <!-- Input product model -->
                     <input type="search" name="prodModel" value="" size="20"  >
                </td>
                <td>
                    <!-- Input price start -->
                    <input type="search" name="priceStart" value="" size="20"  >
                </td>
                <td>
                    <!-- Input price end -->
                    <input type="search" name="priceEnd" value="" size="20"  >
                </td>
                >  <td><input type="submit" value="Найти" name="SearchButtom" ></td> 
            </tr>
            <tr>
                <td>Категория</td>
                <td>Наименовани</td>
                <td>Цена</td>
            </tr>
            <% /* 
             try {
                    ControlApp app = new ControlApp();
                    List<Prod> resault = app.getAllProducts();                  
                    for(Prod product: resault) {
                    */
            %>   
              <!--
            <tr> 
                <td><%//=product.getCat().getCatName() %> </td> 
                <td><%//=product.getProdName() %> </td>
                <td><%//=product.getPrice() %> </td>>
                <td><%//=product.getProdId() %> </td>
                 product.getCat().getCatName()); 
            </tr> -->
            <%
                                /*
                    } 
                 
                        
                } catch (NullPointerException ex) {
                   
                    //out.println("Exception. Страница была показана " + ++count +" раз.");   
                    out.println("Exception:[" + ex + "]");
                    ex.printStackTrace();                 
                } 
              */
             %>
               <form name="getProductList" action="productList.jsp">
                   <%//  <jsp:include page="productList.jsp"/> %>
                 
           
        </form>
         </table>   
            </form>
       
        
        
    </body>
</html>
