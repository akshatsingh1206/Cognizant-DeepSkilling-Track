package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Call the method with specific arguments
        service.fetchData();

        // 3. Verify the interaction
        verify(mockApi).getData();
    }
}
