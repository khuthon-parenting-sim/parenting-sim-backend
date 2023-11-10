package lomayd.parentingsim.api.domain.parenting.controller;

import lomayd.parentingsim.api.domain.parenting.dto.ParentingInfoResponseDto;
import lomayd.parentingsim.api.domain.parenting.dto.ParentingSituationResponseDto;
import lomayd.parentingsim.api.domain.parenting.service.ParentingSituationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parenting-situation")
@RequiredArgsConstructor
public class ParentingSituationController {

    private final ParentingSituationService parentingSituationService;

    @GetMapping("/board")
    public ResponseEntity<ParentingSituationResponseDto.BoardInfo> getParentingSituationBoard() {
        return ResponseEntity.ok(parentingSituationService.getParentingSituationBoard());
    }

    @GetMapping("/post")
    public ResponseEntity<ParentingSituationResponseDto.PostInfo> getParentingSituationPost(@RequestParam int id) {
        return ResponseEntity.ok(parentingSituationService.getParentingSituationPost(id));
    }
}
