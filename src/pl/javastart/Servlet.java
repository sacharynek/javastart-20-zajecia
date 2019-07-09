package pl.javastart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println(login+password);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if(login.equals("admin") && password.equals("admin")){
            writer.println("zalogowany");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        System.out.println(number1 + number2);

        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String age = request.getParameter("age");

        //wysyłamy odpowiedź
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("Hello " + number1 + number2);
        if (null != fname && null != lname && null != age) {
            writer.println("Cześć " + fname + " Wiem, że masz na nazwisko " + lname + " Kiedyś też miałem " + age + " lat");
        }

        if (null != fname & null == lname || null == age) {
            writer.println("Cześć " + fname + " Niestety nie wiem jak masz na nazwisko. Ja tez nie lubie chwalić się wiekiem");
        }
    }
}
