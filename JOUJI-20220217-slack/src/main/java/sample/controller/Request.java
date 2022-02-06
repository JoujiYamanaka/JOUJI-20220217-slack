package sample.controller;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Request {
    /** 氏名 */
    @NotBlank
    private String name;
}