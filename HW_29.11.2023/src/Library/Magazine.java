package Library;
import java.time.LocalDate;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private LocalDate releaseDate;
    private boolean isMonthly;
    private String title;

    public Magazine(String title, String author, Genre genre, int issueNumber, LocalDate releaseDate, boolean isMonthly) {
        super(title, author, genre);
        this.issueNumber = issueNumber;
        this.releaseDate = releaseDate;
        this.isMonthly = isMonthly;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    public String getTitle() {
        return title;
    }

}
