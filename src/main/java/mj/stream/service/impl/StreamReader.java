package mj.stream.service.impl;

import mj.stream.service.IStreamReader;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by mjakubowicz on 2016-09-25.
 */
@Service("streamReader")
public class StreamReader implements IStreamReader {

    @Override
    public List<String> getTextLinesFromStram(InputStream stream) {
        try {
            return IOUtils.readLines(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            //TODO dodać logger
            e.printStackTrace();
        }
        return null;
    }
}
