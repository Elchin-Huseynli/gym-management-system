package service.impl;

import exception.MemberAlreadyExitsException;
import model.Member;
import repository.MemberRepository;
import repository.impl.MemberRepositoryImpl;
import service.MemberService;
import static util.InputUtil.*;
import java.util.List;
import static helper.MemberServiceHelper.fillMember;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl() {
        memberRepository = new MemberRepositoryImpl();
    }

    @Override
    public void addMember() {
        Member member = fillMember();
        List<Member> members = memberRepository.showMembers();
        boolean isAdd = false;
        for (Member member1 : members) {
            if (member.getFin().equals(member1.getFin())) {
                isAdd = true;
            }
        }
        if (!isAdd) {
            memberRepository.addMember(member);
            System.out.println("Member added successfully!");
        }
        else {
            throw new MemberAlreadyExitsException();
        }

    }

    @Override
    public void showMembers() {
        List<Member> members = memberRepository.showMembers();
        members.stream()
                .forEach(System.out::println);
    }

    @Override
    public void enterTheGym() {
        String fin = inputTypeString("Enter the fin: ");
        memberRepository.enterTheGym(fin);
        memberRepository.showMembers().stream()
                .filter(member -> member.getFin().equals(fin))
                .peek(member -> {
                    if (member.getNumberOfDepartures().equals(0)) System.out.println("Rejected!");
                    else {
                        System.out.println(member.getName() + " " + member.getSurname() + " - " +
                                member.getNumberOfDepartures() + " departures left");
                    }
                })
                .findFirst();
    }

    @Override
    public void updateDepartures() {
        Integer numberOfDepartures = inputTypeInteger("Enter the departures: ");
        String fin = inputTypeString("Enter the fin: ");
        memberRepository.updateDepartures(fin, numberOfDepartures);
        memberRepository.showMembers().stream()
                .filter(member -> member.getFin().equals(fin))
                .forEach(member -> System.out.println(member.getName() + " " + member.getSurname() + " -  Departure updated successfully!"));
    }
}
