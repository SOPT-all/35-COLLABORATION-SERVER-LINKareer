package sopt35.linkareer.global.util;

import jakarta.servlet.http.HttpServletRequest;

public class HeaderExtracter {

    private static final String MEMBER_ID = "memberId";

    public static long extractMemberId(HttpServletRequest req) {
        System.out.println(req.getHeader(MEMBER_ID));
        return Long.parseLong(req.getHeader(MEMBER_ID));
    }

}
