package com.taseerahmad.linkzapper.util;

import java.util.List;

public class URLBuilder {
    
    public String buildShortenedUrl(List<Integer> encodedNumbers)
    {
        StringBuilder url = new StringBuilder();
        
        for (int number: encodedNumbers)
        {
            char urlCharacter = IDUtil.getCharFromNumber(number);
            url.append(urlCharacter);
        }

        return url.toString();
    }
}
