package ru.nsd.islandcount.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;
import ru.nsd.islandcount.Data;
import ru.nsd.islandcount.dao.DataDao;
import ru.nsd.islandcount.objects.Graph;
import ru.nsd.islandcount.objects.Matrix;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FileServlet extends HttpServlet {

    ApplicationContext applicationContext;
    DataDao dataDao;
    Matrix matrix;
    Graph graph;

    public FileServlet(){
        //applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        applicationContext = ContextLoader.getCurrentWebApplicationContext();
        dataDao = applicationContext.getBean(DataDao.class);
        matrix = applicationContext.getBean(Matrix.class);
        graph = applicationContext.getBean(Graph.class);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter pw = response.getWriter();
        System.out.println(matrix.toString());
        int result = graph.quantityOfIslands(graph)- matrix.quantityOfDots();
        Data data = new Data(matrix.getN(), matrix.getM(), matrix.toString(), result);
        dataDao.insert(data);
        pw.print(data.getJsonString());
    }
}