package uz.mutalov.travellog.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenericCriteria implements BaseCriteria {
    protected Integer size;
    protected Integer page;

    public Integer getPage() {
        if (Objects.isNull(page))
            page=0;
        return page;
    }

    public Integer getSize() {
        if (size==0)
            size = 10;
        return size;
    }
}
