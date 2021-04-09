package com.test.board.service;

import com.test.board.mapper.BoardMapper;
import com.test.board.model.Board;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardService {

    @Resource
    BoardMapper boardMapper;

    public List<Board> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    public void updateBoard(int id, Board board) {
        boardMapper.updateBoard(id,board);
    }

    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }

}
