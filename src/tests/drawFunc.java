import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.*;

class drawFunc {

	@Test
	void testDrawFunction() {
        Graphics graphics = Mockito.mock(Graphics.class);

        // Call the method from the utility class
        FunctionDrawer.drawFunction(graphics, 10, 20, 42);

        // Verify that the correct method of the graphics object is called
        verify(graphics).drawString(anyString(), anyInt(), anyInt());
    }

}
