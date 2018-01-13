/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;

/**
 *
 * @author sooryagangarajk
 */
@WebServlet(name = "Servlet", urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {
    
        Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public static String USN;
    public static String SID;

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
            throws ServletException, IOException, SQLException {
        String usr = request.getParameter("username");
        String pasd = request.getParameter("password");
        String Sql = "select * from Login where UserName=? and Password=?";
        
            conn=MySqlConnect.ConnectDB();
                try {
            pst = conn.prepareStatement(Sql);
            pst.setString(1, usr);
            pst.setString(2, pasd);
            rs = pst.executeQuery();
            if (rs.next()) {
                //for public

                String ad = rs.getString(3);
                String usn = rs.getString(4);
                String sid = rs.getString(5);
                // JOptionPane.showMessageDialog(null, "" + (ad != null) + ":" + (usn != null) + ":" + sid != null);
                if (ad.equals("0") && (sid != null) && (usn == null)) {/////////SGK//////////
                    this.SID=sid;
               /////////SGK//////////
               RequestDispatcher rd = request.getRequestDispatcher("/Teacher.html");
rd.include(request, response);
//                      response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Servlet at " + "Teacher" + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
                    //JOptionPane.showMessageDialog(null, "TT");
                    //statusId.setText("TT");
                    
                    
                    
                    
                }
                if (ad.equals("0") && (usn != null) && (sid == null)) {/////////SGK//////////
                    RequestDispatcher rd = request.getRequestDispatcher("/Teacher.html");
rd.include(request, response);
//                    students
//                    this.USN=usn;
//                    JOptionPane.showMessageDialog(null, "students");
//                    statusId.setText("students");
//                    response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Servlet at " + "Student" + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//                    


                    
                }
                if (ad.equals("1")) {/////////SGK//////////
                    RequestDispatcher rd = request.getRequestDispatcher("/Teacher.html");
rd.include(request, response);
                    //statusId.setText("Admin");
                    //JOptionPane.showMessageDialog(null, "Admin");
//                    response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Servlet at " + "Admin" + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
                


                }
                //this.setVisible(false);
                //for admin add data ,show all data etc.

            } else {}
               

        } catch (Exception e) {
            //statusId.setText(e.toString());
            // usernameId.setText(e.toString());
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
