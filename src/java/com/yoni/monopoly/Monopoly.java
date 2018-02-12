package com.yoni.monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monopoly {

    private final Engine engine;

    public Monopoly() {
        engine = new Engine();
    }


    public void run() {
        System.out.println("Game started");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean terminated = false;
        String line = null;
        do {
            try {
                line = reader.readLine();
                terminated = line == null || line.equals("quit");

                if (!terminated) {
                    engine.run();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!terminated);

        System.out.println("Exited...");
    }


    public static void main(String[] args) {
        Monopoly app = new Monopoly();
        app.run();
    }
}
