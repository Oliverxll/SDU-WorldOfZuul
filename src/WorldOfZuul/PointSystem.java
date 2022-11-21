package WorldOfZuul;

public class PointSystem {
    int score = 0;

    //Increment score by one, and show score
    public int addPoint () {
        score++;

        System.out.println("Your score: " + score);
        return score;

    }
}
