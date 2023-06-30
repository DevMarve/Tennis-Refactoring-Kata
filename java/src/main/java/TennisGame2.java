import java.util.Map;

public class TennisGame2 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private final Map<Integer, String> pointMapper = Map.of(
            0, "Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty"
    );

    public int P1point = 0;
    public int P2point = 0;
    public String P1res = "";
    public String P2res = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (isEven()) {
            score = getPoints(P1point) + "-All";
        }
        if (P1point == P2point && P1point >= 3) {
            score = "Deuce";
        }

        if (P1point > 0 && P2point == 0) {
            P1res = getPoints(P1point);
            P2res = "Love";
            score = P1res + "-" + "Love";
        }

        if (P2point > 0 && P1point == 0) {
            P1res = "Love";
            P2res = getPoints(P2point);
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P1point < 4) {
            P1res = getPoints(P1point);
            P2res = getPoints(P2point);
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            P1res = getPoints(P1point);
            P2res = getPoints(P2point);
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String getPoints(int points) {
        return pointMapper.get(points);
    }

    private boolean isEven() {
        return P1point == P2point && P1point < 4;
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (this.player1Name.equals(player))
            P1Score();
        else
            P2Score();
    }
}
