import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Login extends  BaseTest{

    @Test
    public void deveRealizarLogin() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        String welcome = driver.findElement(By.className("subheader")).getText();

        assertEquals("Welcome to the Secure Area. When you are done click logout below.", welcome);
    }

    @Test
    public void deveValidarUsuarioInvalidoCambosEmBranco() {
       driver.findElement(By.className("radius")).click();
       String flash = driver.findElement(By.id("flash")).getText();

       assertTrue(flash.contains("Your username is invalid!"));
    }

    @Test
    public void deveValidarUsuarioInvalidoCampoUserEmBranco() {
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String flash = driver.findElement(By.id("flash")).getText();

        assertTrue(flash.contains("Your username is invalid!"));
    }

    @Test
    public void deveValidarSenhaInvalidaCampoPasswordEmBranco() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.className("radius")).click();
        String flash = driver.findElement(By.id("flash")).getText();

        assertTrue(flash.contains("Your password is invalid!"));
    }

    @Test
    public void deveValidarUsuarioInvalidoUsuarioSenhaIncorretos() {
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test123!");
        driver.findElement(By.className("radius")).click();
        String flash = driver.findElement(By.id("flash")).getText();

        assertTrue(flash.contains("Your username is invalid!"));
    }

    @Test
    public void deveValidarUsuarioInvalidoComUsuarioIncorretoCampoPassWordEmBranco() {
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.className("radius")).click();
        String flash = driver.findElement(By.id("flash")).getText();

        assertTrue(flash.contains("Your username is invalid!"));
    }

    @Test
    public void deveValidarUsuarioInvalidoComUsuarioEmBrancoESenhaIncorreta() {
        driver.findElement(By.id("password")).sendKeys("test123!");
        driver.findElement(By.className("radius")).click();
        String flash = driver.findElement(By.id("flash")).getText();

        assertTrue(flash.contains("Your username is invalid!"));
    }

    @Test
    public void deveValidarSenhaIncorretaComCampoUserCorretoEeSenhaIncorreta() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("test123!");
        driver.findElement(By.className("radius")).click();
        String flash = driver.findElement(By.id("flash")).getText();

        assertTrue(flash.contains("Your password is invalid!"));
    }

    @Test
    public void deveValidarUsuarioInvalidoComCampoUserIncorretoESenhaValida() {
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String flash = driver.findElement(By.id("flash")).getText();

        assertTrue(flash.contains("Your username is invalid!"));
    }
}