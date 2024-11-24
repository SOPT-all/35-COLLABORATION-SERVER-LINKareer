package sopt35.linkareer.global.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.global.exception.LinkareerException;

@Component
public class HeaderExtracter {

    private static final String MEMBER_ID_HEADER = "memberId";

    public Long extractMemberIdHeader(HttpServletRequest req){
        try {
            String header = req.getHeader(MEMBER_ID_HEADER);
            return Long.parseLong(header);
        }catch (NumberFormatException | NullPointerException e){
            throw new LinkareerException(ErrorCode.INVALID_HEADER_EXCEPTION);
        }
    }
}
