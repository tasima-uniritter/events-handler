package br.edu.uniritter.topi.dto;

import lombok.Data;

@Data
public class UserDTO {
    enum TYPE {
        STUDANT,
        OLDERLY,
        GOLD,
        SILVER,
    }

    private TYPE type;
}
