package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    @Test
    public void shouldSumGenreIfTwoGame() {
        GameStore store = new GameStore();
        Game MK = store.publishGame("Mortal Combat", "Аркады");
        Game lbp = store.publishGame("LBP", "Приключение");
        Game rdr = store.publishGame("RDR", "Приключение");
        Game rayman = store.publishGame("Rayman", "Аркады");


        Player player = new Player("Ivan");

        player.installGame(MK);
        player.installGame(rayman);
        player.installGame(lbp);
        player.installGame(rdr);

        player.play(MK, 3);
        player.play(rayman, 5);
        player.play(lbp, 10);
        player.play(rdr, 20);


        int expected = 8;
        int actual = player.sumGenre("Аркады");
//        int actual = player.sumGenre(game.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playTestRuntimeException() {

        GameStore store = new GameStore();
        Game MK = store.publishGame("Mortal Combat", "Аркады");
        Game lbp = store.publishGame("LBP", "Приключение");
        Game rdr = store.publishGame("RDR", "Приключение");
        Game rayman = store.publishGame("Rayman", "Аркады");

        Player player = new Player("Ivan");

        player.installGame(rayman);
        player.installGame(lbp);
        player.installGame(rdr);

        player.play(rayman, 5);
        player.play(lbp, 10);
        player.play(rdr, 20);

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(MK, 4);
        });


    }

    @Test
    public void testMostPlayerByGenre() {
        GameStore store = new GameStore();

        Game MK = store.publishGame("Mortal Combat", "Аркады");
        Game lbp = store.publishGame("LBP", "Приключение");
        Game rdr = store.publishGame("RDR", "Приключение");
        Game rayman = store.publishGame("Rayman", "Аркады");

        Player player = new Player("Ivan");

        player.installGame(MK);
        player.installGame(rayman);
        player.installGame(lbp);
        player.installGame(rdr);


        player.play(MK, 3);
        player.play(rayman, 5);
        player.play(lbp, 10);
        player.play(rdr, 20);

        Game expected = rdr;
        Game actually = player.mostPlayerByGenre("Приключение");
        Assertions.assertEquals(expected, actually);



    }
    @Test
    public void testMostPlayerByGenreNull() {
        GameStore store = new GameStore();

        Game MK = store.publishGame("Mortal Combat", "Аркады");
        Game lbp = store.publishGame("LBP", "Приключение");
        Game rdr = store.publishGame("RDR", "Приключение");
        Game rayman = store.publishGame("Rayman", "Аркады");
        Game ecco = store.publishGame("Ecco", "Шутер");

        Player player = new Player("Ivan");

        player.installGame(MK);
        player.installGame(rayman);
        player.installGame(lbp);
        player.installGame(rdr);
        player.installGame(ecco);


        player.play(MK, 3);
        player.play(rayman, 5);
        player.play(lbp, 10);
        player.play(rdr, 20);

        Game expected = null;
        Game actually = player.mostPlayerByGenre("Шутер");
        Assertions.assertEquals(expected, actually);
    }


    }


// другие ваши тесты

