package com.taseerahmad.linkzapper.service;

import com.taseerahmad.linkzapper.interfaces.Base62Transcoder;
import com.taseerahmad.linkzapper.util.IDUtil;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class Base62 implements Base62Transcoder {

    @Override
    public List<Integer> encode(long id)
    {
        LinkedList<Integer> digits = new LinkedList<>();
        while (id > 0)
        {
            int remainder = (int) id % 62;
            id /= 62;
            digits.addFirst(remainder);
        }

        return digits;
    }

    @Override
    public long decode(String shortenedUrl)
    {
        long decodedId = 0;
        int urlLength = shortenedUrl.length() - 1;
        char[] urlCharacters = shortenedUrl.toCharArray();

        for (char urlCharacter : urlCharacters) {
            int base10 = IDUtil.getNumberFromChar(urlCharacter);
            decodedId += (long) (base10 * Math.pow(62, urlLength));
            urlLength--;
        }

        return decodedId;
    }
}
