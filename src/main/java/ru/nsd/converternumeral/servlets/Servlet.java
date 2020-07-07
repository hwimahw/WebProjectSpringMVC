package ru.nsd.converternumeral.servlets;

import ru.nsd.converternumeral.*;
import ru.nsd.converternumeral.exceptions.InputException;
import ru.nsd.converternumeral.exceptions.OverFlowException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            String number = request.getParameter("number");
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            String result = Converter.countResult(number, a, b);
            //  ServletConfig servletConfig = getServletConfig();
            //  ServletContext servletContext = servletConfig.getServletContext();
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("number", number);
            servletContext.setAttribute("a", a);
            servletContext.setAttribute("b", b);
            servletContext.setAttribute("result", result);
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/converterNumeralPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (OverFlowException e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/overFlowExceptionPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (InputException e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/inputExceptionPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/numberFormatExceptionPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            PrintWriter pw = response.getWriter();
            String number = request.getParameter("number");
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            String result = Converter.countResult(number, a, b);
            DataModel dataModel = new DataModel(number, a, b, result);
            pw.print(dataModel.toJson().toString());
        } catch (OverFlowException e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/overFlowExceptionPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (InputException e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/inputExceptionPage.jsp");
            requestDispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/numberFormatExceptionPage.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
