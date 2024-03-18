package org.example;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.concurrent.Exchanger;

public class Main {
    private static final Exchanger<Action> EXCHANGER = new Exchanger<>();
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    private static List<Action> getListActionOf10() {
        List<Action> actionList = new ArrayList<>();
        Action[] actions = Action.values();

        for (int i = 0; i < 10; i++) {
            actionList.add(actions[RANDOM.nextInt(actions.length)]);
        }
        return actionList;
    }

    private static Set<Player> playersCreate(int count) {
        Set<Player> players = new HashSet<>();
        for (int i = 0; i < count; i++) {
            players.add(new Player(FAKER.name().name(), EXCHANGER, getListActionOf10()));
        }
        return players;
    }

    private static void playGames(List<Team> teams) {
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                player.start();
            }
        }
    }

    private static void gameIsOver(List<Team> teams) {
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                try {
                    player.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Map<Team, Double> calculateScores(List<Team> teams) {
        Map<Team, Double> scores = new HashMap<>();
        for (Team team : teams) {
            double teamScore = 0;
            for (Player player : team.getPlayers()) {
                teamScore += player.getScore();
            }
            scores.put(team, teamScore);
        }
        return scores;
    }

    private static Team determineWinner(Map<Team, Double> scores) {
        return Collections.max(scores.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            teams.add(new Team(FAKER.funnyName().name(), playersCreate(3)));
        }

        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Команда " + (i + 1) + ":");
            Team team = teams.get(i);
            for (Player player : team.getPlayers()) {
                System.out.println("Имя игрока: " + player.getName());
                System.out.println();
            }
        }
        Map<Team, Double> scores = calculateScores(teams);
        playGames(teams);
        gameIsOver(teams);
        Team winner = determineWinner(scores);
        System.out.println("Победитель: " + winner.getName());
    }

    enum Action {
        SCISSORS,
        STONE,
        PAPER
    }

    static class Player extends Thread {
        private String name;
        private Exchanger<Action> exchanger;
        private List<Action> actionList;
        private double score;

        public Player(String name, Exchanger<Action> exchanger, List<Action> actionList) {
            this.name = name;
            this.exchanger = exchanger;
            this.actionList = actionList;
            this.score = 0;
        }

        private void getWinner(Action p1, Action p2) {
            if (p1 == Action.PAPER && p2 == Action.STONE ||
                    p1 == Action.SCISSORS && p2 == Action.PAPER ||
                    p1 == Action.STONE && p2 == Action.SCISSORS) {
                score += 1;
            } else if (p1 == p2) {
                score += 0.5;
            }
        }

        @Override
        public void run() {
            Action get;
            for (Action action : actionList) {
                try {
                    Thread.sleep(1234);
                    get = exchanger.exchange(action);
                    getWinner(action, get);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public double getScore() {
            return score;
        }
    }

    static class Team {
        private String name;
        private Set<Player> players;

        public Team(String name, Set<Player> players) {
            this.name = name;
            this.players = players;
        }

        public String getName() {
            return name;
        }

        public Set<Player> getPlayers() {
            return players;
        }
    }
}
