package co.istad.clientservice.controller;

import co.istad.clientservice.service.ExternalApiClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/external")
@RequiredArgsConstructor
public class ExternalApiClientController {

    private final ExternalApiClientService externalApiClientService;

    @GetMapping("/files/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable("fileName") String fileName){
        return externalApiClientService.getFile(fileName);
    }

    @PostMapping(value = "/files/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadFile(@RequestPart MultipartFile file){
        return externalApiClientService.uploadFile(file);
    }
}
