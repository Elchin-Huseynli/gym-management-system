package exception;

import enums.ExceptionEnum;

public class NotFoundMemberException extends RuntimeException{
    public NotFoundMemberException() {
        super(ExceptionEnum.NOT_FOUND_MEMBER.name());
    }
}
