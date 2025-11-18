package login;
import admin.AdminPage;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class LoginFormTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    // Serenity inyecta automáticamente el PageObject
    LoginPage loginPage;
    AdminPage adminPage;

    @Test
    void successful_login_should_display_secure_area_message() throws InterruptedException {
        // 1. Abrir login
        loginPage.open();

        // 2. Ingresar credenciales
        loginPage.loginAs("Admin", "admin123");

        // 3. Abrir formulario Add User
        adminPage.openAddUserForm();

    }
}
