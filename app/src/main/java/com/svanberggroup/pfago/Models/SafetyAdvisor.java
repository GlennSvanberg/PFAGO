package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

public class SafetyAdvisor {
    public enum Answer{
        Unknown(R.string.unknown),
        No(R.string.no),
        Yes(R.string.yes);

        public final int label;
        Answer(int label) {
            this.label = label;
        }
    };
    private Answer answer;
    private String name;

    public SafetyAdvisor(Answer answer, String name) {
        this.answer = answer;
        this.name = name;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
