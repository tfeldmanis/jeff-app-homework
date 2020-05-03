package jeff.app.homework.engine.chat;

import java.time.LocalDate;

public class TestingPojo {
	private String text;
	private String email;
	private LocalDate date;
	private String singleChoice;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSingleChoice() {
		return singleChoice;
	}

	public void setSingleChoice(String singleChoice) {
		this.singleChoice = singleChoice;
	}

}
