package com.example.test.dto.response.board;


import com.example.test.common.ResponseCode;
import com.example.test.common.ResponseMessage;
import com.example.test.dto.response.ResponseDto;
import com.example.test.entity.BoardEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetBoardResponseDto extends ResponseDto {
//    private Long boardNumber;
//    private String title;
//    private String content;
    BoardEntity board;

    public GetBoardResponseDto(BoardEntity resultSet){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
//        this.boardNumber = resultSet.getBoardNumber();
//        this.title = resultSet.getTitle();
//        this.content = resultSet.getContent();
        this.board = resultSet;
    }
    public static ResponseEntity<GetBoardResponseDto> success(BoardEntity resultSet){
        GetBoardResponseDto responseBody = new GetBoardResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistBoard(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
