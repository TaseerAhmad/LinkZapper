package com.taseerahmad.linkzapper.util;

public class URLUtil {
    public static final URLUtil INSTANCE = new URLUtil();

    private URLUtil() {

    }

    public String extractUrlId(String url)
    {
        StringBuilder urlId = new StringBuilder();
        char[] uniqueUrl = url.toCharArray();

        for (int index = uniqueUrl.length -1; index >= 0; index--)
        {
            if (uniqueUrl[index] == '/') {
                break;
            } else {
                urlId.append(uniqueUrl[index]);
            }
        }

        return urlId.toString();
    }

    public Boolean isUrlValid(String url)
    {
        if (url.trim().isEmpty()) {
            return false;
        } else {
            return URLValidation.INSTANCE.validateURL(url);
        }
    }

    public String applyServiceBranding(String url)
    {
        String serviceName = "www.zapp.it";
        return serviceName.concat("/").concat(url);
    }
}
