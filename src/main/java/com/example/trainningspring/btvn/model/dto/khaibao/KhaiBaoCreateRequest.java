package com.example.trainningspring.btvn.model.dto.user.khaibao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KhaiBaoCreateRequest {
    String sdt;
    String dichuyen;
    String trieuchung;
    String nghinhiem;
    String nuocbenh;
    String bieuhien;
}
