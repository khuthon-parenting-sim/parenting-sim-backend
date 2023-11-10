package lomayd.parentingsim.api.domain.parenting.controller;

import lomayd.parentingsim.api.domain.parenting.dto.ParentingInfoResponseDto;
import lomayd.parentingsim.api.domain.parenting.dto.ParentingSituationResponseDto;
import lomayd.parentingsim.api.domain.parenting.service.ParentingSituationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parenting-situation")
@RequiredArgsConstructor
public class ParentingSituationController {

    private final ParentingSituationService parentingSituationService;

    @GetMapping("/board")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParentingSituationResponseDto.BoardInfo> getParentingSituationBoard() {
        return ResponseEntity.ok(parentingSituationService.getParentingSituationBoard());
    }

    @GetMapping("/post")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParentingSituationResponseDto.PostInfo> getParentingSituationPost(@RequestParam int id) {
        return ResponseEntity.ok(parentingSituationService.getParentingSituationPost(id));
    }
}
