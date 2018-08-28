package com.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Override
	public EasyUIDataGridResult findContentAll(long categoryId) {
		
		List<TbContent> contents = tbContentMapper.findTbContentAll(categoryId);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		//这里就是总记录条数
		result.setTotal(contents.size());
		//加入结果集
		result.setRows(contents);	
		
		return result;
	}

	@Override
	public TaotaoResult addContent(TbContent tbContent) {
		Date date = new Date();
		tbContent.setCreated(date);
		tbContent.setUpdated(date);
		
		tbContentMapper.addTbContent(tbContent);
		
		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> getTbContent(long categoryId) {
		List<TbContent> result = tbContentMapper.findTbContentAll(categoryId);
		
		return result;
	}

}
