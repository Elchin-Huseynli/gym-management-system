package service.impl;

import exception.InvalidOptionException;
import exception.NotFoundMemberException;
import service.ManagementService;
import util.MenuUtil;

import java.util.InputMismatchException;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void management() {
        MemberServiceImpl memberService = new MemberServiceImpl();
        while (true) {
            try {
                while (true) {
                    Integer option = MenuUtil.entry();
                    switch (option) {
                        case 0 -> {
                            System.out.println("Good bye!");
                            System.exit(-1);
                        }
                        case 1 -> memberService.addMember();
                        case 2 -> memberService.showMembers();
                        case 3 -> memberService.enterTheGym();
                        case 4 -> memberService.updateDepartures();
                        default -> throw new InvalidOptionException();
                    }
                }
            }
            catch (NotFoundMemberException | InvalidOptionException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
