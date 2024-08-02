package com.example.test.dto.response.board;

import com.example.test.common.ResponseCode;
import com.example.test.common.ResponseMessage;
import com.example.test.dto.response.ResponseDto;
import com.example.test.entity.BoardEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetAllBoardsResponseDto  extends ResponseDto  {
    private List<BoardEntity> boards;

    public GetAllBoardsResponseDto(List<BoardEntity> boards){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.boards = boards;
    }
    public static ResponseEntity<GetAllBoardsResponseDto> success(List<BoardEntity> boards){
        GetAllBoardsResponseDto responseBody = new GetAllBoardsResponseDto(boards);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
