package com.test.board.controller;

import com.test.board.model.Board;
import com.test.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    @Resource
    BoardService boardService;

    //리스트
    @GetMapping("/board")
    public List<Board> openBoardList() throws Exception {
        return boardService.selectBoardList();
    }

    //쓰기
    @PostMapping("/board")
    public void insertBoard(@RequestBody Board board) throws Exception{
        boardService.insertBoard(board);
    }

    //수정
    @PutMapping("/board/{id}")
    public void updateBoard(@PathVariable("id") int id, @RequestBody Board board) throws Exception {
        boardService.updateBoard(id,board);
    }

    //삭제
    @DeleteMapping("/board/{id}")
    public void deleteBoard(@PathVariable("id") int id) throws Exception {
        boardService.deleteBoard(id);
    }

}
