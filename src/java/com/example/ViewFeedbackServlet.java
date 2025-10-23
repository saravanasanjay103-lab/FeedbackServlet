package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.List;

@WebServlet("/viewFeedback")
public class ViewFeedbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<String> feedbackList = FeedbackServlet.getFeedbackList();

        out.println("<html><body>");
        out.println("<h2>All Submitted Feedback</h2>");

        if (feedbackList.isEmpty()) {
            out.println("<p>No feedback submitted yet.</p>");
        } else {
            out.println("<ul>");
            for (String fb : feedbackList) {
                out.println("<li>" + fb + "</li>");
            }
            out.println("</ul>");
        }

        out.println("<a href='feedback.html'>Submit New Feedback</a>");
        out.println("</body></html>");
    }
}
