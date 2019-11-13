package com.cos.util;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import com.cos.model.Board;

public class Utils {
	public static List<Board> getPreviewCotent(List<Board> boards) {
		for (Board board : boards) {
			String content = board.getContent();
			Document doc = Jsoup.parse(content);
			content = doc.select("p").text();
			if (content.length() >= 85) {
				content = content.substring(0, 85) + " ...";
			}
			board.setContent(content);
		}
		return boards;
	}

	// 미리보기 이미지 가져오기
	public static void getpreviewImage(List<Board> boards) {
		for (Board board : boards) {
	         Document doc = Jsoup.parse(board.getContent());
	         Elements etyoutube = doc.select("a");
	         Element et = doc.selectFirst("img");
	         String thumbnail = "";
	         if (etyoutube != null) {
	            for (Element element : etyoutube) {
	               String href = element.attr("href");
	               if (href.contains("https://www.youtube.com/watch") && !element.text().equals("")) {
	                  String video[] = href.split("=");
	                  String v = video[1];
	                  thumbnail = "http://i.ytimg.com/vi/" + v + "/0.jpg";
	                  board.setPreviewImage(thumbnail);
	                  break;
	               }
	            }
	         }
	         if (thumbnail.equals("")) {
	            if (et != null) {
	               String previewImg = et.attr("src");// 이미지 소스 찾기
	               board.setPreviewImage(previewImg);
	            } else {
	               board.setPreviewImage("/blog/img/home-blog/blog-1.jpg");
	            }
	         }
	      }
	}
	
	public static void setTest(Board board) {
		
	}
	
	
	public static void setPreviewYoutube(Board board) {
		String content = board.getContent();
		Document doc = Jsoup.parse(content);
		Elements ets = doc.select("a");
		if (ets != null) {
			for (Element et : ets) {
				String href = et.attr("href");
				String value = et.text();
				if (href.contains("https://www.youtube.com/watch") && !value.equals("")) {
					String[] video = href.split("=");
					String v = video[1]; // 배열로 저장 -> 리턴
					String iframe = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/" + v
							+ "\" frameborder=\"0\" allowfullscreen />";
					et.after(iframe);
				}
			}
			board.setContent(doc.toString());
		}
	}

	@Test
	public void previewYoutubeTest() {
		String content = "<a href='https://www.youtube.com/watch?v=u0cLvvGobGE'>https://www.youtube.com/watch?v=u0cLvvGobGE</a>";
		Document doc = Jsoup.parse(content);
		Elements ets = doc.select("a");
		if (ets != null) {
			for (Element et : ets) {
				String href = et.attr("href");
				if (href.contains("https://www.youtube.com/watch")) {
					String[] video = href.split("=");
					String v = video[1];
					String iframe = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/" + v
							+ "\" frameborder=\"0\" allowfullscreen />";
					et.after(iframe);
					System.out.println(doc);
				}
			}
		}
	}
}
