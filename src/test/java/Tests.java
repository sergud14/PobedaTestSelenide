import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void Test1() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        startPage.moveToButtonInformation();
        InformationHoverMenu informationHoverMenu=new InformationHoverMenu();
        Assertions.assertTrue(informationHoverMenu.verifyHeaders());
    }

    @Test
    public void Test2() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        TicketSearchBlock ticketSearchBlock=new TicketSearchBlock();
        Assertions.assertTrue(ticketSearchBlock.verifyInputs());
        ticketSearchBlock.scrollToSearchTicketBlock();
        ticketSearchBlock.fillInputFrom("Москва");
        ticketSearchBlock.fillInputTo("Санкт-Петербург");
        ticketSearchBlock.clickSearchButton();
        Assertions.assertTrue(ticketSearchBlock.verifyInputDateFromErrorBorderColor());
    }

    @Test
    public void Test3() throws InterruptedException {
        Selenide.open("https://www.pobeda.aero/");
        StartPage startPage=new StartPage();
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        BookingManagementBlock bookingManagementBlock=new BookingManagementBlock();
        bookingManagementBlock.scrollToBookingManagementBlock();
        Assertions.assertTrue(bookingManagementBlock.verifyInputs());
        bookingManagementBlock.fillInputClientName("Qwerty");
        bookingManagementBlock.fillInputBookingNumber("XXXXXX");
        bookingManagementBlock.clickSearchButton();
        bookingManagementBlock.switchToNewTab();
        Assertions.assertTrue(bookingManagementBlock.verifyBookingErrorMessage());
    }
}