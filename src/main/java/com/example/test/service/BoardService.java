package com.example.test.service;

import com.example.test.dto.request.PatchBoardRequestDto;
import com.example.test.dto.request.PostBoardRequestDto;
import com.example.test.dto.response.board.*;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber);
    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer itemNumber);
    ResponseEntity<? super GetAllBoardsResponseDto> getAllBoards();
}

