package edu.hsai.homework4.pages.homepage;

import edu.hsai.homework4.pages.homepage.elements.HeaderSection;
import edu.hsai.homework4.pages.homepage.elements.IFrame;
import edu.hsai.homework4.pages.homepage.elements.LeftSection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class HomePage {
    private static WebDriver driver;
    private static Properties properties;

    private final HeaderSection headerSection;
    private final LeftSection leftSection;

    @FindBy(id = "name")
    private WebElement loginName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "html > body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropDownButton;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitIconsTexts;

    @FindBy(tagName = "iframe")
    private WebElement frame;

    public HomePage(WebDriver driver, Properties properties) {
        HomePage.driver = driver;
        HomePage.properties = properties;

        driver.navigate().to(properties.getProperty("site.url"));

        PageFactory.initElements(driver, this);

        headerSection = new HeaderSection(driver);
        leftSection = new LeftSection(driver);
    }

    public void performLogin() {
        loginDropDownButton.click();
        this.loginName.sendKeys(properties.getProperty("user.name"));
        this.password.sendKeys(properties.getProperty("user.password"));
        loginButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getLoggedName() {
        return userName.getText();
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public int getBenefitIconsSize() {
        return benefitIcons.size();
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public int getBenefitIconsTextsSize() {
        return benefitIconsTexts.size();
    }

    public List<String> getBenefitIconsTextsStrings() {
        return benefitIconsTexts.stream().map(WebElement::getText).toList();
    }

    public LeftSection getLeftSection() {
        return leftSection;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return new IFrame(driver).getFrameButton();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}
