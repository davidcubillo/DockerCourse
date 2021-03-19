package com.newtours.tests;

import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;

public class BookFlightTest extends BaseTest {
//Creo variables privadas de lo que voy a llamar desde el book-flight-module.xml
  private String noOFPassengers;
  private String name;
  private String lastName;
  //Cuando varios test usan las variables hacemos un metodo de setupparameters para enviar las variables a variables privadas en el test
  @BeforeTest
  //En parameters ponemos en orden las variables y en el metodo el orden igual de las variables
  @Parameters({"noOfPassengers","name","lastName"})
  public void setupParameters(String noOFPassengers, String name, String lastName){
  //Asignamos las variables del archivo a la variable privada
    this.noOFPassengers = noOFPassengers;
    this.name = name;
    this.lastName = lastName;

  }
  @Test
  public void registrationPageTest(){
    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.goTo();
    registrationPage.enterUserDetails(name,lastName);
    registrationPage.userCredentials(name,lastName);
    registrationPage.submit();
  }
  @Test(dependsOnMethods = "registrationPageTest")
  public void registrationConfirmationTest(){
    RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
    registrationConfirmationPage.goToFlightDetailsPage();
  }
  @Test(dependsOnMethods = "registrationConfirmationTest" )
  public void flightDetailsTest(){
    FlightFinderPage flightFinderPage = new FlightFinderPage(driver);
    flightFinderPage.selectPassengers(noOFPassengers);
    flightFinderPage.goToFindFlightPage();
  }

}
