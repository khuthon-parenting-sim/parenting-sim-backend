package lomayd.parentingsim.api.domain.parenting.service;

import lomayd.parentingsim.api.domain.parenting.ParentingInfo;
import lomayd.parentingsim.api.domain.parenting.dto.ParentingInfoResponseDto;
import lomayd.parentingsim.api.domain.parenting.repository.ParentingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentingInfoService {

    private final ParentingInfoRepository parentingInfoRepository;

    public ParentingInfoResponseDto.BoardInfo getParentingInfoBoard() {

        List<ParentingInfo> parentingInfos = parentingInfoRepository.findAll();

        List<ParentingInfoResponseDto.BoardPostInfo> boardPostInfos = new ArrayList<>();

        for(ParentingInfo p : parentingInfos) {
            boardPostInfos.add(ParentingInfoResponseDto.BoardPostInfo.of(p));
        }

        return ParentingInfoResponseDto.BoardInfo.of(boardPostInfos);
    }

    public ParentingInfoResponseDto.PostInfo getParentingInfoPost(int id) {

        ParentingInfo parentingInfo = parentingInfoRepository.findById(id).get();

        return ParentingInfoResponseDto.PostInfo.of(parentingInfo);
    }
}
