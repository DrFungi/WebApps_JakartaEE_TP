package webdevelopment.jakartaee_pojo_tp.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webdevelopment.jakartaee_pojo_tp.view.UI_Tax;


import java.io.IOException;

@WebServlet("/calculate")
public class TaxServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double income;
        try {
            income = Double.parseDouble(req.getParameter("income"));
        } catch (NumberFormatException e){
            req.setAttribute("error", "Invalid income format. Please enter a valid number");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        String authority = req.getParameter("province");
        boolean calculateFederal = req.getParameter("calculateFederal") != null;
        UI_Tax tax = new UI_Tax();
        //get the variables to know the tax to pay
        double taxToPayC = 0;
        double taxToPayQ = tax.displayTaxToPayQuebec(authority, income);
        // check if federal tax is requested
        if (calculateFederal){
            taxToPayC = tax.displayTaxToPayCanada("Canada", income);
        }

        //calculate total tax to pay

        double totalTax = taxToPayQ + taxToPayC;

        String formatedTaxToPayQ = String.format("%.2f", taxToPayQ);
        String formatedTaxToPayC = String.format("%.2f",taxToPayC);
        String formatedTotalTax = String.format("%.2f",totalTax);
        req.setAttribute("taxQ", formatedTaxToPayQ);
        req.setAttribute("taxC", formatedTaxToPayC);
        req.setAttribute("taxT", formatedTotalTax);
        req.setAttribute("calculateFederal", calculateFederal);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

}
