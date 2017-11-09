Feature: As StreetSmart User

  @test	
  Scenario: Login to StreetSmart
    Given I open the app and land on home screen
    When user provides his phone number "9999900101"
    And he clicks on button "Activate"
   	Then user waits to see "EULA" page
	And he clicks on button "I Agree"
    And he clicks on button "Ok"


#    Given user is on home page
#    When user clicks on "Timesheets"
#    Then he see "Start Shift" button
#    And he clicks on button "Start Shift"
#    Then he see "Start Break" button
#    And he clicks on button "Start Break"
#    Then he see "End Break" button
#    And he clicks on button "End Break"
#    Then he see "End Shift" button
#    And he clicks on button "End Shift"


#    Then I should see the ten default recipes
#	    | Ristretto       | A smaller shot of espresso coffee, for a fast dose of caffeine. |
#	    | Espresso        | A strong coffee shot of about 40 ml, to energize you after a fine meal. |
#	    | Espresso Macchiato | An Espresso with a milky touch. |
#	    | Caffè           | A black coffee with indulgent crema to easily wake you up in the morning. |
#	    | Cappuccino      | Prepared with espresso, hot milk, and milk foam, for your joyful Italian style coffee moments. |
#	    | Caffè Latte     | Same amount of milk as the Café au lait, but brewed with an Espresso, this is the one for hot milk lovers. |
#	    | Café au Lait    | This traditional drink has caffè and hot milk in equal parts, for mug size coffee for milk lovers. |
#	    | Latte Macchiato | With even more delicious milk and foam added then in a Cappuccino, it will boost your innovative moments. |
#	    | Iced Cappuccino | Cappuccino poured over ice cubes and brewed with cold milk and froth, to enjoy in hot moments. |
#	    | Iced Caffè Latte | Caffè Latte poured over ice cubes and brewed with cold milk, makes a perfect summer drink. |
#	    | Iced Latte Macchiato | Latte Macchiato poured over ice cubes and brewed with cold milk and froth, to always keep a cool head. |
	    
    
