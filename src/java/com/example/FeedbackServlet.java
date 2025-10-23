package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.*;

@WebServlet("/submitFeedback")
public class FeedbackServlet extends HttpServlet {

    // Store all feedback in memory (static so it persists across sessions)
    private static List<String> feedbackList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Save feedback in memory
        String feedback = "Name: " + name + ", Email: " + email + ", Message: " + message;
        feedbackList.add(feedback);

        // Confirmation page
        out.println("<html><body>");
        out.println("<h2>Thank you for your feedback!</h2>");
        out.println("<a href='feedback.html'>Submit Another Feedback</a><br>");
        out.println("<a href='viewFeedback'>View All Feedback</a>");
        out.println("</body></html>");
    }

    // Method to allow other servlets to access feedback
    public static List<String> getFeedbackList() {
        return feedbackList;
    }
}
