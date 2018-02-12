package com.yoni.monopoly;

public class Monopoly {

    private final Engine engine;

    public Monopoly() {
        engine = new Engine();
    }


    public void run() {
        engine.run();
    }


    public static void main(String[] args) {
        Monopoly app = new Monopoly();
        app.run();
    }
}
