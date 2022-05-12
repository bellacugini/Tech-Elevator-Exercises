package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        if (((1.0 * earnedMarks / possibleMarks) * 100) >= 90.0) {
            return "A";
        } else if (((1.0 * earnedMarks / possibleMarks) * 100) >= 80.0) {
            return "B";
        } else if (((1.0 * earnedMarks / possibleMarks) * 100) >= 70.0) {
            return "C";
        } else if (((1.0 * earnedMarks / possibleMarks) * 100) >= 60.0) {
            return "D";
        } else {
            return "F";
        }
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

}
