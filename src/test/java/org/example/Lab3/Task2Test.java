package org.example.Lab3;

import edu.hsai.homework3.expecteddata.ExpectedData;

import edu.hsai.homework3.pages.differnetelementspage.DifferentElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Task2Test extends DriverSetup {
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title
        assertEquals(homePage.getTitle(), ExpectedData.SITE_NAME);
    }

    @Test
    public void testLogin() {
        // 4. Assert Username is loggined
        assertEquals(homePage.getLoggedName(), ExpectedData.LOGGED_USER_NAME);
    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver, homePage);

        // 6. Select checkboxes
        differentElementsPage.selectCheckbox("Water");
        differentElementsPage.selectCheckbox("Wind");

        // 7. Select radio
        differentElementsPage.selectRadio("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectDropdownOption("Yellow");

        // 9. Assert logs
        assertEquals(differentElementsPage.getLogs(), ExpectedData.DIFFERENT_ELEMENTS_LOGS);
    }
}