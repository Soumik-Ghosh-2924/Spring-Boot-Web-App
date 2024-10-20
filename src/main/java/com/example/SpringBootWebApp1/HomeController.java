package com.example.SpringBootWebApp1;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String home() //this is responsible to call the index.jsp file
    {
        System.out.println();
        System.out.println("Home method called");
        return "index";
    }

//    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session){
//        //Servlet way of accepting parameters to add them
//        System.out.println();
//        System.out.println("Add method in controller called.");
//        int num1 =Integer.parseInt(req.getParameter("num1"));
//        int num2 =Integer.parseInt(req.getParameter("num2"));
//        int result = num1+num2;
//        session.setAttribute("result", result);
// if session object was used we would have used <h2> The result is : <%= model.getAttribute("result")%>  </h2> in the result.jsp file.


        //there is also a spring way of doing the above implementation
        //by using request parameters

//        public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, HttpSession session)
//        {
//            int res= num1+num2;
//            session.setAttribute("result", res);
//        }

//        return "result.jsp";
//    }

    @RequestMapping("/add")
    public String add(@RequestParam("num1") int num1, @RequestParam("num2")int num2, Model model)
    {
        //Spring way of accepting parameters to add them
        System.out.println();
        System.out.println("Add method in controller called.");

        int result = num1+num2;
        model.addAttribute("result", result);

        return "result";
    }

    @RequestMapping("/subtract")
    public String subtract(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
        System.out.println("Subtract method called.");
        int result = num1 - num2;
        model.addAttribute("operation", "Subtraction");
        model.addAttribute("result", result);
        return "result";
    }


    @RequestMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
        System.out.println("Multiply method called.");
        int result = num1 * num2;
        model.addAttribute("operation", "Multiplication");
        model.addAttribute("result", result);
        return "result";
    }


    @RequestMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
        System.out.println("Divide method called.");
        if (num2 == 0) {
            model.addAttribute("result", "Division by zero is not allowed");
        } else {
            int result = num1 / num2;
            model.addAttribute("operation", "Division");
            model.addAttribute("result", result);
        }
        return "result";
    }



    @RequestMapping("/calculate")
    public String calculate(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operation") String operation, Model model) {
        switch (operation) {
            case "add":
                return add(num1, num2, model);
            case "subtract":
                return subtract(num1, num2, model);
            case "multiply":
                return multiply(num1, num2, model);
            case "divide":
                return divide(num1, num2, model);
            default:
                model.addAttribute("result", "Invalid operation");
                return "result";
        }
    }
}
