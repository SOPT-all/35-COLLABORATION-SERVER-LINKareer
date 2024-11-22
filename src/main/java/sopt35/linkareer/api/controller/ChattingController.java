package sopt35.linkareer.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt35.linkareer.api.dto.response.ChattingHistoryApiResponse;
import sopt35.linkareer.api.facade.ChattingFacade;

@RestController
@RequestMapping("/api/v1/chatting")
public class ChattingController {

    private final ChattingFacade chattingFacade;

    public ChattingController(ChattingFacade chattingFacade) {
        this.chattingFacade = chattingFacade;
    }

    @GetMapping("/history")
    public ResponseEntity<ChattingHistoryApiResponse> getChattingHistory(@RequestHeader Long memberId) {
        return ResponseEntity.ok(
            ChattingHistoryApiResponse.of(chattingFacade.getChattingHistory(memberId))
        );
    }

}
