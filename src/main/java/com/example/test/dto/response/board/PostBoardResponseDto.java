package com.example.test.dto.response.board;

import com.example.test.common.ResponseCode;
import com.example.test.common.ResponseMessage;
import com.example.test.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostBoardResponseDto extends ResponseDto {

    private PostBoardResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostBoardResponseDto> success(){
        PostBoardResponseDto responseBody = new PostBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}