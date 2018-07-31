package by.htp.pageObjectMail.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailLoginPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://mail.ru";

	@FindBy(xpath = "//child::input[attribute::id='mailbox:login']")
	private WebElement inputLogin;

	@FindBy(xpath = "//child::input[attribute::id='mailbox:password']")
	private WebElement inputPassword;

	@FindBy(xpath = "//child::input[attribute::class='o-control']")
	private WebElement buttonSubmit;

	public MailLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}
}
