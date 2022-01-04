package library.movies.application.producers.controller;

import library.movies.application.producers.dto.WinnerIntervalDto;
import library.movies.domain.producers.ProducersService;
import library.movies.domain.producers.models.WinnerIntervalModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerCtr {

    private final ProducersService producersService;

    @GetMapping("producers/intervals")
    @Description("Obter o produtor com maior intervalo entre dois prêmios consecutivos, " +
            "e o que obteve dois prêmios mais rápido.")
    public HttpEntity<WinnerIntervalDto> calculateIntervals() {
        WinnerIntervalModel winners = producersService.calculateIntervals();
        return ResponseEntity.status(HttpStatus.OK).body(new WinnerIntervalDto(winners));
    }

}
