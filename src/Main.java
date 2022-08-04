import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Anime> animes = List.of(
				new Anime("ドクターストーン", 5, Genre.ACTION, LocalDate.of(2012, 2, 6)),
				new Anime("進撃の巨人", 4.5F, Genre.ACTION, LocalDate.of(2011, 1, 5)),
				new Anime("ホリミヤ", 5, Genre.ROMANCE, LocalDate.of(2021, 2, 26)),
				new Anime("その 着せ替え人形 ビスク・ドール は恋をする", 5, Genre.ROMANCE, LocalDate.of(2021, 10, 9)),
				new Anime("日常", 3, Genre.COMEDY, LocalDate.of(2020, 12, 6)),
				new Anime("銀魂", 3.5F, Genre.COMEDY, LocalDate.of(2006, 4, 15)),
				new Anime("Haikyuu", 4, Genre.SPORT, LocalDate.of(2014, 4, 9)),
				new Anime("Haikyuu Season 2", 4.5F, Genre.SPORT, LocalDate.of(2015, 12, 3)));
	}

}
