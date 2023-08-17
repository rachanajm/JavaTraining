<%@page import="com.nttdatatraining.dao.OrderDAO"%>
<%@page import="com.nttdatatraining.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<div class="container">
	<%
	
	
		int cancid = Integer.parseInt(request.getParameter("OrderId"));
		OrderDAO odao4 = new OrderDAO();
		int qtycanci = odao4.getQantityFromOrdered(cancid);
		int orderpid = odao4.getProductId(cancid);
		
		int orderAvailableQty=odao4.getProductQty(orderpid);
		System.out.println("CancelledOrderid"+"\t"+"OrderedQantity"+"\t"+"OrderProductId"+"\t"+"ProductAvailableQty"+"\t"+"OrderedQantity+ProductAvailableQty");
		
		System.out.println(cancid+"\t"+qtycanci+"\t"+orderpid+"\t"+orderAvailableQty+"\t"+(orderAvailableQty+qtycanci));
		
		boolean isQtyUpdatedToProduct = odao4.updateProductQty(orderpid, orderAvailableQty+qtycanci);
		boolean upDatePriceOrder = odao4.updateAmount(cancid);   
		boolean upDateCancelDataOrder = odao4.updateCancel(cancid);
		boolean upDateAcceptedOrder = odao4.updateAccepted(cancid);
		boolean upDateOrderQtyOrder = odao4.updateOrderQty(cancid);
		boolean isOrderDenyedForProduct = odao4.denyOrder(cancid);
		if(isQtyUpdatedToProduct && upDatePriceOrder && upDateCancelDataOrder && upDateAcceptedOrder && upDateOrderQtyOrder && isOrderDenyedForProduct)
		{
			
	%>
	
			<p style="color:green">Order Unplaced Successfully and Quantity Updated Back to Product !!! </p>
			<jsp:include page="customercon11.jsp"></jsp:include>
	<% 
		}
		else 
		{
			
	%>
			<p style="color:green">Order cancellation failed !!! </p>
			<jsp:include page="customercon11.jsp"></jsp:include>
		<%
		
		}
	%>

</div>
</body>
</html>