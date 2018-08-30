package com.lev.hooker.utils;

import java.io.*;

public class ProcessRunner {

    public static String run(String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
      //  builder.directory(new File("C:\\home\\l2\\hooker\\build\\libs\\bot"));
        Process p = builder.start();
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        return getBufferedReaderOutput(new BufferedReader(isr));
    }

    private static String getBufferedReaderOutput(BufferedReader bufferedReader) throws IOException {
        StringBuilder output = new StringBuilder();
        String str;
        try (BufferedReader br = bufferedReader) {
            while ((str = br.readLine()) != null) {
                output.append(str).append('\n');
            }
        }
        return output.toString();
    }
}