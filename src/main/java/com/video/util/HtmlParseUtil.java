package com.video.util;

import com.video.bean.BaseBookSentenceBean;
import com.video.bean.BaseBookWordBean;
import com.video.controller.WordController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.AbstractDocument;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {
    private static Logger logger = LoggerFactory.getLogger(HtmlParseUtil.class);

    public static void main(String[] args) throws Exception {
//        new HtmlParseUtil().parseJD("西瓜");
    }

    public static List<BaseBookSentenceBean> parseJD(BaseBookWordBean words) throws Exception {
        List<BaseBookSentenceBean> list = new ArrayList<>();
        String word = words.getVcVocabulary();
        word = word.replaceAll("\\.", "");
        word = word.replaceAll("\\?", "");
        word = word.replaceAll("!", "");
        String url = "http://www.iciba.com/word?w="+word;
        Document document = Jsoup.parse((new URL(url)), 30000);
        if(document == null){
            return list;
        }
        Element element = document.getElementById("__next");
        if(element == null){
            return list;
        }
        Elements elements = element.getElementsByClass("SceneSentence_scene__1Dnz6").eq(0);

        if(elements != null && elements.size() > 0){
            Elements children = elements.get(0).children();
            if(children != null){
                for (int i = 0;i < children.size();i++) {
                    if(i == 0){
                       continue;
                    }
                    Elements ch = children.get(i).children();
                    if(ch != null && ch.size() == 3){
                        String text0 = ch.get(0).getElementsByTag("span").text();
                        String text1 = ch.get(0).getElementsByTag("span").html();
                        String text2 = ch.get(1).text();
                        String text3 = ch.get(2).text();
                        list.add(new BaseBookSentenceBean(VideoUtils.getUUID(),words.getVcId(),text0,text1,text2,text3));
                    }
                }
            }
        }
        return list;
    }





    /*public static List<BaseBookSentenceBean> parseJD(BaseBookWordBean words) throws Exception {
        String word = words.getVcVocabulary().replaceAll(".", "")
                .replaceAll("\\?", "")
                .replaceAll("!", "");
//        String url = "https://search.jd.com/Search?keyword=" + URLDecoder.decode(keywords, "GBK");
//        String url = "http://word.iciba.com/?action=words&class=57&course=3";
        String url = "http://www.iciba.com/word?w="+word;
        // 解析网页.（Jsoup返回Document就是浏览器的Document对象）
        Document document = Jsoup.parse((new URL(url)), 30000);
//        Element element = document.getElementById("J_goodsList");
//        Element element = document.getElementById("word_list_1");
//        Elements elements = element.getElementsByTag("li");

        Element element = document.getElementById("__next");
        Elements elements = element.getElementsByClass("SceneSentence_scene__1Dnz6").eq(0);
        List<BaseBookSentenceBean> list = new ArrayList<BaseBookSentenceBean>();
        if(elements.size() > 0){
            Elements children = elements.get(0).children();
            if(children != null){
                for (int i = 0;i < children.size();i++) {
                    if(i != 0){
                        Elements ch = children.get(i).children();
                        if(ch != null && ch.size() == 3){
                            String text1 = ch.get(0).getElementsByTag("span").html();
                            String text2 = ch.get(1).text();
                            String text3 = ch.get(2).text();
                            list.add(new BaseBookSentenceBean(words.getVcId(),words.getVcId(),text1,text2,text3));
                        }
                    }
                }
            }
        }
        *//*for (Element el : elements) {

            String src = el.getElementsByTag("span").eq(0).text();


           *//**//*
           String src = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
           String price = el.getElementsByClass("p-price").eq(0).text();
            String name = el.getElementsByClass("p-name").eq(0).text();
            list.add(new Content(name, src, price));*//**//*
        }*//*
        return list;
    }*/
}
