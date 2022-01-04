package library.movies.domain.producers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProducerRangeModel {

    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

}
