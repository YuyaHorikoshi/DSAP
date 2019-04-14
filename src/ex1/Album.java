package ex1;

import java.util.ArrayList;

public class Album {
	private String title;
	private String artist;
	private ArrayList<Music> aList = new ArrayList<Music>();

	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;

	}

	public ArrayList<Music> getMusicList() {
		return aList;

	}

	public void add(Music music) {
		aList.add(music);
	}

	public int getTotalTime() {
		int totalTime = 0;
		for (Music time : aList) {
			totalTime += time.getTime();
		}
		return totalTime;
	}

	public double getRating() {
		float aveRating = 0;
		for (Music rating : aList) {
			aveRating += rating.getRating();
		}
		return aveRating / aList.size();
	}

	public void play() {
		System.out.println("総再生時間："+getTotalTime());
		System.out.println("アルバム評価："+getRating());
		
		for (Music playNow : aList) {
			System.out.println("再生中:　" + playNow.getTitle()+"　by　"+playNow.getArtist()+"　"+playNow.getTime()+"sec"+".,　"+"Fav:"+getRating());
		}
		System.out.println("再生終了");
	}

	public String toString() {
		return "anAlbum"+"("+ getTitle()+",　"+getArtist()+",　"+aList.size()+",　"+getTotalTime()+",　"+getRating()+")"; 
	}

	public static void main(String[] args) {
		Album album = new Album("なんだこれくしょん", "きゃりーぱみゅぱみゅ");
		album.add(new Music("にんじゃばんばん", "きゃりーぱみゅぱみゅ", 246, 4));
		album.add(new Music("キミに100パーセント","きゃりーぱみゅぱみゅ",200,3));
		album.play();
		System.out.println(album);
	}

}
