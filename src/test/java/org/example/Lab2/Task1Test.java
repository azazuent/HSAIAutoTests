package org.example.Lab2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Task1Test extends DriverSetup {
    @Test
    public void testTask1() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 4. Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        var headerItems = driver
                .findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8"))
                .findElements(By.xpath("./child::*"));

        final int EXPECTED_HEADER_ITEMS_SIZE = 4;
        softAssert.assertEquals(headerItems.size(), EXPECTED_HEADER_ITEMS_SIZE);

        headerItems.forEach(item -> softAssert.assertTrue(item.isDisplayed()));

        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toList(),
                List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        var benefitImages = driver.findElements(By.className("benefit-icon"));

        final int EXPECTED_BENEFIT_IMAGES_SIZE = 4;
        softAssert.assertEquals(benefitImages.size(), EXPECTED_BENEFIT_IMAGES_SIZE);

        benefitImages.forEach(image -> softAssert.assertTrue(image.isDisplayed()));

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        var benefitTexts = driver.findElements(By.className("benefit-txt"));

        final int EXPECTED_BENEFIT_TEXTS_SIZE = 4;
        softAssert.assertEquals(benefitTexts.size(), EXPECTED_BENEFIT_TEXTS_SIZE);

        benefitTexts.forEach(image -> softAssert.assertTrue(image.isDisplayed()));

        softAssert.assertEquals(benefitTexts.stream().map(WebElement::getText).toList(),
                List.of("""
                                To include good practices
                                and ideas from successful
                                EPAM project""",
                        """
                                To be flexible and
                                customizable""",
                        "To be multiplatform",
                        """
                                Already have good base
                                (about 20 internal and
                                some external projects),
                                wish to get more…"""));

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertEquals(driver.findElement(By.tagName("iframe")).getAttribute("src"),
                "https://jdi-testing.github.io/jdi-light/frame-button.html");

        // 9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");

        softAssert.assertEquals(driver.findElement(By.id("frame-button")).getAttribute("value"), "Frame Button");

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        var leftSectionItems = driver.findElement(By.cssSelector("ul.sidebar-menu.left"))
                .findElements(By.xpath("./child::*"));

        leftSectionItems.forEach(item -> softAssert.assertTrue(item.isDisplayed()));

        softAssert.assertEquals(leftSectionItems.stream().map(WebElement::getText).toList(),
                List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        softAssert.assertAll();
    }
}
