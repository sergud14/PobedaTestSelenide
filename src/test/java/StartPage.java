import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class StartPage {
    private SelenideElement buttonInformation = $(By.xpath("//a[@href='/information']"));
    private SelenideElement logo = $(By.xpath("(//img[@alt='«Авиакомпания «Победа», Группа «Аэрофлот»'])[1]"));
    public StartPage ()
    {
    }

    public boolean verifySiteIsOpen() {
        if(Selenide.title().equals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками")&&$(logo).isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void moveToButtonInformation() {
        $(buttonInformation).hover();
    }
}
