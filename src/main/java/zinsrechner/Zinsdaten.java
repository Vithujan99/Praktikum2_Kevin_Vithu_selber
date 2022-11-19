package zinsrechner;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public record Zinsdaten(
        @Min(value=1, message = "Muss Positiv sein")double kapital,
        @Min(value = 1, message = "Muss größer 0 sein")int zeit,
        @Min(value = 0, message = "Muss positiv sein")
        @Max(value = 1, message = "Muss kleiner 1 sein") double zinssatz) {

}
