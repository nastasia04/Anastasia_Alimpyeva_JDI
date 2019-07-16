package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import hw7.entities.MetalsAndColors;
import hw7.forms.MetalsAndColorsForm;

import java.util.List;

import static org.testng.Assert.assertTrue;


@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    // TODO What is the reason fo 'static' here ?
    private static MetalsAndColorsForm metalsAndColorsForm;
    @UI("['Submit']")
    private Button submit;

    // TODO Same story lime 20
    @XPath("//ul[contains(@class,'results')]")
    private static Text resultSection;

    @XPath("//li[@class='summ-res']")
    private Text resultSummary;

    @XPath("//*[@class='elem-res']")
    private Text resultElements;

    @XPath("//*[@class='col-res']")
    private Text resultColor;

    @XPath("//*[@class='met-res']")
    private Text resultMetal;

    @XPath("//*[@class='sal-res']")
    private Text resultVegetables;

    public MetalsAndColorsPage checkMetalsAndColorsPageOpened() {
        checkOpened();
        return this;
    }

    public MetalsAndColorsPage fillAndSubmitForm(MetalsAndColors data) {
        metalsAndColorsForm.fill(data);
        submit.click();
        return this;
    }

    // TODO The certain sequence of log's rows doesn't matter in this case.
    // It will be easier to compare just two List<strings>
    // First list you can generate from MetalsAndColors instance
    // Second list can be generated from Log ui-element
    public void checkResultSection(MetalsAndColors data) {
        checkTextEquality(resultSummary, String.valueOf(data.sum()));
        checkTextEquality(resultElements, listOfElementsToString(data.getElements()));
        checkTextEquality(resultColor, data.getColor());
        checkTextEquality(resultMetal, data.getMetal());
        checkTextEquality(resultVegetables, listOfElementsToString(data.getVegetables()));
    }

    private void checkTextEquality(Text actualText, String expectedText) {
        assertTrue(actualText.getText().contains(expectedText));
    }

    private String listOfElementsToString(List<String> list) {
        return list.toString().replaceAll("\\[|\\]", "");
    }
}
