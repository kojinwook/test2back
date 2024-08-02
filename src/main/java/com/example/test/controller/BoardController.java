package com.example.test.controller;

import com.example.test.dto.request.PatchBoardRequestDto;
import com.example.test.dto.request.PostBoardRequestDto;
import com.example.test.dto.response.board.*;
import com.example.test.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
            @RequestBody @Valid PostBoardRequestDto requestBody
    ) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody);
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity<? super GetAllBoardsResponseDto> getAllBoards() {
        ResponseEntity<? super GetAllBoardsResponseDto> response = boardService.getAllBoards();
        return response;
    }

    @GetMapping("/detail/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
            @RequestBody @Valid PatchBoardRequestDto requestBody,
            @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBody, boardNumber);
        return response;
    }

    @DeleteMapping("/delete/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber);
        return response;
    }
}