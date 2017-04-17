package com.nerds.nerdproject;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


/**
 * Created by michal on 16.04.17.
 */

public class ServerClient {
    private Socket socket;
    private ServerClientListener listener;

    private static URI url = URI.create("http://localhost:8080");

    public void setListener(ServerClientListener listener){
        this.listener = listener;
    }

    public String getConnectionState() {
        return "";
    }

    public String getGameSessionState() {
        return "";
    }

    public void connect() {
        this.socket.connect();
    }

    public void getNameSuggestion(String name) {
        socket.emit("getSuggestion", name);
    }

    public ServerClient() {
        this.socket = IO.socket(url);

        this.socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args){
                listener.onConnected();
            }
        });

        this.socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                listener.onConnectionError();
                }
        });

        this.socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                listener.onConnectionError();
            }
        });

        this.socket.on("regSuccess", new Emitter.Listener() {
            @Override
            public void call(Object... args){
                listener.onRegSucces();
            }
        });

        this.socket.on("regFail", new Emitter.Listener() {
            @Override
            public void call(Object... args){
                String reason = "";
                try {
                    JSONObject obj = (JSONObject) args[0];
                    reason = obj.getString("reason");
                } catch (JSONException e) {

                }
                listener.onRegFail(reason);
            }
        });

        this.socket.on("nameSuggestion", new Emitter.Listener() {
            @Override
            public void call(Object... args){
                String name = "";
                try {
                    JSONObject obj = (JSONObject) args[0];
                    name = obj.getString("suggestedName");
                } catch (JSONException e) {

                }
                listener.onNameSuggestion(name);
            }
        });

        this.socket.on("m", new Emitter.Listener() {
            @Override
            public void call(Object... args){
                int x = -1;
                int y = -1;
                double time = -1;
                double duration = -1;
                try {
                    JSONObject obj = (JSONObject) args[0];
                    x = obj.getInt("x");
                    y = obj.getInt("y");
                    time = obj.getDouble("t");
                    duration = obj.getDouble("d");
                } catch (JSONException e){

                }

                listener.onPlayer2Move(new PlayerMove(x, y, duration, time));
            }
        });

        this.socket.on("sessionStart", new Emitter.Listener() {
            @Override
            public void call(Object... args){
                String player2Name = "";
                try {
                    JSONObject obj = (JSONObject) args[0];
                    player2Name = obj.getString("player2Name");
                } catch (JSONException e) {

                }

                listener.onGameSessionStart(player2Name);
            }
        });

        this.socket.on("sessionStop", new Emitter.Listener() {
            @Override
            public void call(Object... args){
                String reason = "";
                try {
                    JSONObject obj = (JSONObject) args[0];
                    reason = obj.getString("reason");
                } catch (JSONException e) {

                }
                listener.onGameSessionStop(reason);
            }
        });

        this.socket.on("player2Unavailable", new Emitter.Listener() {
            @Override
            public void call(Object... args){
                listener.onPlayer2Unavailable();
            }
        });

        this.socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args){
                listener.onConnectionLost();
            }
        });


    }

    public void findPlayer2(String name){
        socket.emit("challengePlayer", name);
    }

    public void findPlayer2(){
        socket.emit("findChallenge");
    }

    public void registerName(String name){
        socket.emit("registerName", name);
    }

    public void sendMove(PlayerMove move){
        int x = move.x;
        int y = move.y;
        double duration = move.duration;
        double time = move.time;
        JSONObject req = new JSONObject();
        try {
            req.put("x", x);
            req.put("y", y);
            req.put("t", time);
            req.put("d", duration);
        } catch (JSONException e) {}
        socket.emit("m", req);
    }
}
