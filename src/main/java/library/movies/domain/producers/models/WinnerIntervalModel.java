package library.movies.domain.producers.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class WinnerIntervalModel {
    private List<ProducerRangeModel> min = new ArrayList<>();
    private List<ProducerRangeModel> max = new ArrayList<>();

    public void AddAndResetMin(ProducerRangeModel producer) {
        min = new ArrayList<>();
        AddMin(producer);
    }

    public void AddMin(ProducerRangeModel producer) {
        min.add(producer);
    }

    public void AddAndResetMax(ProducerRangeModel producer) {
        max = new ArrayList<>();
        AddMax(producer);
    }

    public void AddMax(ProducerRangeModel producer) {
        max.add(producer);
    }


}
