package edu.psu.ist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SweeperTests {

    @Test
    public void testStep1() {
        Minesweeper game = new Minesweeper();
        String expectedBoard =
                "- - * -\n" +
                        "- - * -\n" +
                        "- - - -\n" +
                        "- - - -\n";
        Assertions.assertEquals(expectedBoard, game.renderBoard());
    }

    @Test
    public void testStep2() {
        Minesweeper game = new Minesweeper();

        int result1 = game.updateBoard(0, 1);
        String expectedBoard1 =
                "- 2 * -\n" +
                        "- - * -\n" +
                        "- - - -\n" +
                        "- - - -\n";
        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(expectedBoard1, game.renderBoard());

        // Test updating (2, 1)
        int result2 = game.updateBoard(2, 1);
        String expectedBoard2 =
                "- 2 * -\n" +
                        "- - * -\n" +
                        "- 1 - -\n" +
                        "- - - -\n";
        Assertions.assertEquals(0, result2);
        Assertions.assertEquals(expectedBoard2, game.renderBoard());

        // Test updating (3, 1)
        int result3 = game.updateBoard(3, 1);
        String expectedBoard3 =
                "- 2 * -\n" +
                        "- - * -\n" +
                        "- 1 - -\n" +
                        "- 0 - -\n";
        Assertions.assertEquals(0, result3);
        Assertions.assertEquals(expectedBoard3, game.renderBoard());
    }


    @Test
    public void testMineReveal() {
        Minesweeper game = new Minesweeper();
        int result = game.updateBoard(0, 2);

        Assertions.assertEquals(-1, result);
        String expectedBoard =
                "- - * -\n" +
                        "- - * -\n" +
                        "- - - -\n" +
                        "- - - -\n";
        Assertions.assertEquals(expectedBoard, game.renderBoard());
    }

    @Test
    public void testUserInputSequence() {
        Minesweeper game = new Minesweeper();

        int result1 = game.updateBoard(0, 0);
        String expectedBoard1 =
                "0 - * -\n" +
                        "- - * -\n" +
                        "- - - -\n" +
                        "- - - -\n";
        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(expectedBoard1, game.renderBoard());

        int result2 = game.updateBoard(1, 3);
        String expectedBoard2 =
                "0 - * -\n" +
                        "- - * 2\n" +
                        "- - - -\n" +
                        "- - - -\n";
        Assertions.assertEquals(0, result2);
        Assertions.assertEquals(expectedBoard2, game.renderBoard());


        int result3 = game.updateBoard(1, 2);
        Assertions.assertEquals(-1, result3);
    }

    public void testWinCondition() {
        Minesweeper game = new Minesweeper();

        char[][] customBoard = {
                {'-', '*', '*', '*'},
                {'*', '*', '-', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'}
        };
        game.setBoard(customBoard);

        int result1 = game.updateBoard(0, 0);
        Assertions.assertTrue(result1 == 0);


        int result2 = game.updateBoard(1, 2);
        Assertions.assertTrue(result2 == 1);
    }
}
