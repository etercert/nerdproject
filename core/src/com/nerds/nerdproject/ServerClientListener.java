package com.nerds.nerdproject;

/**
 * Created by michal on 16.04.17.
 */


public interface ServerClientListener {
    void onRegSucces();
    void onRegFail(String reason);
    void onNameSuggestion(String suggestion);
    void onPlayer2Move(PlayerMove move);
    void onConnectionLost();
    void onGameSessionStart(String player2Name);
    void onGameSessionStop(String reason);
    void onPlayer2Unavailable();
    void onConnectionError();
    void onConnected();
}
