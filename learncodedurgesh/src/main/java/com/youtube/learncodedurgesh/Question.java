package com.youtube.learncodedurgesh;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qId;
	private String questionText;

	@OneToMany(mappedBy = "q", fetch = FetchType.LAZY)
	private List<Answer> answers;

//	public List<Answer> getAnswers() {
//		return answers;
//	}
//
//	public void setAnswers(List<Answer> answers) {
//		this.answers = answers;
//	}

	public Question() {
	}

	public Question(String questionText) {
		this.questionText = questionText;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
}
