package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    // метод play
    public void numberHoursOfLost() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 4);
        player.play(game, 3);

        int expected = 7;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    //метод sumGenre
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game rayman = store.publishGame("Rayman", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);
        player.installGame(rayman);

        player.play(game, 3);
        player.play(rayman, 4);

        int expected = 7;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    //Runtime
    public void uninstalledGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> {
            player.play(game, 5);
        });
    }

}
