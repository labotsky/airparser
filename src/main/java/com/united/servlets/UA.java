package com.united.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.united.entity.AirLines;
import com.united.parse.AirLinesParser;
import com.united.parse.ParseUtil;

/**
 * Servlet implementation class UA
 */
@WebServlet("/UA")
public class UA extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UA() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AirLines.AirLinesBuilder builder = new AirLines.AirLinesBuilder();
    AirLines.Type type = null;
    if(request.getParameter("type") == "ow"){
      type = AirLines.Type.OW;
    }
    AirLines airLines =
        builder.startDate(request.getParameter("startDate")).endDate(request.getParameter("endDate")).origin(request.getParameter("origin")).destination(request.getParameter("destination")).seats(Integer.valueOf(request.getParameter("seats"))).classEconomy(AirLines.EconomyClass.AWARDECON)
            .type(type).build();
    AirLinesParser parser = new AirLinesParser();
    String jsonString = ParseUtil.createJsonFromAwardList(parser.fullParseAirLines(airLines));
    PrintWriter out = response.getWriter();
    out.println(jsonString);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
  }

}
