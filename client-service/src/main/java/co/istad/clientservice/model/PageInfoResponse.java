package co.istad.clientservice.model;

public record PageInfoResponse(
        int size,
        int number,
        int totalElements,
        int totalPages
) {
}
