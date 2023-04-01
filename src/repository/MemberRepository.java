package repository;

import model.Member;

import java.util.List;

public interface MemberRepository {
    boolean addMember(Member member);
    List<Member> showMembers();
    boolean enterTheGym(String fin);
    boolean updateDepartures(String fin, Integer numberOfDepartures);
}
