package com.game.mapper;

import com.game.vo.BoardInfoVO;

public interface BoardInfoMapper {
	BoardInfoVO selectBoardInfoList(BoardInfoVO board);
	int insertBoardInfo(BoardInfoVO board);
	int updateBoardInfo(BoardInfoVO board);
	int deleteBoardInfo(BoardInfoVO board);
}
