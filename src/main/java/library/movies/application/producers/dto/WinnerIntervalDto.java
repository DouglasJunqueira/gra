package library.movies.application.producers.dto;

import library.movies.domain.producers.models.ProducerRangeModel;
import library.movies.domain.producers.models.WinnerIntervalModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WinnerIntervalDto {

    private List<ProducerRangeDto> min;
    private List<ProducerRangeDto> max;

    //TODO - change for modelmapper
    public WinnerIntervalDto(WinnerIntervalModel interval) {
        MapMinModel(interval.getMin());
        MapMaxModel(interval.getMax());
    }

    private void MapMaxModel(List<ProducerRangeModel> producers) {
        max = MapModel(producers);
    }

    private void MapMinModel(List<ProducerRangeModel> producers) {
        min = MapModel(producers);
    }

    private List<ProducerRangeDto> MapModel(List<ProducerRangeModel> producers) {
        return producers.stream()
                .map(producer -> new ProducerRangeDto(producer.getProducer(), producer.getInterval(),
                        producer.getPreviousWin(), producer.getFollowingWin()))
                .collect(Collectors.toList());
    }
}
