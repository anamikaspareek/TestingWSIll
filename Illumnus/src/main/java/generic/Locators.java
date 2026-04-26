package generic;

public interface Locators
{
String teacher ="//span[@class='d-block mt-2' and text()='Teacher']";
String username = "//input[@id='email']";
String password ="//input[@id='pwd']";
String signin = "//button[@class='btn btn-primary' and text()='Sign In']";

String notebook = "//h2[contains(text(), 'MATHS')]"; // for selecting the notebook
}
