package rs.ac.metropolitan.eLearning.servlet;

import rs.ac.metropolitan.eLearning.database.dao.RoleDAO;
import rs.ac.metropolitan.eLearning.database.dao.UserDAO;
import rs.ac.metropolitan.eLearning.entity.Role;
import rs.ac.metropolitan.eLearning.entity.User;
import rs.ac.metropolitan.eLearning.security.Security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/add-user")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(Security.hash(req.getParameter("password")));
        user.setEmail(req.getParameter("email"));


        RoleDAO roleDAO = new RoleDAO();
        List<Role> roles = Arrays.stream(req.getParameterValues(("roles")))
                .map(Integer::parseInt)
                .map(roleDAO::find)
                .collect(Collectors.toList());

        user.setRoles(roles);

        UserDAO userDAO = new UserDAO();
        userDAO.create(user);

        req.getRequestDispatcher("/users.jsp").forward(req, resp);

    }
}
