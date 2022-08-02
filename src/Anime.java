import java.time.LocalDate;
import java.util.Objects;

public class Anime {
	private final String title;
	private final float rating;
	private final Genre genre;
	private final LocalDate releasedDate;

	public Anime(String title, float rating, Genre genre, LocalDate releasedDate) {
		this.title = title;
		this.genre = genre;
		this.releasedDate = releasedDate;
		if (rating >= 0 && rating <= 5) {
			this.rating = rating;
		} else {
			throw new IllegalArgumentException("【レイティングが5以下になければなりません】");
		}	
	}

	public String getTitle() {
		return title;
	}

	public float getRating() {
		if(rating >= 0 && rating <= 5) {
			return rating;
		}
		else {
			throw new IllegalArgumentException("【レイティングが5以下になければなりません】");
		}
	}

	public Genre getGenre() {
		return genre;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, rating, releasedDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anime other = (Anime) obj;
		return genre == other.genre && Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating)
				&& Objects.equals(releasedDate, other.releasedDate) && Objects.equals(title, other.title);
	}

}
