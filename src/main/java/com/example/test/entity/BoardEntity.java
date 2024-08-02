package com.example.test.entity;


import com.example.test.dto.request.PatchBoardRequestDto;
import com.example.test.dto.request.PostBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board")
@Table(name = "board")

public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNumber;

    private String title;
    private String content;

    public BoardEntity(PostBoardRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

    public void patchBoard(PatchBoardRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }


}
