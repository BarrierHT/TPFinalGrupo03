package ar.edu.unju.edm.tpfinalgrupo03.models;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component

public class Movie {
	
    private Integer id;
	private String title;
	private String description;
	private LocalDate startingDate;
    private LocalDate finishingDate;
    private String movieType;
    private String room;
	private String fShowTime;
    private String sShowTime;
    private String tShowTime;
	private String cover; // imageURL
	private Boolean status = true;

	public Movie() {
	}

	public Movie(Integer id, String title, String description, LocalDate startingDate, LocalDate finishingDate,
			String movieType, String room, String fShowTime, String sShowTime, String tShowTime, String cover, Boolean status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startingDate = startingDate;
		this.finishingDate = finishingDate;
        this.movieType = movieType;
        this.room = room;
        this.fShowTime = fShowTime;
        this.sShowTime = sShowTime;
        this.tShowTime = tShowTime;
        this.cover = cover;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getFinishingDate() {
		return finishingDate;
	}

	public void setFinishingDate(LocalDate finishingDate) {
		this.finishingDate = finishingDate;
	}

    public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

    public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

    public String getfShowTime() {
		return fShowTime;
	}

	public void setFShowTime(String fShowTime) {
		this.fShowTime = fShowTime;
	}

    public String getSShowTime() {
		return sShowTime;
	}

	public void setSShowTime(String sShowTime) {
		this.sShowTime = sShowTime;
	}

    public String getTShowTime() {
		return tShowTime;
	}

	public void setTShowTime(String tShowTime) {
		this.tShowTime = tShowTime;
	}

    public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}