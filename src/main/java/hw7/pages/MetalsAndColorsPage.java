package hw7.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import hw7.entities.MetalsAndColors;
import hw7.forms.MetalsAndColorsForm;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;


@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    // TODO What is the reason fo 'static' here ? - fixed
    private MetalsAndColorsForm metalsAndColorsForm;

    @UI("['Submit']")
    private Button submit;

    // TODO Same story lime 20 - fixed
    @XPath("//ul[contains(@class,'results')]")
    private UIElement resultSection;

    public MetalsAndColorsPage checkMetalsAndColorsPageOpened() {
        checkOpened();
        return this;
    }

    public MetalsAndColorsPage fillAndSubmitForm(MetalsAndColors data) {
        metalsAndColorsForm.fill(data);
        submit.click();
        return this;
    }

    // TODO The certain sequence of log's rows doesn't matter in this case. - fixed
    // It will be easier to compare just two List<strings>
    // First list you can generate from MetalsAndColors instance
    // Second list can be generated from Log ui-element
    public void checkResultSection(MetalsAndColors data) {
        assertEquals(getActualResultData(), data.getAllData());
    }

    private List<String> getActualResultData() {
        return resultSection.childs().stream().map(UIElement::getText).collect(Collectors.toList());
    }
}
