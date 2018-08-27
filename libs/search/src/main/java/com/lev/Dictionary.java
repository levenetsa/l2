package com.lev;

import java.io.IOException;
import java.util.List;

public interface Dictionary {

    void createTree(String fileName) throws IOException;

    boolean containsBadSigns(String string);

    List<String> search(String line);
}
