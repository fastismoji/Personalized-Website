<!DOCTYPE html>
<!--[if lt IE 8 ]><html class="no-js ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 8)|!(IE)]><!-->
<%@ taglib prefix="s" uri="/struts-tags" %>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- Basic Page Needs
   ================================================== -->
<meta charset="utf-8">
<title>Rasika Mohod Profile</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Mobile Specific Metas
   ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
    ================================================== -->
<link rel="stylesheet" href="css/default.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/media-queries.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Script
   ================================================== -->
<script src="js/modernizr.js"></script>
<script src="js/zipcodes.js"></script>
<!--  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		window.jQuery || document.write('<script src="js/jquery-1.10.2.min.js"><\/script>')
	</script>-->
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>

<script src="js/jquery.flexslider.js"></script>
<script src="js/waypoints.js"></script>
<script src="js/jquery.fittext.js"></script>
<script src="js/magnific-popup.js"></script>
<script src="js/init.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>
<script>
	  $( function() {
	    $( "#tooltip" ).tooltip();
	  } );
</script>

<script type="text/javascript">
		function calculateAverageMax() {
			var inputString = document.getElementById("inputData").value;
			var tokens = new Array();
			tokens = inputString.split(",");

			var numtokens = tokens.length;
			if (numtokens >= 10) {
				var sum = 0;
				var max = 0;
				for (var i = 0; i < tokens.length; i++) {
					if (tokens[i] >= 0 && tokens[i] <= 100) {
						if (tokens[i] > max)
							max = parseInt(tokens[i], 10);

						sum += parseInt(tokens[i], 10); //don't forget to add the base
					} else {
						alert("Please enter numbers in the range between 1 - 100.");
					}
				}

				var avg = sum / tokens.length;

				document.getElementById("outputAverage").value = avg;
				document.getElementById("outputMaximum").value = max;
			} else {
				document.getElementById("inputData").title = "Please enter numbers in the range between 1 - 100.";
				//$( "#inputData" ).dialog("Please enter atleast 10 numbers.");
				alert("Please enter atleast 10 numbers.");
				
			}
		} // end function splitButtonPressed

		$('#contactForm').submit(function(evt) {
			evt.preventDefault();

			var checkboxes = document.getElementsByName("checkbox");
			console.log(checkboxes);

			var count = 0;

			for (var i = 0, len = checkboxes.length; i < len; i++) {
				if (checkboxes[i].checked) {
					count++;
				}
			}
			if (count >= 2) {
				return true;
			}
			document.getElementById("checkboxLabel").innerHTML = "newtext";
			document.getElementById("checkboxlabel").title = "Please check atleast two checkboxes.";
			alert("error in checkbox");
			evt.preventDefault();
			return false;

		});

		//Funtion for Form validation
		function formValidation() {
			var checkboxes = document.getElementsByName("checkbox");
			console.log(checkboxes);

			var count = 0;

			for (var i = 0, len = checkboxes.length; i < len; i++) {
				if (checkboxes[i].checked) {
					count++;
				}
			}
			if (count >= 2) {
				return true;
			} else {
				document.getElementById("checkboxLabel").innerHTML = "newtext";
				//document.getElementById("checkboxlabel").setAttribute("title", "Please check atleast two checkboxes.");
				alert("Please select atleast two checkboxes.");
			}
			return false;
		}

		function getzipcodes() {
			var inputzipcode = $("#zip").val();
			if (inputzipcode.length === 5) {
				var ajaxCall = $.ajax({
					url: "zipcodes.json",
					cache: false,
					dataType: "json",
					type: "GET"
				});
				ajaxCall.done(function(data, success, jqXHR){
					var zipcode = data.zipcodes;
					console.log(data);
					for (var i = 0; i < zipcode.length; i++) {
						var object = zipcode[i];
						if(object.zip == inputzipcode){
							document.getElementById( "city" ).value = object.city;
							document.getElementById( "state" ).value = object.state;
						}
						else
						{
							document.getElementById("zip").setAttribute("title","This Zip Code is not valid (or not in VA or IL)");
						}
					}
				});
				ajaxCall.fail(function(jqXHR, status, error){
					console.log(error);
				});
			}
		}
	</script>

<!-- Favicons
	================================================== -->
<link rel="shortcut icon" href="favicon.png">

</head>

<body>

	<!-- Header
   ================================================== -->
	<header id="home">

		<div class="row banner">
			<div class="banner-text">
				<h3 class="responsive-headline">Author: Rasika Mohod</h3>
				<hr>
				<h4 style="color: #ffffff">
					<span id="greetingMessage"> Welcome to Assignment# 5! </span>
				</h4>
			</div>
		</div>
		<p class="scrolldown">
			<a class="smoothscroll" href="#survey"><i
				class="icon-down-circle"></i></a>
		</p>
	</header>
	<!-- Header End -->

	<!-- Survey Section
   ================================================== -->
	<section id="survey">

		<div class="row section-head">

			<div class="two columns header-col">

				<h1>
					<span>CS Department Survey</span>
				</h1>

			</div>

			<div class="ten columns">

				<h2>CS Department Survey</h2>
				<p class="lead">We would like prospective students to provide
					feedback about their campus visit.</p>

			</div>

		</div>


		<!-- form -->
		<s:form action="SurveyFormStoreActionServlet" method="post" autocomplete="on">
			<fieldset>

				<!-- Start of Row 1 -->
				<div class="row">
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Name <span class="required">*</span>
							</h2>
							<input type="text" pattern="[A-Za-z ]+"
								title="Only alphabets or space is accepted."
								placeholder="FirstName LastName" value="" size="35"
								id="contactName" name="studentName" autofocus required>
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Email <span class="required">*</span>
							</h2>
							<input type="email" value="" size="35" id="contactEmail"
								title="Enter valid email address." name="studentEmail" required>
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Telephone Number <span class="required">*</span>
							</h2>
							<input type="text" value="" size="35" pattern="\d{10}"
								title="Enter telephone in the format: XXXXXXXXXX" id="telephoneNumber"
								placeholder="Use format: XXXXXXXXXX" name="telephoneNumber"
								required>
						</div>
					</div>
				</div>
				<!-- End of Row 1 -->


				<!-- Start of Row 2 -->
				<div class="row">
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Data <span class="required">*</span></h2>
							</label> <input type="text"
								placeholder="Enter min. 10 nos.: 1 - 100" value="" size="35" 
								id="inputData" name="data" title = "Enter atleast 10 numbers in the range between 1 to 100."
								onblur="calculateAverageMax()" autofocus required>
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Student ID <span class="required">*</span>
							</h2>
							<input type="text" value="" size="35" id="studentId"
								name="studentId" required>
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">Street
								Address</h2>
							<input type="text" value="" pattern="[a-zA-Z0-9, ]+"
								title="Only alphanumeric or space is accepted." size="35"
								id="streetAddress" name="streetAddress">
						</div>
					</div>
				</div>
				<!-- End of Row 2 -->


				<!-- Start of Row 3 -->
				<div class="row">
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Zip Code</h2>
							<input type="number" value="" pattern="[0-9]*" maxlength="5"
								style="width: 75%" title="Enter valid zipcode" size="35"
								id="zip" name="zip" onblur="getzipcodes()">

						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								City</h2>
							<input type="text" value="" pattern="[A-Za-z ]+"
								title="Only alphabets or space is accepted." size="35" id="city"
								name="city">
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								State</h2>
							<input type="text" value="" pattern="[A-Za-z ]+"
								title="Only alphabets or space is accepted." size="35" id="state"
								name="state">
						</div>
					</div>
				</div>
				<!-- End of Row 3 -->


				<!-- Start of Row 4 -->
				<div class="row">
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Graduaton Month <span class="required">*</span>
							</h2>
							<input list="months" name="graduationMonth" size="35"
								style="width: 75%" required>
							<datalist id="months" required>
								<option value="January">
								<option value="February">
								<option value="March">
								<option value="April">
								<option value="May">
								<option value="June">
								<option value="July">
								<option value="August">
								<option value="September">
								<option value="October">
								<option value="November">
								<option value="December">
							</datalist>
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Graduation Year <span class="required">*</span>
							</h2>
							<input type="text" pattern="\d{4}" title="Enter valid year."
								name="graduationYear" required>
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								How likely would you recommend GMU? <span class="required">*</span>
							</h2>
	
							<select name="datalist">
								<option value="select otpion">Select Option</option>
								<option value="Very Likely">Very Likely</option>
								<option value="Likely">Likely</option>
								<option value="Unlikely">Unlikely</option>
							</select>
						</div>
					</div>
				</div> <!-- End of Row 4 -->

				<!-- Start of Row 5 -->
				<div class="row">
					
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								How did you hear about GMU ? <span class="required">*</span>
							</h2>
								<input type="radio" value="Friends" name="radioButton"
									style="width: 15px; height: 15px" required> Friends
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp   <input
									type="radio" value="Television" name="radioButton"
									style="width: 15px; height: 15px" required> Television 
								<br> <input type="radio" value="Internet" name="radioButton"
									style="width: 15px; height: 15px" required> Internet
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp   <input
									type="radio" value="Other" name="radioButton"
									style="width: 15px; height: 15px" required> Other
							
						</div>
					</div>
					
					<div class="eight columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								What did you like the most about GMU ? <span class="required">*</span> </h2>
							
							<input type="checkbox" name="checkbox" value="Students"
								style="width: 15px; height: 15px; display: inline; "> Students &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
							<input type="checkbox" name="checkbox" value="Location"
								style="width: 15px; height: 15px; display: inline;"> Location &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
							<input type="checkbox" name="checkbox" value="Campus" 
								style="width: 15px; height: 15px; display: inline;"> Campus
							<br>
							<input type="checkbox" name="checkbox" value="Dorm Rooms"
								style="width: 15px; height: 15px; display: inline;"> Dorm Rooms &nbsp &nbsp 
							<input type="checkbox" name="checkbox" value="Atmosphere"
								style="width: 15px; height: 15px; display: inline;"> Atmosphere &nbsp &nbsp &nbsp 
							<input type="checkbox" name="checkbox" value="Sports"
								style="width: 15px; height: 15px; display: inline;"> Sports 
						</div>
					</div>
				</div><!-- End of Row 5 -->

				<!-- Start of Row 6 -->
				<div class="row">
					<div class="eight columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">
								Comments <span class="required">*</span>
							</h2>
							<textarea cols="50" rows="5" id="comments"
								name="comments" style="width: 90%" required></textarea>
						</div>
					</div>
					<div class="four columns">
						<div>
							<h2 style="font: 15px 'opensans-bold', sans-serif;">Date of
								Survey</h2>
							<input type="datetime" style="width: 75%"
								pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d"
								value="" size="35" id="surveyDate" name="surveyDate"
								placeholder="Use format: mm/dd/yyyy"
								title="Please enter date in format: mm/dd/yyyy">
						</div>
					</div>
				</div> <!-- End of Row 6 -->


				<!-- Start of Row 7 -->
				<div class="row">
					<div class="six columns">
						<div>
							<input type="submit" value="Submit" class="submit"
								style="float: left">
						</div>
					</div>
					<div class="six columns">
						<div>
							<input type="reset" value="Reset" class="submit">
						</div>
					</div>
				</div><!-- End of Row 7 -->
				
			</fieldset>
		</s:form>
		<!-- Form End -->





	</section>
	<!-- Survey Section End-->

	<!-- footer
   ================================================== -->
	<footer style="background-color: #000000;">

		<div class="row">

			<div class="twelve columns">
				<ul class="copyright">
					<li style="color: #0F9095;">&copy; SWE 642 2017 RasikaMohod</li>
				</ul>
				<p id="tooltip" class="tooltip" style="background-color: #0F9095;">
					<a href="https://www2.gmu.edu/"> <img class="gmu-logo"
						src="images/gmulogo.jpg"
						title="Please visit http://www.gmu.edu for more information.">
					</a>
				</p>
			</div>
			<div id="go-top">
				<a class="smoothscroll" title="Back to Top" href="#home"><i
					class="icon-up-open"></i></a>
			</div>
		</div>

	</footer>
	<!-- Footer End-->

</body>

</html>