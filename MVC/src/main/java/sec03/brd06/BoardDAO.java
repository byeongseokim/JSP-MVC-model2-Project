package sec03.brd06;

import java.net.URLEncoder;
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
			String query = "WITH RECURSIVE board AS (" + " SELECT 1 AS LEVEL, t.* " + " FROM t_board t "
					+ " WHERE parentNO = 0 " + " UNION ALL " + " SELECT b.LEVEL + 1, t.* " + " FROM t_board t "
					+ " INNER JOIN board b ON t.parentNO = b.articleNO " + ")"
					+ " SELECT LEVEL, articleNO, parentNO, title, content, id, writeDate " + "FROM board "
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

	private int getNewArticleNO() {
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT MAX(articleNO) FROM t_board ";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if (rs.next())
				return (rs.getInt(1) + 1);
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertNewArticle(ArticleVO article) {
		int articleNO = getNewArticleNO();
		try {
			conn = dataFactory.getConnection();
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			String imageFileName = article.getImageFileName();
			String query = "INSERT INTO t_board (articleNO, parentNO, title, content, imageFileName, id)"
					+ " VALUES (?, ?, ?, ?, ?, ?)"; // insert문을 이용해 글 정보를 추가함.
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleNO;
	}

	public ArticleVO selectArticle(int articleNO) {
		ArticleVO article = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNO, parentNO, title, content, imageFileName, id, writeDate" + " from t_board"
					+ " where articleNO=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = URLEncoder.encode(rs.getString("imageFileName"), "UTF-8");
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");

			article.setArticleNO(_articleNO);
			article.setParentNO(parentNO);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public void updateArticle(ArticleVO article) {
		int articleNO = article.getArticleNO();
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		try {
			conn = dataFactory.getConnection();
			String query = "update t_board set title=?,content=?";
			if (imageFileName != null && imageFileName.length() != 0) {
				query += ",imageFileName=?";
			}
			query += " where articleNO = ?";

			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			if (imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNO);
			} else {
				pstmt.setInt(3, articleNO);
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	public void deleteArticle(int articleNO) {
	    try {
	        conn = dataFactory.getConnection();
	        String query = "DELETE FROM t_board " +
	                "WHERE articleNO IN (" +
	                "   WITH RECURSIVE board AS (" +
	                "       SELECT b.*" +
	                "       FROM t_board b WHERE b.articleNo = ?" +
	                "       UNION ALL" +
	                "       SELECT b.*" +
	                "       FROM board l INNER JOIN t_board b ON l.articleNo = b.parentNO" +
	                "   )" +
	                "   SELECT articleNo FROM board" +
	                ")";
	        System.out.println(query);
	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, articleNO);
	        pstmt.executeUpdate();
	        pstmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public List<Integer> selectRemovedArticles(int articleNO) {
	    List<Integer> articleNOList = new ArrayList<Integer>();
	    try {
	        conn = dataFactory.getConnection();
	        String query = "WITH RECURSIVE board AS (" +
	                "   SELECT b.*" +
	                "   FROM t_board b WHERE b.articleNo = ?" +
	                "   UNION ALL" +
	                "   SELECT b.*" +
	                "   FROM board l INNER JOIN t_board b ON l.articleNo = b.parentNO" +
	                ") " +
	                "SELECT articleNo FROM board";
	        System.out.println(query);
	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, articleNO);
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            articleNO = rs.getInt("articleNo");
	            articleNOList.add(articleNO);
	        }
	        pstmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return articleNOList;
	}
}