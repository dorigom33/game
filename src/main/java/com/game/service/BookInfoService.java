package com.game.service;

import java.util.List;
import java.util.Map;

public interface BookInfoService {
	List<Map<String, String>> selectBookInfoList(Map<String, String> bookInfo);
	
	Map<String, String> selectBookInfo (String biNum);
	
	int insertBookInfo (Map<String, String> bookInfo);
	
	int updateBookInfo (Map<String, String> bookInfo);
	
	int deleteBookInfo (String biNum);

}
