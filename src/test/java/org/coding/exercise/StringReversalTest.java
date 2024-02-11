package org.coding.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StringReversalTest {
    @Test
    public void testStringReversal() {
        StringReversal stringReversal = new StringReversal();
        final String STR_TO_REVERSE = "erised straeh ruoy tub ecaf ruoy ton wohs i";
        final String STR_REVERSED = "i show not your face but your hearts desire";

        String strActualOutput = stringReversal.reverseString(STR_TO_REVERSE);

        Assert.assertEquals(STR_REVERSED, strActualOutput);
    }

    @Test
    public void testReadStringFromFile() throws Exception {
        StringReversal stringReversal = mock(StringReversal.class);
        when(stringReversal.readStringFromFile(ArgumentMatchers.anyString())).thenThrow(IOException.class);

        assertThrows(IOException.class, () -> stringReversal.readStringFromFile(""));
    }

    @Test
    public void testWriteReversedStringToFile() throws Exception {
        StringReversal stringReversal = mock(StringReversal.class);
        doThrow(IOException.class).when(stringReversal).writeReversedStringToFile(ArgumentMatchers.anyString());

        assertThrows(IOException.class, () -> stringReversal.writeReversedStringToFile(""));
    }
}