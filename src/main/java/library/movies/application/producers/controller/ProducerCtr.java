package library.movies.application.producers.controller;

import io.swagger.v3.oas.annotations.Operation;
import library.movies.application.producers.dto.WinnerIntervalDto;
import library.movies.domain.producers.ProducersService;
import library.movies.domain.producers.models.WinnerIntervalModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO - @Api("Producer")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerCtr {

    private final ProducersService producersService;

    @GetMapping("producers/intervals")
    @Operation(description = "Obter o produtor com maior intervalo entre dois prêmios consecutivos, " +
            "e o que obteve dois prêmios mais rápido.")
    public WinnerIntervalDto calculateIntervals() {
        WinnerIntervalModel winners = producersService.calculateIntervals();
        return new WinnerIntervalDto(winners);
    }

    //TODO - Carregar novos arquivos via api para facilidade de teste

}
