<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="products">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="filters">
              <ul>
                  <li>All Products</li>
                  <c:forEach items="${listCategories }" var="item"> 
                  		<a href="${pageContext.request.contextPath }/CategoryServlet?id=${item.idCategorys}"><li>${item.name }</li></a>
                  </c:forEach>
              </ul>
            </div>
          </div>
          <div class="col-md-12">
            <div class="filters-content">
                <div class="row grid">
                    <c:forEach items="${listProducts }" var="item">
                    	<div class="col-lg-4 col-md-4 all gra">
	                      <div class="product-item">
	                      <div class="col-2 mt-2" style="background-color: red; color: white;">-${item.discount.percent }%</div>	
	                        <a href="DetailServlet?id=${item.idProducts }"><img src="${item.image }" alt=""></a>
	                        <div class="down-content">
	                          <a href="href="DetailServlet?id=${item.idProducts }""><h4>${item.name }</h4></a>
	                          <h6><strike>${item.price }</strike></h6>	
	                          <h5 style="margin-left: 220px; color: red">${item.price * (100 - item.discount.percent)/100 }</h5>
	                          <p>${item.description }</p>
	                          <a href="AddCartServlet?id=${item.idProducts }" class="btn btn-primary ${item.active == false ? 'disabled' : '' }">Add to Cart</a>
	                          <span>Views (${item.view })</span>
	                        </div>
	                      </div>
	                    </div>
                    </c:forEach>                   
                </div>
            </div>
          </div>
          <div class="col-md-12">
            <ul class="pages">
              <c:forEach begin="1" end="${pageCount }" var="i">
              		<li class="${i == index ? 'active' : '' }"><a href="${pageContext.request.contextPath }/ProductServlet?page=${i }">${i}</a></li>
              </c:forEach>
            </ul>
          </div>
        </div>
      </div>
    </div>
