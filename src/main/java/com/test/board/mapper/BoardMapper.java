package com.test.board.mapper;

import com.test.board.model.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT ID" +
           "      , TITLE" +
           "      , CONTENT" +
           "   FROM BOARD")
    List<Board> selectBoardList();

    @Insert("INSERT INTO BOARD VALUES(" +
            "#{board.id}, " +
            "#{board.title}, " +
            "#{board.content} " +
            ")")
    public void insertBoard(@Param("board") Board board);

    @Update({
            "<script>",
            "UPDATE BOARD",
            "<set>",
            "<if test='#{board.title} != null'>TITLE = #{board.title},</if>",
            "<if test='#{board.content} != null'>CONTENT = #{board.content}</if>",
            "</set>",
            "WHERE ID = #{id}",
            "</script>"
    })
    public void updateBoard(@Param("id") int id, @Param ("board") Board board);

    @Delete ("DELETE FROM BOARD WHERE ID = #{id}")
    public void deleteBoard(@Param("id") int id);


}
