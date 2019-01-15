<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/catsAddServlet" method="POST" target="_blank">
    NAME
    <input type="text" name="name"/><br>
    RACE
      <input type="text" name="race"/><br>
    OWNER
        <input type="text" name="owner"/>
    <input type="submit" value="Post"/>
</form>