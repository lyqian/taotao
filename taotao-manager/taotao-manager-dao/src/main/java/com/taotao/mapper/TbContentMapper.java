package com.taotao.mapper;

import java.util.List;

import com.taotao.pojo.TbContent;

public interface TbContentMapper {
 
	List<TbContent> findTbContentAll(long categoryId);
	void addTbContent(TbContent tbContent);
}