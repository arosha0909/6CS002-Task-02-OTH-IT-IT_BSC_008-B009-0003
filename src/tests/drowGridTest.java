import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.*;
class drowGridTest {

	@Test
	void testDrawGrid() {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Graphics graphics = Mockito.mock(Graphics.class);

        GridDrawer gridDrawer = new GridDrawer(grid, 10);
        gridDrawer.drawGrid(graphics);

        // to verify output...
        verify(graphics, times(9)).drawString(anyString(), anyInt(), anyInt());
    }

}
