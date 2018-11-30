<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to the Car Maker!</title>
</head>
<body>

	<h1><a>Car Maker</a></h1>
		<form id="form_37456" class="appnitro"  method="post" action="CarServlet">
					<div class="form_description">
			<p>Please enter the properties for your car!</p>
		</div>						
			<ul >
			
					<li class="section_break">
			<h3>Costs:</h3>
			<p></p>
		</li>		<li id="li_7" >
		<label class="description" for="element_7">Buying Cost: </label>
		<div>
		<select class="element select medium" id="element_7" name="buy"> 
			<option value="" selected="selected"></option>
<option value="vhigh" >vhigh</option>
<option value="high" >high</option>
<option value="med" >med</option>
<option value="low" >low</option>

		</select>
		</div> 
		</li>		<li id="li_6" >
		<br>
		<label class="description" for="element_6">Maintenance Costs: </label>
		<div>
		<select class="element select medium" id="element_6" name="maint"> 
			<option value="" selected="selected"></option>
<option value="vhigh" >vhigh</option>
<option value="high" >high</option>
<option value="med" >med</option>
<option value="low" >low</option>

		</select>
		</div> 
		</li>		<li id="li_3" >
		<br>
		<label class="description" for="element_3">Original Purchase Price </label>
		<div>
			<input id="element_3" name="purchase" class="element text medium" type="text" maxlength="255" value=""/> 
		</div><p class="guidelines" id="guide_3"><small>Enter the purchase price of car, rounded to the closest whole number.</small></p> 
		</li>		<li class="section_break">
			<h3>Capacity:</h3>
			<p></p>
		</li>		<li id="li_5" >
		
		<label class="description" for="element_5">Boot Size: </label>
		<span>
			<input id="element_5_1" name="boot" class="element radio" type="radio" value="small" />
<label class="choice" for="element_5_1">small</label>
<input id="element_5_2" name="boot" class="element radio" type="radio" value="med" />
<label class="choice" for="element_5_2">med</label>
<input id="element_5_3" name="boot" class="element radio" type="radio" value="big" />
<label class="choice" for="element_5_3">big</label>

		</span> 
		</li>		<li id="li_8" >
		<br>
		<label class="description" for="element_8">Number of Doors: </label>
		<div>
		<select class="element select medium" id="element_8" name="doors"> 
			<option value="" selected="selected"></option>
<option value="2" >2</option>
<option value="3" >3</option>
<option value="4" >4</option>
<option value="5" >5 or more</option>

		</select>
		</div> 
		</li>		<li id="li_9" >
		<br>
		<label class="description" for="element_9">Number of People: </label>
		<div>
		<select class="element select medium" id="element_9" name="people"> 
			<option value="" selected="selected"></option>
<option value="2" >2</option>
<option value="4" >4</option>
<option value="5" >5 or more</option>

		</select>
		</div> 
		</li>		<li class="section_break">
			<h3>Safety Rating:</h3>
			<p></p>
		</li>		<li id="li_10" >
		<label class="description" for="element_10">Rating: </label>
		<span>
			<input id="element_10_1" name="safety" class="element radio" type="radio" value="low" />
<label class="choice" for="element_10_1">low</label>
<input id="element_10_2" name="safety" class="element radio" type="radio" value="med" />
<label class="choice" for="element_10_2">med</label>
<input id="element_10_3" name="safety" class="element radio" type="radio" value="high" />
<label class="choice" for="element_10_3">high</label>

<br>
<br>
		</span> 
		</li>
			
					<li class="buttons">
			    <input type="hidden" name="form_id" value="37456" />
			    
				<input id="saveForm" class="button_text" type="submit" name="carsubmit" value="Enter my Car!" />
		</li>
			</ul>
		</form>	
	</body>

</body>
</html>