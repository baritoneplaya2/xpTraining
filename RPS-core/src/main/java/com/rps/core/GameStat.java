package com.rps.core;

public class GameStat {

    private int gameResultId;
    private Player player;
    private Result result;

    enum Result { WON, LOSS, TIE }

    public GameStat( GameResult gameResult, boolean playerOne ) {
        this.gameResultId = gameResult.getGameResultId();
        player = playerOne ? gameResult.getPlayer1() : gameResult.getPlayer2();

        Outcome outcome = gameResult.getOutcome();

        if( outcome == Outcome.TIE )
            result = Result.TIE;
        else if( (outcome == Outcome.P1_WINS && playerOne) || outcome == Outcome.P2_WINS && ! playerOne )
            result = Result.WON;
        else
            result = Result.LOSS;
    }

    public int getGameResultId() {
        return gameResultId;
    }

    public Player getPlayer() {
        return player;
    }

    public Result getResult() {
        return result;
    }
}
