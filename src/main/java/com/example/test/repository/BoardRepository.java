package com.example.test.repository;

import com.example.test.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    BoardEntity findByBoardNumber(Integer boardNumber);

//    @Query(
//            value=
//                    "SELECT " +
//                            "B.board_number AS boardNumber, " +
//                            "B.title AS title, " +
//                            "B.content AS content " +
//                            "FROM board AS B " +
//                            "WHERE board_Number = ?1 ",
//            nativeQuery = true
//    )
//    BoardEntity getBoard(Integer itemNumber);
}