public class FlashCard {
    private String question;
    private String answer;
    private int difficulty;

    public FlashCard(String question, String answer, int difficulty ){
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;

        
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDifficulty(int difficulty) {
        if(difficulty > 5 || difficulty < 1){
            this.difficulty = 0;
        }
        else {
            this.difficulty = difficulty;
        }
        
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void reverseCard(){
        String temp = answer;
        answer = question;
        question = temp;
    }

    public boolean equals(FlashCard other){
        if(other.question.equalsIgnoreCase(this.question) && other.answer.equalsIgnoreCase(this.answer)){
            return true;
        }
        return false;
    }

    public String toString(){
        String str;
        str = question + "-" + answer + ":" + difficulty+ "\n";
        return str;
    }

    public void showFlashCardQuestion(){
        for (int i = 0; i < 10 + question.length() ; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int k = 0; k < 3; k++) {
            System.out.print("*");
            for (int i = 0; i < 8 + question.length(); i++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        System.out.println("*    " + question + "    *");

        for (int k = 0; k < 3; k++) {
            System.out.print("*");
            for (int i = 0; i < 8 + question.length(); i++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 0; i < 10 + question.length() ; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void showFlashCardAnswer(){
        for (int i = 0; i < 10 + answer.length() ; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int k = 0; k < 3; k++) {
            System.out.print("*");
            for (int i = 0; i < 8 + answer.length(); i++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        System.out.println("*    " + answer + "    *");

        for (int k = 0; k < 3; k++) {
            System.out.print("*");
            for (int i = 0; i < 8 + answer.length(); i++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 0; i < 10 + answer.length() ; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

