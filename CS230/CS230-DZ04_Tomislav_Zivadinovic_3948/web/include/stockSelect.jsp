<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="stocksBean" scope="request" class="beans.stocks.StocksBean"/>
<div class="row">
    <div class="col s3"></div>
    <div class="col s6">
        <h4>Stocks</h4>
        <form action="<%=request.getContextPath()%>/stocks.jsp" method="post">
            <div class="row">
                <div class="input-field col s9">
                    <select name="stocks">
                        <option value="" disabled selected>Choose company</option>
                        <c:forEach items="${stocksBean.stocks}" var="stock">
                            <option value="${stock.stockName}">${stock.name} (${stock.stockName})</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-field col s3">
                    <input placeholder="No. of" value="0" id="count" type="number" name="count" class="validate">
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <input type="submit" value="Submit" class="btn" id="button1">
                </div>
            </div>
            <script>
                document.addEventListener('DOMContentLoaded', () => M.FormSelect.init(document.querySelectorAll('select'), {}));
            </script>
        </form>
    </div>
</div>