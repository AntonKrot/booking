package com.example.booking.dto.room;

import com.example.booking.dto.dictionary.DictionaryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private Long id;
    private String description;
    private DictionaryDTO roomType;
}
