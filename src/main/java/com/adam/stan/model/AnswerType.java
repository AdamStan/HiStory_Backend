package com.adam.stan.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers_types")
public class AnswerType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "type")
	private String name;
	@OneToMany(mappedBy = "type")
	@JsonIgnore
	private Set<Answer> answers;

	public AnswerType() {
	}

	public AnswerType(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, answers, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AnswerType)) {
			return false;
		}
		AnswerType other = (AnswerType) obj;
		return Objects.equals(id, other.id) && Objects.equals(answers, other.answers)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "AnswerType [ID=" + id + ", name=" + name + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long iD) {
		id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

}
