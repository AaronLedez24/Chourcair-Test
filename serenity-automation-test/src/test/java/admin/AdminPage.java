package admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminPage extends PageObject {

    @FindBy(xpath = "//a[contains(.,'Admin')]")
    private WebElementFacade adminPanel;

    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary'])")
    private WebElementFacade add;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
    private WebElementFacade userRole;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
    private WebElementFacade userStatus;

    @Step("Abrir formulario Add User")
    public void openAddUserForm() throws InterruptedException {
        adminPanel.click();
        add.withTimeoutOf(60, TimeUnit.SECONDS).waitUntilClickable().click();
        userRole.withTimeoutOf(60, TimeUnit.SECONDS).waitUntilVisible().click();
        selectUserRole("Admin");
        userStatus.withTimeoutOf(60, TimeUnit.SECONDS).waitUntilVisible().click();
        selectUserStatus("Enabled");
        Serenity.reportThat("Formulario Add User cargado correctamente",
                () -> assertThat(true).isTrue());
    }


    public void selectUserRole(String role) {

        //  Seleccionar opción del dropdown real
        $("//div[contains(@class,'oxd-select-dropdown')]//div[contains(@class,'oxd-select-option')][normalize-space()='" + role + "']")
                .waitUntilClickable()
                .click();

        Serenity.reportThat("Seleccionó el rol correctamente",
                () -> assertThat(true).isTrue());
    }

    public void selectUserStatus(String status) {

        //  Seleccionar opción del dropdown real
        $("//div[contains(@class,'oxd-select-dropdown')]//div[contains(@class,'oxd-select-option')][normalize-space()='" + status + "']")
                .waitUntilClickable()
                .click();

        Serenity.reportThat("Seleccionó el Estatus correctamente",
                () -> assertThat(true).isTrue());
    }


}
