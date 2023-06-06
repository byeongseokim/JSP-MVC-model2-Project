package sec03.brd01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/mariadb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ArticleVO> selectAllArticles() {
	    List<ArticleVO> articleList = new ArrayList<ArticleVO>();
	    try {
	        conn = dataFactory.getConnection();
	        String query = "WITH RECURSIVE board AS ("
	            + " SELECT 1 AS LEVEL, t.* "
	            + " FROM t_board t "
	            + " WHERE parentNO = 0 "
	            + " UNION ALL "
	            + " SELECT b.LEVEL + 1, t.* "
	            + " FROM t_board t "
	            + " INNER JOIN board b ON t.parentNO = b.articleNO "
	            + ")"
	            + " SELECT LEVEL, articleNO, parentNO, title, content, id, writeDate "
	            + "FROM board "
	            + "ORDER BY parentNO, articleNO DESC;";

	        pstmt = conn.prepareStatement(query);
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int level = rs.getInt("level");
	            int articleNO = rs.getInt("articleNO");
	            int parentNO = rs.getInt("parentNO");
	            String title = rs.getString("title");
	            String content = rs.getString("content");
	            String id = rs.getString("id");
	            Date writeDate = rs.getDate("writeDate");
	            ArticleVO article = new ArticleVO();
	            article.setLevel(level);
	            article.setArticleNO(articleNO);
	            article.setParentNO(parentNO);
	            article.setTitle(title);
	            article.setContent(content);
	            article.setId(id);
	            article.setWriteDate(writeDate);
	            articleList.add(article);
	        }
	        rs.close();
	        pstmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return articleList;
	}
}
