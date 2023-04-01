package queries;

public class MemberQuery {
    public static String ADD_MEMBER = "insert into gym (name, surname, fin, serial_number, number_of_departures, " +
            "membership_expiration_date, amount, register_date, update_date) values (?,?,?,?,?,?,?,now(),now())";

    public static String SHOW_MEMBERS = "select * from gym";

    public static String INCREMENT_DEPARTURES = "update gym set number_of_departures = number_of_departures + ?, update_date=now() where fin=?";
    public static String DECREMENT_DEPARTURES = "update gym set number_of_departures = number_of_departures - 1 where fin=? and number_of_departures>0";
}
