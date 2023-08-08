package com.game.mapper;

import java.util.List;

import com.game.vo.GameInfoVO;

public interface GameInfoMapper {
	List<GameInfoVO> selectGameInfoList(GameInfoVO game);

}
