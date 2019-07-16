package hw7.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MetalsAndColors extends DataClass<MetalsAndColors> {
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;

    public int sum() {
        return summary.stream().mapToInt(Integer::intValue).sum();
    }

    public List<String> getAllData(){
        List<String>  resultList = new ArrayList<>();
        resultList.add("Summary: " + sum());
        resultList.add("Elements: " + listOfElementsToString(elements));
        resultList.add("Color: " + color);
        resultList.add("Metal: " + metal);
        resultList.add("Vegetables: " + listOfElementsToString(vegetables));
        return resultList;
    }
    private String listOfElementsToString(List<String> list) {
        return list.toString().replaceAll("\\[|\\]", "");
    }

}
