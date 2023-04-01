package model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {
    Long id;
    String name;
    String surname;
    String fin;
    String serialNumber;
    Integer numberOfDepartures;
    LocalDate registerDate;
    LocalDate updateDate;
    LocalDate membershipExpirationDate;
    Integer amount;

    public Member(String name, String surname, String fin, String serialNumber, Integer numberOfDepartures, LocalDate membershipExpirationDate, Integer amount) {
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.serialNumber = serialNumber;
        this.numberOfDepartures = numberOfDepartures;
        this.membershipExpirationDate = membershipExpirationDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "---------------------" +
                "\nId: " + getId() +
                "\nName: " + getName() +
                "\nSurname: " + getSurname() +
                "\nFin: " + getFin() +
                "\nSerial number: " + getSerialNumber() +
                "\nNumber of departures: " + getNumberOfDepartures() +
                "\nRegister date: " + getRegisterDate() +
                "\nUpdate date: " + getUpdateDate() +
                "\nMembership expiration date: " + getMembershipExpirationDate() +
                "\nAmount: " + getAmount() +
                "\n---------------------";
    }
}
