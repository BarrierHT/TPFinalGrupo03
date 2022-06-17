package ar.edu.unju.edm.tpfinalgrupo03.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private LocalDate startingDate;
	private LocalDate finishingDate;
	private String movieType;
	private String room;
	private String firstShowTime;
	private String secondShowTime;
	private String thirdShowTime;
	private String cover; // imageURL
	private Boolean status = true;

	public Movie() {
	}

	public Movie(Integer id, String title, String description, LocalDate startingDate, LocalDate finishingDate,
			String movieType, String room, String firstShowTime, String secondShowTime, String thirdShowTime,
			String cover,
			Boolean status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startingDate = startingDate;
		this.finishingDate = finishingDate;
		this.movieType = movieType;
		this.room = room;
		this.firstShowTime = firstShowTime;
		this.secondShowTime = secondShowTime;
		this.thirdShowTime = thirdShowTime;
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

	public String getFirstShowTime() {
		return firstShowTime;
	}

	public void setFirstShowTime(String firstShowTime) {
		this.firstShowTime = firstShowTime;
	}

	public String getSecondShowTime() {
		return secondShowTime;
	}

	public void setSecondShowTime(String secondShowTime) {
		this.secondShowTime = secondShowTime;
	}

	public String getThirdShowTime() {
		return thirdShowTime;
	}

	public void setThirdShowTime(String thirdShowTime) {
		this.thirdShowTime = thirdShowTime;
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