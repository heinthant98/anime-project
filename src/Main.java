import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		 List<Anime> animes = List.of(new Anime("ドクターストーン", 5, Genre.ACTION, LocalDate.of(2012, 2, 6)),
				 	　　　new Anime("進撃の巨人", 4.5F, Genre.ACTION, LocalDate.of(2011, 1, 5)),
				 	　　　new Anime("ホリミヤ", 5, Genre.ROMANCE, LocalDate.of(2021, 2, 26)),
				 	　　　new Anime("その 着せ替え人形 ビスク・ドール は恋をする", 5, Genre.ROMANCE, LocalDate.of(2021, 10, 9)),
				 	　　　new Anime("日常", 3, Genre.COMEDY, LocalDate.of(2020, 12, 6)),
				 	　　　new Anime("銀魂", 3.5F, Genre.COMEDY, LocalDate.of(2006, 4, 15)),
				 	　　　new Anime("Haikyuu", 4, Genre.SPORT, LocalDate.of(2014, 4, 9)),
					　　　new Anime("Haikyuu Season 2", 4.5F, Genre.SPORT, LocalDate.of(2015, 12, 3)));

		Map<Genre, List<Anime>> genreMap = new HashMap<>();
		genreMap.putAll(animes.stream().collect(Collectors.groupingBy(Anime::getGenre)));
		
		System.out.println(" 【すべてのアニメを表示する】");
		animes.forEach(a -> System.out.println("Title: %s, Genre: %s, Rating: %s, Release_Date: %s"
							.formatted(a.getTitle(), a.getGenre(), a.getRating(), toJapaneseFormat(a.getReleasedDate()))));

		System.out.println("【コメデイアニメを表示する(%d)】".formatted(sameGenreAnimesCount(animes, Genre.COMEDY)));
		animes.stream()
			  .filter(a -> a.getGenre().equals(Genre.COMEDY))
			  .forEach(a -> System.out.println("Title: %s, Genre: %s, Rating: %s, Release_Date: %s"
							.formatted(a.getTitle(), a.getGenre(), a.getRating(), toJapaneseFormat(a.getReleasedDate()))));

		System.out.println("【ジャンルに沿ってアニメを表示する】");
		genreMap.keySet().stream().forEach(g ->{
			System.out.println("%s(%d)".formatted(g, sameGenreAnimesCount(animes, g)));
			genreMap.get(g).stream()
							.forEach(a -> System.out.println("Title: %s, Genre: %s, Rating: %s, Release_Date: %s"
										  .formatted(a.getTitle(), a.getGenre(), a.getRating(), toJapaneseFormat(a.getReleasedDate()))));
		});
		
		System.out.println("【ジャンルに沿ってアニメをジャンルの昇順に並び替えて表示する】");
		genreMap.keySet().stream().sorted().forEach(g ->{
			System.out.println("%s(%d)".formatted(g, sameGenreAnimesCount(animes, g)));
			genreMap.get(g).stream()
							.forEach(a -> System.out.println("Title: %s, Genre: %s, Rating: %s, Release_Date: %s"
										  .formatted(a.getTitle(), a.getGenre(), a.getRating(), toJapaneseFormat(a.getReleasedDate()))));
		});
		
		System.out.println("【レイティングが一番高いアニメ一覧を表示する】");
		animes.stream().filter(a -> a.getRating() == getMaxRating(animes))
				.forEach(a -> System.out.println("Title: %s, Genre: %s, Rating: %s, Release_Date: %s"
							  .formatted(a.getTitle(), a.getGenre(), a.getRating(), toJapaneseFormat(a.getReleasedDate()))));
	}

	private static int sameGenreAnimesCount(List<Anime> animes, Genre genre) {
		if(0 < animes.size() && null != genre) {
			return animes.stream().filter(a -> a.getGenre().equals(genre)).toList().size();
		} else {
			throw new IllegalArgumentException("Animes or Genre must have data.");
		}
	}

	private static float getMaxRating(List<Anime> animes) {
		return animes.stream().max(Comparator.comparing(Anime::getRating)).get().getRating();
	}

	private static String toJapaneseFormat(LocalDate releasedDate) {
		if(null != releasedDate) {
			return releasedDate.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
		} else {
			throw new DateTimeException("ReleaseDate cannot be null.");
		}
	}

}
