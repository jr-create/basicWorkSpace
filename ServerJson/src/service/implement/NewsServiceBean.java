package service.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.News;
import service.NewsService;


public class NewsServiceBean  implements NewsService {
	/**
	 * 获取最新的视频资讯
	 * @return
	 */
	public List<News> getLastNews(){
		List<News> newes = new ArrayList<News>();
		newes.add(new News(100, "aaa", 20));
		newes.add(new News(45, "bbb", 10));
		newes.add(new News(89, "Android is good", 50));

		Collections.sort(newes,new NewsCom());
		return newes;
	}
}
