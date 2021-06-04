package com.taseerahmad.linkzapper.interfaces;

import java.util.List;

public interface Base62Transcoder {
    List<Integer> encode(long id);
    long decode(String encodedValue);
}
