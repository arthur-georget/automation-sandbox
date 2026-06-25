package com.automation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
@DisplayName("CalciferAPI Tests with Mockito")
public class CalciferAPITest {

    private CalciferAPI calciferAPI;

    @Mock
    private CalciferProcess calciferProcessMock;

    @BeforeEach
    void setUp() {
        calciferAPI = new CalciferAPI(calciferProcessMock);
    }

    @Test
    @DisplayName("CodeReviewed POST request handling Tests")
    void testCodeReviewed() throws IOException {
        when(calciferProcessMock.getGithubStatus())
            .thenReturn("Connected to Github as : bob-kelso");

        Map<String, Object> testMap = Map.of("branch", "feat/tests");
        String expectedResponse = "HTTP request successfully received for feat/tests branch. Github status -> Connected to Github as : bob-kelso";

        assertEquals(expectedResponse, calciferAPI.codeReviewed(testMap));

        verify(calciferProcessMock, times(1)).triggerAutoMerge("feat/tests");
    }
}