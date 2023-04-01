package repository.impl;

import exception.NotFoundMemberException;
import model.Member;
import repository.MemberRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static queries.MemberQuery.*;
import static repository.DbConnection.connection;

public class MemberRepositoryImpl implements MemberRepository {
    @Override
    public boolean addMember(Member member) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_MEMBER);
            preparedStatement.setString(1,member.getName());
            preparedStatement.setString(2,member.getSurname());
            preparedStatement.setString(3,member.getFin());
            preparedStatement.setString(4,member.getSerialNumber());
            preparedStatement.setInt(5,member.getNumberOfDepartures());
            preparedStatement.setDate(6, Date.valueOf(member.getMembershipExpirationDate()));
            preparedStatement.setInt(7,member.getAmount());

            int count = preparedStatement.executeUpdate();
            return count>0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Member> showMembers() {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_MEMBERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Member> members = new LinkedList<>();
            if (resultSet.wasNull()) throw new NotFoundMemberException();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String fin = resultSet.getString("fin");
                String serialNumber = resultSet.getString("serial_number");
                Integer numberOfDepartures = resultSet.getInt("number_of_departures");
                LocalDate registerDate = resultSet.getDate("register_date").toLocalDate();
                LocalDate updateDate = resultSet.getDate("update_date").toLocalDate();
                LocalDate membershipExpirationDate = resultSet.getDate("membership_expiration_date").toLocalDate();
                Integer amount = resultSet.getInt("amount");
                members.add(new Member(id,name,surname,fin,serialNumber,numberOfDepartures,registerDate,updateDate,membershipExpirationDate,amount));
            }
            return members;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean enterTheGym(String fin) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DECREMENT_DEPARTURES);
            preparedStatement.setString(1,fin);

            int count = preparedStatement.executeUpdate();
            return count>0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateDepartures(String fin, Integer numberOfDepartures) {
        try (Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INCREMENT_DEPARTURES);
            preparedStatement.setInt(1,numberOfDepartures);
            preparedStatement.setString(2,fin);

            int count = preparedStatement.executeUpdate();
            return count>0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
