package sec03.brd01;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class ArticleVO {

	private int level;
	private int articleNO;
	private int parentNO;
	private String title;
	private String content;
	private String imageFilename;
	private String id;
	private Date writeDate;

	public ArticleVO() {
	}

	public ArticleVO(int level, int articleNO, int parentNO, String title, String content, String imageFilename,
			String id) {
		this.level = level;
		this.articleNO = articleNO;
		this.parentNO = parentNO;
		this.title = title;
		this.content = content;
		this.imageFilename = imageFilename;
		this.id = id;
	}

	// get setter
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArticleNO() {
		return articleNO;
	}

	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}

	public int getParentNO() {
		return parentNO;
	}

	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		try {
			this.imageFilename = URLEncoder.encode(imageFilename, "UTF-8"); // 파일 이름에 특수 문자가 있을경우 인코딩
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;

	}

}
