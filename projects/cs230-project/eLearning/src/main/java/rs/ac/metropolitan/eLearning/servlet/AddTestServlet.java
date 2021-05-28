package rs.ac.metropolitan.eLearning.servlet;

import rs.ac.metropolitan.eLearning.database.dao.QuestionDAO;
import rs.ac.metropolitan.eLearning.database.dao.TestDAO;
import rs.ac.metropolitan.eLearning.database.dao.UserDAO;
import rs.ac.metropolitan.eLearning.entity.Question;
import rs.ac.metropolitan.eLearning.entity.Test;
import rs.ac.metropolitan.eLearning.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/add-test")
public class AddTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = new Test();
        test.setTitle(req.getParameter("title"));
        test.setMaxPoints(Double.parseDouble(req.getParameter("maxPoints")));
        test.setDateTime(req.getParameter("dateTime"));

        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> questionList = Arrays.stream(req.getParameterValues(("questions")))
                .map(Integer::parseInt)
                .map(questionDAO::find)
                .collect(Collectors.toList());

        UserDAO userDAO = new UserDAO();
        List<User> users = Arrays.stream(req.getParameterValues(("users")))
                .map(Integer::parseInt)
                .map(userDAO::find)
                .collect(Collectors.toList());

        test.setQuestions(questionList);
        test.setUsers(users);

        TestDAO testDAO = new TestDAO();
        testDAO.create(test);

        req.getRequestDispatcher("/tests.jsp").forward(req, resp);
    }
}
