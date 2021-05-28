package rs.ac.metropolitan.eLearning.servlet;

import rs.ac.metropolitan.eLearning.database.dao.RoleDAO;
import rs.ac.metropolitan.eLearning.database.dao.UserDAO;
import rs.ac.metropolitan.eLearning.entity.Role;
import rs.ac.metropolitan.eLearning.entity.User;
import rs.ac.metropolitan.eLearning.util.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/edit-user")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = UrlUtil.getUrlBase(req.getRequestURL().toString());
        int userId;

        try {
            userId = Integer.parseInt(userIdStr);
        } catch (NumberFormatException ex) {
            resp.sendRedirect(req.getContextPath() + "/users.jsp");
            return;
        }

        User user = new UserDAO().find(userId);
        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/edit-user-form.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/edit-user-form.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        UserDAO userDAO = new UserDAO();

        User user = userDAO.findByUsername(username);

        user.setEmail(email);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);


        RoleDAO roleDAO = new RoleDAO();
        List<Role> roles = Arrays.stream(req.getParameterValues(("roles")))
                .map(Integer::parseInt)
                .map(roleDAO::find)
                .collect(Collectors.toList());

        user.setRoles(roles);

        userDAO.update(user);

        req.getRequestDispatcher("/users.jsp").forward(req, resp);

    }
}
