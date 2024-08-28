package co.istad.clientservice.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface ExternalApiClientService {

    @GetExchange("/{fileName}")
    ResponseEntity<byte[]> getFile(@PathVariable String fileName);

    @PostExchange(value = "/upload", contentType = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> uploadFile(@RequestPart MultipartFile file);

}
