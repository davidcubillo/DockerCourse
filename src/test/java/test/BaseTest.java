package test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
  protected WebDriver driver;

  @BeforeTest
  public void setupDriver() throws MalformedURLException {
    //Necesito
    //La variable Browser  variable que puede ser chrome/firefox
    //El HUB host
    //Tenemos Valores por defecto en el caso de que no nos den un browser en especifico
    String host = "localhost";
    DesiredCapabilities dc;
    if(System.getProperty("BROWSER")!= null &&
       System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
      dc = DesiredCapabilities.firefox();
    }
    else{
      dc = DesiredCapabilities.chrome();
    }
    if(System.getProperty("HUB_HOST")!= null)
        {
        host = System.getProperty("HUB_HOST");
        }
    String completeUrl = "http://" + host + ":4444/wd/hub";
    this.driver = new RemoteWebDriver(new URL(completeUrl),dc);

  }
  @AfterTest
  public void quitBrowser() {
    this.driver.close();
  }
}
