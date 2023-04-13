package to;

import enums.EnumPlayerRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerTO {

    public String       accountName;
    public String       apiKey;
    public EnumPlayerRole role;
}
