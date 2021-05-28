package rs.ac.metropolitan.eLearning.servlet;

import rs.ac.metropolitan.eLearning.database.dao.QuestionDAO;
import rs.ac.metropolitan.eLearning.database.dao.TestDAO;
import rs.ac.metropolitan.eLearning.database.dao.UserDAO;
import rs.ac.metropolitan.eLearning.entity.Question;
import rs.ac.metropolitan.eLearning.entity.Test;
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

@WebServlet(urlPatterns = "/edit-test")
public class EditTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String testIdStr = UrlUtil.getUrlBase(req.getRequestURL().toString());
        int testId;

        try {
            testId = Integer.parseInt(testIdStr);
        } catch (NumberFormatException ex) {
            resp.sendRedirect(req.getContextPath() + "/tests.jsp");
            return;
        }

        Test test = new TestDAO().find(testId);
        if (test != null) {
            req.setAttribute("test", test);
            req.getRequestDispatcher("/edit-test-form.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String dateTime = req.getParameter("dateTime");
        Double maxPoints = Double.parseDouble(req.getParameter("maxPoints"));

        TestDAO testDAO = new TestDAO();

        String testIdStr = req.getParameter("id");
        int testId = Integer.parseInt(testIdStr);
        Test test = testDAO.find(testId);

        test.setTitle(title);
        test.setDateTime(dateTime);
        test.setMaxPoints(maxPoints);

        QuestionDAO questionDAO = new QuestionDAO();
        String[] questionArr = req.getParameterValues(("questions"));
        if (questionArr == null) questionArr = new String[]{};
        List<Question> questionList = Arrays.stream(questionArr)
                .map(Integer::parseInt)
                .map(questionDAO::find)
                .collect(Collectors.toList());

        test.setQuestions(questionList);

        UserDAO userDAO = new UserDAO();
        String[] userArr = req.getParameterValues(("users"));
        if (userArr == null) userArr = new String[]{};
        List<User> users = Arrays.stream(userArr)
                .map(Integer::parseInt)
                .map(userDAO::find)
                .collect(Collectors.toList());

        test.setUsers(users);

        testDAO.update(test);

        req.getRequestDispatcher("/tests.jsp").forward(req, resp);
    }
}
