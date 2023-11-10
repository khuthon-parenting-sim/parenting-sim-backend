package lomayd.parentingsim.api.domain.parenting.controller;

import lomayd.parentingsim.api.domain.parenting.dto.ParentingInfoResponseDto;
import lomayd.parentingsim.api.domain.parenting.service.ParentingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parenting-info")
@RequiredArgsConstructor
public class ParentingInfoController {

    private final ParentingInfoService parentingInfoService;

    @GetMapping("/board")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParentingInfoResponseDto.BoardInfo> getParentingInfoBoard() {
        return ResponseEntity.ok(parentingInfoService.getParentingInfoBoard());
    }

    @GetMapping("/post")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParentingInfoResponseDto.PostInfo> getParentingInfoPost(@RequestParam int id) {
        return ResponseEntity.ok(parentingInfoService.getParentingInfoPost(id));
    }

    @GetMapping("/search")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParentingInfoResponseDto.BoardInfo> searchParentingInfoPost(@RequestParam String type, @RequestParam String search) {
        return ResponseEntity.ok(parentingInfoService.searchParentingInfoPost(type, search));
    }

    @GetMapping("/today")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParentingInfoResponseDto.PostInfo> getTodayParentingInfoPost() {
        return ResponseEntity.ok(parentingInfoService.getTodayParentingInfoPost());
    }
}
