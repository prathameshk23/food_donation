/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author pratham
 */
@WebServlet(urlPatterns = {"/meals"})
public class meals extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet meals</title>");
            out.println("</head>");
            out.println("<body style='background: #f2eee3;' >");
//            out.println("<h1>Servlet meals at " + requesttContextPath() + "</h1>");
            out.println("<center><h1>Meal List</h1></center>");

            List<don> list = registerOper.getAll();

            out.print("<center><table border='0' cellpadding='10' style='margin-bottom: 100px' ");
            out.print("<tr><th>Name</th><th>Type</th><th>No.People Can Feed</th><th>Pick Up Time</th><th>Address</th><th>Place Request</th></tr>");
            for (don e : list) {
                
                out.print("<tr><td>" + e.getName() + "</td><td>" + e.getType() + "</td><td>" + e.getFeed() + "</td><td>" + e.getTime() + "</td><td>" + e.getAddress() + "</td><td><a href='reqPlaced?id=" + e.getId() + "'>Place Request</a></td></tr>");
            }
            out.print("</table></center>");
            out.print("<center><a style='margin-top: 300px;\n"
                    + "  border: 2px solid #cda45e;\n"
                    + "  color: #000000;\n"
                    + "  border-radius: 50px;\n"
                    + "  padding: 8px 25px;\n"
                    + "  text-transform: uppercase;\n"
                    + "  font-size: 13px;\n"
                    + "  font-weight: 500;\n"
                    + "  letter-spacing: 1px;\n"
                    + "  transition: 0.3s;*/\n"
                    + "  border-radius: 50px;\n"
                    + "  padding: 8px;\n"
                    + "  font-size: 13px;' href='index.html'>Go Home</a></center>");

            out.close();

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
