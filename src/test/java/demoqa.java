import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class demoqa {

    WebDriver wd;


    @BeforeMethod
    public void preconditions() {
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/text-box");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void fillForm() {
        WebElement userName = wd.findElement(By.id("userName"));
        WebElement userEmail = wd.findElement(By.id("userEmail"));
        WebElement currentAddress = wd.findElement(By.id("currentAddress"));
        WebElement permanentAddress = wd.findElement(By.id("permanentAddress"));
        WebElement submit = wd.findElement(By.id("submit"));

        fillFields(userName,"Vladimir");
        fillFields(userEmail, "feldman@gmail.com");
        fillFields(currentAddress, "Ashqelon");
        fillFields(permanentAddress,"Iotvata 6");
        submit.click();

        List<WebElement> fields = wd.findElements(By.className("mb-1"));
        System.out.println(fields.size());
        WebElement field = fields.get(0);
        String fieldText = field.getText();
        System.out.println(fieldText);
        Assert.assertEquals(fieldText,"Name:Vladimir" );

        WebElement field1 = fields.get(1);
        String fieldText1 = field1.getText();
        System.out.println(fieldText1);
        Assert.assertEquals(fieldText1,"Email:feldman@gmail.com" );

        WebElement field2 = fields.get(2);
        String fieldText2 = field2.getText();
        System.out.println(fieldText2);
        Assert.assertEquals(fieldText2,"Current Address :Ashqelon" );

        WebElement field3 = fields.get(3);
        String fieldText3 = field3.getText();
        System.out.println(fieldText3);
        Assert.assertEquals(fieldText3,"Permananet Address :Iotvata 6" );




    }


    public void fillFields(WebElement el, String text){
        el.click();
        el.clear();
        el.sendKeys(text);
    }
    @AfterMethod
    public void tearDown() {
        //wd.quit();
    }
}
