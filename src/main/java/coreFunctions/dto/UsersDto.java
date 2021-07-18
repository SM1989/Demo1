package main.java.coreFunctions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
}
