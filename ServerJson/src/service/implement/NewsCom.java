package service.implement;

import domain.News;

import java.util.Comparator;

public class NewsCom implements Comparator<News> {


    @Override
    public int compare(News o1, News o2) {
        return -(o1.getId()-o2.getId()>0?1:0);//½µÐò
//        return o1.getId()-o2.getId()>0?0:-1;//ÉýÐò
    }
}
