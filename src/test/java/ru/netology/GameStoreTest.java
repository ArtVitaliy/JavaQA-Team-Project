package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void testPublishGameBorderLastValue() {

        GameStore store = new GameStore();

        Game game1 = store.publishGame("Игра1", "Стратегии");
        Game game2 = store.publishGame("Игра2", "Стратегии");
        Game game3 = store.publishGame("Игра3", "Аркады");
        Game game4 = store.publishGame("Игра4", "Аркады");

        boolean expected = true;
        boolean actual = store.containsGame(game4);
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void testPublishGameBorderFirstValue() {

        GameStore store = new GameStore();

        Game game1 = store.publishGame("Игра1", "Стратегии");
        Game game2 = store.publishGame("Игра2", "Стратегии");
        Game game3 = store.publishGame("Игра3", "Аркады");
        Game game4 = store.publishGame("Игра4", "Аркады");

        boolean expected = true;
        boolean actual = store.containsGame(game1);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testAddPlayTime() {
        GameStore playTime = new GameStore();
        playTime.addPlayTime("Ivan", 10);
        playTime.addPlayTime("Ruslan", 5);
        playTime.addPlayTime("Petr", 7);
        playTime.addPlayTime("Alex", 8);
        playTime.addPlayTime("Ruslan", 7);

        String expected = "Ruslan";
        String actual = playTime.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testGetSumPlayedTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Ivan", 10);
        store.addPlayTime("Ruslan", 5);
        store.addPlayTime("Petr", 7);
        store.addPlayTime("Alex", 8);
        store.addPlayTime("Ruslan", 7);

        int expected = 37;
        int actual = store.getSumPlayedTime();
        Assertions.assertEquals(expected, actual);
    }


}
