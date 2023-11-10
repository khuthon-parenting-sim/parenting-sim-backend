package lomayd.parentingsim.api.domain.parenting.service;

import lomayd.parentingsim.api.domain.parenting.ParentingSituation;
import lomayd.parentingsim.api.domain.parenting.dto.ParentingSituationResponseDto;
import lomayd.parentingsim.api.domain.parenting.repository.ParentingSituationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentingSituationService {

    private final ParentingSituationRepository parentingSituationRepository;

    public ParentingSituationResponseDto.BoardInfo getParentingSituationBoard() {

        List<ParentingSituation> parentingSituations = parentingSituationRepository.findAll();

        List<ParentingSituationResponseDto.BoardPostInfo> boardPostInfos = new ArrayList<>();

        for(ParentingSituation p : parentingSituations) {
            boardPostInfos.add(ParentingSituationResponseDto.BoardPostInfo.of(p));
        }

        return ParentingSituationResponseDto.BoardInfo.of(boardPostInfos);
    }

    public ParentingSituationResponseDto.PostInfo getParentingSituationPost(int id) {

        ParentingSituation parentingSituation = parentingSituationRepository.findById(id).get();

        return ParentingSituationResponseDto.PostInfo.of(parentingSituation);
    }
}
