package com.leonardo.logparser.quake;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.leonardo.logparser.model.DeathType;
import com.leonardo.logparser.model.Game;
import com.leonardo.logparser.model.Player;
import com.leonardo.logparser.model.PlayerKD;

public class Display {

    private static final String SPACE = "    ";

    private static final String OPEN_BRACE = "{";

    private static final String CLOSE_BRACE = "}";

    private static final String DOUBLE_QUOTES = "\"";

    public static void printGames(final List<Game> games) {
        final Display display = new Display();
        display.showOverallData(games);
        System.out.println("");
        display.showGameData(games);
    }

    private void showOverallData(final List<Game> games) {
        System.out.println("Overall: " + OPEN_BRACE);

        final Map<String, Integer> killsByName = groupKills(games);
        for (final Entry<String, Integer> entry : killsByName.entrySet()) {
            System.out.println(SPACE + DOUBLE_QUOTES + entry.getKey() + DOUBLE_QUOTES + ": " + entry.getValue());
        }

        System.out.println(CLOSE_BRACE);
    }


    private Map<String, Integer> groupKills(List<Game> games) {
        final Map<String, Integer> kills = new HashMap<>();
        final List<Player> players = games.stream().map(Game::getPlayers).flatMap(List::stream).collect(toList());

        for (Player player : players) {
            final String name = player.getName();
            final Integer killsOnGame = player.getPlayerKD().getCountKill();

            if (!kills.containsKey(name)) {
                kills.put(name, 0);
            }

            // get old value and add to new value
            kills.put(name, kills.get(name) + killsOnGame);
        }

        return kills;
    }

    private void showGameData(final List<Game> games) {
        for (final Game game : games) {
            showGameInfo(game);
        }
    }

    private void showGameInfo(Game game) {

        System.out.println(game.getName() + ": " + OPEN_BRACE);


        int totalKills = 0;
        for (Player player : game.getPlayers()) {
            totalKills += player.getPlayerKD().getValidKills();
        }
        System.out.println(SPACE + "total_kills: " + totalKills + ";");


        final String players = game.getPlayers().stream().map(Player::getName).map(this::nameWithDoubleQuotes)
                .collect(joining(", "));
        System.out.println(SPACE + "players: [" + players + "]");


        System.out.println(SPACE + "Kills: " + OPEN_BRACE);
        final Iterator<Player> iterator = game.getPlayers().iterator();
        while (iterator.hasNext()) {
            final Player player = iterator.next();
            final PlayerKD playerKD = player.getPlayerKD();

            System.out.print(
                    SPACE + SPACE + DOUBLE_QUOTES + player.getName() + DOUBLE_QUOTES + ": " + playerKD.getCountKill());

            if (iterator.hasNext()) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println(SPACE + CLOSE_BRACE);


        System.out.println(SPACE + "kills_by_means: " + OPEN_BRACE);
        final Map<DeathType, Integer> countDeathTypes = groupDeathType(game);
        final Iterator<Entry<DeathType, Integer>> iteratorDeathType = countDeathTypes.entrySet().iterator();
        while (iteratorDeathType.hasNext()) {

            final Entry<DeathType, Integer> countDeathType = iteratorDeathType.next();
            final DeathType deathType = countDeathType.getKey();
            final Integer count = countDeathType.getValue();

            System.out.print(SPACE + SPACE + DOUBLE_QUOTES + deathType + DOUBLE_QUOTES + ": " + count);

            if (iteratorDeathType.hasNext()) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println(SPACE + CLOSE_BRACE);

        // end of Display
        System.out.println(CLOSE_BRACE);
    }

    private String nameWithDoubleQuotes(final String string) {
        return DOUBLE_QUOTES + string + DOUBLE_QUOTES;
    }


    private Map<DeathType, Integer> groupDeathType(final Game game) {

        final List<Player> players = game.getPlayers();
        final Map<DeathType, Integer> countDeathType = new HashMap<>();

        for (final Player player : players) {
            final Map<DeathType, Integer> playerCountByDeathTypes = player.getPlayerKD().getCountDeathType();

            for (final Entry<DeathType, Integer> entry : playerCountByDeathTypes.entrySet()) {
                final DeathType deathType = entry.getKey();
                final Integer deathsCount = entry.getValue();

                if (!countDeathType.containsKey(deathType)) {
                    countDeathType.put(deathType, 0);
                }
                countDeathType.put(deathType, countDeathType.get(deathType) + deathsCount);
            }
        }

        return countDeathType;
    }

}

