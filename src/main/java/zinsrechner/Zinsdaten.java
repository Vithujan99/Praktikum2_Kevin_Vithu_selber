package zinsrechner;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public record Zinsdaten(
        @Min(value=1, message = "Muss Positiv sein")Double kapital,
        @Min(value = 1, message = "Muss größer 0 sein")Integer zeit,
        @Min(value = 0, message = "Muss positiv sein")
        @Max(value = 1, message = "Muss kleiner 1 sein")Double zinssatz) {

}
