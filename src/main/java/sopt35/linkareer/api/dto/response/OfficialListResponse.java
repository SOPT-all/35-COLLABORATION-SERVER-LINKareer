package sopt35.linkareer.api.dto.response;

import sopt35.linkareer.domain.official.application.dto.response.OfficialDto;

import java.util.List;
import java.util.stream.Collectors;

/*
List<Official>를 받아 List<OfficialResponse>로 변환
 */
public record OfficialListResponse(List<OfficialResponse> officialList) {

    // official 리스트를 받아 OfficialResponse 리스트로 변환
    public static OfficialListResponse from(List<OfficialDto> officialList) {
        List<OfficialResponse> OfficialResponse = officialList.stream()
                .map(official -> new OfficialResponse(
                        official.getId(), official.getInterestJob(), official.getImageUrl(),
                        official.getTitle(), official.getCompanyName(), official.getTag(),
                        official.getViews(), official.getComments(), official.getDDay(), official.isBookmark()))
                .collect(Collectors.toList());
        return new OfficialListResponse(OfficialResponse);
    }
}