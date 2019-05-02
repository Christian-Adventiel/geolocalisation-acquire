package fr.adventiel.innov.geolocalisationacquire.importer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ImportScheduler {
    private final ImportService importService;

    @Scheduled(fixedRateString = "${import-rate}")
    public void fwsImport() {
        log.info("Start import ...");
        importService.doImport();
    }
}
