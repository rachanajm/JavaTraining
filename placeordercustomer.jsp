<%@page import="com.nttdatatraining.dao.OrderDAO"%>
<%@page import="com.nttdatatraining.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<body>
<div class="container">
	<%
		//String cid = request.getParameter("cid");
	  	String cid = null;
   		 if(!session.isNew() || session.getAttribute("USERID") != null)
    	{
    	 cid = (String) session.getAttribute("USERID");
   		 }
		int pid = Integer.parseInt(request.getParameter("pid"));
		int orderuni = Integer.parseInt(request.getParameter("orderedunits"));
		
		OrderDAO odao1 = new OrderDAO(); 	//creating object of orderDAO class.
		Order od1 = new Order();
		int price=0;
		int amt=0;
		boolean b4 = odao1.checkQuantity(orderuni,pid); 
		if(b4) {
		//	od1.setOrderedunits(orderedunits);
			price=odao1.getPriceFromProduct(pid);  //Getting  price from product table.
			
			//od1.setPrice(price * qty);	
			amt = price * orderuni;//Inserting Amount for each Order
		}
		else {
%>
			<p style="color:red">Order placed failed Due quantity greater then product quantity !!! </p>
			<jsp:include page="customercon11.jsp"></jsp:include>
<% 			
		}
		int amount=amt;
		String address=request.getParameter("address");
		String requesteddate=request.getParameter("requesteddate");
		
	%>	
	
	<jsp:useBean id="order" class="com.nttdatatraining.dto.Order">
		<jsp:setProperty property="custid" value="<%=cid %>" name="order"></jsp:setProperty>
		<jsp:setProperty property="productid" value="<%=pid %>" name="order"></jsp:setProperty>
		<jsp:setProperty property="orderedunits" value="<%=orderuni %>" name="order"></jsp:setProperty>
		
		<jsp:setProperty property="price" value="<%=amount %>" name="order"></jsp:setProperty>
		
		<jsp:setProperty property="address" value="<%=address %>" name="order"></jsp:setProperty>
		<jsp:setProperty property="requesteddate" value="<%=requesteddate %>" name="order"></jsp:setProperty>	
	</jsp:useBean>
	
	
<%

		OrderDAO orderDao = new OrderDAO();
		//Order ord = new Order();
		int availableQty=odao1.getProductQty(pid);
		//boolean isQtyUpdated = odao1.updateProductQty(pid, availableQty-orderuni); //Updating Quantity to product table
		
	if(b4)
	{
		orderDao.addNewOrder(order);
%>
	<p style="color:green">Order placed successfully !!! </p>
	<jsp:include page="customercon11.jsp"></jsp:include>
		

<%
	}
	else
	{
%>
		<p style="color:red">Order placed failed !!! </p>
		<jsp:include page="customercon11.jsp"></jsp:include>

		<%--<jsp:forward page="Delete_Failure.jsp"></jsp:forward> --%>
<% 	
	}
%>
</div>

 <br><br>
 <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">

            <div class="block-7">
              <h3 class="footer-heading mb-4">About Us</h3>
              <p>We are the best pharmacy store available online.</p>
            </div>

          </div>
          <div class="col-lg-3 mx-auto mb-5 mb-lg-0">
            <h3 class="footer-heading mb-4">Why Us?</h3>
            <p>Rated best by the great experts around the corner and whole globe.</p>
          </div>

          <div class="col-md-6 col-lg-3">
            <div class="block-5 mb-5">
              <h3 class="footer-heading mb-4">Contact Info</h3>
              <ul class="list-unstyled">
                <li class="address">222, Kengeri, Bangalore, Karnataka</li>
                <li class="phone"><a href="tel://23923929210">+2 392 3929 210</a></li>
                <li class="email">emailaddress@domain.com</li>
              </ul>
            </div>


          </div>
        </div>

        </div>
      </div>
    </footer>
  </div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>
</body>
</html>