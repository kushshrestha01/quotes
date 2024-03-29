/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import org.checkerframework.checker.units.qual.A;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;


public class AppTest {
    @Test
    public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

    @Test
    public void testJsonReader() {
        App testReadJson = new App();
        int expectedOutput = 1;
        int output = testReadJson.readJson().size();
        assertEquals("checking if there is any output",
                1,
                output);
    }

    @Test
    public void testGetQuotesFromAPI() {
        App testApp = new App();
        assertNotNull(testApp.getQuotesFromAPI());
    }

    @Test
    public void testIfAPIDataIsAdded() throws FileNotFoundException {
        App testApp = new App();
        File file = new File("src/main/resources/recentquotes.json");
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        Quote[] response = gson.fromJson(reader, Quote[].class);
        int lengthBeforeRunningQuotesAPI = response.length + 1;

        testApp.getQuotesFromAPI();

        File fileAfter = new File("src/main/resources/recentquotes.json");
        FileReader readerAfter = new FileReader(fileAfter);
        Gson gsonAfter = new Gson();
        Quote[] responseAfter = gson.fromJson(readerAfter, Quote[].class);
        int lengthAfterRunningQuotesAPI = responseAfter.length;

        assertEquals("checking for length JSON file before and after",
                lengthBeforeRunningQuotesAPI,
                lengthAfterRunningQuotesAPI);
    }

}
