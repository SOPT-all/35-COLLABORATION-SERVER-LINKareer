package sopt35.linkareer.domain.official.application.service;

import org.springframework.stereotype.Service;
import sopt35.linkareer.domain.official.application.dto.response.OfficialDto;
import sopt35.linkareer.domain.official.infra.Official;
import sopt35.linkareer.domain.official.infra.Official.Category;
import sopt35.linkareer.domain.official.infra.repository.OfficialRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficialService {
    private final OfficialRepository officialRepository;

    public OfficialService(OfficialRepository officialRepository) {
        this.officialRepository = officialRepository;
    }

    // 추천 공고, 실시간 인기 공고 리스트 조회 API
    public List<OfficialDto> getOfficialListByCategory(Long memberId, Category category) {
        // Repository에서 엔티티 조회
        List<Official> officialList;

        // 추천 공고라면 (유저에게 '정규직 전환' 태그만 있다고 가정하고 해당 태그와 관련된 리스트 반환)
        if(category == Category.RECOMMEND){
            officialList = officialRepository.findAllByTag("정규직 전환");
        }
        // 실시간 인기 공고라면 (유저는 UX/UI 직무에 관심있다고 가정하고 해당 직무와 관련된 리스트 반환)
        else {
            officialList = officialRepository.findAllByInterestJob("UX/UI");
        }
        // 엔티티 -> 도메인 모델로 변환
        return officialList.stream()
                .map(official -> new OfficialDto(
                        official.getId(),
                        official.getInterestJob(),
                        official.getImageUrl(),
                        official.getTitle(),
                        official.getCompanyName(),
                        official.getTag(),
                        official.getViews(),
                        official.getComments(),
                        official.getDDay(),
                        official.isBookmark()
                ))
                .collect(Collectors.toList());
    }

}
