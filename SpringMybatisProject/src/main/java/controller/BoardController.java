package controller;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import model.BoardDataBean;
import service.MybatisBoardDaoMysql;

@Controller
@RequestMapping("board/")
public class BoardController
{
    
    String ip;
    
    String boardid;
    
    @Autowired
    MybatisBoardDaoMysql dbPro;
    
    @ModelAttribute
    public void initProcess(HttpServletRequest request, HttpServletResponse arg1)
    {
        // TODO Auto-generated method stub
        System.out.println("=================initProcess");
        
        HttpSession session = request.getSession();
        ip = request.getRemoteAddr();
        
        if (request.getParameter("boardid") != null)
        {
            session.setAttribute("boardid", request.getParameter("boardid"));
            session.setAttribute("pageNum", 1);
        }
        
        boardid = (String) session.getAttribute("boardid");
        
        if (boardid == null)
        {
            boardid = "1";
            session.setAttribute("boardid", "1");
            
        }
        
    }
    
    // board/list -> board_list
    @RequestMapping("list")
    public String board_list(HttpServletRequest request)
    {
        
        System.out.println("=================board_list");
        HttpSession session = request.getSession();
        int pageSize = 3;

        int currentPage = 1;
        if (session.getAttribute("pageNum") == null)
        {
            session.setAttribute("pageNum", 1);
            System.out.println("currentPage " + currentPage);
        }
        try
        {
            currentPage = Integer.parseInt(request.getParameter("pageNum"));
            session.setAttribute("pageNum", currentPage);
            System.out.println("1 " + currentPage);
        }
        catch (Exception e)
        {
            
        }
        
        
        currentPage = (int) session.getAttribute("pageNum");
        
        
       
        String boardid = (String) session.getAttribute("boardid");
        
        int count = dbPro.getArticleCount(boardid);
        System.out.println("count : " + count);
        int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
        
        if (currentPage > pageCount)
        {
            currentPage = pageCount;
            session.setAttribute("pageNum", currentPage);
        }
        
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = startRow + pageSize - 1;
        // int endRow = currentPage pageSize;
        
        System.out.println(startRow + ":" + endRow + ":" + boardid);
        List li = dbPro.getArticles(startRow, endRow, boardid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int number = count - (currentPage - 1) * pageSize;
        
        int bottomLine = 3;
        
        int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
        int endPage = startPage + bottomLine - 1;
        if (endPage > pageCount) endPage = pageCount;
        
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("startRow", startRow);
        request.setAttribute("endRow", endRow);
        request.setAttribute("count", count);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("number", number);
        request.setAttribute("bottomLine", bottomLine);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageCount", pageCount);
        
        request.setAttribute("li", li);
        
        return "board/list";
    }
    
    // board/write
    @RequestMapping(value = "write", method = RequestMethod.GET)
    public String board_writeForm(@ModelAttribute("article") BoardDataBean article)
    {
        return "board/writeUploadForm";
    }
    /*
    @RequestMapping(value = "write", method = RequestMethod.POST)
    public String board_writePro(BoardDataBean article) throws Exception
    {
        article.setIp(ip);
        article.setBoardid(boardid);
        System.out.println(boardid + " ::: " + ip);
        dbPro.insertArticle(article);
        return "redirect:/board/list";
    }
    
*/    /*
     * int num = 0, ref = 1, re_step = 0, re_level =
     * 0;if(request.getParameter("num")!=null) { num =
     * Integer.parseInt(request.getParameter("num")); ref =
     * Integer.parseInt(request.getParameter("ref")); re_step =
     * Integer.parseInt(request.getParameter("re_step")); re_level =
     * Integer.parseInt(request.getParameter("re_level")); }
     * 
     * request.setAttribute("num",num);request.setAttribute("ref",ref);request.
     * setAttribute("re_step",re_step);request.setAttribute("re_level",re_level)
     * ;
     * 
     * return"board/writeUploadForm"; }
     */
    
    @RequestMapping(value = "write", method = RequestMethod.POST)
    public String board_writePro(MultipartHttpServletRequest multipart, BoardDataBean article) throws Exception
    {
        MultipartFile multi = multipart.getFile("uploadfile");
        
        String filename = multi.getOriginalFilename();
        
        if(filename != null && !filename.equals(""))
        {
            String uploadPatch = multipart.getRealPath("/")+"/uploadFile";
            System.out.println(uploadPatch);
            FileCopyUtils.copy(multi.getInputStream(), new FileOutputStream(uploadPatch + "/"+multi.getOriginalFilename()));
            
            article.setFilename(filename);
            article.setFilesize((int)multi.getSize());
        }
        else
        {
            article.setFilename("");
            article.setFilesize(0);
        }
        article.setIp(ip);
        article.setBoardid(boardid);
        dbPro.insertArticle(article);
        return "redirect:list";
    }
    
    @RequestMapping(value = "content")
    public String board_content(int num, Model m)
    {
        // TODO Auto-generated method stub
        /*
         * int num = Integer.parseInt(request.getParameter("num")); String
         * pageNum = request.getParameter("pageNum"); if (pageNum == null ||
         * pageNum.equals("")) { pageNum = "1"; }
         */
        BoardDataBean article = dbPro.getArticle(num);
        m.addAttribute("article", article);
        return "board/content";
    }
    
    @RequestMapping(value = "deleteForm")
    public String board_deleteForm(int num, Model m)
    {
        // TODO Auto-generated method stub
        
        m.addAttribute("num", num);
        
        return "board/deleteForm";
    }
    
    @RequestMapping(value = "deletePro", method = RequestMethod.POST)
    public String board_deletePro(int num, String passwd, Model m) throws Exception
    {
        int check = dbPro.deleteArticle(num, passwd);
        m.addAttribute("check", check);
        return "board/updatePro";
    }
    
    @RequestMapping(value = "updateForm")
    public String board_updateForm(int num, Model m)
    {
        
        BoardDataBean article = dbPro.getUpdateArticle(num);
        
        m.addAttribute("article", article);
        
        return "board/updateForm";
    }
    
    @RequestMapping(value = "updatePro", method = RequestMethod.POST)
    public String board_updatePro(BoardDataBean article, Model m) throws Exception
    {
        
        System.out.println(article);
        int check = dbPro.updateArticle(article);
        System.out.println(check);
        m.addAttribute("check", check);
        
        return "board/updatePro";
    }
    
}