
package org.ort.starwars.fleet.utils;

import java.net.URI;

public class Parsing {

    public static String getEndpoint(String baseUrl, String url) {
        String basePath = URI.create(baseUrl).getPath();
        String path = URI.create(url).getRawPath();
        String query = URI.create(url).getRawQuery();

        if (!path.startsWith(basePath)) {
            return "";
        }

        String endpoint = path.substring(basePath.length());
        return endpoint + (query == null ? "" : "?" + query);
    }

    public static int getInt(String value, int fallback) {
        try {
            return Integer.parseInt(
                value.replace(",", "")
                     .replace(".", "")
                     .replace(" ", "")
            );
        } catch (Exception e) {
            return fallback;
        }
    }

    public static int[] getRange(String value, int fallback, String sep) {
        try {
            int index = value.indexOf(sep);

            int min = getInt(value.substring(0, index), fallback);
            int max = getInt(value.substring(index + sep.length()), fallback);

            return new int[]{min, max};
        } catch (Exception e) {
            return new int[]{fallback, fallback};
        }
    }

    public static int[] getRange(String value, int fallback) {
        return getRange(value, fallback, "-");
    }

    public static int[] getRange(String value) {
        return getRange(value, -1);
    }
}
