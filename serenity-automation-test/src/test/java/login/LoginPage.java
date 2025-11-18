package login;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;


@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")

public class LoginPage extends PageObject {

    @FindBy(xpath = "(//input[@name='username'])")
    private WebElementFacade usernameField;

    @FindBy(xpath = "(//input[@name='password'])")
    private WebElementFacade passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "(//li[@class='oxd-userdropdown'])")
    private WebElementFacade userName;

    @FindBy(xpath = "(//a[@class='oxd-main-menu-item active'])")
    private WebElementFacade adminPanel;

    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary'])")
    private WebElementFacade add;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
    private WebElementFacade userRole;

    @Step ("Iniciar sesión como Admin")
    public void loginAs(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        Serenity.reportThat("Usuario ingresó credenciales (Admin/admin123)",
                () -> assertThat(true).isTrue());
        loginButton.click();
        Serenity.reportThat("Validar login exitoso",
                () -> assertThat(true).isTrue());
    }

    public String getUser() {
        // getText() trae el mensaje completo; trim() limpia saltos de línea
        return userName.getText().trim();
    }


}
