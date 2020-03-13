package chap06.board;

import java.util.HashMap;
import java.util.Map;

public class MemoryArticleDao implements ArticleDao
{
    private int articleNo = 0;
    
    private Map<Integer, Article> articleMap = new HashMap<Integer, Article>();
    
    public void insert(Article article)
    {
       System.out.println("MemoryArticleDao.insert() 호출");
       articleNo++;
       article.setId(articleNo);
       articleMap.put(articleNo, article);
        
    }
    
    public Article selectById(Integer id)
    {
        // TODO Auto-generated method stub
        return articleMap.get(id);
    }
    
}
