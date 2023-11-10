package lomayd.parentingsim.api.domain.parenting.controller;

import lomayd.parentingsim.api.domain.parenting.dto.ParentingInfoResponseDto;
import lomayd.parentingsim.api.domain.parenting.service.ParentingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parenting-info")
@RequiredArgsConstructor
public class ParentingInfoController {

    private final ParentingInfoService parentingInfoService;

    @GetMapping("/board")
    public ResponseEntity<ParentingInfoResponseDto.BoardInfo> getParentingInfoBoard() {
        return ResponseEntity.ok(parentingInfoService.getParentingInfoBoard());
    }

    @GetMapping("/post")
    public ResponseEntity<ParentingInfoResponseDto.PostInfo> getParentingInfoPost(@RequestParam int id) {
        return ResponseEntity.ok(parentingInfoService.getParentingInfoPost(id));
    }
}
