package com.youtube.learncodedurgesh;

import javax.persistence.*;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;

	private String answerText;

	@ManyToOne
	@JoinColumn(name = "q_id")
	private Question q;

	public Answer() {
	}

	public Answer(String answerText) {
		this.answerText = answerText;
	}

	public int getaId() {
		return aId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
}
