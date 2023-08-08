package com.game.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.GameInfoMapper;
import com.game.service.GameInfoService;
import com.game.vo.GameInfoVO;

public class GameInfoServiceImpl implements GameInfoService {
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<GameInfoVO> selectGameInfoList(GameInfoVO game) {
		try(SqlSession session = ssf.openSession()){
			GameInfoMapper giMapper = session.getMapper(GameInfoMapper.class);
			return giMapper.selectGameInfoList(game);
		}
	}

}
