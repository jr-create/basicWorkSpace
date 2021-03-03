package service;

import java.util.List;

import domain.News;


public interface NewsService {

	/**
	 * 获取最新的视频资讯
	 * @return
	 */
	public List<News> getLastNews();

}