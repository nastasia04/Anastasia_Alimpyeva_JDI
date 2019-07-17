package hw8.testData;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hw7.entities.MetalsAndColors;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class MetalsAndColorsDataProvider {
    private static final String PATH_TO_JSON = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider
    public Object[][] provideData() throws FileNotFoundException {
        JsonObject jsonDataObject = new JsonParser()
                .parse(new FileReader(PATH_TO_JSON))
                .getAsJsonObject();
        Object[][] dataArray = new Object[jsonDataObject.size()][1];
        int i = 0;
        for (Map.Entry<String, JsonElement> entry : jsonDataObject.entrySet()) {
            dataArray[i++][0] = new Gson()
                    .fromJson(entry.getValue(), MetalsAndColors.class);
        }
        return dataArray;
    }
}