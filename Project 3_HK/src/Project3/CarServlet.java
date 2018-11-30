package Project3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.*;
import project2.*;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	
	//Declaring car and predictor variables.
	Car dude = new Car();
	Predictor predict = new Predictor("/Project3/carTrain.DATA");
	int purchase = 0;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//My stuff
		if(request.getParameter("login")!=null)
		{	
			//If the user enters wrong info, tell them they did so, and send them
			//back to the index page.
			if ((!(request.getParameter("username").equals("countryroads"))) || (!(request.getParameter("password").equals("takemehome"))))
			{
				response.getWriter().append("<form name=\"errorForm\" method=\"post\" action=\"CarServlet\">");
				response.getWriter().append("<h2> Wrong username/password combination. Try again!</h2>");
				response.getWriter().append("<input type=\"submit\" value=\"Got it!\" name = \"backtoindex\"/>");
				response.getWriter().append("</form>");
				response.getWriter().close();
			}
			
			//Otherwise, sending users to the second page where they can enter all the car info.
			else
			{
				response.sendRedirect("carMaker.jsp");
				return;
			}
		}
		
		//Sending users back to the index page after they have been notified that they entered wrong info.
		if(request.getParameter("backtoindex")!=null)
		{
			response.sendRedirect("index.html");
			return;
		}
		
		//After the user enters their car
		if(request.getParameter("carsubmit")!=null)
		{
			//Checking if user entered everything, if not, let them know that
			String errormsg = "Error: Please complete the following field(s):";
			if ((request.getParameter("purchase").equals("")) || (request.getParameter("boot")==null)||(request.getParameter("buy").equals(""))
					||(request.getParameter("doors").equals(""))||(request.getParameter("maint").equals(""))||(request.getParameter("people").equals(""))
					||(request.getParameter("safety")==null))
			{
				if (request.getParameter("purchase").equals(""))
					errormsg += "<br>"+"Original Purchase Price";
				if (request.getParameter("boot")==null)
					errormsg += "<br>"+"Boot Size";
				if (request.getParameter("buy").equals(""))
					errormsg += "<br>"+"Buying Price";
				if (request.getParameter("doors").equals(""))
					errormsg += "<br>"+"Number of Doors";
				if (request.getParameter("maint").equals(""))
					errormsg += "<br>"+"Maintenance";
				if (request.getParameter("people").equals(""))
					errormsg += "<br>"+"Number of People";
				if (request.getParameter("safety")==null)
					errormsg += "<br>"+"Safety Rating";
				
				response.getWriter().append("<form name=\"errorForm\" method=\"post\" action=\"CarServlet\">");
				response.getWriter().append("<h2>" +errormsg + "</h2>");
				response.getWriter().append("<input type=\"submit\" value=\"Got it! Let me re-do it!\" name = \"anothercar\"/>");
				response.getWriter().append("</form>");
				response.getWriter().close();
			}
				
			//If all is entered correctly, setting the variables of the car object according to everything entered by the user.
			dude.setBuying(request.getParameter("buy"));
			dude.setMaint(request.getParameter("maint"));
			dude.setTrunk(request.getParameter("boot"));
			dude.setDoors(Integer.parseInt(request.getParameter("doors")));
			dude.setPersons(Integer.parseInt(request.getParameter("people")));
			dude.setSafety(request.getParameter("safety"));
			
			//At this point the car is set.
			//We now need to pass the car into the predictor and get the closest cars to it,
			//and hence the value that can be offered for the car.
			
			//Making some attributes that can be passed on as part of the
			//request to the next jsp page which will display the results.
			
			//Setting up the rating
			String rating = "rating";
			String ratingval = predict.getPrediction(dude);
			request.setAttribute(rating, ratingval);
			
			//Has exact match been found?
			String match = "match";
			String matchval = String.valueOf(predict.equalcheck(dude));
			request.setAttribute(match, matchval);
			
			//Cars returned from search
			ArrayList<Car> returncars = new ArrayList<Car>();
			String returned = "returned";
			String returnedval = "";
			
			if (predict.equalcheck(dude))
			{
				returncars.add(predict.returnequal(dude));
				returnedval = "<input type=\"radio\" name=\"car\" value=\"" +predict.returnequal(dude).getRating() +"\" />" + predict.returnequal(dude).toString(); 
			}
				
			else
			{
				returncars = predict.threesimilarreturn(dude);
				for (Car a : returncars)
				{
					returnedval += "<input type=\"radio\" name=\"car\" value=\"" +a.getRating() +"\" />" + a.toString() + "<br>";
				}
			}
			
			//Setting up the return cars as radio buttons, as one of the request attributes.
			request.setAttribute(returned, returnedval);
			
			//Saving the purchase price entered by the user, to the servlet variable, and then including it
			//in the request as well.
			purchase = Integer.parseInt(request.getParameter("purchase"));
			
			//Finally, sending this modified request over to carResults.jsp
			RequestDispatcher rd=request.getRequestDispatcher("carResults.jsp");   
			rd.forward(request,response);
		}
		
		//Dealing with the user's selection of the car from the radiobutton list
		if(request.getParameter("showvalue")!=null)
		{
			if (request.getParameter("car")!=null)
			{
				if (request.getParameter("car").equals("unacc"))
					purchase = (int) (purchase*(0.25));
				else if (request.getParameter("car").equals("acc"))
					purchase = (int) (purchase*(0.50));
				else if (request.getParameter("car").equals("good"))
					purchase = (int) (purchase*(0.70));
				else if (request.getParameter("car").equals("vgood"))
					purchase = (int) (purchase*(0.90));
				
				//Setting up the request value with the newly calculated trade in value of the car.
				request.setAttribute("purchase", (Integer)purchase);
				
				//Finally, sending this modified request over to finalShow.jsp
				RequestDispatcher rd=request.getRequestDispatcher("finalShow.jsp");   
				rd.forward(request,response);
			}
			
			else
			{
				response.getWriter().append("<form name=\"errorForm\" method=\"post\" action=\"CarServlet\">");
				response.getWriter().append("<h2>" + "Please select a car next time!" + "</h2>");
				response.getWriter().append("<input type=\"submit\" value=\"Got it! Let me re-do it!\" name = \"anothercar\"/>");
				response.getWriter().append("</form>");
				response.getWriter().close();
			}
		}
		
		if(request.getParameter("logout")!=null)
		{
			response.sendRedirect("index.html");
			return;
		}
		
		if(request.getParameter("anothercar")!=null)
		{
			response.sendRedirect("carMaker.jsp");
			return;
		}
		
		if(request.getParameter("youtube")!=null)
		{
			response.sendRedirect("https://www.youtube.com/");
			return;
		}
		
		//Making a generic base case with the built-in servlet statement.
		else
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
