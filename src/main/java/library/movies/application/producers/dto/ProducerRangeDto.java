package library.movies.application.producers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerRangeDto {
    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;
}
