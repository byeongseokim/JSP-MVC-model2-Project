<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set  var="articlesList"  value="${articlesMap.articlesList}" />
<c:set  var="totArticles"  value="${articlesMap.totArticles}" />
<c:set  var="section"  value="${articlesMap.section}" />
<c:set  var="pageNum"  value="${articlesMap.pageNum}" />

<%
  request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
 <style>
   .no-uline {text-decoration:none;}
   .sel-page{text-decoration:none;color:red;}
   .cls1 {text-decoration:none;}
   .cls2{text-align:center; font-size:30px;}
  </style>
  <meta charset="UTF-8">
  <title>글목록창</title>
</head>
<body>
<table align="center" border="1"  width="80%"  >
  <tr height="10" align="center"  bgcolor="lightgreen">
     <td >글번호</td>
     <td >작성자</td>              
     <td >제목</td>
     <td >작성일</td>
  </tr>
<c:choose>
  <c:when test="${articlesList ==null }" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
  </c:when>
  <c:when test="${articlesList !=null }" >
    <c:forEach  var="article" items="${articlesList }" varStatus="articleNum" >
     <tr align="center">
	<td width="5%">${articleNum.count}</td>
	<td width="10%">${article.id }</td>
	<td align='left'  width="35%">
	    <span style="padding-right:30px"></span>    
	   <c:choose>
	      <c:when test='${article.level > 1 }'>  
	         <c:forEach begin="1" end="${article.level }" step="1">
	             <span style="padding-left:10px"></span> 
	         </c:forEach>
	         <span style="font-size:12px;">[답변]</span>
                   <a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
	          </c:when>
	          <c:otherwise>
	            <a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title }</a>
	          </c:otherwise>
	        </c:choose>
	  </td>
	  <td  width="10%"><fmt:formatDate value="${article.writeDate}" /></td> 
	</tr>
    </c:forEach>
     </c:when>
    </c:choose>
</table>

<div class="cls2">
 <c:if test="${totArticles != null }" >
      <c:choose>
        <c:when test="${totArticles > 10 }"> 
          <c:if test="${section > 1 }">
            <a class="no-uline" href="${contextPath }/board/listArticles.do?section=${section - 1}&pageNum=${(section - 1) * 10 + 1}">  Previous </a>
          </c:if>
          <c:forEach var="page" begin="${section*10-9}" end="${section*10}" step="1">
            <c:if test="${page == pageNum}">
              <a class="sel-page" href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${page } </a>
            </c:if>
            <c:if test="${page != pageNum}">
              <a class="no-uline" href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${page } </a>
            </c:if>
          </c:forEach>
          <c:if test="${section * 10 < totArticles }">
            <a class="no-uline" href="${contextPath }/board/listArticles.do?section=${section + 1}&pageNum=${section * 10 + 1}">  Next</a>
          </c:if>
        </c:when>
        <c:otherwise>
          <c:forEach var="page" begin="1" end="10" step="1">
            <c:if test="${page == pageNum}">
              <a class="sel-page" href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${page } </a>
            </c:if>
            <c:if test="${page != pageNum}">
              <a class="no-uline" href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${page } </a>
            </c:if>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </c:if>
</div>    
<br><br>
<a  class="cls1"  href="${contextPath}/board/articleForm.do"><p class="cls2">글쓰기</p></a>
</body>
</html>
