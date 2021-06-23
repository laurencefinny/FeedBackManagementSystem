package com.cognizant.entity;

import lombok.Data;

@Data
public class FeedbackQuestions {

	private int id;

	private String question;

	private String fb_type;

	private int tot_ans;

}