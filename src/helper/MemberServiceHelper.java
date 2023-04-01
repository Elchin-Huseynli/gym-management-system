package helper;

import model.Member;
import java.time.LocalDate;
import static util.InputUtil.*;

public class MemberServiceHelper {
    public static Member fillMember() {
        String name = inputTypeString("Enter the name: ");
        String surname = inputTypeString("Enter the surname: ");
        String fin = inputTypeString("Enter the fin: ");
        String serialNumber = inputTypeString("Enter the serial number: ");
        Integer numberOfDepartures = inputTypeInteger("Enter the departures: ");
        LocalDate membershipExpirationDate = LocalDate.parse(inputTypeString("Enter the expiration date: "));
        Integer amount = inputTypeInteger("Enter the amount: ");

        return new Member(name,surname,fin,serialNumber,numberOfDepartures,membershipExpirationDate,amount);
    }
}
