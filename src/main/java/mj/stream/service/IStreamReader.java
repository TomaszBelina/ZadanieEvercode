package mj.stream.service;

import java.io.InputStream;
import java.util.List;

/**
 * Created by mjakubowicz on 2016-09-25.
 */
public interface IStreamReader {
    List<String> getTextLinesFromStram(InputStream stream);
}
