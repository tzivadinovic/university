<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Izabrani fakultet/i</title>
    </head>
    <body>
          <%
            String ime = request.getParameter("name");
            out.print("<h2>Dobrodosli " + ime + ", izabrali ste da se upoznate sa sledecim fakultetima:</h2>");
            if(request.getParameter("fit") != null){
                out.print("<h3>Fakultet informacionih tehnologija </h3> <a href=\"http://www.metropolitan.ac.rs/osnovne-studije/fakultet-informacionih-tehnologija\">Posetite FIT</a>");
            }if(request.getParameter("fdu") != null){
                out.print("<h3>Fakultet digitalnih umetnosti </h3> <a href=\"http://www.metropolitan.ac.rs/fakultet-digitalnih-umetnosti-2\">Posetite FDU</a>");
            }if(request.getParameter("fam") != null){
                out.print("<h3>Fakultet za menadzment</h3> <a href=\"http://www.metropolitan.ac.rs/osnovne-studije/fakultet-za-menadzment\">Posetite FAM</a>");
            }if(request.getParameter("fit") == null && request.getParameter("fdu") == null && request.getParameter("fam") == null) {
              out.print("<h2>Niste nista izabrali</h2>");
            }
        %>
    </body>
</html>
