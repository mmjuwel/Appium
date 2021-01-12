Feature: Login into ERP 

@SnokeTest  @RegressionTest 
Scenario Outline: Login as a authenticated user 

	Given  User is in Landing page of ERP 
	Then Insert Username <userName> 
	And Insert Password <password> 
	Then Click on Login Button 
	Then Successfully Login and Get Home Page of ERP 
	

	Examples: 
		| userName  | password |
		| anis 	    | 1234     |
 

@RegressionTest 
Scenario: Nevigate To Bank Setup 

	Given User is in Dashboard Page 
	Then Nevigate to Bank Entry Page
	

@RegressionTest
Scenario Outline: Insert Bank Name

	Then Insert Bank Name <bankName>
	And  Insert Bank Short Name <bankShortName>
	Then Click on Save Button
		
	Examples: 
		| bankName  | bankShortName |
		| AAAA 	    | A             |
		| AAAAA     | B             |


@EndToEnd
Scenario: Quite Browser
	Given  User is in Landing page of ERP 
	Then Close The browser 
	
@Test
Scenario Outline: Calculation 
	Given  two numberes <a> and <b>
	Examples:
	|	a	|	b	|
	|	10	|	15	|

















