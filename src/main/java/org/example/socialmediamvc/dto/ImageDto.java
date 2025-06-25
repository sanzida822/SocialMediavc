package org.example.socialmediamvc.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ImageDto {

    int id;
    @NotNull(message = "{error.image.data.required}")
    @Size(min = 1, message = "{error.image.data.empty}")
    private byte[] data;
    @Min(value = 1, message = "{error.image.size.invalid}")
    private long size;




}
