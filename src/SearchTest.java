import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class SearchTest {
    @Test
    public void testFindRat(){
        char [][] maze = {
            {'o', 'o', 'o', 'o', 'c', 'w', 'c', 'o'},
            {'w', 'o', 'o', 'w', 'w', 'c', 'w', 'o'},
            {'o', 'o', 'o', 'o', 'R', 'w', 'o', 'o'},
            {'o', 'o', 'w', 'w', 'w', 'o', 'o', 'o'},
            {'o', 'o', 'o', 'o', 'c', 'o', 'o', 'o'}
        };
        int[] expected = {2, 4};
        assertEquals(expected[0], Search.ratLocation(maze)[0]);
        assertEquals(expected[1], Search.ratLocation(maze)[1]);
    }

    @Test
    public void testFindRat_noRat(){
        char [][] maze = {
            {'o', 'o', 'o', 'o', 'c', 'w', 'c', 'o'},
            {'w', 'o', 'o', 'w', 'w', 'c', 'w', 'o'},
            {'o', 'o', 'o', 'o', 'w', 'w', 'o', 'o'},
            {'o', 'o', 'w', 'w', 'w', 'o', 'o', 'o'},
            {'o', 'o', 'o', 'o', 'c', 'o', 'o', 'o'}
        };
        
        assertThrows(EscapedRatException.class, () ->{
            Search.ratLocation(maze);
        });
    }

    @Test
    public void testFindRat_TwoRats(){
        char [][] maze = {
            {'o', 'o', 'o', 'o', 'c', 'w', 'c', 'o'},
            {'w', 'o', 'o', 'w', 'w', 'c', 'w', 'o'},
            {'o', 'o', 'o', 'o', 'R', 'w', 'o', 'o'},
            {'o', 'o', 'w', 'w', 'w', 'o', 'o', 'o'},
            {'o', 'o', 'o', 'o', 'c', 'o', 'o', 'R'}
        };
        
        assertThrows(CrowdedMazeException.class, () ->{
            Search.ratLocation(maze);
        });
    }

    @Test
    public void testNearestCheese_noCheese(){
        char [][] maze = {
            {'o', 'o', 'o', 'o', 'o', 'w', 'o', 'o'},
            {'w', 'o', 'o', 'w', 'w', 'o', 'w', 'o'},
            {'o', 'o', 'o', 'o', 'R', 'w', 'o', 'o'},
            {'o', 'o', 'w', 'w', 'w', 'o', 'o', 'o'},
            {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'}
        };
        
        assertThrows(HungryRatException.class, () ->{
            Search.nearestCheese(maze);
        });
    }
    
    @Test
    public void testNearestCheese_twoCheese(){
        char [][] maze = {
            {'o', 'o', 'o', 'o', 'o', 'w', 'o', 'o'},
            {'w', 'o', 'o', 'w', 'c', 'o', 'w', 'o'},
            {'o', 'o', 'o', 'c', 'R', 'w', 'o', 'o'},
            {'o', 'o', 'w', 'w', 'w', 'o', 'o', 'o'},
            {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'}
        };
       
        assertEquals(1, Search.nearestCheese(maze)[0]);
        assertEquals(4, Search.nearestCheese(maze)[1]);

    }
}
