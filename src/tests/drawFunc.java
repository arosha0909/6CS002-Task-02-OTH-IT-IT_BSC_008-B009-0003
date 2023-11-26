import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.*;

class drawFunc {

	@Test
	void testDrawFunction() {
        Graphics graphics = Mockito.mock(Graphics.class);

        FunctionDrawer.drawFunction(graphics, 10, 20, 42);

        // verify output
        verify(graphics).drawString(anyString(), anyInt(), anyInt());
    }

}
