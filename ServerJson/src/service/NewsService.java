package service;

import java.util.List;

import domain.News;


public interface NewsService {

	/**
	 * ��ȡ���µ���Ƶ��Ѷ
	 * @return
	 */
	public List<News> getLastNews();

}