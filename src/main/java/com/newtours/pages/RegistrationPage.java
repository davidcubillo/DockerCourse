package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(name="firstName")
  private WebElement firstNameTxt;
  @FindBy(name="lastName")
  private WebElement lastNameTxt;
  @FindBy(name="phone")
  private WebElement phoneTxt;
  @FindBy(name="email")
  private WebElement userName;
  @FindBy(name="password")
  private WebElement password;
  @FindBy(name="confirmPassword")
  private WebElement confirmPassword;
  @FindBy(name="submit")
  private WebElement submitButton;

  public RegistrationPage(WebDriver driver)
  {
    this.driver= driver;
    this.wait = new WebDriverWait(driver,30);
    PageFactory.initElements(driver,this);
  }
  public void goTo(){
    this.driver.get("http://demo.guru99.com/test/newtours/register.php");
    this.wait.until((ExpectedConditions.visibilityOf(this.firstNameTxt)));
  }
  public void enterUserDetails(String firstName, String lastName)
  {
    this.firstNameTxt.sendKeys((firstName));
    this.lastNameTxt.sendKeys(lastName);
  }
  public void userCredentials(String userName, String password)
  {
    this.userName.sendKeys(userName);
    this.password.sendKeys(password);
    this.confirmPassword.sendKeys(password);
  }
  public void submit(){
    this.submitButton.click();
  }

}
