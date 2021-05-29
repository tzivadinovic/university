package rs.ac.metropolitan.eLearning.servlet;

import rs.ac.metropolitan.eLearning.database.dao.QuestionDAO;
import rs.ac.metropolitan.eLearning.entity.Answer;
import rs.ac.metropolitan.eLearning.entity.Question;
import rs.ac.metropolitan.eLearning.util.UrlUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/edit-question")
public class EditQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionIdStr = UrlUtil.getUrlBase(req.getRequestURL().toString());
        int questionId;

        try {
            questionId = Integer.parseInt(questionIdStr);
        } catch (NumberFormatException ex) {
            resp.sendRedirect(req.getContextPath() + "/question.jsp");
            return;
        }

        Question question = new QuestionDAO().find(questionId);
        if (question != null) {
            req.setAttribute("question", question);
            req.getRequestDispatcher("/edit-question-form.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/edit-question-form.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question question = new QuestionDAO().find(Integer.parseInt(req.getParameter("id")));
        question.setText(req.getParameter("text"));
        question.setPoints(Double.parseDouble(req.getParameter("points")));

        String answer1text = req.getParameter("answer1text");
        boolean answer1correct = req.getParameter("answer1correct") != null && req.getParameter("answer1correct").equals("on");
        String answer2text = req.getParameter("answer2text");
        boolean answer2correct = req.getParameter("answer2correct") != null && req.getParameter("answer2correct").equals("on");
        String answer3text = req.getParameter("answer3text");
        boolean answer3correct = req.getParameter("answer3correct") != null && req.getParameter("answer3correct").equals("on");
        String answer4text = req.getParameter("answer4text");
        boolean answer4correct = req.getParameter("answer4correct") != null && req.getParameter("answer4correct").equals("on");

        Answer answer1 = new Answer(question, answer1text, answer1correct);
        Answer answer2 = new Answer(question, answer2text, answer2correct);
        Answer answer3 = new Answer(question, answer3text, answer3correct);
        Answer answer4 = new Answer(question, answer4text, answer4correct);

        question.setAnswers(Arrays.asList(answer1, answer2, answer3, answer4));

        QuestionDAO questionDAO = new QuestionDAO();
        questionDAO.update(question);

        req.getRequestDispatcher("/questions.jsp").forward(req, resp);
    }
}
