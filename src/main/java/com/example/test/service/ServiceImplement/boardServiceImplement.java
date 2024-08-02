package com.example.test.service.ServiceImplement;


import com.example.test.dto.request.PatchBoardRequestDto;
import com.example.test.dto.request.PostBoardRequestDto;
import com.example.test.dto.response.ResponseDto;
import com.example.test.dto.response.board.*;
import com.example.test.entity.BoardEntity;
import com.example.test.repository.BoardRepository;
import com.example.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class boardServiceImplement implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
        BoardEntity resultSet = null;
        try {
            resultSet = boardRepository.findByBoardNumber(boardNumber);

            if (resultSet == null) return GetBoardResponseDto.notExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetBoardResponseDto.success(resultSet);
    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto) {

        try {
            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber) {

        try {
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return PatchBoardResponseDto.notExistBoard();

            boardEntity.patchBoard(dto);
            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber) {
        try {
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return DeleteBoardResponseDto.notExistedBoard();

            boardRepository.delete(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAllBoardsResponseDto> getAllBoards() {
        List<BoardEntity> boards = null;
        try {
            boards = boardRepository.findAll();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetAllBoardsResponseDto.success(boards);
    }
}