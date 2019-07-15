package hw7.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

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
}
