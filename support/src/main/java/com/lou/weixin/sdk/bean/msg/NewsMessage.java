package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.bean.WxArticle;
import com.lou.weixin.sdk.constants.MsgType;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class NewsMessage extends WxMessage {

    private static final long serialVersionUID = 2580968407840940731L;

    private List<WxArticle> articles = new ArrayList<WxArticle>();

    public NewsMessage() {
        this.setMsgType(MsgType.news);
    }

    public List<WxArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<WxArticle> articles) {
        this.articles = articles;
    }

    public void addArticle(WxArticle article) {
        this.articles.add(article);
    }

    @Override
    public void fromXmlNode(Element element) {
    }

    @Override
    public void toXmlNode(Element element) {
        element.addElement("ArticleCount").addText(String.valueOf(articles.size()));
        element.addText("\n");
        Element articleElements = element.addElement("Articles");
        element.addText("\n");
        articleElements.addText("\n");
        for (WxArticle article : articles) {
            article.toXmlNode(articleElements);
        }
        element.addText("\n");
    }
}
