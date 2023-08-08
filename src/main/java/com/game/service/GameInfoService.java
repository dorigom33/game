package com.game.service;

import java.util.List;

import com.game.vo.GameInfoVO;

public interface GameInfoService {
	List<GameInfoVO> selectGameInfoList(GameInfoVO game);
}
